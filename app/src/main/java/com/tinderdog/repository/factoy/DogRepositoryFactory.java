package com.tinderdog.repository.factoy;

import com.tinderdog.repository.api.IDogRepository;
import com.tinderdog.repository.impl.sqlite.DogRepository;

public class DogRepositoryFactory {

    private static DogRepositoryFactory instance;

    public static DogRepositoryFactory getInstance(){
        if (instance == null){
            instance = new DogRepositoryFactory();
        }
        return instance;
    }

    private DogRepositoryFactory() {
    }

    public IDogRepository getRepository(){
        return new DogRepository();
    }

}
