package com.tinderdog.repository.impl.runtime;

import com.tinderdog.models.usuario.Pessoa;
import com.tinderdog.repository.api.ILoginReposiitory;

public class LoginRepository implements ILoginReposiitory {
    private Pessoa currentUser;

    @Override
    public boolean isLogged() {
        return currentUser != null;
    }

    @Override
    public void setLoggedUser(Pessoa pessoa) {
        currentUser = pessoa;
    }

    @Override
    public Pessoa getCurrentUser() {
        return currentUser;
    }
}
