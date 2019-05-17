package com.example.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.models.Funcionario;

import java.util.ArrayList;

public class DeletarActivity extends CadastroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletar);

        final EditText deleteByCPF = findViewById(R.id.deleteByCPF);
        Button buttonDelete = findViewById(R.id.buttonDelete);
        Intent e = getIntent();
        //funcionarios = (ArrayList<Funcionario>) e.getSerializableExtra("Lista");
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < funcionarios.size(); i++){
                    if(funcionarios.get(i).getCPF().equals(deleteByCPF.getText().toString())){
                        funcionarios.remove(funcionarios.get(i));
                        Toast.makeText(getApplicationContext(), "Funcionário deletado com sucesso!", Toast.LENGTH_SHORT).show();
                        break;
                    }else{
                        Toast.makeText(getApplicationContext(), "Funcionário não encontrado!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


    }
}
