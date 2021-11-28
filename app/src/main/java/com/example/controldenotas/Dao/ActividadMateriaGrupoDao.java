package com.example.controldenotas.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.controldenotas.Models.ActividadMateriaGrupo;

import java.util.List;

@Dao
public interface ActividadMateriaGrupoDao {
    @Query("SELECT * FROM ActividadMateriaGrupo")
    public List<ActividadMateriaGrupo> getAll();

    @Query("SELECT idActividadMateriaGrupo FROM ActividadMateriaGrupo WHERE idActividad = :id1 AND idMateria = :id2 AND idGrupo = :id3")
    public int get(int id1, int id2, int id3);

    @Query("SELECT * FROM ActividadMateriaGrupo WHERE idActividadMateriaGrupo = :id")
    public ActividadMateriaGrupo get(int id);

    @Insert
    public void save(ActividadMateriaGrupo entity);

    @Delete
    public void delete(ActividadMateriaGrupo entity);

    @Update
    public void update(ActividadMateriaGrupo entity);
}
