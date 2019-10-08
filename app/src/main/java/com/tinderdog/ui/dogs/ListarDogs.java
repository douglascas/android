package com.tinderdog.ui.dogs;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tinderdog.R;
import com.tinderdog.adapters.DogAdapter;
import com.tinderdog.controllers.Facade;
import com.tinderdog.models.Dog;

import java.util.List;

public class ListarDogs extends AppCompatActivity {

    private List<Dog> dogs;
    private DogAdapter adapter;
    private ListView listView;
    private Facade facade = Facade.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_dogs);

        listView = findViewById(R.id.list);
        listView.setEmptyView(findViewById(android.R.id.empty));

        //Todo:: Paginar
        dogs = facade.getAllDogs();

        adapter = new DogAdapter(this, dogs);


        //header e footer -costumizar
        final int PADDING = 8;
        TextView txtHeader = new TextView(this);
        txtHeader.setBackgroundColor(Color.GRAY);
        txtHeader.setTextColor(Color.WHITE);
        txtHeader.setText(R.string.list_dogs_header);
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

        listView.setOnItemClickListener((adapterView, view, position, id) -> {
            Dog dog = (Dog) adapterView.getItemAtPosition(position);
            if (dog != null) {
                Intent intent = new Intent(ListarDogs.this, DogDetailActivity.class);
                intent.putExtra("dog_id", dog.getId());
                startActivity(intent);
            }
        });



    }
}
