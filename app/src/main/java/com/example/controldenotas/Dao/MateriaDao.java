package com.example.controldenotas.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.controldenotas.Models.Materia;

import java.util.List;

@Dao
public interface MateriaDao {
    @Query("SELECT * FROM Materia")
    public List<Materia> getAll();

    @Query("SELECT nombre FROM Materia")
    public List<String> getNombreMateria();

    @Query("SELECT * FROM Materia WHERE idMateria = :id")
    public Materia get(int id);

    @Insert
    public void save(Materia entity);

    @Delete
    public void delete(Materia entity);

    @Update
    public void update(Materia entity);
}
