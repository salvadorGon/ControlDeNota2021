package com.example.controldenotas.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.controldenotas.Dao.ActividadDao;
import com.example.controldenotas.Models.Actividad;

@Database(entities = {Actividad.class}, version = 1)
public abstract class DataBaseRoomActividad extends RoomDatabase {
    public abstract ActividadDao Actividaddao();
}