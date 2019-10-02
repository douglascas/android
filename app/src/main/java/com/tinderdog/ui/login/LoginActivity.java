package com.tinderdog.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tinderdog.R;
import com.tinderdog.controllers.Facade;
import com.tinderdog.controllers.PessoaController;
import com.tinderdog.models.usuario.Pessoa;

public class LoginActivity extends AppCompatActivity {

    private Facade facade = Facade.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);

        loginButton.setOnClickListener(v -> {
            loadingProgressBar.setVisibility(View.VISIBLE);
            Pessoa authUser = facade.login(usernameEditText.getText().toString(),
                    passwordEditText.getText().toString());

            if (authUser == null){
                showLoginFailed(R.string.login_failed);
                return;
            }
            updateUiWithUser(authUser);
        });
    }


    private void updateUiWithUser(Pessoa pessoa) {
        Toast.makeText(getApplicationContext(), R.string.welcome, Toast.LENGTH_SHORT).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }
}
