package com.catatanasad.portalberitafix.network;

import com.catatanasad.portalberitafix.model.ResponseBerita;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("lihat_berita.php")
    Call<ResponseBerita> tampil_berita();

}
