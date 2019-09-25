package com.tinderdog.repository.api.localstorage;

import com.tinderdog.models.Dog;
import com.tinderdog.repository.exceptions.DogNotFoundException;
import com.tinderdog.repository.exceptions.InsertDogException;
import com.tinderdog.repository.exceptions.UpdateDogException;

public interface IDogRepository {
    Dog get(Dog dog) throws DogNotFoundException;
    Dog getById(int id) throws DogNotFoundException;
    void update(Dog dog) throws UpdateDogException;
    void insert(Dog dog) throws InsertDogException;
    void delete(Dog dog) throws DogNotFoundException;
    void deleteById(Dog dog) throws DogNotFoundException;
}
