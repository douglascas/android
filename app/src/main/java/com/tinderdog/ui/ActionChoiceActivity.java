package com.tinderdog.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.tinderdog.R;
import com.tinderdog.repository.factoy.LoginRepositoryFactory;
import com.tinderdog.ui.dogs.ListarDogs;
import com.tinderdog.ui.dogs.RegisterDogActivity;
import com.tinderdog.ui.login.LoginActivity;


public class ActionChoiceActivity extends AppCompatActivity {

    private Button mbtnAdotar;
    private Button mBtnCadastrarDog;
    private Button mBtnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        mbtnAdotar =  findViewById(R.id.btnAdote);
        mBtnCadastrarDog =  findViewById(R.id.btnAddDog);
        mBtnLogout = findViewById(R.id.logout);
        mBtnLogout.setOnClickListener(v -> {
            LoginRepositoryFactory.getInstance().getRepository().logout();
            Intent intent = new Intent(ActionChoiceActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

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
