package com.example.controldenotas.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "AlumnoNotaMateria")
public class AlumnoNotaMateria implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int idAlumnoNotaMateria;

    public int idAlumno;
    int idNota;
    int idMateria;

    public AlumnoNotaMateria() {
    }

    public AlumnoNotaMateria(int idAlumnoNotaMateria, int idAlumno, int idNota, int idMateria) {
        this.idAlumnoNotaMateria = idAlumnoNotaMateria;
        this.idAlumno = idAlumno;
        this.idNota = idNota;
        this.idMateria = idMateria;
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

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }
}
