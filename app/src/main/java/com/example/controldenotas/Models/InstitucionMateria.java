package com.example.controldenotas.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "InstitucionMateria")
public class InstitucionMateria implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int idInstitucionMateria;
    int idInstitucion;
    int idMateria;

    public InstitucionMateria() {
    }

    public InstitucionMateria(int idInstitucionMateria, int idInstitucion, int idMateria) {
        this.idInstitucionMateria = idInstitucionMateria;
        this.idInstitucion = idInstitucion;
        this.idMateria = idMateria;
    }

    public int getIdInstitucionMateria() {
        return idInstitucionMateria;
    }

    public void setIdInstitucionMateria(int idInstitucionMateria) {
        this.idInstitucionMateria = idInstitucionMateria;
    }

    public int getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(int idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }
}
