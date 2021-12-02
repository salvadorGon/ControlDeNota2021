package com.example.controldenotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.controldenotas.Adaptador.AlumnoAdapter;
import com.example.controldenotas.Adaptador.AlumnoNotasAdapter;
import com.example.controldenotas.Dao.ActividadMateriaGrupoDao;
import com.example.controldenotas.Dao.AlumnoDao;
import com.example.controldenotas.Dao.NotaDao;
import com.example.controldenotas.DaoImp.ActividadMateriaGrupoDaoImpRoom;
import com.example.controldenotas.DaoImp.AlumnoDaoImpRoom;
import com.example.controldenotas.DaoImp.NotaDaoImpRoom;
import com.example.controldenotas.Models.ActividadMateriaGrupo;
import com.example.controldenotas.Models.Alumno;
import com.example.controldenotas.Models.Nota;

import java.util.ArrayList;
import java.util.List;

public class MostrarNotasAlumno extends AppCompatActivity {

    RecyclerView rvAlumnosInscritos;
    List<Alumno> alumnos;
    AlumnoDao dao;

    List<Nota> nota;
    NotaDao notadao;

    ActividadMateriaGrupo actividadmateriagrupo;
    ActividadMateriaGrupoDao actividadmateriagrupodao;
    TextView tvNombreActEvaluada;
   TextView edittextnota, tvNombreMateria;
   int idact, idmater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrarnotasalumno);
        dao=new AlumnoDaoImpRoom(getApplicationContext());

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //RECUPERAR VALORES
        Bundle bundle = getIntent().getExtras();
        String variable = bundle.getString("Actividad");
        String variablemateria = bundle.getString("Materia");
        idact = bundle.getInt("idActividad");
        idmater = bundle.getInt("idMateria");

        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        notadao = new NotaDaoImpRoom(getApplicationContext());
        actividadmateriagrupodao = new ActividadMateriaGrupoDaoImpRoom(getApplicationContext());

        this.rvAlumnosInscritos=(RecyclerView) findViewById(R.id.rvAlumnosInscritosmos);
        this.tvNombreActEvaluada = (TextView) findViewById(R.id.tvNombreActEvaluada);
        this.edittextnota = (TextView) findViewById(R.id.txvMostrarNota);
        this.tvNombreMateria = (TextView) findViewById(R.id.tvNombreMateria);

        cargarDatos();

        //asignando valores
        tvNombreActEvaluada.setText(variable);
        tvNombreMateria.setText(variablemateria);

        //**********************************************************************

        //configurando recyclerview
        //instancia del adaptador
        AlumnoNotasAdapter adapter=new AlumnoNotasAdapter(this.alumnos, this.nota, getApplicationContext(), dao, notadao);
        rvAlumnosInscritos.setLayoutManager(new LinearLayoutManager(this));
        Intent intentPrincipal = new Intent(this, Principal.class);



        //config del adaptador
        rvAlumnosInscritos.setAdapter(adapter);
    }

    void  cargarDatos(){
        alumnos=new ArrayList<Alumno>();
        alumnos=dao.getAll();
        nota = new ArrayList<Nota>();
        nota = notadao.get(conseguirIdActividadMateriaGrupo(idact, idmater, 1));
    }


    int conseguirIdActividadMateriaGrupo(int idAct, int idMateria, int idGrupo){
        int id = 0;
        //evaluar para conseguir id
        id = actividadmateriagrupodao.get(idAct,idMateria,idGrupo);
        return id;
    }

    void mostrarDatosNotasCargar(){
        //hacer un getall
    }
}