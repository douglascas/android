package com.tinderdog.repository.helper.localstorage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class LocalDBHelper extends SQLiteOpenHelper {


    private static LocalDBHelper instance;

    public static LocalDBHelper getInstance(){
        if (instance == null){
            instance = new LocalDBHelper();
        }
        return instance;
    }


    private LocalDBHelper() {
        super(null, "dbname", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
