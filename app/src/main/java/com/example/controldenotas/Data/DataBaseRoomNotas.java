package com.example.controldenotas.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.controldenotas.Dao.NotasDao;
import com.example.controldenotas.Models.Notas;

@Database(entities = {Notas.class}, version = 1)
public abstract class DataBaseRoomNotas extends RoomDatabase {
    public abstract NotasDao Notasdao();
}