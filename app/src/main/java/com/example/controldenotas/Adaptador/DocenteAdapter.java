package com.example.controldenotas.Adaptador;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.controldenotas.Dao.DocenteDao;
import com.example.controldenotas.Models.Docente;
import com.example.controldenotas.R;

import java.util.List;

public class DocenteAdapter extends RecyclerView.Adapter<DocenteAdapter.ViewHolder> {
    List<Docente> docente;
    Context context;

    DocenteDao dao;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txvIdDoce;
        TextView txvMostrasDoce;

        ImageButton btnModificar;
        ImageButton btnEliminar;

        Context context;

        public ViewHolder(View v, Context context){

            super(v);
            txvIdDoce=(TextView) v.findViewById(R.id.txvIdDocente);
            txvMostrasDoce=(TextView) v.findViewById(R.id.txvNombreDocente);
            btnModificar=(ImageButton) v.findViewById(R.id.btnModificarDocente);
            btnEliminar=(ImageButton) v.findViewById(R.id.btnEliminarDocente);

            this.context=context;
        }
    }


    //Constructor del adaptador
    public DocenteAdapter(List<Docente> docente, Context context, DocenteDao dao ){
        this.context = context;
        this.docente = docente;
        this.dao = dao;
    }

    //Configuraciones
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_docente, parent, false);
        ViewHolder vh = new ViewHolder(v,context);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        Docente docentemodel = docente.get(position);
        holder.txvIdDoce.setText(""+docentemodel.getIdDocente());
        holder.txvMostrasDoce.setText(docentemodel.getNombre());

        //Boton MODIFICAR
        holder.btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Docente.class);
                intent.putExtra("estado", 1);
                intent.putExtra("nombre",docentemodel);
                v.getContext().startActivity(intent);
            }
        });

        //Boton ELIMINAR
        holder.btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.delete(docentemodel);

                docente = dao.getAll();
                notifyDataSetChanged();

                Toast.makeText(context.getApplicationContext(), "Profesor Eliminado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return docente.size();
    }


}
