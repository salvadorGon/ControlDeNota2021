package com.example.controldenotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.controldenotas.Adaptador.InstitucionAdapter;
import com.example.controldenotas.Dao.InstitucionDao;
import com.example.controldenotas.DaoImp.InstitucionDaoImpRoom;
import com.example.controldenotas.Models.Institucion;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListaInstitucion extends AppCompatActivity {

    FloatingActionButton btnNuevaInstitucion;
    RecyclerView rvInstitucion;

    List<Institucion> institucion;

    InstitucionDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listainstitucion);

        dao = new InstitucionDaoImpRoom(getApplicationContext());

        //instancias a componentes graficos
        this.btnNuevaInstitucion = (FloatingActionButton) findViewById(R.id.btnNuevaInstitucion);
        this.rvInstitucion = (RecyclerView) findViewById(R.id.rvInstitucion);

        //Eventos

        this.btnNuevaInstitucion.setOnClickListener(v->{
            Institucion i = new Institucion();
            i.setNombre("uso");
            i.setTelefono("76890987");
            dao.save(i);
            cargarDatos();

            InstitucionAdapter adapter = new InstitucionAdapter(this.institucion, getApplicationContext(), dao);
            rvInstitucion.setLayoutManager(new LinearLayoutManager(this));

            rvInstitucion.setAdapter(adapter);
        });

        //cargando datos de Institucion
        this.cargarDatos();



        //cpmfiguracion recyclerview
        //instancia del adaptador
        InstitucionAdapter adapter = new InstitucionAdapter(this.institucion, getApplicationContext(), dao);
        rvInstitucion.setLayoutManager(new LinearLayoutManager(this));

        //Configuracion del adaptador
        rvInstitucion.setAdapter(adapter);
    }

    void cargarDatos(){
        institucion = new ArrayList<Institucion>();
        institucion = dao.getAll();
    }
}
