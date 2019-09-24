package com.tinderdog.models.usuario;

import com.tinderdog.models.Dog;

import java.util.List;

public class Pessoa {

    private int id;
    private Login login;
    private String nome;
    private String cpf;
    private String dt_nascimento;
    private Endereco endereco;
    private List<Dog> dogs;

    public Pessoa(int id, Login login, String nome, String cpf, String dt_nascimento, Endereco endereco, List<Dog> dogs) {
        this.id = id;
        this.login = login;
        this.nome = nome;
        this.cpf = cpf;
        this.dt_nascimento = dt_nascimento;
        this.endereco = endereco;
        this.dogs = dogs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }
}
