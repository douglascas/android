package com.tinderdog.ui.dogs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tinderdog.R;
import com.tinderdog.controllers.Facade;
import com.tinderdog.models.usuario.Pessoa;
import com.tinderdog.models.Dog;
import com.tinderdog.repository.exception.dog.DogNotHaveOwnerException;
import com.tinderdog.repository.exception.dog.InsertDogException;
import com.tinderdog.repository.exception.pessoa.InsertPessoaException;

public class RegisterDogActivity extends AppCompatActivity {

    private Button mbtnCadastro;
    private EditText etNome;
    private EditText etCorPelagem;
    private EditText etIdade;
    private EditText etPorte;
    private Facade facade = Facade.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_dog);

        mbtnCadastro = findViewById(R.id.btnCadastro);
        Pessoa pessoa = (Pessoa) getIntent().getSerializableExtra("pessoa");

        etNome = findViewById(R.id.txtEmail);
        etCorPelagem = findViewById(R.id.txtPwd);
        etIdade = findViewById(R.id.txtName);
        etPorte = findViewById(R.id.txtData);



        mbtnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = etNome.getText().toString();
                String pelagem = etCorPelagem.getText().toString();
                double idade  = Double.parseDouble(etIdade.getText().toString());
                String  porte  = etPorte.getText().toString();

                Dog dog = new Dog(1, pessoa, nome, pelagem, idade, porte);

                try {
                    facade.insertDog(dog);
                } catch (InsertDogException e) {
                    e.printStackTrace();
                } catch (DogNotHaveOwnerException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
