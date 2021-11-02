package com.example.controldenotas.Dao;

import android.content.Context;

import androidx.room.Room;

import com.example.controldenotas.Data.DataBaseRoomInstitucion;
import com.example.controldenotas.Models.Institucion;

import java.util.List;

public class InstitucionDaoImpRoom implements InstitucionDao{
    DataBaseRoomInstitucion db;

    InstitucionDao dao;

    public InstitucionDaoImpRoom(Context context){
        db= Room.databaseBuilder(context, DataBaseRoomInstitucion.class,"db")
                .allowMainThreadQueries().build();
        dao= db.Instituciondao();
    }

    @Override
    public List<Institucion> getAll() {
        return dao.getAll();
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
