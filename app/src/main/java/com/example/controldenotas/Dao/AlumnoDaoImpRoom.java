package com.example.controldenotas.Dao;

import android.content.Context;

import androidx.room.Room;

import com.example.controldenotas.Data.DataBaseRoomAlumno;
import com.example.controldenotas.Models.Alumno;

import java.util.List;

public class AlumnoDaoImpRoom implements AlumnoDao{
    DataBaseRoomAlumno db;

    AlumnoDao dao;

    public AlumnoDaoImpRoom(Context context){
        db= Room.databaseBuilder(context, DataBaseRoomAlumno.class,"db")
                .allowMainThreadQueries().build();
        dao= db.Alumnodao();
    }

    @Override
    public List<Alumno> getAll() {
        return dao.getAll();
    }

    @Override
    public Alumno get(int id) {
        return dao.get(id);
    }

    @Override
    public void save(Alumno entity) {
        dao.save(entity);
    }

    @Override
    public void delete(Alumno entity) {
        dao.delete(entity);
    }

    @Override
    public void update(Alumno entity) {
        dao.update(entity);
    }
}
