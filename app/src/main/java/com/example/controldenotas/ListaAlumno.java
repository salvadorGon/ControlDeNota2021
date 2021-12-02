package com.example.controldenotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.controldenotas.Adaptador.AlumnoAdapter;
import com.example.controldenotas.Adaptador.AlumnoVAdapter;
import com.example.controldenotas.Dao.AlumnoDao;
import com.example.controldenotas.DaoImp.AlumnoDaoImpRoom;
import com.example.controldenotas.Models.Alumno;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListaAlumno extends AppCompatActivity {

    FloatingActionButton btnNuevoAlum;
    RecyclerView rvAlumno;

    List<Alumno> alumno;

    AlumnoDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alumno);

        dao = new AlumnoDaoImpRoom(getApplicationContext());

        //Instancias a componentes graficos
        this.btnNuevoAlum = (FloatingActionButton) findViewById(R.id.btnNuevoAlumno);
        this.rvAlumno = (RecyclerView) findViewById(R.id.rvAlumno);

        //Eventos
        this.btnNuevoAlum.setOnClickListener(v->{
            Alumno a = new Alumno();
            a.setPrimerNombre("Gerson");
            a.setSegundoNombre("Otoniel");
            a.setPrimerApellido("Gutierrez");
            a.setSegundoApellido("Giron");
            dao.save(a);
            cargarDatos();

            AlumnoVAdapter adapter = new AlumnoVAdapter(this.alumno,getApplicationContext(), dao);
            rvAlumno.setLayoutManager(new LinearLayoutManager(this));

            rvAlumno.setAdapter(adapter);
        });

        //Cargando datos de Docente
        this.cargarDatos();

        //Configuracion de Recyclerview
        //Instancia del adaptador
        AlumnoVAdapter adapter = new AlumnoVAdapter(this.alumno,getApplicationContext(), dao);
        rvAlumno.setLayoutManager(new LinearLayoutManager(this));

        //Configuracion del adaptador
        rvAlumno.setAdapter(adapter);
    }
    void cargarDatos(){
        alumno = new ArrayList<Alumno>();
        alumno = dao.getAll();
    }
}