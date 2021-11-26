package com.example.controldenotas.DataView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.controldenotas.Dao.DocenteDao;
import com.example.controldenotas.Dao.UsuarioDao;
import com.example.controldenotas.DaoImp.DocenteDaoImpRoom;
import com.example.controldenotas.DaoImp.UsuarioDaoImpRoom;
import com.example.controldenotas.Login;
import com.example.controldenotas.Models.Docente;
import com.example.controldenotas.Models.Usuario;
import com.example.controldenotas.R;

public class RegistroUsuario extends AppCompatActivity {

    Button btnGuardarUsuario;

    EditText txtNombre;
    EditText txtApellido;
    EditText txtTelefono;
    EditText txtDui;
    EditText txtClaveUsuario;

    TextView tvUsuario;

    DocenteDao daoDocente;


    UsuarioDao daoUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        txtNombre = (EditText) findViewById(R.id.txtNombreDocente);
        txtApellido = (EditText) findViewById(R.id.txtApellidoDocente);
        txtTelefono = (EditText) findViewById(R.id.txtTelefonoDocente);
        txtDui = (EditText) findViewById(R.id.txtDuiDocente);
        txtClaveUsuario = (EditText) findViewById(R.id.txtClaveUsuario);
        tvUsuario = (TextView) findViewById(R.id.tvUsuarioDocente);

        btnGuardarUsuario = (Button) findViewById(R.id.btnGuardarUsuario);

        Intent intent = new Intent(this, Login.class);

        btnGuardarUsuario.setOnClickListener(v->{
            GuardarUsuario();
            startActivity(intent);
        });


    }

    public int GuardarUsuario(){
        Usuario nuevoUsuario = new Usuario();
        Docente nuevoDocente = new Docente();
        nuevoDocente.setNombre(txtNombre.toString());
        nuevoDocente.setApellido(txtApellido.toString());
        nuevoDocente.setTelefono(txtTelefono.toString());
        nuevoDocente.setDui(txtDui.toString());

        daoDocente = new DocenteDaoImpRoom(getApplicationContext());
        daoDocente.save(nuevoDocente);

        int id = daoDocente.getMaxIdDocente();


        nuevoUsuario.setUsuario(txtDui.toString());
        nuevoUsuario.setClave(txtClaveUsuario.toString());
        nuevoUsuario.setIdDocente(id);

        
        daoUsuario = new UsuarioDaoImpRoom(getApplicationContext());
        daoUsuario.save(nuevoUsuario);

        return 0;
    }

}