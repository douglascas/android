package com.tinderdog.ui.dogs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tinderdog.R;

import java.util.List;

public class DogDetailActivity extends AppCompatActivity {

    private Button btnAdote;
    private Intent mIntent;
    private String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setContentView(R.layout.activity_detail);

        btnAdote = findViewById(R.id.btnAdote);

        btnAdote.setOnClickListener(v -> {

            //implementar metodo no repositorio que veja qual endereco da pessoa do dog
            //location = "geo:0,0?q=" + pessoas.getDog(i).getEndereco().logradouro
            location = "geo:0,0?q=3600 Av Conselheiro Aguiar, Recife, Pernambuco";
            Uri mapUri = Uri.parse(location);
            mIntent = new Intent(Intent.ACTION_VIEW, mapUri);
            //mIntent.setPackage("com.google.android.apps.maps");
            startActivity(mIntent);

        });

    }
}
