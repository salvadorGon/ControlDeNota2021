package com.example.controldenotas.Adaptador;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.controldenotas.Dao.InstitucionDao;
import com.example.controldenotas.Models.Institucion;
import com.example.controldenotas.R;
import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.List;

public class InstitucionAdapter extends RecyclerView.Adapter<InstitucionAdapter.ViewHolder> {
    List<Institucion> institucion;
    Context context;

    InstitucionDao dao;

    //manipulacion de vista (xml)
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txvIdInst;
        TextView txvMostrarInst;

        //ImageButton btnModificar;
        ImageButton btnEliminar;

        Context context;

        public ViewHolder(View view, Context context){

            super(view);
            txvIdInst=(TextView) view.findViewById(R.id.txvIdInstitucion);
            txvMostrarInst=(TextView) view.findViewById(R.id.txvMostrarNombreInstitucion);
            //btnModificar=(ImageButton) view.findViewById(R.id.btnModificarInstitucion);
            btnEliminar=(ImageButton) view.findViewById(R.id.btnEliminarInstitucion);

            this.context=context;
        }
    }

    //constructor del adaptador
    public InstitucionAdapter(List<Institucion> institucion,Context context, InstitucionDao dao){
        this.context=context;
        this.institucion=institucion;
        this.dao=dao;
    }

    //configuraciones
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_institucion , parent, false);
        ViewHolder vh=new ViewHolder(v,context);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        Institucion institucionmodel=institucion.get(position);
        holder.txvIdInst.setText(""+institucionmodel.getIdInstitucion());
        holder.txvMostrarInst.setText(institucionmodel.getNombre());
/*
        //boton Modificar
        holder.btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Institucion.class);
                intent.putExtra("estado", 1);
                intent.putExtra("nombre", institucionmodel);
                view.getContext().startActivity(intent);

            }
        });

 */
        //boton eliminar
        holder.btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dao.delete(institucionmodel);

                institucion=dao.getAll();
                notifyDataSetChanged();

                Toast.makeText(context.getApplicationContext(),"Institucion eliminada", Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    public int getItemCount() {
        return institucion.size();
    }

}
