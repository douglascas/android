package com.tinderdog.repository.helper.localstorage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LocalDBHelper extends SQLiteOpenHelper {


    private static LocalDBHelper instance;

    public static LocalDBHelper getInstance(){
        if (instance == null){
            instance = new LocalDBHelper();
        }
        return instance;
    }


    private LocalDBHelper() {
        super(null, "local.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "PRAGMA foreign_keys = off;"
                + "BEGIN TRANSACTION;"
                + "CREATE TABLE dogs (id INTEGER PRIMARY KEY AUTOINCREMENT, owner_id INTEGER REFERENCES users (id) ON DELETE CASCADE ON UPDATE NO ACTION NOT NULL, name VARCHAR (180), age DOUBLE, gait VARCHAR (180));"
                + "CREATE TABLE user_adresses (user_id INTEGER REFERENCES users (id) ON DELETE CASCADE ON UPDATE NO ACTION UNIQUE NOT NULL, cep VARCHAR (180), logradouro VARCHAR (180), bairro VARCHAR (180), cidade VARCHAR (180), estado VARCHAR (180));"
                + "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR (180) NOT NULL, email VARCHAR (180), password VARCHAR (128), cpf VARCHAR (11) UNIQUE, birth_date DATE);"
                + "COMMIT TRANSACTION;"
                + "PRAGMA foreign_keys = on;";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
        while (c.moveToNext()) {
            db.execSQL("DROP TABLE IF EXISTS " + c.getString(0));
        }
        c.close();
        onCreate(db);
    }
}
