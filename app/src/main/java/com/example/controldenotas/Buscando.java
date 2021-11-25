package com.example.controldenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Buscando extends AppCompatActivity {

    Button btnMostrarAlumnosCalificar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscando);

        //CARGAR DATOS A LOS

        //fin carga de datos

        //mostrando ventana de alumnos que cumplan con los filtros
        this.btnMostrarAlumnosCalificar = (Button) findViewById(R.id.btnMostrarCALIFICAR);
        Intent intentMostrando = new Intent(this, CalificandoAlumno.class);

        //evento
        btnMostrarAlumnosCalificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentMostrando);
            }
        });


    }
}