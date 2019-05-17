package com.example.myapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.models.Funcionario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class CadastroActivity extends AppCompatActivity implements Serializable {
    static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^" +
            //"(?=.*[0-9])" +         //at least 1 digit
            //"(?=.*[a-z])" +         //at least 1 lower case letter
            //"(?=.*[A-Z])" +         //at least 1 upper case letter
            "(?=.*[a-zA-Z])" +      //any letter
            "(?=.*[@#$%^&amp;+=])" +    //at least 1 special character
            "(?=\\S+$)" +           //no white spaces
            ".{4,}" +               //at least 4 characters
            "$");
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        final EditText editNome = findViewById(R.id.editNome);
        final EditText editCPF = findViewById(R.id.editCPF);
        final EditText editEmail = findViewById(R.id.alteraEmail);
        final EditText editSenha = findViewById(R.id.editSenha);
        Button button = findViewById(R.id.button);


        String emailInput = editEmail.getText().toString();
        String senhaInput  = editSenha.getText().toString();
        if(emailInput.isEmpty()){
            editEmail.setError("Campo não pode ser vazio");
        }
        if(Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            editEmail.setError("Por favor digite um e-mail válido");
        }

        if(senhaInput.isEmpty()){
            editSenha.setError("Senha não pode ser vazia");
        }
        if(!PASSWORD_PATTERN.matcher(senhaInput).matches()){
            editSenha.setError("Senha fraca");
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(editNome.getText().toString());
                funcionario.setCpf(editCPF.getText().toString());
                funcionario.setEmail(editEmail.getText().toString());
                funcionario.setSenha(editSenha.getText().toString());
                funcionarios.add(funcionario);
                Toast.makeText(getApplicationContext(), "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CadastroActivity.this, MainActivity.class);
                //intent.putExtra("Lista", (Serializable)funcionarios);
                startActivity(intent);
            }
        });






    }

}
