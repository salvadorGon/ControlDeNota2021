package com.example.controldenotas.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.controldenotas.Models.AlumnoNotaMateria;

import java.util.List;

@Dao
public interface AlumnoNotaMateriaDao {
    @Query("SELECT * FROM AlumnoNotaMateria")
    public List<AlumnoNotaMateria> getAll();

    @Query("SELECT * FROM AlumnoNotaMateria WHERE idAlumnoNotaMateria = :id")
    public AlumnoNotaMateria get(int id);

    @Insert
    public void save(AlumnoNotaMateria entity);

    @Delete
    public void delete(AlumnoNotaMateria entity);

    @Update
    public void update(AlumnoNotaMateria entity);
}
