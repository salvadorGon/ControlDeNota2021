package com.example.controldenotas.Models;

public class ActividadMateria {
    private int idActividadMateria;
    private Actividad actividad;
    private Materia materia;

    public ActividadMateria() {
    }

    public ActividadMateria(int idActividadMateria, Actividad actividad, Materia materia) {
        this.idActividadMateria = idActividadMateria;
        this.actividad = actividad;
        this.materia = materia;
    }

    public int getIdActividadMateria() {
        return idActividadMateria;
    }

    public void setIdActividadMateria(int idActividadMateria) {
        this.idActividadMateria = idActividadMateria;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
