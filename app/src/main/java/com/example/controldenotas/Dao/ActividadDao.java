package com.example.controldenotas.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.controldenotas.Models.Actividad;

import java.util.List;

@Dao
public interface ActividadDao {
    @Query("select * from Actividad")
    public List<Actividad> getAll();

    @Query("select * from Actividad where idActividad = :id")
    public Actividad get(int id);

    @Insert
    public void save(Actividad entity);

    @Delete
    public void delete(Actividad entity);

    @Update
    public void update(Actividad entity);
}
