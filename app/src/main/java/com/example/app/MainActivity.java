package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText loginEditText, senhaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtém as referências aos campos de texto
        loginEditText = findViewById(R.id.editTextTexdfdgdfft); // Campo de login
        senhaEditText = findViewById(R.id.editTextText2); // Campo de senha

        Button buttonEntrar = findViewById(R.id.button);
        Button buttonCadastrar = findViewById(R.id.button2);

        // Ação para o botão "Ainda não tenho uma conta"
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, funcao.class);
                startActivity(intent);
            }

            {
                buttonEntrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, inspetor.class);
                        startActivity(intent);
                    }
                });
            }

            // Método para validar os campos de login e senha
            private void validarLogin() {
                String login = loginEditText.getText().toString();
                String senha = senhaEditText.getText().toString();

                // Verifica se os campos estão vazios
                if (login.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Se os campos estiverem preenchidos, navega para a tela 'funcao'
                    Intent intent = new Intent(MainActivity.this, funcao.class);
                    startActivity(intent);
                }
            }
        });
    }
}