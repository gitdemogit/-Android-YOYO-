package com.example.smartflower.tools;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.smartflower.MainActivity;
import com.example.smartflower.R;

import java.util.List;

public class FlowerAdapter extends ArrayAdapter<Flower> {

    public FlowerAdapter(MainActivity context, int resource, @NonNull List<Flower> objects) {
       super(context,resource,objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Flower flower=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(R.layout.flower_items,parent,false);
        ImageView flowerfp=view.findViewById(R.id.fp);
        TextView flowername=view.findViewById(R.id.flower_name);
        TextView flowerfs=view.findViewById(R.id.flower_fs);

        flowerfp.setImageResource(flower.getFp());
        flowername.setText(flower.getName());
        flowerfs.setText(flower.getFs());
        return view;
    }
}
