package com.tinderdog.models;

import android.graphics.Bitmap;

import com.tinderdog.models.usuario.Pessoa;

import java.sql.Blob;

public class Dog {

    private int id;
    private String nome;
    private String cor_pelagem;
    // ano.mes ex: 1.2 (1 ano e 2 meses)
    private double idade ;
    private String porte;
    private Pessoa dono;
    private Bitmap photo;

    public Dog(){

    }

    public Dog(int id, Pessoa dono, String nome, String cor_pelagem, double idade, String porte, Bitmap photo) {
        this.id = id;
        this.nome = nome;
        this.cor_pelagem = cor_pelagem;
        this.idade = idade;
        this.porte = porte;
        this.dono = dono;
        this.photo = photo;
    }

    public Dog(String nome, String cor_pelagem, double idade, String porte, Bitmap photo) {
        this.nome = nome;
        this.cor_pelagem = cor_pelagem;
        this.idade = idade;
        this.porte = porte;
        this.photo = photo;
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

    public Pessoa getDono() {
        return dono;
    }

    public void setDono(Pessoa dono) {
        this.dono = dono;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }
}
