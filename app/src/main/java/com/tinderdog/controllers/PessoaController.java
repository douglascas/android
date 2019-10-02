package com.tinderdog.controllers;

import com.tinderdog.controllers.api.IPessoaController;
import com.tinderdog.repository.api.IPessoaRepository;
import com.tinderdog.models.usuario.Pessoa;
import com.tinderdog.repository.exception.pessoa.InsertPessoaException;
import com.tinderdog.repository.exception.pessoa.PessoaNotFoundException;
import com.tinderdog.repository.exception.pessoa.UpdatePessoaException;
import com.tinderdog.repository.factoy.PessoaRepositoryFactory;

public class PessoaController implements IPessoaController {
    private static PessoaController instance;
    private IPessoaRepository repositorio;

    public static PessoaController getInstance() {
        if (instance == null) {
            instance = new PessoaController();
        }
        return instance;
    }

    private PessoaController(){
        repositorio = PessoaRepositoryFactory.getInstance().getRepository();
    }

    @Override
    public void get(Pessoa pessoa) throws PessoaNotFoundException {
        repositorio.get(pessoa);
    }

    @Override
    public void getAll() {
        repositorio.getAll();
    }

    @Override
    public void getAll(int init, int end) {
        repositorio.getAll(init,end);
    }

    @Override
    public void getById(int id) throws PessoaNotFoundException {
        if(id <= 0){
            throw new PessoaNotFoundException();
        }
        repositorio.getById(id);
    }

    @Override
    public void update(Pessoa pessoa) throws UpdatePessoaException{
        if(pessoa == null){
            throw new UpdatePessoaException();
        }
        repositorio.update(pessoa);
    }

    @Override
    public void insert(Pessoa pessoa) throws InsertPessoaException {
        if(pessoa == null){
            throw new InsertPessoaException();
        }
        repositorio.insert(pessoa);
    }

    @Override
    public void delete(Pessoa pessoa) throws PessoaNotFoundException {
        if(pessoa == null){
            throw new PessoaNotFoundException();
        }
        repositorio.delete(pessoa);
    }

    @Override
    public void deleteById(int pessoa) throws PessoaNotFoundException {
        repositorio.deleteById(pessoa);
    }
}
