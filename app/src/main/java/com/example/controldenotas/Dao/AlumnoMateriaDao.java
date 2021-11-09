package com.example.controldenotas.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.controldenotas.Models.AlumnoMateria;

import java.util.List;

@Dao
public interface AlumnoMateriaDao {
    @Query("SELECT * FROM AlumnoMateria")
    public List<AlumnoMateria> getAll();

    @Query("SELECT * FROM AlumnoMateria WHERE idAlumnoMateria = :id")
    public AlumnoMateria get(int id);

    @Insert
    public void save(AlumnoMateria entity);

    @Delete
    public void delete(AlumnoMateria entity);

    @Update
    public void update(AlumnoMateria entity);
}
