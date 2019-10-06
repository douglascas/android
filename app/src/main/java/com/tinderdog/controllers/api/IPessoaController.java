package com.tinderdog.controllers.api;

import com.tinderdog.models.usuario.Pessoa;
import com.tinderdog.repository.exception.pessoa.InsertPessoaException;
import com.tinderdog.repository.exception.pessoa.PessoaNotFoundException;
import com.tinderdog.repository.exception.pessoa.UpdatePessoaException;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface IPessoaController {
    Pessoa getPessoa(Pessoa pessoa) throws PessoaNotFoundException;
    List<Pessoa> getAllPessoas();
    List<Pessoa> getAllPessoas(int init, int end);
    Pessoa getPessoaById(int id) throws PessoaNotFoundException;
    Pessoa getPessoaByEmail(String email) throws PessoaNotFoundException;
    void insertPessoa(Pessoa pessoa) throws InsertPessoaException;
    void updatePessoa(Pessoa pessoa) throws UpdatePessoaException;
    void register(Pessoa pessoa, Runnable success, Consumer<Integer> error);
    void deletePessoa(Pessoa pessoa) throws PessoaNotFoundException;
    void deletePessoaById(int pessoa) throws PessoaNotFoundException;
}