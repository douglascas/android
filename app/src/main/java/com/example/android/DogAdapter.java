package com.example.android;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.Dog;

import java.util.List;


public class DogAdapter extends BaseAdapter {

    Context ctx;
    List<Dog>dogs;

    public DogAdapter(Context ctx,List<Dog> dogs){
        this.ctx = ctx;
        this.dogs = dogs;

    }

    @Override
    public int getCount() {
        return dogs.size();
    }

    @Override
    public Object getItem(int position) {
        return dogs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Dog dog = dogs.get(position);

        ViewHolder holder = null;

        if(convertView == null ){ //VIEW NOVA

            Log.d("NGVL", "View Nova => position: " + position);
            convertView = LayoutInflater.from(ctx)
                    .inflate(R.layout.item_dog, null);

            holder = new ViewHolder(); //cria o holder apenas uma vez

            holder.imgDog = (ImageView) convertView.findViewById(R.id.imgDog);
            holder.txtNome = (TextView) convertView.findViewById(R.id.txtNome);
            holder.txtIdade = (TextView) convertView.findViewById(R.id.txtIdade);

            convertView.setTag(holder);

        }
        else{ //view ja foi criada

            Log.d("NGVL", "View existente => position: "+ position);
            holder = (ViewHolder)convertView.getTag();
        }

        Resources res = ctx.getResources();
        //ID 1 = dog1,ID2 = dog2,etc
        TypedArray fotos_dogs = res.obtainTypedArray(R.array.fotos_dogs);

        holder.imgDog.setImageDrawable(
                fotos_dogs.getDrawable(dog.id));
        holder.txtNome.setText(dog.nome);
        holder.txtIdade.setText(dog.idade);

        return convertView;

    }

    static class ViewHolder {
        ImageView imgDog;
        TextView txtNome;
        TextView txtIdade;
    }

}
