package com.example.controldenotas.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.controldenotas.Models.Institucion;

import java.util.List;

@Dao
public interface InstitucionDao {
    @Query("SELECT * FROM Institucion")
    public List<Institucion> getAll();

    @Query("SELECT nombre FROM Institucion")
    public List<String> getNombreInstitucion();

    @Query("SELECT * FROM Institucion WHERE idInstitucion = :id")
    public Institucion get(int id);

    @Insert
    public void save(Institucion entity);

    @Delete
    public void delete(Institucion entity);

    @Update
    public void update(Institucion entity);
}
