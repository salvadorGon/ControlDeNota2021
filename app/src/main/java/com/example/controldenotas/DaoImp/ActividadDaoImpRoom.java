package com.example.controldenotas.DaoImp;

import android.content.Context;

import androidx.room.Room;

import com.example.controldenotas.Dao.ActividadDao;
import com.example.controldenotas.Data.DataBaseRoom;
import com.example.controldenotas.Models.Actividad;

import java.util.List;

public class ActividadDaoImpRoom implements ActividadDao {

    DataBaseRoom db;
    ActividadDao dao;

    public ActividadDaoImpRoom(Context context){
        db = Room.databaseBuilder(context, DataBaseRoom.class, "db").allowMainThreadQueries().build();
        dao = db.actividadDao();
    }
    @Override
    public List<Actividad> getAll() {
        return dao.getAll();
    }

    @Override
    public List<String> getNombreActividad() {
        return dao.getNombreActividad();
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
