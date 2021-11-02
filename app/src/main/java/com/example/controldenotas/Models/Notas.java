package com.example.controldenotas.Models;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Notas")
public class Notas {
    @PrimaryKey(autoGenerate = true)
    private int idNota;

    private double nota;
    private int alumno;
    private int materia;

    public Notas() {
    }

    public Notas(int idNota, double nota, int alumno, int materia) {
        this.idNota = idNota;
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
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

    public int getAlumno() {
        return alumno;
    }

    public void setAlumno(int alumno) {
        this.alumno = alumno;
    }

    public int getMateria() {
        return materia;
    }

    public void setMateria(int materia) {
        this.materia = materia;
    }
}
