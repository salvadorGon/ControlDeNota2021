package com.example.controldenotas.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "AlumnoMateria")
public class AlumnoMateria implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int idAlumnoMateria;

    int IdAlumno;
    int idMateria;

    public AlumnoMateria() {
    }

    public AlumnoMateria(int idAlumnoMateria, int idAlumno, int idMateria) {
        this.idAlumnoMateria = idAlumnoMateria;
        this.IdAlumno = idAlumno;
        this.idMateria = idMateria;
    }

    public int getIdAlumnoMateria() {
        return idAlumnoMateria;
    }

    public void setIdAlumnoMateria(int idAlumnoMateria) {
        this.idAlumnoMateria = idAlumnoMateria;
    }

    public int getIdAlumno() {
        return IdAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        IdAlumno = idAlumno;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }
}
