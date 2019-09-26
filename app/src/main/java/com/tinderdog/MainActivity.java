package com.tinderdog;

import android.os.Bundle;


import com.tinderdog.adapters.DogAdapter;
import com.tinderdog.models.Dog;
import com.tinderdog.models.usuario.Endereco;
import com.tinderdog.models.usuario.Pessoa;

import androidx.appcompat.app.AppCompatActivity;
import android.view.Gravity;
import android.graphics.Color;
import android.widget.AdapterView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private  List<Dog> dogs;
    private DogAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
        listView.setEmptyView(findViewById(android.R.id.empty));



        Pessoa donoExemplo = new Pessoa(-1, null, "NomePessoa", "","",
                new Endereco("","","","",""),null);

        dogs = new ArrayList<>();
        dogs.add(new Dog(1, donoExemplo, "bob", "branco", 1, "medio"));
        dogs.add(new Dog(2, donoExemplo, "mel", "preto", 2, "pequeno"));
        dogs.add(new Dog(3, donoExemplo, "caramelo", "amarelo", 1, "grande"));
        dogs.add(new Dog(4, donoExemplo, "thor", "branco", 4, "medio"));

        adapter = new DogAdapter(this, dogs);

        //header e footer -costumizar
        final int PADDING = 8;
        TextView txtHeader = new TextView(this);
        txtHeader.setBackgroundColor(Color.GRAY);
        txtHeader.setTextColor(Color.WHITE);
        txtHeader.setText(R.string.texto_cabecalho);
        txtHeader.setPadding(PADDING, PADDING, 0, PADDING);
        listView.addHeaderView(txtHeader);
        final TextView txtFooter = new TextView(this);
        txtFooter.setText(getResources().getQuantityString(
                R.plurals.texto_rodape,
                adapter.getCount(),
                adapter.getCount()));
        txtFooter.setBackgroundColor(Color.LTGRAY);
        txtFooter.setGravity(Gravity.RIGHT);
        txtFooter.setPadding(0, PADDING, PADDING, PADDING);
        listView.addFooterView(txtFooter);

        //end header e footer

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                Dog dog = (Dog) adapterView.getItemAtPosition(position);
                if (dog != null) {
                    Toast.makeText(MainActivity.this, dog.getId() + "-" + dog.getNome(),
                            Toast.LENGTH_SHORT).show(); //notificacao toast
                    //aqui n deleta
                    dogs.remove(dog);
                    adapter.notifyDataSetChanged();

                    txtFooter.setText(getResources().getQuantityString(
                            R.plurals.texto_rodape,
                            adapter.getCount(),
                            adapter.getCount()));
                }
            }
        });
    }
}







