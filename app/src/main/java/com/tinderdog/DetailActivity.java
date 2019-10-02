package com.tinderdog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private Button btnAdote;
    private Intent mIntent;
    //private List<Dog> dogs;
    //private List<Pessoa> pessoas;
    private String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setContentView(R.layout.activity_detail);

        btnAdote = (Button) findViewById(R.id.btnAdote);

        btnAdote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //implementar metodo no repositorio que veja qual endereco da pessoa do dog
                //location = "geo:0,0?q=" + pessoas.get(i).getEndereco().logradouro
                location = "geo:0,0?q=3600 Av Conselheiro Aguiar, Recife, Pernambuco";
                Uri mapUri = Uri.parse(location);
                mIntent = new Intent(Intent.ACTION_VIEW, mapUri);
                //mIntent.setPackage("com.google.android.apps.maps");
                startActivity(mIntent);

            }
        });

    }
}
