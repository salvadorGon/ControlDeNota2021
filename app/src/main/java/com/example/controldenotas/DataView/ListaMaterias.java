package com.example.controldenotas.DataView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.controldenotas.Adaptador.ActividadAdapter;
import com.example.controldenotas.Adaptador.MateriaAdapter;
import com.example.controldenotas.Dao.MateriaDao;
import com.example.controldenotas.DaoImp.MateriaDaoImpRoom;
import com.example.controldenotas.Models.Actividad;
import com.example.controldenotas.Models.Materia;
import com.example.controldenotas.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListaMaterias extends AppCompatActivity {

    FloatingActionButton btnNuevaMateria;
    RecyclerView rvMateria;

    List<Materia> materias;

    MateriaDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_materias);

        btnNuevaMateria = (FloatingActionButton) findViewById(R.id.btnNuevaMateria);
        dao= new MateriaDaoImpRoom(getApplicationContext());
        rvMateria = (RecyclerView) findViewById(R.id.rvMaterias);

        this.btnNuevaMateria.setOnClickListener(v->{
            Materia m = new Materia();
            m.setNombre("Mate1");
            m.setDescripcion("Materia de 1 año ");
            dao.save(m);
            cargarDatos();

            MateriaAdapter adapter = new MateriaAdapter(this.materias, getApplicationContext(), dao);
            rvMateria.setLayoutManager(new LinearLayoutManager(this));

            rvMateria.setAdapter(adapter);

        });

        this.cargarDatos();

        MateriaAdapter adapter = new MateriaAdapter(this.materias, getApplicationContext(), dao);
        rvMateria.setLayoutManager(new LinearLayoutManager(this));

        rvMateria.setAdapter(adapter);


    }

    public void cargarDatos(){
        materias = new ArrayList<Materia>();
        materias = dao.getAll();
    }
}