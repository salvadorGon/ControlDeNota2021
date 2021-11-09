package com.example.controldenotas.DaoImp;

import android.content.Context;

import androidx.room.Room;

import com.example.controldenotas.Dao.AlumnoMateriaDao;
import com.example.controldenotas.Data.DataBaseRoom;
import com.example.controldenotas.Models.AlumnoMateria;

import java.util.List;

public class AlumnoMateriaDaoImpRoom implements AlumnoMateriaDao {

    DataBaseRoom db;
    AlumnoMateriaDao dao;

    public AlumnoMateriaDaoImpRoom(Context context) {
        this.db = Room.databaseBuilder(context, DataBaseRoom.class, "db").allowMainThreadQueries().build();
        this.dao = db.alumnoMateriaDao();
    }

    @Override
    public List<AlumnoMateria> getAll() {
        return dao.getAll();
    }

    @Override
    public AlumnoMateria get(int id) {
        return dao.get(id);
    }

    @Override
    public void save(AlumnoMateria entity) {
        dao.save(entity);
    }

    @Override
    public void delete(AlumnoMateria entity) {
        dao.delete(entity);
    }

    @Override
    public void update(AlumnoMateria entity) {
        dao.update(entity);
    }

}
