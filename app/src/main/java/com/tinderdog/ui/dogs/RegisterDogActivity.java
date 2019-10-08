package com.tinderdog.ui.dogs;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tinderdog.R;
import com.tinderdog.controllers.Facade;
import com.tinderdog.models.Dog;
import com.tinderdog.repository.factoy.LoginRepositoryFactory;
import com.tinderdog.ui.ActionChoiceActivity;
import com.tinderdog.ui.login.LoginActivity;

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
        etNome = findViewById(R.id.txtName);
        etCorPelagem = findViewById(R.id.txtCor);
        etIdade = findViewById(R.id.txtIdade);
        etPorte = findViewById(R.id.txtPorte);
        mbtnUpload = findViewById(R.id.btnUpload);
        imageUpload = findViewById(R.id.image);

        mbtnUpload.setOnClickListener(v -> {
            startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI), GET_FROM_GALLERY);
        });

        mbtnCadastro.setOnClickListener(v -> {

            String nome = etNome.getText().toString();
            String pelagem = etCorPelagem.getText().toString();
            double idade  = Double.parseDouble(etIdade.getText().toString());
            String  porte  = etPorte.getText().toString();
            Bitmap photo = ((BitmapDrawable)imageUpload.getDrawable()).getBitmap();

            Dog dog = new Dog(nome, pelagem, idade, porte, photo);

            facade.insertDog(dog, () -> {
                //Dog registrado!!
                Intent intent = new Intent(RegisterDogActivity.this, ActionChoiceActivity.class);
                startActivity(intent);
                //finishActivity(-1);
                Toast.makeText(RegisterDogActivity.this, R.string.dog_register_success, Toast.LENGTH_LONG).show();
                //Previne que o usuário volte a o registro passado
                finish();
            }, (error)-> Toast.makeText(RegisterDogActivity.this, error, Toast.LENGTH_LONG).show());
        });
    }

    @Override
    protected void onResume() {
        if (!LoginRepositoryFactory.getInstance().getRepository().isLogged()){
            //Usuário não esta logado existe.
            //Redireciona para o login
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        super.onResume();
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
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
