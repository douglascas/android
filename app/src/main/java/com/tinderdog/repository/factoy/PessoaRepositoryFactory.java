package com.tinderdog.repository.factoy;

import com.tinderdog.repository.api.IPessoaRepository;
import com.tinderdog.repository.impl.sqlite.PessoaRepository;

public class PessoaRepositoryFactory {

    private static PessoaRepositoryFactory instance;

    public static PessoaRepositoryFactory getInstance(){
        if (instance == null){
            instance = new PessoaRepositoryFactory();
        }
        return instance;
    }

    private PessoaRepositoryFactory() {
    }

    public IPessoaRepository getRepository(){
        return new PessoaRepository();
    }

}
