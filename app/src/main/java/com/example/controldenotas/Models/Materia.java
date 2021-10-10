package com.example.controldenotas.Models;
import java.util.ArrayList;

public class Materia {
    private int idMateria;
    private String nombre;
    private ArrayList<Actividad> actividades;
    private Docente docente;

    public Materia(){

    }

    public Materia(int idMateria, String nombre, Docente docente) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.docente = docente;
    }

    public Materia(int idMateria, String nombre, ArrayList<Actividad> actividades, Docente docente) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.actividades = actividades;
        this.docente = docente;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
}
