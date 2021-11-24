package com.example.controldenotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.controldenotas.DataView.RegistroUsuario;

public class Login extends AppCompatActivity {

    Button btnIngreso;
    Button btnRegistrarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.btnIngreso = (Button) findViewById(R.id.btnIngresar);
        this.btnRegistrarUsuario = (Button)  findViewById(R.id.btnRegistrarse);

        Intent intent = new Intent(this, Principal.class);

        btnIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        Intent intent1 = new Intent(this, RegistroUsuario.class);

        btnRegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });
    }
}