package com.example.controldenotas.Dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.controldenotas.Models.InstitucionMateria;

import java.util.List;

@Dao
public interface InstitucionMateriaDao {
    @Query("SELECT * FROM InstitucionMateria")
    public List<InstitucionMateria> getAll();

    @Query("SELECT * FROM InstitucionMateria WHERE idInstitucionMateria = :id")
    public InstitucionMateria get(int id);

    @Insert
    public void save(InstitucionMateria entity);

    @Delete
    public void delete(InstitucionMateria entity);

    @Update
    public void update(InstitucionMateria entity);
}
