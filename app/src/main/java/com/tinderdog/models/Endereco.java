package com.tinderdog.models;

public class Endereco {

    public int id;
    public String cep;
    public String logradouro;
    public String bairro;
    public String cidade;
    public String estado;
    public String pais;

    public Endereco(int id, String cep, String logradouro, String bairro, String cidade, String estado, String pais) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }
}
