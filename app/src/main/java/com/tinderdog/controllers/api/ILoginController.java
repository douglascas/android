package com.tinderdog.controllers.api;

import com.tinderdog.models.usuario.Pessoa;

public interface ILoginController {

    Pessoa login(String email, String password);
    void logout();

}
