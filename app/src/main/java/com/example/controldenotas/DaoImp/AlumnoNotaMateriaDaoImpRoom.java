package com.example.controldenotas.DaoImp;

import android.content.Context;

import androidx.room.Room;

import com.example.controldenotas.Dao.AlumnoNotaMateriaDao;
import com.example.controldenotas.Data.DataBaseRoom;
import com.example.controldenotas.Models.AlumnoNotaMateria;

import java.util.List;

public class AlumnoNotaMateriaDaoImpRoom implements AlumnoNotaMateriaDao {
    DataBaseRoom db;
    AlumnoNotaMateriaDao dao;
    public AlumnoNotaMateriaDaoImpRoom(Context context){
        this.db = Room.databaseBuilder(context, DataBaseRoom.class, "db").allowMainThreadQueries().build();
        this.dao = db.alumnoNotaMateriaDao();
    }
    @Override
    public List<AlumnoNotaMateria> getAll() {
        return dao.getAll();
    }

    @Override
    public AlumnoNotaMateria get(int id) {
        return dao.get(id);
    }

    @Override
    public void save(AlumnoNotaMateria entity) {
        dao.save(entity);
    }

    @Override
    public void delete(AlumnoNotaMateria entity) {
        dao.delete(entity);
    }

    @Override
    public void update(AlumnoNotaMateria entity) {
        dao.update(entity);
    }
}
