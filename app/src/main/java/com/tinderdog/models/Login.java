package com.tinderdog.models;

public class Login {
    public int id;
    public String email;
    private String senha;

    public Login(int id,String email,String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }
}
