package com.example.trabalhosubpesquisapais.service;

import com.example.trabalhosubpesquisapais.dto.PaisDTO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface I_Pais {
    @GET("api/paises")
    Call<ArrayList<PaisDTO>> getPaisDtoCall();
}
