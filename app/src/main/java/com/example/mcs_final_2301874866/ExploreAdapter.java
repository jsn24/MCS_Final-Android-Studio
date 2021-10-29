package com.example.mcs_final_2301874866;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.MyViewHolder> {

    Context ctx;
    ArrayList<Dictianory> dictianorylist;

    public ExploreAdapter(Fragment_Explore ctx, ArrayList<Dictianory> dictianorylist) {
        this.dictianorylist = dictianorylist;
        this.ctx = ctx;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.fragment_main, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ExploreAdapter.MyViewHolder holder, int position) {
        Dictianory diksi = dictianorylist.get(position);
        holder.nama.setText(diksi.getWord());

        holder.btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FavoriteDB favoriteDB = new FavoriteDB(ctx);

                Intent intent = new Intent(ctx, Fragment_Favorite.class);
                intent.putExtra("nama", favoriteDB.getFavoriteWord(position + 1));
                intent.putExtra("definisi", favoriteDB.getFavoriteDefinition(position + 1));
                intent.putExtra("tipe", favoriteDB.getFavoriteType(position + 1));
                intent.putExtra("imageurl", favoriteDB.getFavoriteImageURL(position + 1));
                intent.putExtra("position", position + 1);
                ctx.startActivity(intent);

            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FavoriteDB favoriteDB = new FavoriteDB(ctx);

                Intent intent = new Intent(ctx, DictionaryDetail.class);
                intent.putExtra("nama", favoriteDB.getFavoriteWord(position + 1));
                intent.putExtra("definisi", favoriteDB.getFavoriteDefinition(position + 1));
                intent.putExtra("tipe", favoriteDB.getFavoriteType(position + 1));
                intent.putExtra("imageurl", favoriteDB.getFavoriteImageURL(position + 1));
                intent.putExtra("position", position + 1);
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dictianorylist.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nama;
        Button btnsave;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nama = itemView.findViewById(R.id.dictionary_name);
            btnsave = itemView.findViewById(R.id.btn_save);
        }
    }
}
