package com.example.controldenotas.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Alumno")
public class Alumno {
    @PrimaryKey(autoGenerate = true)
    private int idAlumno;

    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;

    public Alumno() {
    }

    public Alumno(int id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido) {
        this.idAlumno = id;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
}
