package com.tinderdog.repository.factoy;

import com.tinderdog.repository.api.IDogRepository;
import com.tinderdog.repository.api.ILoginReposiitory;
import com.tinderdog.repository.impl.runtime.LoginRepository;
import com.tinderdog.repository.impl.sqlite.DogRepository;

public class LoginRepositoryFactory {

    private static LoginRepositoryFactory instance;

    public static LoginRepositoryFactory getInstance(){
        if (instance == null){
            instance = new LoginRepositoryFactory();
        }
        return instance;
    }

    private LoginRepositoryFactory() {
    }

    private ILoginReposiitory loginReposiitory;

    public ILoginReposiitory getRepository(){
        if (loginReposiitory == null){
            loginReposiitory = new LoginRepository();
        }
        return loginReposiitory;
    }


}
