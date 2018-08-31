package com.catatanasad.portalberitafix.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigRetrofit {

    public static Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://192.168.95.135/portal_berita/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService service(){
        return retrofit().create(ApiService.class);
    }

}
