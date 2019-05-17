package com.example.myapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.models.Funcionario;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends CadastroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCadastrar =  findViewById(R.id.buttonCadastrar);
        Button buttonListar = findViewById(R.id.buttonListar);
        Button buttonDeletar = findViewById(R.id.buttonDeletar);
        Button buttonAtualizar = findViewById(R.id.buttonAtualizar);


        buttonListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = getIntent();
                //funcionarios = (ArrayList<Funcionario>) e.getSerializableExtra("Lista");
                Intent intent = new Intent(MainActivity.this, ListarDados.class);
                intent.putExtra("Lista", (Serializable)funcionarios);
                startActivity(intent);
            }
        });

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

        buttonDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DeletarActivity.class);
                intent.putExtra("Lista", (Serializable)funcionarios);
                startActivity(intent);
            }
        });
        buttonAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AtualizarActivity.class);
                intent.putExtra("Lista", funcionarios);
                startActivity(intent);
            }
        });


    }
}
