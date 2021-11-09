package com.example.controldenotas.Models;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Nota")
public class Nota implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int idNota;

    double nota;
    int idActividad;

    public Nota() {
    }

    public Nota(int idNota, double nota, int idActividad) {
        this.idNota = idNota;
        this.nota = nota;
        this.idActividad = idActividad;
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

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }
}
