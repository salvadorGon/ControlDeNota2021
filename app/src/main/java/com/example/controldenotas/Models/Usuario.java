package com.example.controldenotas.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Usuario")
public class Usuario implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int idUsuario;

    String usuario;
    String clave;
    int idDocente;

    public Usuario() {
    }

    public Usuario(int idUsuario, String usuario, String clave, int idDocente) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.clave = clave;
        this.idDocente = idDocente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }
}
