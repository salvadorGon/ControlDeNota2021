package com.example.controldenotas.Dao;

import android.content.Context;

import androidx.room.Room;

import com.example.controldenotas.Data.DataBaseRoomActividad;
import com.example.controldenotas.Data.DataBaseRoomAlumno;
import com.example.controldenotas.Models.Actividad;

import java.util.List;

public class ActividadDaoImpRoom implements ActividadDao{
    DataBaseRoomActividad db;

    ActividadDao dao;

    public ActividadDaoImpRoom(Context context){
        db= Room.databaseBuilder(context, DataBaseRoomActividad.class,"db")
                .allowMainThreadQueries().build();
        dao= db.Actividaddao();
    }

    @Override
    public List<Actividad> getAll() {
        return dao.getAll();
    }

    @Override
    public Actividad get(int id) {
        return dao.get(id);
    }

    @Override
    public void save(Actividad entity) {
        dao.save(entity);
    }

    @Override
    public void delete(Actividad entity) {
        dao.delete(entity);
    }

    @Override
    public void update(Actividad entity) {
        dao.update(entity);
    }
}
