package com.example.architamittal.retrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.net.URI;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    @NonNull
    List<Facts> datalist;
    Context context;
    public CustomAdapter(List<Facts> datalist,Context context)
    {
        this.datalist = datalist;
        this.context = context;
    }
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listlayout,viewGroup,false);
        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {

        Facts facts = datalist.get(i);
        Log.d("tag", facts.getText());
        //customViewHolder.text.setText(String.valueOf(facts.getId()));
        customViewHolder.text1.setText(String.valueOf(facts.getText()));
        //customViewHolder.text2.setText(String.valueOf(facts.getSource()));
        //customViewHolder.image.setImageURI(photos.getUrl());
        //customViewHolder.text3.setText(String.valueOf(facts.getUsed()));
        //customViewHolder.text4.setText(String.valueOf(facts.getType()));
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView text,text1,text2,text3,text4;
        //ImageView image;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            //text = itemView.findViewById(R.id.text);
            text1 = itemView.findViewById(R.id.text1);
            //text2 = itemView.findViewById(R.id.text2);
            //text3 = itemView.findViewById(R.id.text3);
            //text4 = itemView.findViewById(R.id.text4);
            //image = itemView.findViewById(R.id.image);
        }
    }
}
