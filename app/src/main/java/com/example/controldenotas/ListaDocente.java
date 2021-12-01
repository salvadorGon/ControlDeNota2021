package com.example.controldenotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.controldenotas.Adaptador.DocenteAdapter;
import com.example.controldenotas.Dao.DocenteDao;
import com.example.controldenotas.DaoImp.DocenteDaoImpRoom;
import com.example.controldenotas.Models.Docente;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListaDocente extends AppCompatActivity {

    FloatingActionButton btnNuevoDocen;
    RecyclerView rvDocente;

    List<Docente> docente;

    DocenteDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_docente);

        dao = new DocenteDaoImpRoom(getApplicationContext());

        //Instancias a componentes graficos
        this.btnNuevoDocen = (FloatingActionButton) findViewById(R.id.btnNuevoDocente);
        this.rvDocente = (RecyclerView) findViewById(R.id.rvDocente);

        //Eventos
        this.btnNuevoDocen.setOnClickListener(v->{
            Docente d = new Docente();
            d.setNombre("Iliana");
            d.setApellido("Rodriguez");
            dao.save(d);
            cargarDatos();

            DocenteAdapter adapter = new DocenteAdapter(this.docente,getApplicationContext(), dao);
            rvDocente.setLayoutManager(new LinearLayoutManager(this));

            rvDocente.setAdapter(adapter);
        });

        //Cargando datos de Docente
        this.cargarDatos();

        //Configuracion de Recyclerview
        //Instancia del adaptador
        DocenteAdapter adapter = new DocenteAdapter(this.docente,getApplicationContext(), dao);
        rvDocente.setLayoutManager(new LinearLayoutManager(this));

        //Configuracion del adaptador
        rvDocente.setAdapter(adapter);
    }

    void cargarDatos(){
        docente = new ArrayList<Docente>();
        docente = dao.getAll();
    }
}