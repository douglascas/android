package com.tinderdog.repository.impl.localstorage;

import com.tinderdog.models.Dog;
import com.tinderdog.repository.api.localstorage.IDogRepository;
import com.tinderdog.repository.exceptions.DogNotFoundException;
import com.tinderdog.repository.exceptions.InsertDogException;
import com.tinderdog.repository.exceptions.UpdateDogException;
import com.tinderdog.repository.helper.localstorage.LocalDBHelper;

public class DogRepository implements IDogRepository {

    private LocalDBHelper db = LocalDBHelper.getInstance();

    @Override
    public Dog get(Dog dog) throws DogNotFoundException {
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
