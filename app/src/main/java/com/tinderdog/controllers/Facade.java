package com.tinderdog.controllers;

import com.tinderdog.controllers.api.IDogController;
import com.tinderdog.controllers.api.IPessoaController;
import com.tinderdog.models.Dog;
import com.tinderdog.models.usuario.Pessoa;
import com.tinderdog.repository.exception.dog.DogNotFoundException;
import com.tinderdog.repository.exception.dog.DogNotHaveOwnerException;
import com.tinderdog.repository.exception.dog.InsertDogException;
import com.tinderdog.repository.exception.dog.UpdateDogException;
import com.tinderdog.repository.exception.pessoa.InsertPessoaException;
import com.tinderdog.repository.exception.pessoa.PessoaNotFoundException;
import com.tinderdog.repository.exception.pessoa.UpdatePessoaException;

import java.util.FormatterClosedException;

public class Facade implements IPessoaController, IDogController {

    private IPessoaController pessoaControlador;
    private static Facade instancia;

    public static Facade getInstance(){
        if(instancia == null){
            instancia = new Facade();
        }
        return instancia;
    }

    private Facade (){
        pessoaControlador = new PessoaController();
    }
    @Override
    public void get(Pessoa pessoa) throws PessoaNotFoundException {

    }

    @Override
    public void get(Dog dog) throws DogNotFoundException {

    }

    @Override
    public void getAll() {

    }

    @Override
    public void getAll(int init, int end) {

    }

    @Override
    public void getById(int id) throws PessoaNotFoundException {

    }

    @Override
    public void getByDono(Pessoa dono) {

    }

    @Override
    public void update(Dog dog) throws UpdateDogException, DogNotHaveOwnerException {

    }

    @Override
    public void insert(Dog dog) throws InsertDogException, DogNotHaveOwnerException {

    }

    @Override
    public void delete(Dog dog) throws DogNotFoundException {

    }

    @Override
    public void update(Pessoa pessoa) throws UpdatePessoaException {

    }

    @Override
    public void insert(Pessoa pessoa) throws InsertPessoaException {

    }

    @Override
    public void delete(Pessoa pessoa) throws PessoaNotFoundException {

    }

    @Override
    public void deleteById(int pessoa) throws PessoaNotFoundException {

    }
}
