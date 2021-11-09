package com.example.controldenotas.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "ActividadMateria")
public class ActividadMateria implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int idActividadMateria;

    int idActividad;
    int IdMateria;

    public ActividadMateria() {
    }

    public ActividadMateria(int idActividadMateria, int idActividad, int idMateria) {
        this.idActividadMateria = idActividadMateria;
        this.idActividad = idActividad;
        IdMateria = idMateria;
    }

    public int getIdActividadMateria() {
        return idActividadMateria;
    }

    public void setIdActividadMateria(int idActividadMateria) {
        this.idActividadMateria = idActividadMateria;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public int getIdMateria() {
        return IdMateria;
    }

    public void setIdMateria(int idMateria) {
        IdMateria = idMateria;
    }
}
