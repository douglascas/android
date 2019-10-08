package com.tinderdog.ui.dogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.tinderdog.R;
import com.tinderdog.controllers.Facade;
import com.tinderdog.models.usuario.Pessoa;
import com.tinderdog.models.Dog;
import com.tinderdog.repository.exception.dog.DogNotHaveOwnerException;
import com.tinderdog.repository.exception.dog.InsertDogException;
import com.tinderdog.repository.exception.pessoa.InsertPessoaException;
import com.tinderdog.repository.factoy.LoginRepositoryFactory;
import com.tinderdog.repository.factoy.PessoaRepositoryFactory;
import com.tinderdog.ui.login.LoginActivity;
import com.tinderdog.ui.pessoa.RegisterPessoaActivity;

import java.io.FileNotFoundException;
import java.io.IOException;

public class RegisterDogActivity extends AppCompatActivity {

    private Button mbtnCadastro;
    private Button mbtnUpload;
    private ImageView imageUpload;
    private EditText etNome;
    private EditText etCorPelagem;
    private EditText etIdade;
    private EditText etPorte;
    public static final int GET_FROM_GALLERY = 3;
    private Facade facade = Facade.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_dog);

        mbtnCadastro = findViewById(R.id.btnCadastro);
        Pessoa pessoa = LoginRepositoryFactory.getInstance().getRepository().getCurrentUser();
        //Usuário não esta logado existe.
        if (pessoa == null){
            //Redireciona para o login
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        etNome = findViewById(R.id.txtEmail);
        etCorPelagem = findViewById(R.id.txtPwd);
        etIdade = findViewById(R.id.txtName);
        etPorte = findViewById(R.id.txtData);
        mbtnUpload = findViewById(R.id.btnUpload);
        imageUpload = findViewById(R.id.image);

        mbtnUpload.setOnClickListener(v -> {
            startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), GET_FROM_GALLERY);
        });

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==GET_FROM_GALLERY && resultCode == Activity.RESULT_OK) {
            Uri selectedImage = data.getData();
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),selectedImage);
                imageUpload.setImageBitmap(bitmap);
            }catch (FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
