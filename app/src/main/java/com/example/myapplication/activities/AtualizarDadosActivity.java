package com.example.myapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

public class AtualizarDadosActivity extends CadastroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_dados);


        Button btSalvar = findViewById(R.id.btSalvar);



        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras(); //Pegar todos os extras da activity AtualizarActivity
                String cpf = extras.getString("CPF"); //Guardar o cpf para ser comparado posteriormente

                for(int i = 0; i < funcionarios.size(); i++){
                    EditText alteraEmail = findViewById(R.id.alteraEmail);
                    EditText alteraSenha = findViewById(R.id.alteraSenha);
                    if(alteraEmail.getText() != null && alteraSenha.getText()!= null){
                        if(funcionarios.get(i).getCPF().equals(cpf)){
                            funcionarios.get(i).setEmail(alteraEmail.getText().toString());
                            funcionarios.get(i).setSenha(alteraSenha.getText().toString());
                            Toast.makeText(getApplicationContext(), "Funcionário alterado com sucesso!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(AtualizarDadosActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Preencha todos os campos!", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });


    }
}
