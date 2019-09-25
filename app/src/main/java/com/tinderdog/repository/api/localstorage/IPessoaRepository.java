package com.tinderdog.repository.api.localstorage;

import com.tinderdog.models.usuario.Pessoa;
import com.tinderdog.repository.exceptions.pessoa.InsertPessoaException;
import com.tinderdog.repository.exceptions.pessoa.PessoaNotFoundException;
import com.tinderdog.repository.exceptions.pessoa.UpdatePessoaException;

import java.util.List;

public interface IPessoaRepository {
    Pessoa get(Pessoa dog) throws PessoaNotFoundException;
    List<Pessoa> getAll();
    List<Pessoa> getAll(int init, int end);
    Pessoa getById(int id) throws PessoaNotFoundException;
    void update(Pessoa pessoa) throws UpdatePessoaException;
    void insert(Pessoa pessoa) throws InsertPessoaException;
    void delete(Pessoa pessoa) throws PessoaNotFoundException;
    void deleteById(int pessoa) throws PessoaNotFoundException;
}
