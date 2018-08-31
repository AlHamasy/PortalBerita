package com.catatanasad.portalberitafix;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RestrictTo;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ScrollingActivity extends AppCompatActivity {

    ImageView imgDetail;
    TextView txtJudulDetail, txtPenulisDetail, txtIsiDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        fab.setVisibility(View.INVISIBLE);

        imgDetail = findViewById(R.id.image_detail);
        txtJudulDetail = findViewById(R.id.judul_detail);
        txtPenulisDetail = findViewById(R.id.penulis_detail);
        txtIsiDetail = findViewById(R.id.isi_detail);

        // url gambar
        String url_gambar = "http://192.168.95.135/portal_berita/image/";

        Intent terimaData = getIntent();

        String setImage = terimaData.getStringExtra("IMAGE");
        Glide.with(ScrollingActivity.this)
                .load(url_gambar + setImage)
                .into(imgDetail);

        txtJudulDetail.setText(terimaData.getStringExtra("JUDUL"));
        txtPenulisDetail.setText("oleh :" + terimaData.getStringExtra("PENULIS"));
        txtIsiDetail.setText(terimaData.getStringExtra("ISI"));

        getSupportActionBar().setTitle(terimaData.getStringExtra("JUDUL"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
