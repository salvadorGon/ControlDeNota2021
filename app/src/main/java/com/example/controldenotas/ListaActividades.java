package com.example.controldenotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.controldenotas.Adaptador.ActividadAdapter;
import com.example.controldenotas.Dao.ActividadDao;
import com.example.controldenotas.DaoImp.ActividadDaoImpRoom;
import com.example.controldenotas.Models.Actividad;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListaActividades extends AppCompatActivity {
    FloatingActionButton btnNuevaActividad;
    RecyclerView rvactividad;

    List<Actividad> actividades;

    ActividadDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listaactividades);
        dao=new ActividadDaoImpRoom(getApplicationContext());

        //instancias a componentes graficos
        this.btnNuevaActividad=(FloatingActionButton) findViewById(R.id.btnNuevaActividad);
        this.rvactividad=(RecyclerView) findViewById(R.id.rvActividades);

        //mandamos a llamar nuevo contacto
        Intent intent=new Intent(this, AgregarActividades.class);

        //eventos
        this.btnNuevaActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        //cargando datos de actividades
        this.cargarDatos();

        //configurando recyclerview
        //instancia del adaptador
        ActividadAdapter adapter=new ActividadAdapter(this.actividades, getApplicationContext(), dao);

        rvactividad.setLayoutManager(new LinearLayoutManager(this));

        //config del adaptador
        rvactividad.setAdapter(adapter);
    }

    void  cargarDatos(){
        actividades=new ArrayList<Actividad>();
        actividades=dao.getAll();
    }
}