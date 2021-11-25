package com.example.controldenotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.example.controldenotas.Adaptador.ActividadAdapter;
import com.example.controldenotas.Adaptador.AlumnoAdapter;
import com.example.controldenotas.Dao.ActividadDao;
import com.example.controldenotas.DaoImp.ActividadDaoImpRoom;
import com.example.controldenotas.Models.Actividad;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class Buscando extends AppCompatActivity {

    Button btnMostrarAlumnosCalificar;
    AutoCompleteTextView acInstitucion, acMateria, acGrupo,acActividad;
    private String[] universidades = { "USO", "UNAB", "UES", "UFG"};
    List<Actividad> actividadeslist;
    ActividadDao daoActividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscando);

        daoActividad=new ActividadDaoImpRoom(getApplicationContext());

        //CARGAR DATOS A LOS

        //mostrando ventana de alumnos que cumplan con los filtros
        this.btnMostrarAlumnosCalificar = (Button) findViewById(R.id.btnMostrarCALIFICAR);
        this.acInstitucion = (AutoCompleteTextView) findViewById(R.id.acInstitucion);
        this.acMateria = (AutoCompleteTextView) findViewById(R.id.acMateria);
        this.acGrupo = (AutoCompleteTextView) findViewById(R.id.acGrupo);
        this.acActividad = (AutoCompleteTextView) findViewById(R.id.acActividad);

        Intent intentMostrando = new Intent(this, CalificandoAlumno.class);
        this.cargarDatos();

        //adaptador de tipo string
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, universidades);

        //instancia del adaptador de tipo objeto
        ActividadAdapter adapterActividades=new ActividadAdapter(this.actividadeslist, getApplicationContext(), daoActividad);

        acInstitucion.setAdapter(adapter);
        acMateria.setAdapter(adapter);
        acGrupo.setAdapter(adapter);
        acActividad.setAdapter(adapter);
        //acActividad.setAdapter(adapterActividades);

        //fin carga de datos

        //evento
        btnMostrarAlumnosCalificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentMostrando);
            }
        });




    }
    void  cargarDatos(){
        actividadeslist=new ArrayList<Actividad>();
        actividadeslist=daoActividad.getAll();
    }
}