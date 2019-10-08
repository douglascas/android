package com.tinderdog.repository.api;

import com.tinderdog.models.usuario.Pessoa;

public interface ILoginReposiitory {
    boolean isLogged();
    void setLoggedUser(Pessoa pessoa);

    void logout();
    Pessoa getCurrentUser();
}
