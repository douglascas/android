package com.tinderdog.repository.api.localstorage;

import com.tinderdog.models.Dog;
import com.tinderdog.repository.exceptions.dog.DogNotFoundException;
import com.tinderdog.repository.exceptions.dog.InsertDogException;
import com.tinderdog.repository.exceptions.dog.UpdateDogException;

import java.util.List;

public interface IDogRepository {
    Dog get(Dog dog) throws DogNotFoundException;
    List<Dog> getAll();
    List<Dog> getAll(int init, int end);
    List<Dog> searchForName(String name);
    List<Dog> searchForAge(double age);
    List<Dog> searchForAgeRange(double ageI, double ageE);
    List<Dog> searchForCity(String cityName);
    List<Dog> searchForState(String state);
    Dog getById(int id) throws DogNotFoundException;
    void update(Dog dog) throws UpdateDogException;
    void insert(Dog dog) throws InsertDogException;
    void delete(Dog dog) throws DogNotFoundException;
    void deleteById(Dog dog) throws DogNotFoundException;
}
