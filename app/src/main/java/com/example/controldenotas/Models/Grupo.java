package com.example.controldenotas.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Grupo")
public class Grupo implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int idGrupo;

    String nombre;

    int anio;
    int idMateria;

    public Grupo() {
    }

    public Grupo(int idGrupo, String nombre, int anio, int idMateria) {
        this.idGrupo = idGrupo;
        this.nombre = nombre;
        this.anio = anio;
        this.idMateria = idMateria;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }
}
