package com.example.controldenotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityViewCommand;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.controldenotas.DataView.RegistroUsuario;

public class Principal extends AppCompatActivity {

    Button btnAlumnoPerfil;
    Button btnActividad;
    Button btnCali;
    Button btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        this.btnAlumnoPerfil = (Button) findViewById(R.id.btnPerfil);

        Intent intent = new Intent(this, Perfil.class);

        btnAlumnoPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        this.btnActividad = (Button) findViewById(R.id.btnActividad);

        Intent intentAct = new Intent(this, AgregarActividades.class);

        btnActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentAct);
            }
        });

        this.btnCali = (Button) findViewById(R.id.btnCalificarr);

        Intent intentCal = new Intent(this, Calificando.class);

        btnCali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentCal);
            }
        });

        this.btnCerrarSesion = (Button) findViewById(R.id.btnCerrar);

        Intent intentCerrar = new Intent(this, Login.class);

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentCerrar);
            }
        });

    }
}