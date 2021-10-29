package com.example.mcs_final_2301874866;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Dictionary;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Fragment_Explore extends Fragment{

    ArrayList<Dictianory> dictionary = new ArrayList<>();
    EditText search;
    Button cari;
    RecyclerView rv_explore;
    ExploreAdapter exploreadpt;
    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_explore_layout);

        search = search.findViewById(R.id.search_bar);
        cari = cari.findViewById(R.id.search_btn);

        rv_explore = rv_explore.findViewById(R.id.rv_xplore);

        cari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dictionary.removeAll(dictionary);
                String text = search.getText().toString();
                String url = "https://myawesomedictionary.herokuapp.com/words?q=" + text;

                JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        Log.i("TAG", "onCreate: masuk");
                        for (int i = 0; i < response.length(); i++){
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Log.i("TAG", "onResponse: " + jsonObject.getString("name"));
                                Dictionary diksi = new Dictionary();
                                diksi.setWord(jsonObject.getString("name"));
                                diksi.setDefinition(jsonObject.getString("definistion"));
                                diksi.setType(jsonObject.getString("type"));
                                diksi.setImageurl(jsonObject.getString("imageurl"));

                                dictionary.add(diksi);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }
        });

        LinearLayoutManager llManager = new LinearLayoutManager(this);
        rv_explore.setLayoutManager(llManager);
        ExploreAdapter = new ExploreAdapter(Fragment_Explore.this, dictionary);
        rv_explore.setAdapter(ExploreAdapter);
    }

    private void setContentView(int fragment_explore_layout) {
    }
}
