package com.example.myapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.models.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class ListarDados extends CadastroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_dados);
        //Lista de Funcionarios
        ListView listaDeFuncionarios = (ListView) findViewById(R.id.lista);
        //Todos os funcionarios
        Intent e = getIntent();
        //funcionarios = (ArrayList<Funcionario>) e.getSerializableExtra("Lista");
        ArrayAdapter<Funcionario> adapter = new ArrayAdapter<Funcionario>(this, android.R.layout.simple_list_item_1, funcionarios);


        listaDeFuncionarios.setAdapter(adapter);
    }
}
