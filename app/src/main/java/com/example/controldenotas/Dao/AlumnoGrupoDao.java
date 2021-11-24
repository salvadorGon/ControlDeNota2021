package com.example.controldenotas.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.controldenotas.Models.AlumnoGrupo;

import java.util.List;

@Dao
public interface AlumnoGrupoDao {

    @Query("SELECT * FROM AlumnoGrupo")
    public List<AlumnoGrupo> getAll();

    @Query("SELECT * FROM AlumnoGrupo WHERE idAlumnoGrupo = :id")
    public AlumnoGrupo get(int id);

    @Insert
    public void save(AlumnoGrupo entity);

    @Update
    public void update(AlumnoGrupo entity);

    @Delete
    public void delete(AlumnoGrupo entity);

}
