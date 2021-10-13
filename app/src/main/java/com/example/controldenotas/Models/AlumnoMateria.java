package com.example.controldenotas.Models;

public class AlumnoMateria {
    private int idAlumnoMateria;
    private Alumno alumno;
    private Materia materia;

    public AlumnoMateria() {
    }

    public AlumnoMateria(int idAlumnoMateria, Alumno alumno, Materia materia) {
        this.idAlumnoMateria = idAlumnoMateria;
        this.alumno = alumno;
        this.materia = materia;
    }

    public int getIdAlumnoMateria() {
        return idAlumnoMateria;
    }

    public void setIdAlumnoMateria(int idAlumnoMateria) {
        this.idAlumnoMateria = idAlumnoMateria;
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
