package com.example.controldenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.controldenotas.Dao.ActividadDao;
import com.example.controldenotas.Dao.ActividadMateriaGrupoDao;
import com.example.controldenotas.Dao.GrupoDao;
import com.example.controldenotas.Dao.InstitucionDao;
import com.example.controldenotas.Dao.MateriaDao;
import com.example.controldenotas.Dao.NotaDao;
import com.example.controldenotas.DaoImp.ActividadDaoImpRoom;
import com.example.controldenotas.DaoImp.ActividadMateriaGrupoDaoImpRoom;
import com.example.controldenotas.DaoImp.GrupoDaoImpRoom;
import com.example.controldenotas.DaoImp.InstitucionDaoImpRoom;
import com.example.controldenotas.DaoImp.MateriaDaoImpRoom;
import com.example.controldenotas.DaoImp.NotaDaoImpRoom;
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
    Bundle bundle = new Bundle();

    String nameactivity;
    int idactividad, idmateria, validar, idValidadorUnico;

    ActividadMateriaGrupoDao actividadmateriagrupodaoBuscando;
    NotaDao notadao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscando);

        daoInstitucion = new InstitucionDaoImpRoom(getApplicationContext());
        daoMateria = new MateriaDaoImpRoom(getApplicationContext());
        daoGrupo = new GrupoDaoImpRoom(getApplicationContext());
        daoActividad=new ActividadDaoImpRoom(getApplicationContext());
        actividadmateriagrupodaoBuscando = new ActividadMateriaGrupoDaoImpRoom(getApplicationContext());
        notadao = new NotaDaoImpRoom(getApplicationContext());


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


        //ASIGNANDO VALOR A ENVIAR
        //***********************************************************************
        //seleccionados por el usuario
        //*******************************************************************************
        acInstitucion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                validar += 1;
            }
        });

        acGrupo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                validar += 1;
            }
        });

        acActividad.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                nameactivity = (String)parent.getItemAtPosition(position);
                idactividad = position+1;
                validar += 1;
                //Log.e("========>>", acActividad.getText().toString());
            }
        });

        acMateria.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                idmateria = position+1;
                validar += 1;
            }
        });

        //*******************************************************************
        //*********************************************************************
        //evento
        btnMostrarAlumnosCalificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validar >= 4) {
                    //Toast.makeText(getApplicationContext(), idactividad + " " + idmateria, Toast.LENGTH_SHORT).show();
                    //VALOR A TRASLADAR
                    bundle.putString("Actividad", nameactivity);
                    bundle.putInt("idActividad", idactividad);
                    bundle.putInt("idMateria", idmateria);
                    idValidadorUnico = conseguirIdActividadMateriaGrupoBuscando(idactividad,idmateria,1);
                    intentMostrando.putExtras(bundle);
                    try {
                        if (notadao.geti(idValidadorUnico) == 0) {
                            startActivity(intentMostrando);
                        } else {
                            Toast.makeText(getApplicationContext(), "Actividad ya fue calificada", Toast.LENGTH_SHORT).show();
                        }
                    }catch (Exception e){}
                }else{
                    Toast.makeText(getApplicationContext(), "Complete la informacion", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    void  cargarDatos(){
        actividadeslist=new ArrayList<Actividad>();
        actividadeslist=daoActividad.getAll();
    }

    int conseguirIdActividadMateriaGrupoBuscando(int idAct, int idMateria, int idGrupo){
        int id = 0;
        //evaluar para conseguir id
        id = actividadmateriagrupodaoBuscando.get(idAct,idMateria,idGrupo);
        return id;
    }
}