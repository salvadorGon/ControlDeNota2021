package com.example.controldenotas.DaoImp;

import android.content.Context;

import androidx.room.Room;

import com.example.controldenotas.Dao.InstitucionMateriaDao;
import com.example.controldenotas.Data.DataBaseRoom;
import com.example.controldenotas.Models.InstitucionMateria;

import java.util.List;

public class InstitucionMateriaDaoImpRoom implements InstitucionMateriaDao {

    DataBaseRoom db;
    InstitucionMateriaDao dao;

    public InstitucionMateriaDaoImpRoom(Context context){
        this.db = Room.databaseBuilder(context, DataBaseRoom.class, "db").allowMainThreadQueries().build();
        this.dao = db.institucionMateriaDao();
    }

    @Override
    public List<InstitucionMateria> getAll() {
        return dao.getAll();
    }

    @Override
    public InstitucionMateria get(int id) {
        return dao.get(id);
    }

    @Override
    public void save(InstitucionMateria entity) {
        dao.save(entity);
    }

    @Override
    public void delete(InstitucionMateria entity) {
        dao.delete(entity);
    }

    @Override
    public void update(InstitucionMateria entity) {
        dao.update(entity);
    }
}
