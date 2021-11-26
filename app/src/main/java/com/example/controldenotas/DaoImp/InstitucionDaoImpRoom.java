package com.example.controldenotas.DaoImp;

import android.content.Context;

import androidx.room.Room;

import com.example.controldenotas.Dao.InstitucionDao;
import com.example.controldenotas.Data.DataBaseRoom;
import com.example.controldenotas.Models.Institucion;

import java.util.List;

public class InstitucionDaoImpRoom implements InstitucionDao {

    DataBaseRoom db;
    InstitucionDao dao;

    public InstitucionDaoImpRoom(Context context){
        this.db = Room.databaseBuilder(context, DataBaseRoom.class, "db").allowMainThreadQueries().build();
        this.dao = db.institucionDao();
    }

    @Override
    public List<Institucion> getAll() {
        return dao.getAll();
    }

    @Override
    public List<String> getNombreInstitucion() {
        return dao.getNombreInstitucion();
    }

    @Override
    public Institucion get(int id) {
        return dao.get(id);
    }

    @Override
    public void save(Institucion entity) {
        dao.save(entity);
    }

    @Override
    public void delete(Institucion entity) {
        dao.delete(entity);
    }

    @Override
    public void update(Institucion entity) {
        dao.update(entity);
    }
}
