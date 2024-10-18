package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class funcao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcao);

        RadioGroup radioGroup = findViewById(R.id.radioGroup2);
        Button salvar = findViewById(R.id.button4);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedId = radioGroup.getCheckedRadioButtonId();
                Intent intent = null;

                if (checkedId == R.id.radioButton8) {
                    intent = new Intent(funcao.this, cadastro_inspetor.class);
                    intent.putExtra("funcao","inspetor");
                } else if (checkedId == R.id.radioButton7) {
                    intent = new Intent(funcao.this, cadastro_nutricionista.class);
                    intent.putExtra("funcao","nutricionista");
                } else if (checkedId == R.id.radioButton9) {
                    intent = new Intent(funcao.this, aluno.class);
                    intent.putExtra("funcao","aluno");
                }

                if (intent != null) {
                    startActivity(intent);
                } else {
                  Toast.makeText(funcao.this, "Selecione uma opção", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
