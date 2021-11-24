package com.example.controldenotas.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "AlumnoNotaMateria")
public class AlumnoNotaMateria implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int idAlumnoNotaMateria;

    public int idAlumno;
    int idActividad;

    public AlumnoNotaMateria() {
    }

    public AlumnoNotaMateria(int idAlumnoNotaMateria, int idAlumno, int idActividad) {
        this.idAlumnoNotaMateria = idAlumnoNotaMateria;
        this.idAlumno = idAlumno;
        this.idActividad = idActividad;
    }

    public int getIdAlumnoNotaMateria() {
        return idAlumnoNotaMateria;
    }

    public void setIdAlumnoNotaMateria(int idAlumnoNotaMateria) {
        this.idAlumnoNotaMateria = idAlumnoNotaMateria;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }
}
