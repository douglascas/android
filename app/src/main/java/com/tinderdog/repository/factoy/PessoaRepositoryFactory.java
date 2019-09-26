package com.tinderdog.repository.factoy;

import com.tinderdog.repository.api.sqlite.IPessoaRepository;
import com.tinderdog.repository.impl.sqlite.PessoaRepository;

public class PessoaRepositoryFactory {

    private static PessoaRepositoryFactory instance;

    public static PessoaRepositoryFactory getInstance(){
        if (instance == null){
            instance = new PessoaRepositoryFactory();
        }
        return instance;
    }

    public IPessoaRepository getRepository(){
        return new PessoaRepository();
    }

}
