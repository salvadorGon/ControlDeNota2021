package com.example.controldenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.example.controldenotas.Dao.ActividadDao;
import com.example.controldenotas.Dao.GrupoDao;
import com.example.controldenotas.Dao.InstitucionDao;
import com.example.controldenotas.Dao.MateriaDao;
import com.example.controldenotas.DaoImp.ActividadDaoImpRoom;
import com.example.controldenotas.DaoImp.GrupoDaoImpRoom;
import com.example.controldenotas.DaoImp.InstitucionDaoImpRoom;
import com.example.controldenotas.DaoImp.MateriaDaoImpRoom;
import com.example.controldenotas.Models.Actividad;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class Buscando extends AppCompatActivity {

    Button btnMostrarAlumnosCalificar;
    AutoCompleteTextView acInstitucion, acMateria, acGrupo,acActividad;
    private String[] universidades = { "USO", "UNAB", "UES", "UFG"};
    List<Actividad> actividadeslist;

    InstitucionDao daoInstitucion;
    MateriaDao daoMateria;
    GrupoDao daoGrupo;
    ActividadDao daoActividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscando);

        daoInstitucion = new InstitucionDaoImpRoom(getApplicationContext());
        daoMateria = new MateriaDaoImpRoom(getApplicationContext());
        daoGrupo = new GrupoDaoImpRoom(getApplicationContext());
        daoActividad=new ActividadDaoImpRoom(getApplicationContext());


        //CARGAR DATOS A LOS AUTO COMPLETE TEXT

        //mostrando ventana de alumnos que cumplan con los filtros
        this.btnMostrarAlumnosCalificar = (Button) findViewById(R.id.btnMostrarCALIFICAR);
        this.acInstitucion = (AutoCompleteTextView) findViewById(R.id.acInstitucion);
        this.acMateria = (AutoCompleteTextView) findViewById(R.id.acMateria);
        this.acGrupo = (AutoCompleteTextView) findViewById(R.id.acGrupo);
        this.acActividad = (AutoCompleteTextView) findViewById(R.id.acActividad);


        Intent intentMostrando = new Intent(this, CalificandoAlumno.class);
        this.cargarDatos();

        //adaptador de tipo string
        ArrayAdapter<String> adapterInstitucion = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, daoInstitucion.getNombreInstitucion());
        ArrayAdapter<String> adapterMateria = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, daoMateria.getNombreMateria());
        ArrayAdapter<String> adapterGrupo = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, daoGrupo.getNombreGrupo());
        ArrayAdapter<String> adapterActividad = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, daoActividad.getNombreActividad());


        acInstitucion.setAdapter(adapterInstitucion);
        acMateria.setAdapter(adapterMateria);
        acGrupo.setAdapter(adapterGrupo);
        acActividad.setAdapter(adapterActividad);
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