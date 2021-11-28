package com.example.controldenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.controldenotas.Dao.ActividadDao;
import com.example.controldenotas.Dao.ActividadMateriaGrupoDao;
import com.example.controldenotas.Dao.DocenteDao;
import com.example.controldenotas.Dao.GrupoDao;
import com.example.controldenotas.Dao.InstitucionDao;
import com.example.controldenotas.Dao.MateriaDao;
import com.example.controldenotas.DaoImp.ActividadDaoImpRoom;
import com.example.controldenotas.Dao.AlumnoDao;
import com.example.controldenotas.DaoImp.ActividadMateriaGrupoDaoImpRoom;
import com.example.controldenotas.DaoImp.AlumnoDaoImpRoom;
import com.example.controldenotas.DaoImp.DocenteDaoImpRoom;
import com.example.controldenotas.DaoImp.GrupoDaoImpRoom;
import com.example.controldenotas.DaoImp.InstitucionDaoImpRoom;
import com.example.controldenotas.DaoImp.MateriaDaoImpRoom;
import com.example.controldenotas.Models.Actividad;
import com.example.controldenotas.Models.ActividadMateriaGrupo;
import com.example.controldenotas.Models.Alumno;
import com.example.controldenotas.Models.Docente;
import com.example.controldenotas.Models.Grupo;
import com.example.controldenotas.Models.Institucion;
import com.example.controldenotas.Models.Materia;

public class AgregarActividades extends AppCompatActivity {
    Button btnContinuar;

    Actividad actividad;
    ActividadDao dao;

    Alumno alumno;
    AlumnoDao daoalumno;

    Docente docente;
    DocenteDao daodocente;

    Grupo grupo;
    GrupoDao daogrupo;

    Institucion institucion;
    InstitucionDao daoinstitucion;

    Materia materia;
    MateriaDao daomateria;

    ActividadMateriaGrupo amg;
    ActividadMateriaGrupoDao amgdao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_actividades);

        //generando el contexto para los dao
        dao = new ActividadDaoImpRoom(getApplicationContext());
        daoalumno = new AlumnoDaoImpRoom(getApplicationContext());
        daodocente = new DocenteDaoImpRoom(getApplicationContext());
        daogrupo = new GrupoDaoImpRoom(getApplicationContext());
        daoinstitucion = new InstitucionDaoImpRoom(getApplicationContext());
        daomateria = new MateriaDaoImpRoom(getApplicationContext());
        amgdao = new ActividadMateriaGrupoDaoImpRoom(getApplicationContext());

        //vinculando los botones
        this.btnContinuar=(Button) findViewById(R.id.btnContinuar);

        //ejecutando creacion de datos
        guardarAlumno();
        guardarActividad();
        guardarMateria();
        guardarDocente();
        guardarGrupo();
        guardarInstitucion();
        guardarActividadMateriagrupo();

        Intent intent =new Intent(this,Principal.class);

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

    void guardarDocente(){
        docente = new Docente();
        docente.setNombre("Walter");
        docente.setApellido("Tejada");
        docente.setTelefono("77889988");
        docente.setDui("05236987");
        daodocente.save(docente);
    }

    void guardarGrupo(){
        grupo = new Grupo();
        grupo.setNombre("GrupoAlumnos");
        grupo.setAnio(2021);
        grupo.setIdMateria(1);
        daogrupo.save(grupo);
    }

    void guardarInstitucion(){
        institucion = new Institucion();
        institucion.setNombre("Universidad de Sonsonate");
        institucion.setTelefono("23456786");
        institucion.setIdDocente(1);
        daoinstitucion.save(institucion);
    }

    void guardarMateria(){
        materia = new Materia();
        materia.setNombre("Matematica");
        materia.setDescripcion("Es una materia");
        daomateria.save(materia);
    }

    void guardarActividadMateriagrupo(){
        amg = new ActividadMateriaGrupo();
        amg.setIdActividad(1);
        amg.setIdMateria(1);
        amg.setIdGrupo(1);
        amgdao.save(amg);
    }

}