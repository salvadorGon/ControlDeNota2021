package com.example.controldenotas.Dao;

import android.content.Intent;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.controldenotas.Models.Nota;

import java.util.List;

@Dao
public interface NotaDao {
    @Query("SELECT * FROM Nota")
    public List<Nota> getAll();

    @Query("SELECT * FROM Nota WHERE idActividadMateriaGrupo = :id")
    public List<Nota> get(int id);

    @Query("SELECT idNota FROM Nota WHERE idActividadMateriaGrupo = :id")
    public int geti(int id);

    @Insert
    public void save(Nota entity);

    @Delete
    public void delete(Nota entity);

    @Update
    public void update(Nota entity);
}
