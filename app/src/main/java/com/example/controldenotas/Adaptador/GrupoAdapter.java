package com.example.controldenotas.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.controldenotas.Dao.GrupoDao;
import com.example.controldenotas.DataView.ListaGrupos;
import com.example.controldenotas.DataView.ListaMaterias;
import com.example.controldenotas.Models.Grupo;
import com.example.controldenotas.R;

import java.util.List;

public class GrupoAdapter extends RecyclerView.Adapter<GrupoAdapter.ViewHolder> {

    List<Grupo> grupo;
    Context context;
    GrupoDao dao;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView txvIdGrupo;
        TextView txvNombreGrupo;
        TextView txvAnio;

        Button btnEditarGrupo;
        Button btnVerNotas;
        Button btnEliminarGrupo;
        Context context;

        public ViewHolder(View view, Context context){
            super(view);
            this.txvIdGrupo = (TextView) view.findViewById(R.id.txvIdGrupo);
            this.txvNombreGrupo = (TextView) view.findViewById(R.id.txvMostrarNombreGrupo);
            this.txvAnio = (TextView) view.findViewById(R.id.txvanio);

            this.btnEditarGrupo = (Button) view.findViewById(R.id.btnModificarGrupo);
            this.btnVerNotas= (Button) view.findViewById(R.id.btnVerNotas);
            this.btnEliminarGrupo= (Button) view.findViewById(R.id.btnEliminarGrupo);
            this.context = context;
        }
    }

    public GrupoAdapter(List<Grupo> grupo, Context context, GrupoDao dao){
        this.context = context;
        this.grupo = grupo;
        this.dao=dao;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grupo, parent, false);
        ViewHolder vh = new ViewHolder(v,context);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Grupo grupoModel= grupo.get(position);
        holder.txvIdGrupo.setText(""+grupoModel.getIdGrupo());
        holder.txvNombreGrupo.setText(grupoModel.getNombre());
        holder.txvAnio.setText(grupoModel.getAnio()+"");

        //Eliminar

        holder.btnEliminarGrupo.setOnClickListener(v->{
            dao.delete(grupoModel);
            grupo = dao.getAll();
            notifyDataSetChanged();
            Toast.makeText(context.getApplicationContext(),"Grupo eliminado",Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return grupo.size();
    }

}
