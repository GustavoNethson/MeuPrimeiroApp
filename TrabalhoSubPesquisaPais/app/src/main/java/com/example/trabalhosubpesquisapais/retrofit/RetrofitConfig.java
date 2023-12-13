package com.example.trabalhosubpesquisapais.retrofit;

import com.example.trabalhosubpesquisapais.service.I_Pais;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private Retrofit retrofit;
    private static final String BASE_URL = "https://falabr.cgu.gov.br/";

    public RetrofitConfig(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

    }

    public I_Pais paisService(){
        return this.retrofit.create(I_Pais.class);
    }


}
