package com.sshartika.punya_atik.androiddasar5onlinedb;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sshartika.punya_atik.androiddasar5onlinedb.model.ResultsItem;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>{
    public static final String DATA_MOVIE = "datamovie" ;
    public static final String DATA_EXTRA = "dataextra" ;
    private Context context;
    private List<ResultsItem>data = new ArrayList<>();

    //constructor

    public MovieAdapter(Context context, List<ResultsItem> data) {
        this.context = context;
        this.data = data;
    }

    //menyambungkan layout item
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemview = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        return new MyViewHolder(itemview);
    }

    //set data
    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int posisi) {
        myViewHolder.tvJudul.setText(data.get(posisi).getTitle());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500"+data.get(posisi).getPosterPath()).into(myViewHolder.ivPoster);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(context, DetailMovieActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable(DATA_MOVIE, Parcels.wrap(data.get(posisi)));
                pindah.putExtra(DATA_EXTRA, bundle);
                context.startActivity(pindah);
            }
        });
    }

    //jumlah data
    @Override
    public int getItemCount() {
        return data.size();
    }

    //mengenalkan komponen dalam item
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvJudul;
        ImageView ivPoster;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvJudul = itemView.findViewById(R.id.tv_item_judul);
            ivPoster = itemView.findViewById(R.id.iv_item_gambar);
        }
    }
}
