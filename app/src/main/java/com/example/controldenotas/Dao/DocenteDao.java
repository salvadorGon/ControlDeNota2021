package com.example.controldenotas.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.controldenotas.Models.Docente;

import java.util.List;

@Dao
public interface DocenteDao {
    @Query("SELECT * FROM Docente")
    public List<Docente> getAll();

    @Query("SELECT * FROM Docente WHERE idDocente = :id")
    public Docente get(int id);

    @Insert
    public void save(Docente entity);

    @Delete
    public void delete(Docente entity);

    @Update
    public void update(Docente entity);
}
