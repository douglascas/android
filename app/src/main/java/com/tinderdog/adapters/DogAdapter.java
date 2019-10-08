package com.tinderdog.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tinderdog.R;
import com.tinderdog.models.Dog;

import java.util.List;


public class DogAdapter extends BaseAdapter {

    private Context ctx;
    private List<Dog>dogs;

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

        ViewHolder holder;

        if(convertView == null ){ //VIEW NOVA

//            Log.d("NGVL", "View Nova => position: " + position);
            convertView = LayoutInflater.from(ctx)
                    .inflate(R.layout.item_dog, null);

            holder = new ViewHolder(); //cria o holder apenas uma vez

            holder.imgDog = convertView.findViewById(R.id.imgDog);
            holder.txtNome = convertView.findViewById(R.id.txtNome);
            holder.txtIdade = convertView.findViewById(R.id.txtIdade);

            convertView.setTag(holder);

        }
        else{ //view ja foi criada
//            LoggerWrapper.log("View existente => position: "+ position);
            holder = (ViewHolder)convertView.getTag();
        }

        holder.imgDog.setImageBitmap(dog.getPhoto());
        holder.txtNome.setText(dog.getNome());
        holder.txtIdade.setText(dog.getIdade()+"");

        return convertView;

    }

    static class ViewHolder {
        ImageView imgDog;
        TextView txtNome;
        TextView txtIdade;
    }

}
