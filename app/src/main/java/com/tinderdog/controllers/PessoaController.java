package com.tinderdog.controllers;

import com.tinderdog.controllers.api.IPessoaController;
import com.tinderdog.repository.api.ILoginReposiitory;
import com.tinderdog.repository.api.IPessoaRepository;
import com.tinderdog.models.usuario.Pessoa;
import com.tinderdog.repository.exception.pessoa.InsertPessoaException;
import com.tinderdog.repository.exception.pessoa.PessoaNotFoundException;
import com.tinderdog.repository.exception.pessoa.UpdatePessoaException;
import com.tinderdog.repository.factoy.LoginRepositoryFactory;
import com.tinderdog.repository.factoy.PessoaRepositoryFactory;
import com.tinderdog.repository.impl.runtime.LoginRepository;

import java.util.List;

public class PessoaController implements IPessoaController {

    private static PessoaController instance;
    private IPessoaRepository pessoaRepositorio;
    private ILoginReposiitory loginReposiitory;

    public static PessoaController getInstance() {
        if (instance == null) {
            instance = new PessoaController();
        }
        return instance;
    }

    private PessoaController(){
        pessoaRepositorio = PessoaRepositoryFactory.getInstance().getRepository();
        loginReposiitory = LoginRepositoryFactory.getInstance().getRepository();
    }

    @Override
    public Pessoa getPessoa(Pessoa pessoa) throws PessoaNotFoundException {
        return pessoaRepositorio.get(pessoa);
    }

    @Override
    public List<Pessoa> getAllPessoas() {
        return pessoaRepositorio.getAll();
    }

    @Override
    public List<Pessoa> getAllPessoas(int init, int end) {
        return pessoaRepositorio.getAll(init,end);
    }

    @Override
    public Pessoa getPessoaById(int id) throws PessoaNotFoundException {
        if(id <= 0){
            throw new PessoaNotFoundException();
        }
        return pessoaRepositorio.getById(id);
    }

    @Override
    public Pessoa getPessoaByEmail(String email) throws PessoaNotFoundException {
        return pessoaRepositorio.getByEmail(email);
    }

    @Override
    public void updatePessoa(Pessoa pessoa) throws UpdatePessoaException{
        if(pessoa == null){
            throw new UpdatePessoaException();
        }
        pessoaRepositorio.update(pessoa);
    }

    @Override
    public void insertPessoa(Pessoa pessoa) throws InsertPessoaException {
        if(pessoa == null){
            throw new InsertPessoaException();
        }
        pessoaRepositorio.insert(pessoa);
    }

    @Override
    public void deletePessoa(Pessoa pessoa) throws PessoaNotFoundException {
        if(pessoa == null){
            throw new PessoaNotFoundException();
        }
        pessoaRepositorio.delete(pessoa);
    }

    @Override
    public void deletePessoaById(int pessoa) throws PessoaNotFoundException {
        pessoaRepositorio.deleteById(pessoa);
    }

}
