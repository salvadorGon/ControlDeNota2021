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

import com.example.controldenotas.CalificandoAlumno;
import com.example.controldenotas.Dao.ActividadDao;
import com.example.controldenotas.Login;
import com.example.controldenotas.Models.Actividad;
import com.example.controldenotas.ListaActividades;
import com.example.controldenotas.R;

import java.util.List;

public class ActividadAdapter extends RecyclerView.Adapter<ActividadAdapter.ViewHolder> {
    List<Actividad> actividad;
    Context context;

    ActividadDao dao;

    //manipulacion de vista(xml)
    public static class ViewHolder extends RecyclerView.ViewHolder  {
        TextView txvId;
        TextView txvMostrarNombre;

        Button btnCalificar;
        Button btnEliminar;

        Context context;
    public ViewHolder(View view, Context context) {

            super(view);
        txvId=(TextView) view.findViewById(R.id.txvIdActividad);
        txvMostrarNombre=(TextView) view.findViewById(R.id.txvMostrarNombreActividad);
        btnCalificar=(Button) view.findViewById(R.id.btnCalificar);
        btnEliminar=(Button) view.findViewById(R.id.btnEliminar);

             this.context=context;
    }}

    //constructor del adaptador
    public ActividadAdapter(List<Actividad> actividad, Context context, ActividadDao dao){
        this.context=context;
        this.actividad=actividad;
        this.dao=dao;
    }

    //configuraciones
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_actividad,parent,false);
        ViewHolder vh=new ViewHolder(v,context);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Actividad actividadmodel=actividad.get(position);
        holder.txvId.setText(""+actividadmodel.getIdActividad());
        holder.txvMostrarNombre.setText(actividadmodel.getNombre());



        //boton eliminar
        holder.btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.delete(actividadmodel);

                actividad=dao.getAll();

                notifyDataSetChanged();

                Toast.makeText(context.getApplicationContext(),"Actividad eliminada",Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnCalificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Login.class);
                intent.putExtra("estado",1);
                //intent.putExtra("actividad",actividadmodel);
                view.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return actividad.size();
    }




}
