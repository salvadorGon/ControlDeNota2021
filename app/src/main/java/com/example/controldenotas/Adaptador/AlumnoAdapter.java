package com.example.controldenotas.Adaptador;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.controldenotas.Dao.ActividadDao;
import com.example.controldenotas.Dao.AlumnoDao;
import com.example.controldenotas.ListaActividades;
import com.example.controldenotas.Models.Actividad;
import com.example.controldenotas.Models.Alumno;
import com.example.controldenotas.Models.Nota;
import com.example.controldenotas.R;

import java.util.ArrayList;
import java.util.List;

public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.ViewHolder> {
    List<Alumno> alumno;
    List<Nota> nota;
    Context context;

    AlumnoDao dao;


    //manipulacion de vista(xml)
    public static class ViewHolder extends RecyclerView.ViewHolder  {
        TextView txvId;
        TextView txvMostrarNombre;
        TextView edittextnota;


        Context context;
    public ViewHolder(View view, Context context) {

            super(view);
        txvId=(TextView) view.findViewById(R.id.txvIdAlumno);
        txvMostrarNombre=(TextView) view.findViewById(R.id.txvMostrarNombreAlumno);
        edittextnota = (TextView) view.findViewById(R.id.edittextnota);

             this.context=context;
    }}

    //constructor del adaptador
    public AlumnoAdapter(List<Alumno> alumno, Context context, AlumnoDao dao){
        this.context=context;
        this.alumno=alumno;
        this.dao=dao;
    }

    //configuraciones
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_calificandoalumno,parent,false);
        ViewHolder vh=new ViewHolder(v,context);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Alumno alumnomodel=alumno.get(position);
        //Nota notamodel = nota.get(position);
        holder.txvId.setText(""+alumnomodel.getIdAlumno());
        holder.txvMostrarNombre.setText(alumnomodel.getPrimerNombre());
        holder.edittextnota.setText("0.1");
    }
    @Override
    public int getItemCount() {
        return alumno.size();
    }
}
