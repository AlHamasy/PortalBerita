package com.catatanasad.portalberitafix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.catatanasad.portalberitafix.model.DataBeritaItem;
import com.catatanasad.portalberitafix.model.ResponseBerita;
import com.catatanasad.portalberitafix.network.ApiService;
import com.catatanasad.portalberitafix.network.ConfigRetrofit;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        getBerita();

    }

    private void getBerita() {

        ApiService api = ConfigRetrofit.service();
        Call<ResponseBerita> request = api.tampil_berita();

        request.enqueue(new Callback<ResponseBerita>() {
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita> response) {

               Boolean status = response.body().isStatus();

                if (status == true){

                    List<DataBeritaItem> dataBeritaItems = response.body().getDataBerita();

                    BeritaAdaper adapter = new BeritaAdaper(MainActivity.this, dataBeritaItems);

                    recyclerView.setAdapter(adapter);

                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                }
            }

            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {

            }
        });

    }
}
