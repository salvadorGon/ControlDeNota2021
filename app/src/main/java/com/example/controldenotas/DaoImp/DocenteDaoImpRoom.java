package com.example.controldenotas.DaoImp;

import android.content.Context;

import androidx.room.Room;

import com.example.controldenotas.Dao.DocenteDao;
import com.example.controldenotas.Data.DataBaseRoom;
import com.example.controldenotas.Models.Docente;

import java.util.List;

public class DocenteDaoImpRoom implements DocenteDao {

    DataBaseRoom db;
    DocenteDao dao;

    public DocenteDaoImpRoom(Context context){
        this.db = Room.databaseBuilder(context, DataBaseRoom.class, "db").allowMainThreadQueries().build();
        this.dao = db.docenteDao();
    }

    @Override
    public List<Docente> getAll() {
        return dao.getAll();
    }

    @Override
    public Docente get(int id) {
        return dao.get(id);
    }

    @Override
    public void save(Docente entity) {
        dao.save(entity);
    }

    @Override
    public void delete(Docente entity) {
        dao.delete(entity);
    }

    @Override
    public void update(Docente entity) {
        dao.update(entity);
    }

    @Override
    public int getMaxIdDocente() {
        return dao.getMaxIdDocente();
    }
}
