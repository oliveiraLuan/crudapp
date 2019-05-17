package com.example.myapplication.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;

import java.io.Serializable;

public class Funcionario implements Serializable {
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private static final long serialVersionUID = 2020123;

    //Constructors
    public Funcionario() {

    }

    //Getters
    public String getNome(){
        return nome;
    }
    public String getEmail(){
        return email;
    }
    public String getSenha(){
        return senha;
    }
    public String getCPF(){
        return cpf;
    }
   //Setters

    public void setNome(String nome){
        this.nome  = nome;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String toString(){
        return "Nome: \n" + nome + "\nE-mail: \n" + email + "\nCPF: \n" + cpf ;
     }
}
