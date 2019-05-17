package com.example.myapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

public class AtualizarActivity extends CadastroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar);

        Button buttonCPF = findViewById(R.id.buttonCPF);


        buttonCPF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < funcionarios.size(); i++){
                    EditText editTextCPF = findViewById(R.id.editTextCPF);
                    if(funcionarios.get(i).getCPF().equals(editTextCPF.getText().toString())){
                        Intent intent = new Intent(AtualizarActivity.this, AtualizarDadosActivity.class);
                        intent.putExtra("CPF", funcionarios.get(i).getCPF());
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "CPF não encontrado", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });




    }
}
