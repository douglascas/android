package com.tinderdog.controllers.api;

import com.tinderdog.models.usuario.Pessoa;
import com.tinderdog.repository.exception.pessoa.InsertPessoaException;
import com.tinderdog.repository.exception.pessoa.PessoaNotFoundException;
import com.tinderdog.repository.exception.pessoa.UpdatePessoaException;

import java.util.List;

public interface IPessoaController {
    Pessoa getPessoa(Pessoa pessoa) throws PessoaNotFoundException;
    List<Pessoa> getAllPessoas();
    List<Pessoa> getAllPessoas(int init, int end);
    Pessoa getPessoaById(int id) throws PessoaNotFoundException;
    Pessoa getPessoaByEmail(String email) throws PessoaNotFoundException;
    void updatePessoa(Pessoa pessoa) throws UpdatePessoaException;
    void insertPessoa(Pessoa pessoa) throws InsertPessoaException;
    void deletePessoa(Pessoa pessoa) throws PessoaNotFoundException;
    void deletePessoaById(int pessoa) throws PessoaNotFoundException;
}