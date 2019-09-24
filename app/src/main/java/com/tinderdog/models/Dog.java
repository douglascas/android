package com.tinderdog.models;

public class Dog {

    private int id;
    private String nome;
    private String cpf_dono;
    private String cor_pelagem;
    // ano.mes ex: 1.2 (1 ano e 2 meses)
    private double idade ;
    private String porte;

    public Dog(int id,String nome,String cpf_dono, String cor_pelagem, double idade, String porte) {
        this.id = id;
        this.nome = nome;
        this.cpf_dono = cpf_dono;
        this.cor_pelagem = cor_pelagem;
        this.idade = idade;
        this.porte = porte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf_dono() {
        return cpf_dono;
    }

    public void setCpf_dono(String cpf_dono) {
        this.cpf_dono = cpf_dono;
    }

    public String getCor_pelagem() {
        return cor_pelagem;
    }

    public void setCor_pelagem(String cor_pelagem) {
        this.cor_pelagem = cor_pelagem;
    }

    public double getIdade() {
        return idade;
    }

    public void setIdade(double idade) {
        this.idade = idade;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }
}
