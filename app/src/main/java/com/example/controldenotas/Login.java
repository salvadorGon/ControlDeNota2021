package com.example.controldenotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.controldenotas.Dao.UsuarioDao;
import com.example.controldenotas.DaoImp.UsuarioDaoImpRoom;
import com.example.controldenotas.DataView.RegistroUsuario;
import com.example.controldenotas.Models.Usuario;

import java.util.List;

public class Login extends AppCompatActivity {

    UsuarioDao daoUsuario;
    List<Usuario> listaUsuario;


    Button btnIngresar;
    Button btnRegistrar;

    EditText txtUsuario;
    EditText txtClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.btnIngresar = (Button) findViewById(R.id.btnIngresar);
        this.btnRegistrar = (Button)  findViewById(R.id.btnRegistrarse);


        this.txtUsuario = (EditText) findViewById(R.id.editTextTextPersonName);
        this.txtClave = (EditText) findViewById(R.id.editTextTextPassword);

        Intent intent = new Intent(this, Principal.class);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validar()){
                    startActivity(intent);
                }
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

    boolean validar(){
        boolean fl = false;
        daoUsuario = new UsuarioDaoImpRoom(getApplicationContext());
        listaUsuario = daoUsuario.getAll();
        String usua = txtUsuario.getText().toString();
        String pass = txtClave.getText().toString();

        for (Usuario item : listaUsuario){
            if(item.getUsuario().equals(usua) && item.getClave().equals(pass)){

                fl = true;
            }
        }
        return fl;
    }
}