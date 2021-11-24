package com.example.controldenotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.controldenotas.DataView.RegistroUsuario;

public class Login extends AppCompatActivity {

    Button btnRegistrar;
    Button btnAgregarActividades;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.btnRegistrar = (Button) findViewById(R.id.btnIngresar);
        this.btnAgregarActividades = (Button)  findViewById(R.id.btnRegistrarse);

        Intent intent = new Intent(this, Principal.class);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        //Intent intent1 = new Intent(this, ListaActividades.class);
        Intent intent1 = new Intent(this, RegistroUsuario.class);
        btnAgregarActividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });




    }
}