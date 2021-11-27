package com.example.controldenotas.DataView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.controldenotas.Adaptador.GrupoAdapter;
import com.example.controldenotas.Dao.GrupoDao;
import com.example.controldenotas.DaoImp.GrupoDaoImpRoom;
import com.example.controldenotas.Models.Grupo;
import com.example.controldenotas.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListaGrupos extends AppCompatActivity {

    FloatingActionButton btnNuevoGrupo;
    RecyclerView rvGrupo;
    List<Grupo> grupos;
    GrupoDao dao;
    int idMateria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_grupos);

        btnNuevoGrupo = findViewById(R.id.btnNuevoGrupo);
        rvGrupo = (RecyclerView) findViewById(R.id.rvGrupos);
        dao= new GrupoDaoImpRoom(getApplicationContext());
        idMateria = getIntent().getExtras().getInt("idMateria");

        btnNuevoGrupo.setOnClickListener(view -> {
            Grupo g = new Grupo();
            g.setIdGrupo(0);
            g.setNombre("G01");
            g.setAnio(2000);
            g.setIdMateria(idMateria);
            dao.save(g);
            cargarDatos();

            GrupoAdapter adapter = new GrupoAdapter(this.grupos, getApplicationContext(), dao);
            rvGrupo.setLayoutManager(new LinearLayoutManager(this));
            rvGrupo.setAdapter(adapter);
        });
        this.cargarDatos();

        GrupoAdapter adapter = new GrupoAdapter(this.grupos, getApplicationContext(), dao);
        rvGrupo.setLayoutManager(new LinearLayoutManager(this));
        rvGrupo.setAdapter(adapter);
    }

    public void cargarDatos(){
        grupos = new ArrayList<Grupo>();
        grupos = dao.getAll();
    }
}