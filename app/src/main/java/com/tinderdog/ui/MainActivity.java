package com.tinderdog.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tinderdog.R;
import com.tinderdog.controllers.Facade;
import com.tinderdog.models.usuario.Pessoa;
import com.tinderdog.ui.pessoa.RegisterPessoaActivity;

public class MainActivity extends AppCompatActivity {

    private Facade facade = Facade.getInstance();
    private Pessoa pessoa;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final Button registerBuutton = findViewById(R.id.register);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);

        loginButton.setOnClickListener(v -> {
            loadingProgressBar.setVisibility(View.VISIBLE);
            Pessoa authUser = facade.login(usernameEditText.getText().toString(),
                    passwordEditText.getText().toString());
            loadingProgressBar.setVisibility(View.INVISIBLE);
            if (authUser == null){
                showLoginFailed();
                return;
            }
            updateUiWithUser(authUser);
            pessoa = authUser;
        });

        registerBuutton.setOnClickListener(v->{
            Intent intent = new Intent(this, RegisterPessoaActivity.class);
            startActivity(intent);
        });

    }

    @Override
    protected void onResume() {
        if(facade.isLogged()){
            Intent intent = new Intent(this, ActionChoiceActivity.class);
            // passando a lista
            intent.putExtra("pessoa", pessoa);
            startActivity(intent);
        }
        super.onResume();
    }

    private void updateUiWithUser(Pessoa pessoa) {
        Toast.makeText(getApplicationContext(), R.string.welcome, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ActionChoiceActivity.class);
        startActivity(intent);
    }

    private void showLoginFailed() {
        Toast.makeText(getApplicationContext(), R.string.login_failed, Toast.LENGTH_SHORT).show();
    }
}
