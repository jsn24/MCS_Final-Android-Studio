package com.example.mcs_final_2301874866;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Dictionary;

public class DictionaryDetail extends AppCompatActivity {

    ArrayList<Dictionary> dictionary;
    String nama,definisi,tipe,imageurl;
    int position
    SQLiteDatabase db;
    TextView word;
    Button save;
    RecyclerView rv_explore;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dictionary_detail_activity);
        FavoriteDB favoriteDB = new FavoriteDB(this);

        save = save.findViewById(R.id.btn_save_detail);
        word = word.findViewById(R.id.dictionary_name);
        rv_explore = rv_explore.findViewById(R.id.rv_detail);

        Intent intent = getIntent();
        nama = getIntent().getStringExtra("nama");
        definisi = getIntent().getStringExtra("definisi");
        tipe = getIntent().getStringExtra("tipe");
        imageurl = getIntent().getStringExtra("imageurl");
        position = intent.getIntExtra("position", 0);

        word.setText(nama);

        LinearLayoutManager llManager = new LinearLayoutManager(this);
        rv_explore.setLayoutManager(llManager);
        DictionaryDetailAdapter = new DictionaryDetailAdapter(DictionaryDetail.this, dictionary);
        rv_explore.setAdapter(FavoriteAdapter);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FavoriteDB favoriteDB = new FavoriteDB();

                Intent intent = new Intent(Fragment_Favorite.class);
                intent.putExtra("nama", favoriteDB.getFavoriteWord(position + 1));
                intent.putExtra("definisi", favoriteDB.getFavoriteDefinition(position + 1));
                intent.putExtra("tipe", favoriteDB.getFavoriteType(position + 1));
                intent.putExtra("imageurl", favoriteDB.getFavoriteImageURL(position + 1));
                intent.putExtra("position", position + 1);
                startActivity(intent);

            }
        });
}
