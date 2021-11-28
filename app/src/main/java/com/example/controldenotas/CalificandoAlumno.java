package com.example.controldenotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.controldenotas.Adaptador.AlumnoAdapter;
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

public class CalificandoAlumno extends AppCompatActivity {

    Button btnGuardarNotas;
    RecyclerView rvAlumnosInscritos;
    List<Alumno> alumnos;
    AlumnoDao dao;

    Nota nota;
    NotaDao notadao;

    ActividadMateriaGrupo actividadmateriagrupo;
    ActividadMateriaGrupoDao actividadmateriagrupodao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificandoalumno);
        dao=new AlumnoDaoImpRoom(getApplicationContext());

        notadao = new NotaDaoImpRoom(getApplicationContext());
        actividadmateriagrupodao = new ActividadMateriaGrupoDaoImpRoom(getApplicationContext());

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
                //aqui se va  a guardar en tabla notas
                //debo saber los datos del filtro
                try {

                    if(guardarNota(10, 1,conseguirIdActividadMateriaGrupo(1, 1, 1))) {
                        startActivity(intentPrincipal);
                    }else{
                        Toast.makeText(getApplicationContext(), "Error: Datos no guardados ", Toast.LENGTH_SHORT).show();
                    }
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Error: "+e, Toast.LENGTH_SHORT).show();
                }
            }
        });

        //config del adaptador
        rvAlumnosInscritos.setAdapter(adapter);
    }

    void  cargarDatos(){
        alumnos=new ArrayList<Alumno>();
        alumnos=dao.getAll();
    }

    Boolean guardarNota(double notaparametro, int idalumnoparametro, int idActMatGrupo){
        boolean bandera = false;
        if(idActMatGrupo > 0) {
            nota = new Nota();
            nota.setNota(notaparametro);
            nota.setIdAlumno(idalumnoparametro);
            nota.setIdActividadMateriaGrupo(idActMatGrupo);
            notadao.save(nota);
            bandera = true;
            Toast.makeText(getApplicationContext(), "Guardado correctamente", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
        }
        return bandera;
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