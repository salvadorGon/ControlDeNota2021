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
        guardarAlumno("Gerson","Otoniel", "Gutierrez", "Giron");
        guardarAlumno("Iliana","Guadalupe", "Rodriguez", "Chica");
        guardarAlumno("Leyssi","Rosmery", "Suriano", "  Corado");
        guardarAlumno("Salvador","Antonio", "Gonzalez", "Sanchez");
        guardarAlumno("Keny","Guadalupe", "Lue", "Cortez");

        guardarActividad("1 Examen Parcial", 20);
        guardarActividad("2 Examen Parcial", 20);
        guardarActividad("Laboratorio", 10);
        guardarActividad("Practica", 10);
        guardarActividad("Examen Final", 40);

        guardarMateria("Implantacion de sistemas");
        guardarMateria("Metodos");
        guardarMateria("Legislacion");
        guardarMateria("Programacion moviles");
        guardarMateria("Arquitectura de computadoras");

        guardarDocente();

        guardarGrupo("Grupo 1", 1);


        guardarInstitucion("Universidad de Sonsonate");
        guardarInstitucion("Universidad Andres Bello");
        guardarInstitucion("Universidad Modular Abierta");

        for(int i=1; i<=5;i++){
            for(int j=1; j<=5;j++){
                guardarActividadMateriagrupo(i, j, 1);
            }
        }

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
    void  guardarActividad(String name, int porcentaje){
        actividad=new Actividad();
        actividad.setNombre(name);
        actividad.setDescripcion("Hola soy una actividad");
        actividad.setPorcentaje(porcentaje);
        dao.save(actividad);

    }

    void  guardarAlumno(String unon, String dosn, String unoa, String dosa){
        alumno=new Alumno();
        alumno.setPrimerNombre(unon);
        alumno.setSegundoNombre(dosn);
        alumno.setPrimerApellido(unoa);
        alumno.setSegundoApellido(dosa);
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

    void guardarGrupo(String name, int id){
        grupo = new Grupo();
        grupo.setNombre(name);
        grupo.setAnio(2021);
        grupo.setIdMateria(id);
        daogrupo.save(grupo);
    }

    void guardarInstitucion(String name){
        institucion = new Institucion();
        institucion.setNombre(name);
        institucion.setTelefono("23456786");
        institucion.setIdDocente(1);
        daoinstitucion.save(institucion);
    }

    void guardarMateria(String name){
        materia = new Materia();
        materia.setNombre(name);
        materia.setDescripcion("Hola soy materia");
        daomateria.save(materia);
    }

    void guardarActividadMateriagrupo(int id, int id2, int id3){
        amg = new ActividadMateriaGrupo();
        amg.setIdActividad(id);
        amg.setIdMateria(id2);
        amg.setIdGrupo(id3);
        amgdao.save(amg);
    }

}