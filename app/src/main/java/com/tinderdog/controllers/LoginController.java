package com.tinderdog.controllers;

import com.tinderdog.controllers.api.ILoginController;
import com.tinderdog.controllers.api.IPessoaController;
import com.tinderdog.models.usuario.Pessoa;
import com.tinderdog.repository.api.ILoginReposiitory;
import com.tinderdog.repository.exception.pessoa.PessoaNotFoundException;
import com.tinderdog.repository.factoy.LoginRepositoryFactory;
import com.tinderdog.util.PasswordVerification;

public class LoginController implements ILoginController {

    private static LoginController instance;

    public static LoginController getInstance() {
        if (instance == null) {
            instance = new LoginController();
        }
        return instance;
    }

    private IPessoaController pessoaController;
    private ILoginReposiitory loginReposiitory;

    private LoginController(){
        pessoaController = PessoaController.getInstance();
        loginReposiitory = LoginRepositoryFactory.getInstance().getRepository();
    }


    @Override
    public Pessoa login(String email, String password) {
        try {
            Pessoa p = pessoaController.getPessoaByEmail(email);
            if (PasswordVerification.validate(p.getLogin().getSenha(), password)){
                loginReposiitory.setLoggedUser(p);
                return p;
            }
            return null;
        } catch (PessoaNotFoundException e) {
            return null;
        }
    }

    @Override
    public void logout() {
        loginReposiitory.setLoggedUser(null);
    }
}
