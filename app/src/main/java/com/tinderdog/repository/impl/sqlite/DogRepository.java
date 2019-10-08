package com.tinderdog.repository.impl.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tinderdog.models.Dog;
import com.tinderdog.models.usuario.Pessoa;
import com.tinderdog.repository.api.IDogRepository;
import com.tinderdog.repository.api.IPessoaRepository;
import com.tinderdog.repository.exception.dog.DogNotFoundException;
import com.tinderdog.repository.exception.dog.DogNotHaveOwnerException;
import com.tinderdog.repository.exception.dog.InsertDogException;
import com.tinderdog.repository.exception.dog.UpdateDogException;
import com.tinderdog.repository.exception.pessoa.PessoaNotFoundException;
import com.tinderdog.repository.factoy.PessoaRepositoryFactory;
import com.tinderdog.repository.helper.sqlite.LocalDBHelper;
import com.tinderdog.util.ImageUtil;

import java.util.ArrayList;
import java.util.List;

public class DogRepository implements IDogRepository {

    private LocalDBHelper dbh = LocalDBHelper.getInstance();
    private IPessoaRepository pessoaRepository = PessoaRepositoryFactory.getInstance().getRepository();

    @Override
    public Dog get(Dog dog) throws DogNotFoundException {
        return getById(dog.getId());
    }

    @Override
    public List<Dog> getAll() {
        Cursor c = dbh.getReadableDatabase()
            .rawQuery("SELECT * FROM dogs",null);
        List<Dog> dogs = new ArrayList<>();
        while (c.moveToNext()){
            dogs.add(createDogInstance(c));
        }
        c.close();
        return dogs;
    }

    @Override
    public List<Dog> getAll(int init, int end) {
        Cursor c = dbh.getReadableDatabase()
                .rawQuery("SELECT * FROM dogs LIMIT ?,?",
                        new String[]{init+"", end+""});
        List<Dog> dogs = new ArrayList<>();
        while (c.moveToNext()){
            dogs.add(createDogInstance(c));
        }
        c.close();
        return dogs;
    }

    @Override
    public List<Dog> searchForGait(String gait) {
        Cursor c = dbh.getReadableDatabase()
                .rawQuery("SELECT * FROM dogs WHERE gait LIKE ?",
                        new String[]{"%"+gait+"%"});
        List<Dog> dogs = new ArrayList<>();
        while (c.moveToNext()){
            dogs.add(createDogInstance(c));
        }
        c.close();
        return dogs;
    }

    @Override
    public List<Dog> searchForColor(String color) {
        Cursor c = dbh.getReadableDatabase()
                .rawQuery("SELECT * FROM dogs WHERE color LIKE ?",
                        new String[]{"%"+color+"%"});
        List<Dog> dogs = new ArrayList<>();
        while (c.moveToNext()){
            dogs.add(createDogInstance(c));
        }
        c.close();
        return dogs;
    }

    @Override
    public List<Dog> searchForAge(double age) {
        return searchForAgeRange(age,age);
    }

    @Override
    public List<Dog> searchForAgeRange(double ageI, double ageE) {
        Cursor c = dbh.getReadableDatabase()
                .rawQuery("SELECT * FROM dogs WHERE age BETWEEN ? AND ?",
                        new String[]{ageI+"", ageE+""});
        List<Dog> dogs = new ArrayList<>();
        while (c.moveToNext()){
            dogs.add(createDogInstance(c));
        }
        c.close();
        return dogs;
    }

    @Override
    public List<Dog> searchForCity(String cityName) {
        Cursor c = dbh.getReadableDatabase()
                .rawQuery("SELECT * FROM dogs AS d INNER JOIN user_adresses AS ua ON d.owner_id = ua.user_id WHERE ua.cidade LIKE ?",
                        new String[]{cityName});
        List<Dog> dogs = new ArrayList<>();
        while (c.moveToNext()){
            dogs.add(createDogInstance(c));
        }
        c.close();
        return dogs;
    }

    @Override
    public List<Dog> searchForState(String state) {
        Cursor c = dbh.getReadableDatabase()
                .rawQuery("SELECT * FROM dogs AS d INNER JOIN user_adresses AS ua ON d.owner_id = ua.user_id WHERE ua.estado LIKE ?",
                        new String[]{state});
        List<Dog> dogs = new ArrayList<>();
        while (c.moveToNext()){
            dogs.add(createDogInstance(c));
        }
        c.close();
        return dogs;
    }

    @Override
    public List<Dog> searchForOwner(int ownerId) {
        Cursor c = dbh.getReadableDatabase()
                .rawQuery("SELECT * FROM dogs WHERE owner_id = ?",
                        new String[]{"%"+ownerId+"%"});
        List<Dog> dogs = new ArrayList<>();
        while (c.moveToNext()){
            dogs.add(createDogInstance(c));
        }
        c.close();
        return dogs;
    }

    @Override
    public Dog getBy(Pessoa dono) {
        return null;
    }

    @Override
    public Dog getById(int id) throws DogNotFoundException {
        Cursor c = dbh.getReadableDatabase()
                .rawQuery("SELECT * FROM dogs WHERE id = ?",
                        new String[]{id + ""});
        if (!c.moveToNext()) {
            throw new DogNotFoundException();
        }
        return createDogInstance(c);
    }

    @Override
    public void update(Dog dog) throws UpdateDogException, DogNotHaveOwnerException {
        if (dog.getDono() == null){
            throw new DogNotHaveOwnerException();
        }
        try {
            SQLiteDatabase db = dbh.getWritableDatabase();
            db.execSQL("UPDATE dogs SET owner_id = ?, name = ?, age = ?, gait = ?, color = ?, photo = ? WHERE id = ?",
                    new Object[]{
                            dog.getDono().getId(),
                            dog.getNome(),
                            dog.getIdade(),
                            dog.getPorte(),
                            dog.getCor_pelagem(),
                            ImageUtil.bitmapToByteArr(dog.getPhoto()),
                            dog.getId()
                    });
            db.close();
        } catch (Exception e){
            throw new UpdateDogException();
        }
    }

    @Override
    public void insert(Dog dog) throws InsertDogException, DogNotHaveOwnerException {
        if (dog.getDono() == null){
            throw new DogNotHaveOwnerException();
        }
        SQLiteDatabase db = dbh.getWritableDatabase();
        db.execSQL("INSERT INTO dogs (owner_id,name,age,gait,color,photo) VALUES (?,?,?,?,?,?);",
                new Object[]{
                        dog.getDono().getId(),
                        dog.getNome(),
                        dog.getIdade(),
                        dog.getPorte(),
                        dog.getCor_pelagem(),
                        ImageUtil.bitmapToByteArr(dog.getPhoto())
                });
        db.close();
    }

    @Override
    public void delete(Dog dog) throws DogNotFoundException {
        deleteById(dog.getId());
    }

    @Override
    public void deleteById(int id) throws DogNotFoundException {
        Cursor c = dbh.getReadableDatabase()
                .rawQuery("SELECT * FROM dogs WHERE id = ?",
                        new String[]{id+""});
        if (!c.moveToNext()){
            throw new DogNotFoundException();
        }
        int dogId = c.getInt(c.getColumnIndex("id"));
        SQLiteDatabase db = dbh.getWritableDatabase();
        db.execSQL("DELETE FROM dogs WHERE id = ?;", new Object[]{dogId});
        db.close();
        c.close();
    }

    @Override
    public boolean dogExists(int id) {
        Cursor c = dbh.getReadableDatabase()
                .rawQuery("SELECT id FROM dogs WHERE id = ?",
                        new String[]{id + ""});
        boolean r = c.moveToNext();
        c.close();
        return r;
    }

    private Dog createDogInstance(Cursor c){
        return createDogInstance(c, true);
    }

    private Dog createDogInstance(Cursor c, boolean buildOwner){
        Dog dog = new Dog();
        dog.setId(c.getInt(c.getColumnIndex("id")));
        dog.setIdade(c.getDouble(c.getColumnIndexOrThrow("age")));
        dog.setNome(c.getString(c.getColumnIndex("name")));
        dog.setPorte(c.getString(c.getColumnIndex("gait")));
        dog.setCor_pelagem(c.getString(c.getColumnIndex("color")));
        dog.setPhoto(ImageUtil.byteArrToBitmap(c.getBlob(c.getColumnIndex("photo"))));
        //Não sei se isso vale a pena...
        Pessoa owner;
        if (buildOwner){
            try{
                owner = pessoaRepository.getById(c.getInt(c.getColumnIndex("owner_id")));
            } catch (PessoaNotFoundException e) {
                owner = null;
            }
        } else {
            owner = new Pessoa();
            owner.setId(c.getInt(c.getColumnIndex("owner_id")));
        }
        dog.setDono(owner);
        return dog;
    }
}
