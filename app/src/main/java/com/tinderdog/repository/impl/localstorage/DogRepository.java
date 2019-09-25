package com.tinderdog.repository.impl.localstorage;

import com.tinderdog.models.Dog;
import com.tinderdog.repository.api.localstorage.IDogRepository;
import com.tinderdog.repository.exceptions.dog.DogNotFoundException;
import com.tinderdog.repository.exceptions.dog.InsertDogException;
import com.tinderdog.repository.exceptions.dog.UpdateDogException;
import com.tinderdog.repository.helper.localstorage.LocalDBHelper;

import java.util.List;

public class DogRepository implements IDogRepository {

    private LocalDBHelper dbh = LocalDBHelper.getInstance();

    @Override
    public Dog get(Dog dog) throws DogNotFoundException {
        return null;
    }

    @Override
    public List<Dog> getAll() {
        return null;
    }

    @Override
    public List<Dog> getAll(int init, int end) {
        return null;
    }

    @Override
    public List<Dog> searchForName(String name) {
        return null;
    }

    @Override
    public List<Dog> searchForAge(double age) {
        return null;
    }

    @Override
    public List<Dog> searchForAgeRange(double ageI, double ageE) {
        return null;
    }

    @Override
    public List<Dog> searchForCity(String cityName) {
        return null;
    }

    @Override
    public List<Dog> searchForState(String state) {
        return null;
    }

    @Override
    public Dog getById(int id) throws DogNotFoundException {
        return null;
    }

    @Override
    public void update(Dog dog) throws UpdateDogException {

    }

    @Override
    public void insert(Dog dog) throws InsertDogException {

    }

    @Override
    public void delete(Dog dog) throws DogNotFoundException {

    }

    @Override
    public void deleteById(Dog dog) throws DogNotFoundException {

    }
}
