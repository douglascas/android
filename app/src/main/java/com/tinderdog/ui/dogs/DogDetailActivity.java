package com.tinderdog.ui.dogs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tinderdog.R;
import com.tinderdog.controllers.Facade;
import com.tinderdog.models.Dog;
import com.tinderdog.models.usuario.Endereco;
import com.tinderdog.repository.exception.dog.DogNotFoundException;
import com.tinderdog.repository.exception.pessoa.PessoaNotFoundException;

public class DogDetailActivity extends AppCompatActivity {

    private Button btnAdote;
    private Intent mIntent;
    private String location;

    private TextView txtName;
    private TextView txtAge;
    private TextView txtGait;
    private ImageView dogPhoto;

    private Facade facade = Facade.getInstance();

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtName = findViewById(R.id.txtName);
        txtAge = findViewById(R.id.txtAge);
        txtGait = findViewById(R.id.tvPorte);
        dogPhoto = findViewById(R.id.dogPhoto);
        btnAdote = findViewById(R.id.btnAdote);

        if (getIntent().getExtras() == null) {
            errorFallback();
            return;
        }
        int dog_id = getIntent().getExtras().getInt("dog_id", -1);
        if (!facade.dogExists(dog_id)) {
            errorFallback();
            return;
        }
        Dog dog;
        try {
            dog = facade.getDogById(dog_id);
            txtName.setText(getString(R.string.my_name_is, dog.getNome()));
            txtAge.setText(getString(R.string.my_age_is, dog.getIdade() + ""));
            txtGait.setText(getString(R.string.my_gait_is, dog.getPorte()));
            dogPhoto.setImageBitmap(dog.getPhoto());
        } catch (DogNotFoundException | PessoaNotFoundException e) {
            errorFallback();
            return;
        }
        Endereco owner_location = dog.getDono().getEndereco();
        if (owner_location == null) {
            errorFallback();
            return;
        }
        btnAdote.setOnClickListener(v -> {
            location = "geo:0,0?q=" + owner_location.getLogradouro() + ", " + owner_location.getCidade() + ", " + owner_location.getEstado();
            Uri mapUri = Uri.parse(location);
            mIntent = new Intent(Intent.ACTION_VIEW, mapUri);
            startActivity(mIntent);

        });

    }

    private void errorFallback() {
        Intent intent = new Intent(DogDetailActivity.this, ListarDogs.class);
        startActivity(intent);
        Toast.makeText(this, R.string.details_generic_error, Toast.LENGTH_SHORT).show();
        finish();
    }
}
