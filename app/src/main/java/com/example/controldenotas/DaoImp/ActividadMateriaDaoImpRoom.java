package com.example.controldenotas.DaoImp;

import android.content.Context;

import androidx.room.Room;

import com.example.controldenotas.Dao.ActividadMateriaDao;
import com.example.controldenotas.Data.DataBaseRoom;
import com.example.controldenotas.Models.ActividadMateria;

import java.util.List;

public class ActividadMateriaDaoImpRoom implements ActividadMateriaDao {

    DataBaseRoom db;
    ActividadMateriaDao dao;

    public ActividadMateriaDaoImpRoom(Context context){
        db = Room.databaseBuilder(context, DataBaseRoom.class, "db").allowMainThreadQueries().build();
        dao = db.actividadMateriaDao();
    }

    @Override
    public List<ActividadMateria> getAll() {
        return dao.getAll();
    }

    @Override
    public ActividadMateria get(int id) {
        return dao.get(id);
    }

    @Override
    public void save(ActividadMateria entity) {
        dao.save(entity);
    }

    @Override
    public void delete(ActividadMateria entity) {
        dao.delete(entity);
    }

    @Override
    public void update(ActividadMateria entity) {
        dao.update(entity);
    }
}
