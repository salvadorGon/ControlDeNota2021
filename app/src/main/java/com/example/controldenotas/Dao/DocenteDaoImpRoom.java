package com.example.controldenotas.Dao;

import android.content.Context;

import androidx.room.Room;

import com.example.controldenotas.Data.DataBaseRoomDocente;
import com.example.controldenotas.Models.Docente;

import java.util.List;

public class DocenteDaoImpRoom implements DocenteDao{
    DataBaseRoomDocente db;

    DocenteDao dao;

    public DocenteDaoImpRoom(Context context){
        db= Room.databaseBuilder(context, DataBaseRoomDocente.class,"db")
                .allowMainThreadQueries().build();
        dao= db.Docentedao();
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
}
