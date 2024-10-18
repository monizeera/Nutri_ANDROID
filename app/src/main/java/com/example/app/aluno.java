package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class aluno extends AppCompatActivity {

    EditText nomeEditText, emailEditText, senhaEditText, confirmeSenhaEditText,rmEditText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);

        // Obtém referências aos campos de texto
        nomeEditText = findViewById(R.id.editTextText10);
        emailEditText = findViewById(R.id.editTextText7);
        senhaEditText = findViewById(R.id.editTextText8);
        confirmeSenhaEditText = findViewById(R.id.editTextText11);
        rmEditText = findViewById(R.id.editTextText12);

        Button button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chama o método de validação quando o botão é clicado
                validarECadastrar();
            }
        });
    }

    private void validarECadastrar() {
        // Obter os valores dos campos de texto
        String nome = nomeEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String senha = senhaEditText.getText().toString();
        String rm = rmEditText.getText().toString();
        String confirmeSenha = confirmeSenhaEditText.getText().toString();

        // Verifica se algum campo está vazio
        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmeSenha.isEmpty()) {
            Toast.makeText(this, "É necessário preencher todos os campos", Toast.LENGTH_SHORT).show();
        } else if (!senha.equals(confirmeSenha)) {
            // Verifica se a senha e a confirmação são iguais
            Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
        } else {
            // Exibir mensagem de sucesso
            Toast.makeText(this, "Você está cadastrado!", Toast.LENGTH_SHORT).show();

            // Ir para outra tela (opcional)
            Intent intent = new Intent(aluno.this, funcao.class);
            startActivity(intent);
        }
    };
}