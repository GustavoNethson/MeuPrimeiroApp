package com.example.trabalhosubpesquisapais.controller;

import android.content.Context;

import com.example.trabalhosubpesquisapais.dao.PaisDao;
import com.example.trabalhosubpesquisapais.dto.PaisDTO;
import com.example.trabalhosubpesquisapais.model.Pais;

import java.util.ArrayList;

import okhttp3.Response;


public class PaisController {
    private static void getViaPais(Context context) {
        try {
            retrofit2.call<ArrayList<PaisDTO>> call = new retrofitConfig().paisService().getPaisDtoCall();
            call.enqueue(new Call<ArrayList<PaisDTO>>() {
                @Override
                public void onResponse(Call<ArrayList<PaisDTO>> call, Response<ArrayList<PaisDTO>> resonse) {
                    ArrayList<PaisDTO> listaPais = resonse.body();

                    for (int i = 0; i < listaPais.size(); i++) {
                        PaisDTO pais = listaPais.get(i);

                        salvar(pais.getCodigo(), pais.getDescricao(), context);

                    }
                }
                @Override
                public void onFailure(Call<ArrayList<PaisDTO>> call, throwable t){
                }
            });
        }catch (Exception ex){}
    }
    public static String salvar(int codigo, String descricao, Context context){
        try {
            Pais pais = new Pais();
            pais.setCodigo(codigo);
            pais.setDescricao(descricao);
            PaisDao.getInstancia(context).insert(pais);
        }catch (Exception ex){
            return "Erro ao gravar o pais." + ex.getMessage();
        }
        return  null;
    }
    public static ArrayList<Pais> retornar(Context context){
        return PaisDao.getInstancia(context).getAll();
    }
}
