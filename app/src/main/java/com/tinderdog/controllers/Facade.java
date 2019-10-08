package com.tinderdog.controllers;

import com.tinderdog.controllers.api.IDogController;
import com.tinderdog.controllers.api.ILoginController;
import com.tinderdog.controllers.api.IPessoaController;
import com.tinderdog.models.Dog;
import com.tinderdog.models.usuario.Pessoa;
import com.tinderdog.repository.exception.dog.DogNotFoundException;
import com.tinderdog.repository.exception.dog.DogNotHaveOwnerException;
import com.tinderdog.repository.exception.dog.UpdateDogException;
import com.tinderdog.repository.exception.pessoa.InsertPessoaException;
import com.tinderdog.repository.exception.pessoa.PessoaNotFoundException;
import com.tinderdog.repository.exception.pessoa.UpdatePessoaException;

import java.util.List;
import java.util.function.Consumer;

public class Facade implements IPessoaController, IDogController, ILoginController {

    private IPessoaController pessoaController;
    private ILoginController loginController;
    private IDogController dogController;
    private static Facade instancia;

    public static Facade getInstance(){
        if(instancia == null){
            instancia = new Facade();
        }
        return instancia;
    }

    private Facade (){
        pessoaController = PessoaController.getInstance();
        loginController = LoginController.getInstance();
        dogController = DogController.getInstance();
    }


//    Login controller
    @Override
    public Pessoa login(String email, String password) {
        return this.loginController.login(email,password);
    }

    @Override
    public boolean isLogged() {
        return this.loginController.isLogged();
    }

    @Override
    public Pessoa getCurrentUser() {
        return this.loginController.getCurrentUser();
    }

    @Override
    public void logout() {
        this.loginController.logout();
    }


//    Dog Controller
    @Override
    public Dog getDog(Dog dog) throws DogNotFoundException {
        return dogController.getDog(dog);
    }

    @Override
    public List<Dog> getAllDogs() {
        return dogController.getAllDogs();
    }

    @Override
    public List<Dog> getAllDogs(int init, int end) {
        return dogController.getAllDogs(init, end);
    }

    @Override
    public Dog getDogById(int id) throws DogNotFoundException, PessoaNotFoundException {
        return dogController.getDogById(id);
    }

    @Override
    public Dog getDogByDono(Pessoa dono) {
        return dogController.getDogByDono(dono);
    }

    @Override
    public void updateDog(Dog dog) throws UpdateDogException, DogNotHaveOwnerException {
        dogController.updateDog(dog);
    }

    @Override
    public void insertDog(Dog dog, Runnable success, Consumer<Integer> error) {
        dogController.insertDog(dog, success, error);
    }

    @Override
    public void deleteDog(Dog dog) throws DogNotFoundException {
        dogController.deleteDog(dog);
    }

    @Override
    public void deleteDogById(int dog) throws DogNotFoundException, PessoaNotFoundException {
        dogController.deleteDogById(dog);
    }

    @Override
    public boolean dogExists(int id) {
        return dogController.dogExists(id);
    }


    //    Pessoa Controller
    @Override
    public Pessoa getPessoa(Pessoa pessoa) throws PessoaNotFoundException {
        return pessoaController.getPessoa(pessoa);
    }

    @Override
    public List<Pessoa> getAllPessoas() {
        return pessoaController.getAllPessoas();
    }

    @Override
    public List<Pessoa> getAllPessoas(int init, int end) {
        return pessoaController.getAllPessoas(init,end);
    }

    @Override
    public Pessoa getPessoaById(int id) throws PessoaNotFoundException {
        return pessoaController.getPessoaById(id);
    }

    @Override
    public Pessoa getPessoaByEmail(String email) throws PessoaNotFoundException {
        return pessoaController.getPessoaByEmail(email);
    }

    @Override
    public void insertPessoa(Pessoa pessoa) throws InsertPessoaException {
        pessoaController.insertPessoa(pessoa);
    }

    @Override
    public void updatePessoa(Pessoa pessoa) throws UpdatePessoaException {
        pessoaController.updatePessoa(pessoa);
    }

    @Override
    public void register(Pessoa pessoa, Runnable success, Consumer<Integer> error) {
        pessoaController.register(pessoa, success, error);
    }

    @Override
    public void deletePessoa(Pessoa pessoa) throws PessoaNotFoundException {
        pessoaController.deletePessoa(pessoa);
    }

    @Override
    public void deletePessoaById(int pessoa) throws PessoaNotFoundException {
        pessoaController.deletePessoaById(pessoa);
    }
}
