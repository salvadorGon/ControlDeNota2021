package com.example.controldenotas.Models;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Institucion")
public class Institucion {
    @PrimaryKey(autoGenerate = true)
    private int idInstitucion;

    private String nombre;
    private String codigo;
    private String telefono;
    private int docente;

    public Institucion() {
    }

    public Institucion(int idInstitucion, String nombre, String codigo, String telefono, int docente) {
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

    public int getDocente() {
        return docente;
    }

    public void setDocente(int docente) {
        this.docente = docente;
    }
}
