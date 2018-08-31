package com.catatanasad.portalberitafix;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.catatanasad.portalberitafix.model.DataBeritaItem;

import java.util.List;

public class BeritaAdaper extends RecyclerView.Adapter<BeritaAdaper.ViewHolder>{

    private static final String BASE_URL = "http://192.168.95.135/portal_berita/";

    private Context con;
    private List<DataBeritaItem> data_berita;

    public BeritaAdaper(Context con, List<DataBeritaItem> data_berita) {
        this.con = con;
        this.data_berita = data_berita;
    }

    @NonNull
    @Override
    public BeritaAdaper.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //todo layout inflater
        View view = LayoutInflater.from(con).inflate(R.layout.list_berita, parent, false);

        //todo Buat object view holder
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BeritaAdaper.ViewHolder holder, final int position) {

        final String url_image = BASE_URL + "image/" + data_berita.get(position).getImageBerita();

        // todo menampilkan gambar
        Glide.with(con)
                .load(url_image)
                .into(holder.imgBerita);

        holder.txtPenulisBerita.setText(data_berita.get(position).getPenulisBerita());
        holder.txtJudulBerita.setText(data_berita.get(position).getJudulBerita());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent kirimData = new Intent(con, ScrollingActivity.class);

                kirimData.putExtra("IMAGE", data_berita.get(position).getImageBerita());
                kirimData.putExtra("JUDUL", data_berita.get(position).getJudulBerita());
                kirimData.putExtra("PENULIS", data_berita.get(position).getPenulisBerita());
                kirimData.putExtra("ISI", data_berita.get(position).getIsiBerita());

                con.startActivity(kirimData);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data_berita.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgBerita;
        TextView txtJudulBerita, txtPenulisBerita;


        public ViewHolder(View itemView) {
            super(itemView);

            imgBerita = itemView.findViewById(R.id.image_berita);
            txtJudulBerita = itemView.findViewById(R.id.judul_berita);
            txtPenulisBerita = itemView.findViewById(R.id.penulis_berita);

        }
    }
}
