package com.tinderdog.controllers.api;

import com.tinderdog.models.Dog;
import com.tinderdog.models.usuario.Pessoa;
import com.tinderdog.repository.exception.dog.DogNotFoundException;
import com.tinderdog.repository.exception.dog.DogNotHaveOwnerException;
import com.tinderdog.repository.exception.dog.InsertDogException;
import com.tinderdog.repository.exception.dog.UpdateDogException;
import com.tinderdog.repository.exception.pessoa.InsertPessoaException;
import com.tinderdog.repository.exception.pessoa.PessoaNotFoundException;
import com.tinderdog.repository.exception.pessoa.UpdatePessoaException;

public interface IDogController {
    void get(Dog dog) throws DogNotFoundException;
    void getAll();
    void getAll(int init, int end);
    void getById(int id) throws DogNotFoundException, PessoaNotFoundException;

    void getByDono(Pessoa dono);

    void update(Dog dog) throws UpdateDogException,DogNotHaveOwnerException;
    void insert(Dog dog) throws InsertDogException,DogNotHaveOwnerException;
    void delete(Dog dog) throws DogNotFoundException;
    void deleteById(int dog) throws DogNotFoundException,PessoaNotFoundException;
}
