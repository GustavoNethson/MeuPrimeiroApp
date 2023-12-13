package com.example.trabalhosubpesquisapais.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.trabalhosubpesquisapais.MainActivity;
import com.example.trabalhosubpesquisapais.helper.SQLiteDataHelper;
import com.example.trabalhosubpesquisapais.model.Pais;

import java.util.ArrayList;

public class PaisDao implements I_GenericDao<MainActivity {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase baseDados;
    private String[] colunas = {"CODIGO", "DESCRICAO"};
    private String tabela = "PAIS";
    private Context context;
    private static PaisDao instancia;

    public static PaisDao getInstancia(Context context) {
        if (instancia == null) {
            return instancia = new PaisDao(context);
        } else {
            return instancia;
        }
    }

    private PaisDao(Context context) {
        this.context = context;
        openHelper = new SQLiteDataHelper(this.context, "PAIS", null, 1);
        baseDados = openHelper.getWritableDatabase();
    }

    @Override
    public long insert(Pais obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put(colunas[0], obj.getCodigo());
            valores.put(colunas[1], obj.getDescricao());
            return baseDados.insert(tabela, null, valores);
        } catch (SQLException ex) {
            Log.e("PAIS", "ERRO: PAISDAO.insert() " + ex.getMessage());
        }
        return 0;
    }

    @Override
    public long upgrade(Pais obj) {
        return 0;
    }

    @Override
    public long update(Pais obj) {
        try {
            ContentValues valores = new ContentValues();
            valores.put(colunas[0], obj.getCodigo());
            valores.put(colunas[1], obj.getDescricao());
            return baseDados.insert(tabela, null, valores);
        } catch (SQLException ex) {
            Log.e("PAIS", "ERRO: PAISDAO.update() " + ex.getMessage());
        }
        return 0;
    }

    @Override
    public long delete(Pais obj) {
        try {
            String[] identificador = {String.valueOf(obj.getCodigo())};
            return baseDados.delete(tabela, colunas[3] + "= ?", identificador);
        } catch (SQLException ex) {
            Log.e("PAIS", "ERRO: PAISDAO.delete()" + ex.getMessage());
        }
        return 0;
    }

    @Override
    public ArrayList<Pais> getAll() {
        ArrayList<Pais> lista = new ArrayList<Pais>();
        try {
            Cursor cursor = baseDados.query(tabela,
                    colunas, null,
                    null, null,
                    null, colunas[0] + " desc");

            if (cursor.moveToFirst()) {
                do {
                    Pais pais = new Pais();
                    pais.setCodigo(cursor.getInt(0));
                    pais.setDescricao(cursor.getString(1));
                    lista.add(pais);

                } while (cursor.moveToNext());
            }

        } catch (SQLException ex) {
            Log.e("PAIS", "ERRO: PAISDAO.getAll() " + ex.getMessage());
        }

        return lista;
    }

    @Override
    public Pais getById(int id){
        try {
            String[]identificador = {String.valueOf(id)};
            Cursor cursor = baseDados.query(tabela, colunas,
                    colunas[3]+"= ?", identificador,
                    null, null, null);

            if (cursor.moveToFirst()){
                Pais pais = new Pais();
                pais.setCodigo(cursor.getInt(0));
                pais.setDescricao(cursor.getString(1));

                return pais;
            }

        }catch (SQLException ex){
            Log.e("PAIS", "ERRO: PAIS.getById() "+ex.getMessage());
        }
        return null;
    }
}
