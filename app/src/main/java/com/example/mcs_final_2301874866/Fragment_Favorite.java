package com.example.mcs_final_2301874866;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Fragment_Favorite extends Fragment {

    ArrayList<Dictianory> dictionary = new ArrayList<>();
    RecyclerView rv_explore;
    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_favorite_layout);
        final FavoriteDB favoriteDB= new FavoriteDB(Fragment_Favorite.this);
        rv_explore = rv_explore.findViewById(R.id.rv_xplore2);

        //mengambil data dari DB
        dictionary = favoriteDB.getAllDictionary();

        LinearLayoutManager llManager = new LinearLayoutManager(this);
        rv_explore.setLayoutManager(llManager);
        FavoriteAdapter = new FavoriteAdapter(Fragment_Favorite.this, dictionary);
        rv_explore.setAdapter(FavoriteAdapter);
    }

    private void setContentView(int fragment_explore_layout) {
    }
}
