package com.example.controldenotas.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.controldenotas.Models.Alumno;

import java.util.List;

@Dao
public interface AlumnoDao {
    @Query("select * from Alumno")
    public List<Alumno> getAll();

    @Query("select * from Alumno where idAlumno = :id")
    public Alumno get(int id);

    @Insert
    public void save(Alumno entity);

    @Delete
    public void delete(Alumno entity);

    @Update
    public void update(Alumno entity);
}
