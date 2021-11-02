package com.example.controldenotas.Models;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Materia")
public class Materia {
    @PrimaryKey(autoGenerate = true)
    private int idMateria;

    private String nombre;

    public Materia() {
    }

    public Materia(int idMateria, String nombre) {
        this.idMateria = idMateria;
        this.nombre = nombre;
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
}
