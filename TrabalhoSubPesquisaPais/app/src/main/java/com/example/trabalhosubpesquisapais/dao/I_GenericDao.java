package com.example.trabalhosubpesquisapais.dao;

import com.example.trabalhosubpesquisapais.model.Pais;

import java.util.ArrayList;

public interface I_GenericDao<object> {
    long insert(Pais obj);
    long upgrade(Pais obj);
    long delete(Pais obj);
    ArrayList<Pais> getAll();
    Pais getById(int id);
}