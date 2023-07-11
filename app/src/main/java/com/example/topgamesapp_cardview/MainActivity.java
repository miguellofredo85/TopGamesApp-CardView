package com.example.topgamesapp_cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //1-data
    ArrayList<CardViewModel> listData;
    //2- adapter view
    RecyclerView recyclerView;
    //3- Adapter
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    recyclerView = findViewById(R.id.recycleView);
    listData = new ArrayList<>();

    listData.add(new CardViewModel(R.drawable.card1, "card1"));
    listData.add(new CardViewModel(R.drawable.card2, "card2"));
    listData.add(new CardViewModel(R.drawable.card3, "card3"));
    listData.add(new CardViewModel(R.drawable.card4, "card4"));
    listData.add(new CardViewModel(R.drawable.card5, "card5"));
    listData.add(new CardViewModel(R.drawable.card6, "card6"));

    adapter = new MyAdapter(this, listData);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(adapter);
    }
}