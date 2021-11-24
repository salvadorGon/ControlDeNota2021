package com.example.controldenotas.Models;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Materia")
public class Materia implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int idMateria;

    String nombre;
    String descripcion;

    public Materia(int idMateria, String nombre, String descripcion) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Materia() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
