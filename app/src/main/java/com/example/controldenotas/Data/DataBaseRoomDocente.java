package com.example.controldenotas.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.controldenotas.Dao.DocenteDao;
import com.example.controldenotas.Models.Docente;

    @Database(entities = {Docente.class}, version = 1)
    public abstract class DataBaseRoomDocente extends RoomDatabase {
        public abstract DocenteDao Docentedao();
    }