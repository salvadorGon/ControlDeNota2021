package com.example.controldenotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityViewCommand;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.controldenotas.DataView.RegistroUsuario;
import com.example.controldenotas.Models.Alumno;

public class Principal extends AppCompatActivity {

    Button btnAlumnoPerfil, btnActividad, btnCali, btnCerrarSesion, btnConfiguracion;

    @Override
    public void onBackPressed() {

        //super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        this.btnAlumnoPerfil = (Button) findViewById(R.id.btnPerfil);
        this.btnActividad = (Button) findViewById(R.id.btnActividad);
        this.btnCali = (Button) findViewById(R.id.btnCalificarr);
        this.btnCerrarSesion = (Button) findViewById(R.id.btnCerrar);
        this.btnConfiguracion = (Button) findViewById(R.id.btnConfiguracion);

        Intent intent = new Intent(this, Perfil.class);
        Intent intentAct = new Intent(this, ListaActividades.class);
        Intent intentCal = new Intent(this, Buscando.class);
        Intent intentCerrar = new Intent(this, Login.class);
        Intent intentAgregarDatos = new Intent(this, AgregarActividades.class);

        //eventos click de los botones
        //VER EL PERFIL DEL ALUMNO
        btnAlumnoPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        //PARA GESTIONAR ACTIVIDADES
        btnActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentAct);
            }
        });


        //BTN CALIFICAR
        btnCali.setOnClickListener(new View.OnClickListener() {
            @Override
            //busca un alumno o lista de alumnos para calificar
            public void onClick(View v) {
                startActivity(intentCal);
            }
        });


        //BTN CIERRA SESION
        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentCerrar);
            }
        });

        //btn solo agrega datos a las tablas
        btnConfiguracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aqui se va agregar datos a las tablas
                startActivity(intentAgregarDatos);
                //fin de agregar datos a las tablas
            }
        });



    }

}