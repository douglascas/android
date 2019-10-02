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

import java.util.List;

public interface IDogController {
    Dog getDog(Dog dog) throws DogNotFoundException;
    List<Dog> getAllDogs();
    List<Dog> getAllDogs(int init, int end);
    Dog getDogById(int id) throws DogNotFoundException, PessoaNotFoundException;
    Dog getDogByDono(Pessoa dono);

    void updateDog(Dog dog) throws UpdateDogException,DogNotHaveOwnerException;
    void insertDog(Dog dog) throws InsertDogException,DogNotHaveOwnerException;
    void deleteDog(Dog dog) throws DogNotFoundException;
    void deleteDogById(int dog) throws DogNotFoundException,PessoaNotFoundException;
}
