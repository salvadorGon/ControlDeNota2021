package com.example.controldenotas.Models;

public class Notas {
    private int idNota;
    private double nota;
    private Alumno alumno;
    private Materia materia;

    public Notas() {
    }

    public Notas(int idNota, double nota, Alumno alumno, Materia materia) {
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

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
