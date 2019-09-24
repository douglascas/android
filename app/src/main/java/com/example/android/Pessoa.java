package com.example.android;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    public int id;
    public Login login;
    public String nome;
    public int cpf;
    public String dt_nascimento;
    public Endereco endereco;
    List<Dog> dogs;

    public Pessoa(int id, Login login, String nome, int cpf, String dt_nascimento, Endereco endereco, List<Dog> dogs) {
        this.id = id;
        this.login = login;
        this.nome = nome;
        this.cpf = cpf;
        this.dt_nascimento = dt_nascimento;
        this.endereco = endereco;
        this.dogs = dogs;
    }
}
