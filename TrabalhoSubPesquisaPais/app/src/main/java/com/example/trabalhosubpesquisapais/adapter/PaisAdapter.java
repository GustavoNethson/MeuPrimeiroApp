package com.example.trabalhosubpesquisapais.adapter;


import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cursoradapter.widget.ResourceCursorAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabalhosubpesquisapais.R;
import com.example.trabalhosubpesquisapais.model.Pais;

import java.util.ArrayList;


public class PaisAdapter extends ResourceCursorAdapter<PaisAdapter.ViewHolder> {

    private ArrayList<Pais> listaPaises;
    private LayoutInflater inflater;

    public PaisAdapter(Context context, ArrayList<Pais> listaPaises){
        super();
        this.inflater = LayoutInflater.from(context);
        this.listaPaises = listaPaises;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = inflater.inflate(R.layout.item_lista_pais, parent, false);
        return new ViewHolder(View);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Pais pais = listaPaises.get(position);

        holder.tvCodigo.setText(String.valueOf(pais.getCodigo()));
        holder.tvDescricao.setText(pais.getDescricao());
    }

    @Override
    public int getItemCount(){
        return listaPaises.size();
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvCodigo, tvDescricao;

        public ViewHolder(View itemView){
            super(itemView);
            tvCodigo = itemView.findViewById(R.id.tvCodigo);
            tvDescricao = itemView.findViewById(R.id.tvDescricao);
        }
    }
}
