package com.example.topgamesapp_cardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<CardViewModel> listData;
    public MyAdapter(Context context, ArrayList<CardViewModel> listData) {
        //1- Data
//2- constructor
        this.context = context;
        this.listData = listData;
    }

    // 4- adding the methods for MyAdapter.MyViewHolder

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent
                .getContext())
                .inflate(R.layout.card_view_layout, parent,false);
        return new MyViewHolder(view); // estoy pasando un aview nueva creada ahora al parametro
        //del contructor del MyViewHolder del paso 3

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    CardViewModel model = listData.get(position);
    holder.gameTxt.setText(model.getTextView());
    holder.gameImg.setImageResource(model.getImageView());

    //handle click event on itemView
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(context, "Image from movie " + listData.get(position).getTextView(), Toast.LENGTH_LONG).show();
        }
    });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    //3- view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView gameImg;
        private TextView gameTxt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            gameImg = itemView.findViewById(R.id.imageViewCard);
            gameTxt = itemView.findViewById(R.id.textViewCard);
        }
        public ImageView getGameImg() {
            return gameImg;
        }

        public void setGameImg(ImageView gameImg) {
            this.gameImg = gameImg;
        }

        public TextView getGameTxt() {
            return gameTxt;
        }

        public void setGameTxt(TextView gameTxt) {
            this.gameTxt = gameTxt;
        }

    }
}
