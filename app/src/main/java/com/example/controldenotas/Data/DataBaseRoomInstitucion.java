package com.example.controldenotas.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.controldenotas.Dao.InstitucionDao;
import com.example.controldenotas.Models.Institucion;

@Database(entities = {Institucion.class}, version = 1)
public abstract class DataBaseRoomInstitucion extends RoomDatabase {
    public abstract InstitucionDao Instituciondao();
}