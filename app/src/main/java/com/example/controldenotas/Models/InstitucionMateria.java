package com.example.controldenotas.Models;

public class InstitucionMateria {
    private int idInstitucionMateria;
    private Institucion institucion;
    private Materia materia;

    public InstitucionMateria() {
    }

    public InstitucionMateria(int idInstitucionMateria, Institucion institucion, Materia materia) {
        this.idInstitucionMateria = idInstitucionMateria;
        this.institucion = institucion;
        this.materia = materia;
    }

    public int getIdInstitucionMateria() {
        return idInstitucionMateria;
    }

    public void setIdInstitucionMateria(int idInstitucionMateria) {
        this.idInstitucionMateria = idInstitucionMateria;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
