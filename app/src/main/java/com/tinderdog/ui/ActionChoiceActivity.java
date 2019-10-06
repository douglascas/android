package com.tinderdog.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tinderdog.R;
import com.tinderdog.models.Dog;
import com.tinderdog.ui.dogs.ListarDogs;
import com.tinderdog.ui.dogs.RegisterDogActivity;
import com.tinderdog.ui.pessoa.RegisterPessoaActivity;
import com.tinderdog.ui.dogs.ListarDogs;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;


public class ActionChoiceActivity extends AppCompatActivity {

    private Button mbtnAdotar;
    private Button mBtnCadastrarDog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        mbtnAdotar =  findViewById(R.id.btnAdote);
        mBtnCadastrarDog =  findViewById(R.id.btnAddDog);

        mbtnAdotar.setOnClickListener(v -> {
            Intent intent = new Intent(ActionChoiceActivity.this,ListarDogs.class);
            startActivity(intent);
        });

        mBtnCadastrarDog.setOnClickListener(v -> {
            Intent intent = new Intent(ActionChoiceActivity.this, RegisterDogActivity.class);
            startActivity(intent);
        });
    }

}
