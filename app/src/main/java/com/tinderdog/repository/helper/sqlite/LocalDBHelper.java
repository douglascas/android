package com.tinderdog.repository.helper.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tinderdog.TinderDogApp;

public class LocalDBHelper extends SQLiteOpenHelper {


    private static LocalDBHelper instance;

    public static LocalDBHelper getInstance(){
        if (instance == null){
            instance = new LocalDBHelper();
        }
        return instance;
    }


    private LocalDBHelper() {
        super(TinderDogApp.getContext(), "tindedog", null, 11);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR (180) NOT NULL, email VARCHAR (180), password VARCHAR (128), cpf VARCHAR (11) UNIQUE, birth_date DATE);");
        db.execSQL("CREATE TABLE user_adresses (user_id INTEGER REFERENCES users (id) ON DELETE CASCADE ON UPDATE NO ACTION UNIQUE NOT NULL PRIMARY KEY, cep VARCHAR (180), logradouro VARCHAR (180), bairro VARCHAR (180), cidade VARCHAR (180), estado VARCHAR (180));");
        db.execSQL("CREATE TABLE dogs (id INTEGER PRIMARY KEY AUTOINCREMENT, owner_id INTEGER REFERENCES users (id) ON DELETE CASCADE ON UPDATE NO ACTION NOT NULL, name VARCHAR (180), age DOUBLE, gait VARCHAR (180), color VARCHAR (180), photo BLOB);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
        while (c.moveToNext()) {
            if (c.getString(0).equals("sqlite_sequence")){
                continue;
            }
            db.execSQL("DROP TABLE IF EXISTS " + c.getString(0));
        }
        c.close();
        onCreate(db);
    }
}
