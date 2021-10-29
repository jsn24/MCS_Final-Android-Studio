package com.example.mcs_final_2301874866;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Dictionary;

public class DictionaryDetailAdapter extends RecyclerView.Adapter<DictionaryDetailAdapter.MyViewHolder>{
    Context ctx;
    ArrayList<Dictianory> dictianorylist;

    public DictionaryDetailAdapter(Context ctx, ArrayList<Dictianory> dictianorylist) {
        this.dictianorylist = dictianorylist;
        this.ctx = ctx;
    }
    @NonNull
    @NotNull
    @Override
    public DictionaryDetailAdapter.MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.layout_detail_activity, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DictionaryDetailAdapter.MyViewHolder holder, int position) {
        Dictianory diksi = dictianorylist.get(position);
        holder.tipe.setText(diksi.getWord());
        holder.definisi.setText(diksi.getDefinition());
        holder.image.setImage(diksi.getImageurl());

    }

    @Override
    public int getItemCount() {
        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView definisi;
            TextView tipe;
            ImageView image;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                tipe = itemView.findViewById(R.id.type1_text);
                definisi = itemView.findViewById(R.id.detail_text);
                image = itemView.findViewById(R.id.imageView1);
            }
        }
    }
}
