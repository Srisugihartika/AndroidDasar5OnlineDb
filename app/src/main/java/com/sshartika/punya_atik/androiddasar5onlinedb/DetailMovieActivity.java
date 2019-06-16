package com.sshartika.punya_atik.androiddasar5onlinedb;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sshartika.punya_atik.androiddasar5onlinedb.model.ResultsItem;

import org.parceler.Parcels;

public class DetailMovieActivity extends AppCompatActivity {

    ResultsItem dataMovie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getBundleExtra(MovieAdapter.DATA_EXTRA);
        dataMovie = Parcels.unwrap(bundle.getParcelable(MovieAdapter.DATA_MOVIE));

        getSupportActionBar().setTitle(dataMovie.getTitle());

        ImageView ivBackDrop = findViewById(R.id.iv_detail_backdrop);
        TextView tvDeskripsi = findViewById(R.id.tv_detail_description);

        Glide.with(DetailMovieActivity.this).load("https://image.tmdb.org/t/p/w500"+dataMovie.getBackdropPath()).into(ivBackDrop);
        tvDeskripsi.setText(dataMovie.getOverview());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
