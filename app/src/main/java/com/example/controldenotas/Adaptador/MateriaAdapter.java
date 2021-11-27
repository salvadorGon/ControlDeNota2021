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

import com.example.controldenotas.Dao.ActividadDao;
import com.example.controldenotas.Dao.MateriaDao;
import com.example.controldenotas.DataView.ListaGrupos;
import com.example.controldenotas.Models.Actividad;
import com.example.controldenotas.Models.Materia;
import com.example.controldenotas.Principal;
import com.example.controldenotas.R;

import java.util.List;

public class MateriaAdapter extends RecyclerView.Adapter<MateriaAdapter.ViewHolder>{
    List<Materia> materia;
    Context context;

    MateriaDao dao;

    //manipulacion de vista(xml)
    public static class ViewHolder extends RecyclerView.ViewHolder  {
        TextView txvIdMateria;
        TextView txvMostrarNombreMateria;
        TextView txvDescripcion;
        Button btnModificar;
        Button btnVerGrupo;
        Button btnEliminarMateria;
        Context context;

        public ViewHolder(View view, Context context){
            super(view);
            txvIdMateria = (TextView) view.findViewById(R.id.txvIdMateria);
            txvMostrarNombreMateria = (TextView) view.findViewById(R.id.txvMostrarNombreMateria);
            txvDescripcion = (TextView) view.findViewById(R.id.txvDescripcion);

            btnModificar = (Button) view.findViewById(R.id.btnModificar);
            btnVerGrupo = (Button) view.findViewById(R.id.btnVerGrupo);
            btnEliminarMateria = (Button) view.findViewById(R.id.btnEliminarMateria);

            this.context= context;
        }

    }

    //constructor del adaptador
    public MateriaAdapter(List<Materia> materia, Context context, MateriaDao dao){
        this.context = context;
        this.dao = dao;
        this.materia = materia;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_materia,parent,false);
        ViewHolder vh = new ViewHolder(v, context);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Materia materiaModel= materia.get(position);
        holder.txvIdMateria.setText(""+materiaModel.getIdMateria());
        holder.txvMostrarNombreMateria.setText(materiaModel.getNombre());
        holder.txvDescripcion.setText(materiaModel.getDescripcion());

        //boton eliminar


        holder.btnEliminarMateria.setOnClickListener(v->{
            dao.delete(materiaModel);
            materia = dao.getAll();

            notifyDataSetChanged();
            Toast.makeText(context.getApplicationContext(),"Materia eliminada",Toast.LENGTH_SHORT).show();

        });

        //boton ver grupo

        holder.btnVerGrupo.setOnClickListener(v->{
            Intent intent = new Intent(context, ListaGrupos.class);
            intent.putExtra("idMateria",materiaModel.getIdMateria());
            //Intent intent = new Intent(context, Principal.class);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return materia.size();
    }

}
