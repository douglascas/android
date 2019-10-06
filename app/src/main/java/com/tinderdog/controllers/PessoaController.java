package com.tinderdog.controllers;

import androidx.annotation.StringRes;

import com.tinderdog.R;
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
import java.util.function.Consumer;
import java.util.function.Predicate;

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
        if(pessoaRepositorio.getByEmail(email) == null)
            throw new PessoaNotFoundException();

        return pessoaRepositorio.getByEmail(email);
    }

    @Override
    public void insertPessoa(Pessoa pessoa) throws InsertPessoaException {

    }

    @Override
    public void updatePessoa(Pessoa pessoa) throws UpdatePessoaException{
        if(pessoa == null){
            throw new UpdatePessoaException();
        }
        pessoaRepositorio.update(pessoa);
    }

    @Override
    public void register(Pessoa pessoa, Runnable success, Consumer<Integer> error) {
        if(pessoa == null){
            error.accept(R.string.register_fatal_error);
            return;
        }

        if(pessoa.getNome().equals("") || pessoa.getCpf().equals("") || pessoa.getDt_nascimento().equals("") || pessoa.getEndereco() == null){
            error.accept(R.string.register_invalid);
            return;
        }

        if (pessoa.getLogin() == null){
            error.accept(R.string.register_fatal_error);
            return;
        }
        try {
            //Email já existe!
            if (pessoaRepositorio.emailExists(pessoa.getLogin().getEmail())){
                error.accept(R.string.register_email_already_exists);
                return;
            }
            if (pessoaRepositorio.cpfExists(pessoa.getCpf())){
                error.accept(R.string.register_cpf_already_exists);
                return;
            }
            pessoaRepositorio.insert(pessoa);
            success.run();
        } catch (InsertPessoaException ie){
            error.accept(R.string.register_fatal_error);
        }
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
