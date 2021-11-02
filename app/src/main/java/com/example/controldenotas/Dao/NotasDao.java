package com.example.controldenotas.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.controldenotas.Models.Notas;

import java.util.List;

@Dao
public interface NotasDao {
    @Query("select * from Notas")
    public List<Notas> getAll();

    @Query("select * from Notas where idNota = :id")
    public Notas get(int id);

    @Insert
    public void save(Notas entity);

    @Delete
    public void delete(Notas entity);

    @Update
    public void update(Notas entity);
}
