package com.example.controldenotas.Models;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Materia")
public class Materia implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int idMateria;

    String nombre;
    String seccion;
    int año;

    public Materia() {
    }

    public Materia(int idMateria, String nombre, String seccion, int año) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.seccion = seccion;
        this.año = año;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
}
