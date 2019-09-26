package com.tinderdog.repository.facotry.sqlite;

import com.tinderdog.repository.api.sqlite.IDogRepository;
import com.tinderdog.repository.impl.sqlite.DogRepository;

public class DogRepositoryFactory {

    private static DogRepositoryFactory instance;

    public static DogRepositoryFactory getInstance(){
        if (instance == null){
            instance = new DogRepositoryFactory();
        }
        return instance;
    }

    public IDogRepository getRepository(){
        return new DogRepository();
    }

}
