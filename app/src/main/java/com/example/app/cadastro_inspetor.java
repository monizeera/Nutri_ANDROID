package com.example.app;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

    public class cadastro_inspetor extends AppCompatActivity {

        EditText nomeEditText, emailEditText, senhaEditText, confirmeSenhaEditText;

        //Cria objeto JSON vazio
        JSONObject cadastro_inspetor;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cadastro_inspetor);
            //sla
            //kjfkd
            //tg
            // Obtém referências aos campos de texto
            nomeEditText = findViewById(R.id.editTextText10);
            emailEditText = findViewById(R.id.editTextText7);
            senhaEditText = findViewById(R.id.editTextText8);
            confirmeSenhaEditText = findViewById(R.id.editTextText11);

            Button button = findViewById(R.id.button3);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Chama o método de validação quando o botão é clicado

                    if ( validarCampos()) {
                        com.example.app.cadastro_inspetor.MyPost task = new com.example.app.cadastro_inspetor.MyPost();
                        //MUDAR ENDEREÇO
                        String urlApi = "http://10.0.2.2:8000/api/inspector/store";
                        task.execute(urlApi);
                    }
                }
            });
        }

        private Boolean validarCampos() {
            Boolean status = true;
            // Obter os valores dos campos de texto
            String nome = nomeEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String senha = senhaEditText.getText().toString();
            String confirmeSenha = confirmeSenhaEditText.getText().toString();

            // Verifica se algum campo está vazio
            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmeSenha.isEmpty()) {
                Toast.makeText(this, "É necessário preencher todos os campos", Toast.LENGTH_SHORT).show();
                status = false;
            } else if (!senha.equals(confirmeSenha)) {
                // Verifica se a senha e a confirmação são iguais
                Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
                status = false;
            }else{
                try{
                    // ALTERAR ESTRUTURA DO JSON para cada tabela do banco
                    cadastro_inspetor = new JSONObject();
                    cadastro_inspetor.put("name",nome);
                    cadastro_inspetor.put("email",email);
                    cadastro_inspetor.put("password",senha);
                    cadastro_inspetor.put("function", getIntent().getExtras().getString("funcao"));
                    System.out.print(cadastro_inspetor.toString());
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
            return status;
        }

        //NÃO ALTERAR, COPIAR E COLAR DENTRO DAS OUTRAS CLASSES QUE PRECISAR REALIZAR UM POST
        class MyPost extends AsyncTask<String, Void, String> {
            @Override
            protected void onPreExecute(){
                super.onPreExecute();
            }

            @Override
            protected String doInBackground(String... strings) {
                String stringUrl = strings[0];

                try {
                    URL url = new URL(stringUrl);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                    // Configurar a requisição
                    urlConnection.setRequestMethod("POST");
                    urlConnection.setRequestProperty("Content-Type", "application/json; utf-8");
                    urlConnection.setRequestProperty("Accept", "application/json");
                    urlConnection.setDoOutput(true); // Permite enviar dados via POST

                    // Enviar o JSON
                    try (OutputStream os = urlConnection.getOutputStream()) {
                        byte[] input = cadastro_inspetor.toString().getBytes("utf-8");
                        os.write(input, 0, input.length);
                    }

                    // Verificar o código de resposta HTTP
                    int responseCode = urlConnection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        return "JSON enviado com sucesso!";
                    } else {
                        return "Erro ao enviar JSON. Código de resposta: " + responseCode;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    return "Erro: " + e.getMessage();
                }
            }

            @Override
            protected void onPostExecute(String resultado){

                super.onPostExecute(resultado);
            }
        }
    }

