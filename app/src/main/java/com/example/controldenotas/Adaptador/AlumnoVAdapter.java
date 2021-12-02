package com.example.controldenotas.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.controldenotas.Dao.AlumnoDao;
import com.example.controldenotas.Models.Alumno;
import com.example.controldenotas.Models.Nota;
import com.example.controldenotas.R;

import java.util.List;

public class AlumnoVAdapter extends RecyclerView.Adapter<AlumnoVAdapter.ViewHolder> {
    List<Alumno> alumno;
    List<Nota> nota;
    Context context;

    AlumnoDao dao;


    //manipulacion de vista(xml)
    public static class ViewHolder extends RecyclerView.ViewHolder  {
        TextView txvId;
        TextView txvMostrarNombre;
        TextView edittextnota;
        ImageButton ibeliminar;


        Context context;
    public ViewHolder(View view, Context context) {

            super(view);
        txvId=(TextView) view.findViewById(R.id.txvIdAlumno);
        txvMostrarNombre=(TextView) view.findViewById(R.id.txvNombreAlumno);
        edittextnota = (TextView) view.findViewById(R.id.txvNombreAlumno);
        ibeliminar = (ImageButton) view.findViewById(R.id.btnEliminarAlumno);

             this.context=context;
    }}

    //constructor del adaptador
    public AlumnoVAdapter(List<Alumno> alumno, Context context, AlumnoDao dao){
        this.context=context;
        this.alumno=alumno;
        this.dao=dao;
    }

    //configuraciones
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alumno,parent,false);
        ViewHolder vh=new ViewHolder(v,context);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Alumno alumnomodel=alumno.get(position);
        //Nota notamodel = nota.get(position);
        holder.txvId.setText(""+alumnomodel.getIdAlumno());
        holder.txvMostrarNombre.setText(alumnomodel.getPrimerNombre());
        //holder.edittextnota.setText("");

        holder.ibeliminar.setOnClickListener(v->{
            dao.delete(alumnomodel);
            alumno = dao.getAll();

            notifyDataSetChanged();
            Toast.makeText(context.getApplicationContext(),"Alumno eliminado",Toast.LENGTH_SHORT).show();
        });
    }
    @Override
    public int getItemCount() {
        return alumno.size();
    }
}
