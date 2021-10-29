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

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.MyViewHolder>  {
    Context ctx;
    ArrayList<Dictianory> dictianorylist;

    public FavoriteAdapter(Context ctx, ArrayList<Dictianory> dictianorylist) {
        this.dictianorylist = dictianorylist;
        this.ctx = ctx;
    }

    @NonNull
    @NotNull
    @Override
    public FavoriteAdapter.MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.fragment_main2, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FavoriteAdapter.MyViewHolder holder, int position) {
        Dictianory diksi = dictianorylist.get(position);
        holder.nama.setText(diksi.getWord());

        holder.btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FavoriteDB favoriteDB = new FavoriteDB(ctx);
                Log.i("TAG", "onClick: klikk " + position);
                favoriteDB.deleteTransaction(position + 1);
                Intent intent = new Intent(ctx, Fragment_Favorite.class);
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

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView nama;
            Button btndelete;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                nama = itemView.findViewById(R.id.dictionary_name2);
                btndelete = itemView.findViewById(R.id.btn_delete);
            }
        }
    }
}
