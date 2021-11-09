package com.example.controldenotas.Models;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Institucion")
public class Institucion implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int idInstitucion;

    String nombre;
    String telefono;
    int idDocente;

    public Institucion() {
    }

    public Institucion(int idInstitucion, String nombre, String telefono, int docente) {
        this.idInstitucion = idInstitucion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.idDocente = docente;
    }

    public int getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(int idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }
}
