package com.tinderdog.repository.api.sqlite;

import com.tinderdog.models.Dog;
import com.tinderdog.repository.exception.dog.DogNotFoundException;
import com.tinderdog.repository.exception.dog.DogNotHaveOwnerException;
import com.tinderdog.repository.exception.dog.InsertDogException;
import com.tinderdog.repository.exception.dog.UpdateDogException;

import java.util.List;

public interface IDogRepository {
    Dog get(Dog dog) throws DogNotFoundException;
    List<Dog> getAll();
    List<Dog> getAll(int init, int end);
    List<Dog> searchForGait(String gait);
    List<Dog> searchForColor(String color);
    List<Dog> searchForAge(double age);
    List<Dog> searchForAgeRange(double ageI, double ageE);
    List<Dog> searchForCity(String cityName);
    List<Dog> searchForState(String state);
    Dog getById(int id) throws DogNotFoundException;
    void update(Dog dog) throws UpdateDogException, DogNotHaveOwnerException;
    void insert(Dog dog) throws InsertDogException, DogNotHaveOwnerException;
    void delete(Dog dog) throws DogNotFoundException;
    void deleteById(int id) throws DogNotFoundException;
}
