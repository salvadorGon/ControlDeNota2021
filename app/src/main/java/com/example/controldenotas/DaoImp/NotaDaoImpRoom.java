package com.example.controldenotas.DaoImp;

import android.content.Context;

import androidx.room.Room;

import com.example.controldenotas.Dao.NotaDao;
import com.example.controldenotas.Data.DataBaseRoom;
import com.example.controldenotas.Models.Nota;

import java.util.List;

public class NotaDaoImpRoom implements NotaDao {

    DataBaseRoom db;
    NotaDao dao;

    public NotaDaoImpRoom(Context context){
        this.db = Room.databaseBuilder(context, DataBaseRoom.class, "db").allowMainThreadQueries().build();
        this.dao = db.notaDao();
    }

    @Override
    public List<Nota> getAll() {
        return dao.getAll();
    }

    @Override
    public Nota get(int id) {
        return dao.get(id);
    }

    @Override
    public void save(Nota entity) {
        dao.save(entity);
    }

    @Override
    public void delete(Nota entity) {
        dao.delete(entity);
    }

    @Override
    public void update(Nota entity) {
        dao.update(entity);
    }
}
