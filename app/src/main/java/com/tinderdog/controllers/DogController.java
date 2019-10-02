package com.tinderdog.controllers;

import com.tinderdog.controllers.api.IDogController;
import com.tinderdog.repository.api.IDogRepository;
import com.tinderdog.models.Dog;
import com.tinderdog.repository.exception.dog.DogNotHaveOwnerException;
import com.tinderdog.repository.exception.dog.InsertDogException;
import com.tinderdog.repository.exception.dog.DogNotFoundException;
import com.tinderdog.repository.exception.dog.UpdateDogException;
import com.tinderdog.models.usuario.Pessoa;


public class DogController implements IDogController {
    private static DogController instance;
    private IDogRepository repositorio;

    public static DogController getInstance() {
        if (instance == null) {
            instance = new DogController();
        }
        return instance;
    }

    @Override
    public void get(Dog dog) throws DogNotFoundException {
        repositorio.get(dog);
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
    public void getById(int id) throws DogNotFoundException {
        if(id <= 0){
            throw new DogNotFoundException();
        }
        repositorio.getById(id);
    }

    @Override
    public void getByDono(Pessoa dono) {
        repositorio.getBy(dono);
    }

    @Override
    public void update(Dog dog) throws UpdateDogException, DogNotHaveOwnerException {
        if(dog == null){
            throw new UpdateDogException();
        }
        repositorio.update(dog);
    }

    @Override
    public void insert(Dog dog) throws InsertDogException,DogNotHaveOwnerException {
        if(dog == null){
            throw new InsertDogException();
        }
        repositorio.insert(dog);
    }

    @Override
    public void delete(Dog dog) throws DogNotFoundException {
        if(dog == null){
            throw new DogNotFoundException();
        }
        repositorio.delete(dog);
    }

    @Override
    public void deleteById(int dog) throws DogNotFoundException {
        repositorio.deleteById(dog);
    }
}