package com.example.controldenotas.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "AlumnoGrupo")
public class AlumnoGrupo implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int idAlumnoGrupo;

    int idAlumno;

    int idGrupo;

    public AlumnoGrupo(int idAlumnoGrupo, int idAlumno, int idGrupo) {
        this.idAlumnoGrupo = idAlumnoGrupo;
        this.idAlumno = idAlumno;
        this.idGrupo = idGrupo;
    }

    public AlumnoGrupo() {
    }

    public int getIdAlumnoGrupo() {
        return idAlumnoGrupo;
    }

    public void setIdAlumnoGrupo(int idAlumnoGrupo) {
        this.idAlumnoGrupo = idAlumnoGrupo;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }
}
