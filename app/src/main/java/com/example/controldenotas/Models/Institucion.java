package com.example.controldenotas.Models;

public class Institucion {
    private int idInstitucion;
    private String nombre;
    private String codigo;
    private String telefono;
    private Docente docente;

    public Institucion() {
    }

    public Institucion(int idInstitucion, String nombre, String codigo, String telefono, Docente docente) {
        this.idInstitucion = idInstitucion;
        this.nombre = nombre;
        this.codigo = codigo;
        this.telefono = telefono;
        this.docente = docente;
    }

    public int getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(int idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
}
