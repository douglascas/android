package com.tinderdog.repository.impl.localstorage;

import android.database.Cursor;

import com.tinderdog.models.usuario.Endereco;
import com.tinderdog.models.usuario.Login;
import com.tinderdog.models.usuario.Pessoa;
import com.tinderdog.repository.api.localstorage.IPessoaRepository;
import com.tinderdog.repository.exceptions.pessoa.InsertPessoaException;
import com.tinderdog.repository.exceptions.pessoa.PessoaNotFoundException;
import com.tinderdog.repository.exceptions.pessoa.UpdatePessoaException;
import com.tinderdog.repository.helper.localstorage.LocalDBHelper;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepository implements IPessoaRepository {

    private LocalDBHelper dbh = LocalDBHelper.getInstance();

    @Override
    public Pessoa get(Pessoa pessoa) throws PessoaNotFoundException {
        return getById(pessoa.getId());
    }

    @Override
    public List<Pessoa> getAll() {
        Cursor c = dbh.getReadableDatabase()
                .rawQuery("SELECT * FROM users AS u INNER JOIN user_adresses AS wa ON wa.user_id = u.id",null);
        List<Pessoa> pessoas = new ArrayList<>();
        while (c.moveToNext()){
            pessoas.add(createPessoa(c));
        }
        c.close();
        return pessoas;
    }

    @Override
    public List<Pessoa> getAll(int init, int end) {
        Cursor c = dbh.getReadableDatabase()
                .rawQuery("SELECT * FROM users AS u INNER JOIN user_adresses AS wa ON wa.user_id = u.id LIMIT ?,?",
                        new String[]{init+"", end+""});
        List<Pessoa> pessoas = new ArrayList<>();
        while (c.moveToNext()){
            pessoas.add(createPessoa(c));
        }
        c.close();
        return pessoas;
    }

    @Override
    public Pessoa getById(int id) throws PessoaNotFoundException {
        Cursor c = dbh.getReadableDatabase()
                .rawQuery("SELECT * FROM users AS u INNER JOIN user_adresses AS wa ON wa.user_id = u.id WHERE i.id = ?",
                        new String[]{id + ""});
        if (!c.moveToNext()) {
            throw new PessoaNotFoundException();
        }
        return createPessoa(c);
    }

    @Override
    public void update(Pessoa pessoa) throws UpdatePessoaException {
        try {
            dbh.getWritableDatabase().execSQL("UPDATE users SET name = ?, email = ?, password = ?, cpf = ?, birth_date = ? WHERE id = ?",
                    new Object[]{
                            pessoa.getNome(),
                            pessoa.getLogin().getEmail(),
                            pessoa.getLogin().getSenha(),
                            pessoa.getCpf(),
                            pessoa.getDt_nascimento(),
                            pessoa.getId()
                    });
            dbh.getWritableDatabase().execSQL("UPDATE user_adresses SET cep = ?, logradouro = ?, bairro = ?, cidade = ?, estado = ? WHERE user_id =?;",
                    new Object[]{
                            pessoa.getEndereco().getCep(),
                            pessoa.getEndereco().getLogradouro(),
                            pessoa.getEndereco().getBairro(),
                            pessoa.getEndereco().getCidade(),
                            pessoa.getEndereco().getEstado()
                    });
        } catch (Exception e){
            throw new UpdatePessoaException();
        }
    }

    @Override
    public void insert(Pessoa pessoa) throws InsertPessoaException {

    }

    @Override
    public void delete(Pessoa pessoa) throws PessoaNotFoundException {
        deleteById(pessoa.getId());
    }

    @Override
    public void deleteById(int id) throws PessoaNotFoundException {
        Cursor c = dbh.getReadableDatabase()
                .rawQuery("SELECT * FROM users AS u INNER JOIN user_adresses AS wa ON wa.user_id = u.id WHERE i.id = ?",
                        new String[]{id+""});
        if (!c.moveToNext()){
            throw new PessoaNotFoundException();
        }
        int pessoaId = c.getInt(c.getColumnIndex("id"));
        dbh.getWritableDatabase().execSQL("DELETE FROM users WHERE id = ?;", new Object[]{pessoaId});
        c.close();
    }

    private Pessoa createPessoa(Cursor c){
        Pessoa pessoa = new Pessoa();
        Endereco endereco = new Endereco();
        Login login = new Login();
        pessoa.setId(c.getInt(c.getColumnIndex("id")));
        pessoa.setNome(c.getString(c.getColumnIndex("name")));
        pessoa.setCpf(c.getString(c.getColumnIndex("cpf")));
        pessoa.setDt_nascimento(c.getString(c.getColumnIndex("birth_date")));
        endereco.setCep(c.getString(c.getColumnIndex("cep")));
        //Login
        login.setEmail(c.getString(c.getColumnIndex("email")));
        login.setSenha(c.getString(c.getColumnIndex("password")));
        //Endereço
        endereco.setLogradouro(c.getString(c.getColumnIndex("logradouro")));
        endereco.setCidade(c.getString(c.getColumnIndex("cidade")));
        endereco.setEstado(c.getString(c.getColumnIndex("estado")));

        pessoa.setEndereco(endereco);
        pessoa.setLogin(login);
        return pessoa;
    }
}
