package com.example.controldenotas.Models;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Nota")
public class Nota implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int idNota;

    double nota;
    public int idAlumno;
    public int idActividadMateriaGrupo;

    public Nota() {
    }

    public Nota(int idNota, double nota, int idAlumno, int idActividadMateriaGrupo) {
        this.idNota = idNota;
        this.nota = nota;
        this.idAlumno = idAlumno;
        this.idActividadMateriaGrupo = idActividadMateriaGrupo;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdActividadMateriaGrupo() {
        return idActividadMateriaGrupo;
    }

    public void setIdActividadMateriaGrupo(int idActividadMateriaGrupo) {
        this.idActividadMateriaGrupo = idActividadMateriaGrupo;
    }
}
