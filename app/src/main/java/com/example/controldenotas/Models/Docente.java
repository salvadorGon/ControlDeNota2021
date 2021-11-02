package com.example.controldenotas.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Docente")
public class Docente {
    @PrimaryKey(autoGenerate = true)
    private int idDocente;

    private String nombre;
    private String apellido;
    private String telefono;
    private String dui;

    public Docente() {
    }

    public Docente(int idDocente, String nombre, String apellido, String telefono, String dui) {
        this.idDocente = idDocente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.dui = dui;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }
}
