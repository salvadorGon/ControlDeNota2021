package com.example.controldenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.controldenotas.Dao.ActividadDao;
import com.example.controldenotas.DaoImp.ActividadDaoImpRoom;
import com.example.controldenotas.Dao.AlumnoDao;
import com.example.controldenotas.DaoImp.AlumnoDaoImpRoom;
import com.example.controldenotas.Models.Actividad;
import com.example.controldenotas.Models.Alumno;

public class AgregarActividades extends AppCompatActivity {
    Actividad actividad;
    ActividadDao dao;
    Button btnContinuar;
    Alumno alumno;
    AlumnoDao daoalumno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_actividades);
        dao = new ActividadDaoImpRoom(getApplicationContext());
        daoalumno = new AlumnoDaoImpRoom(getApplicationContext());
        this.btnContinuar=(Button) findViewById(R.id.btnContinuar);
        guardarAlumno();
        guardarActividad();

        Intent intent =new Intent(this,ListaActividades.class);

        dao=new ActividadDaoImpRoom(getApplicationContext());
        //eventos
        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intent);
            }
        });

    }
    void  guardarActividad(){
        actividad=new Actividad();
        actividad.setNombre("actividad evaluada");
        actividad.setDescripcion("esta es una actividad evaluada");
        actividad.setPorcentaje(10.00);
        dao.save(actividad);

    }

    void  guardarAlumno(){
        alumno=new Alumno();
        alumno.setPrimerNombre("Gerson");
        alumno.setSegundoNombre("Otoniel");
        alumno.setPrimerApellido("Gutierrez");
        alumno.setSegundoApellido("Giron");
        daoalumno.save(alumno);

    }
}