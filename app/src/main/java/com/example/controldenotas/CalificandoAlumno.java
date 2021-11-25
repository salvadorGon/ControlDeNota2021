package com.example.controldenotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.controldenotas.Adaptador.AlumnoAdapter;
import com.example.controldenotas.Dao.AlumnoDao;
import com.example.controldenotas.DaoImp.AlumnoDaoImpRoom;
import com.example.controldenotas.Models.Alumno;

import java.util.ArrayList;
import java.util.List;

public class CalificandoAlumno extends AppCompatActivity {
    Button btnGuardarNotas;
    RecyclerView rvAlumnosInscritos;

    List<Alumno> alumnos;

    AlumnoDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificandoalumno);
        dao=new AlumnoDaoImpRoom(getApplicationContext());

        this.rvAlumnosInscritos=(RecyclerView) findViewById(R.id.rvAlumnosInscritos);
        this.btnGuardarNotas = (Button) findViewById(R.id.btnGuardarNotas);
        cargarDatos();

        //configurando recyclerview
        //instancia del adaptador
        AlumnoAdapter adapter=new AlumnoAdapter(this.alumnos, getApplicationContext(), dao);
        rvAlumnosInscritos.setLayoutManager(new LinearLayoutManager(this));
        Intent intentPrincipal = new Intent(this, Principal.class);

        //evento click de boton
        btnGuardarNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentPrincipal);
            }
        });

        //config del adaptador
        rvAlumnosInscritos.setAdapter(adapter);
    }

    void  cargarDatos(){
        alumnos=new ArrayList<Alumno>();
        alumnos=dao.getAll();
    }
}