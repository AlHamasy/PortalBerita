package com.catatanasad.portalberitafix;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    ImageView imgDetail;
    TextView txtJudulDetail, txtPenulisDetail, txtIsiDetail;

    public static String setImage;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgDetail = findViewById(R.id.image_detail);
        txtJudulDetail = findViewById(R.id.judul_detail);
        txtPenulisDetail = findViewById(R.id.penulis_detail);
        txtIsiDetail = findViewById(R.id.isi_detail);

        // url gambar
        String url_gambar = "http://192.168.95.135/portal_berita/image/";

        Intent terimaData = getIntent();

        setImage = terimaData.getStringExtra("IMAGE");
        Glide.with(DetailActivity.this)
                .load(url_gambar + setImage)
                .into(imgDetail);

        txtJudulDetail.setText(terimaData.getStringExtra("JUDUL"));
        txtPenulisDetail.setText("oleh :" + terimaData.getStringExtra("PENULIS"));
        txtIsiDetail.setText(terimaData.getStringExtra("ISI"));

       getSupportActionBar().setTitle(terimaData.getStringExtra("JUDUL"));

    }
}
