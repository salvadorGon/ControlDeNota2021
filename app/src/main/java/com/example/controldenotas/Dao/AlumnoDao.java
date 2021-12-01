package com.example.controldenotas.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.controldenotas.Models.Alumno;
import com.example.controldenotas.Models.Nota;

import java.util.List;

@Dao
public interface AlumnoDao {
    @Query("SELECT * FROM Alumno")
    public List<Alumno> getAll();

    @Query("SELECT * FROM Alumno WHERE idAlumno = :id")
    public Alumno get(int id);

    //cargar una lista de alumnos que cumpla con las condiciones descritas
    @Query("SELECT a.*, n.* FROM Alumno a, Nota n, ActividadMateriaGrupo amg WHERE a.idAlumno= n.idAlumno AND n.idAlumno = :idAlumnoTablaNota AND n.idActividadMateriaGrupo = :idActividadMG")
    public List<Alumno> getListado(int idAlumnoTablaNota, int idActividadMG);

    @Insert
    public void save(Alumno entity);

    @Delete
    public void delete(Alumno entity);

    @Update
    public void update(Alumno entity);
}
