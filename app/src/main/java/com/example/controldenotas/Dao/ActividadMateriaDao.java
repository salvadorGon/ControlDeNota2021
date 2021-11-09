package com.example.controldenotas.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.controldenotas.Models.ActividadMateria;

import java.util.List;

@Dao
public interface ActividadMateriaDao {
    @Query("SELECT * FROM ActividadMateria")
    public List<ActividadMateria> getAll();

    @Query("SELECT * FROM ActividadMateria WHERE idActividadMateria = :id")
    public ActividadMateria get(int id);

    @Insert
    public void save(ActividadMateria entity);

    @Delete
    public void delete(ActividadMateria entity);

    @Update
    public void update(ActividadMateria entity);
}
