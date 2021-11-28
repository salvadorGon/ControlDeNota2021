package com.example.controldenotas.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "ActividadMateriaGrupo")
public class ActividadMateriaGrupo implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int idActividadMateriaGrupo;

    public int idActividad;
    public int idMateria;
    public int idGrupo;

    public ActividadMateriaGrupo() {
    }

    public ActividadMateriaGrupo(int idActividadMateriaGrupo, int idActividad, int idMateria, int idGrupo) {
        this.idActividadMateriaGrupo = idActividadMateriaGrupo;
        this.idActividad = idActividad;
        this.idMateria = idMateria;
        this.idGrupo = idGrupo;
    }
    public int getIdActividadMateriaGrupo() {
        return idActividadMateriaGrupo;
    }

    public void setIdActividadMateriaGrupo(int idActividadMateriaGrupo) {
        this.idActividadMateriaGrupo = idActividadMateriaGrupo;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }
}
