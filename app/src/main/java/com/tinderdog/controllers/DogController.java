package com.tinderdog.controllers;

import com.tinderdog.controllers.api.IDogController;
import com.tinderdog.repository.api.IDogRepository;
import com.tinderdog.models.Dog;
import com.tinderdog.repository.exception.dog.DogNotHaveOwnerException;
import com.tinderdog.repository.exception.dog.InsertDogException;
import com.tinderdog.repository.exception.dog.DogNotFoundException;
import com.tinderdog.repository.exception.dog.UpdateDogException;
import com.tinderdog.models.usuario.Pessoa;
import com.tinderdog.repository.factoy.DogRepositoryFactory;

import java.util.List;


public class DogController implements IDogController {
    private static DogController instance;
    private IDogRepository repositorio;

    public static DogController getInstance() {
        if (instance == null) {
            instance = new DogController();
        }
        return instance;
    }

    private DogController(){
        repositorio = DogRepositoryFactory.getInstance().getRepository();
    }

    @Override
    public Dog getDog(Dog dog) throws DogNotFoundException {
        return repositorio.get(dog);
    }

    @Override
    public List<Dog> getAllDogs() {
        return repositorio.getAll();
    }

    @Override
    public List<Dog> getAllDogs(int init, int end) {
        return repositorio.getAll(init,end);
    }

    @Override
    public Dog getDogById(int id) throws DogNotFoundException {
        if(id <= 0){
            throw new DogNotFoundException();
        }
        return repositorio.getById(id);
    }

    @Override
    public Dog getDogByDono(Pessoa dono) {
        return repositorio.getBy(dono);
    }

    @Override
    public void updateDog(Dog dog) throws UpdateDogException, DogNotHaveOwnerException {
        if(dog == null){
            throw new UpdateDogException();
        }
        repositorio.update(dog);
    }

    @Override
    public void insertDog(Dog dog) throws InsertDogException,DogNotHaveOwnerException {
        if(dog == null){
            throw new InsertDogException();
        }
        repositorio.insert(dog);
    }

    @Override
    public void deleteDog(Dog dog) throws DogNotFoundException {
        if(dog == null){
            throw new DogNotFoundException();
        }
        repositorio.delete(dog);
    }

    @Override
    public void deleteDogById(int dog) throws DogNotFoundException {
        repositorio.deleteById(dog);
    }
}