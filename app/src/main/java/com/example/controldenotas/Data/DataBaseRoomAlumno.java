package com.example.controldenotas.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.controldenotas.Dao.AlumnoDao;
import com.example.controldenotas.Models.Alumno;

@Database(entities = {Alumno.class}, version = 1)
public abstract class DataBaseRoomAlumno extends RoomDatabase {
    public abstract AlumnoDao Alumnodao();
}