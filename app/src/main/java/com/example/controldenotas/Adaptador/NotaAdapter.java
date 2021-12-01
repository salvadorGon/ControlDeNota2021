package com.example.controldenotas.Adaptador;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.controldenotas.Dao.MateriaDao;
import com.example.controldenotas.Dao.NotaDao;
import com.example.controldenotas.DataView.ListaGrupos;
import com.example.controldenotas.Models.Materia;
import com.example.controldenotas.Models.Nota;
import com.example.controldenotas.R;

import java.util.List;

public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.ViewHolder>{
    List<Nota> nota;
    Context context;
    NotaDao dao;

    //manipulacion de vista(xml)
    public static class ViewHolder extends RecyclerView.ViewHolder  {
        TextView txvMostrarNota;
        Button btnModificar;
        Context context;

        public ViewHolder(View view, Context context){
            super(view);
            txvMostrarNota = (TextView) view.findViewById(R.id.txvMostrarNota);
            //btnModificar = (Button) view.findViewById(R.id.btnModificar);

            this.context= context;
        }

    }

    //constructor del adaptador
    public NotaAdapter(List<Nota> nota, Context context, NotaDao dao){
        this.context = context;
        this.nota = nota;
        this.dao = dao;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mostrarnotasalumno,parent,false);
        ViewHolder vh = new ViewHolder(v, context);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Nota notaModel= nota.get(position);
        holder.txvMostrarNota.setText(""+notaModel.getNota());
    }

    @Override
    public int getItemCount() {
        return nota.size();
    }

}
