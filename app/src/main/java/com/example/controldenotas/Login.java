package com.example.controldenotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.controldenotas.DataView.RegistroUsuario;

public class Login extends AppCompatActivity {

    Button btnIngresarr;
    Button btnRegistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.btnIngresarr = (Button) findViewById(R.id.btnIngresar);
        this.btnRegistrar = (Button)  findViewById(R.id.btnRegistrarse);

        Intent intent = new Intent(this, Principal.class);

        btnIngresarr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        Intent intentRegis = new Intent(this, RegistroUsuario.class);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentRegis);
            }
        });


    }
}