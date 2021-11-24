package com.example.controldenotas.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.controldenotas.Models.Grupo;

import java.util.List;

@Dao
public interface GrupoDao {

    @Query("SELECT * FROM Grupo")
    public List<Grupo> getAll();

    @Query("SELECT * FROM Grupo WHERE idGrupo = :id")
    public Grupo get(int id);

    @Insert
    public void save(Grupo entity);

    @Delete
    public void delete(Grupo entity);

    @Update
    public void update(Grupo entity);
}
