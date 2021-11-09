package com.example.controldenotas.DaoImp;

import android.content.Context;

import androidx.room.Room;

import com.example.controldenotas.Dao.MateriaDao;
import com.example.controldenotas.Data.DataBaseRoom;
import com.example.controldenotas.Models.Materia;

import java.util.List;

public class MateriaDaoImpRoom implements MateriaDao {

    DataBaseRoom db;
    MateriaDao dao;

    public MateriaDaoImpRoom(Context context){
        this.db = Room.databaseBuilder(context, DataBaseRoom.class, "db").allowMainThreadQueries().build();
        this.dao = db.materiaDao();
    }

    @Override
    public List<Materia> getAll() {
        return dao.getAll();
    }

    @Override
    public Materia get(int id) {
        return dao.get(id);
    }

    @Override
    public void save(Materia entity) {
        dao.save(entity);
    }

    @Override
    public void delete(Materia entity) {
        dao.delete(entity);
    }

    @Override
    public void update(Materia entity) {
        dao.update(entity);
    }
}
