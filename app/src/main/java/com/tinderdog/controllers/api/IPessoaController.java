package com.tinderdog.controllers.api;

import com.tinderdog.models.usuario.Pessoa;
import com.tinderdog.repository.exception.pessoa.InsertPessoaException;
import com.tinderdog.repository.exception.pessoa.PessoaNotFoundException;
import com.tinderdog.repository.exception.pessoa.UpdatePessoaException;

import java.util.List;

public interface IPessoaController {
    void get(Pessoa pessoa) throws PessoaNotFoundException;
    void getAll();
    void getAll(int init, int end);
    void getById(int id) throws PessoaNotFoundException;
    void update(Pessoa pessoa) throws UpdatePessoaException;
    void insert(Pessoa pessoa) throws InsertPessoaException;
    void delete(Pessoa pessoa) throws PessoaNotFoundException;
    void deleteById(int pessoa) throws PessoaNotFoundException;
}