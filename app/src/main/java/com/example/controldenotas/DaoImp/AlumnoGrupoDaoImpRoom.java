package com.example.controldenotas.DaoImp;


import android.content.Context;

import androidx.room.Room;

import com.example.controldenotas.Dao.AlumnoGrupoDao;
import com.example.controldenotas.Data.DataBaseRoom;
import com.example.controldenotas.Models.AlumnoGrupo;

import java.util.List;

public class AlumnoGrupoDaoImpRoom implements AlumnoGrupoDao{
    DataBaseRoom db;
    AlumnoGrupoDao dao;

    public AlumnoGrupoDaoImpRoom(Context context){
        this.db = Room.databaseBuilder(context, DataBaseRoom.class, "db").allowMainThreadQueries().build();
        this.dao = db.alumnoGrupoDao();
    }

    @Override
    public List<AlumnoGrupo> getAll() {
        return dao.getAll();
    }

    @Override
    public AlumnoGrupo get(int id) {
        return dao.get(id);
    }

    @Override
    public void save(AlumnoGrupo entity) {
        dao.save(entity);
    }

    @Override
    public void update(AlumnoGrupo entity) {
        dao.update(entity);
    }

    @Override
    public void delete(AlumnoGrupo entity) {
        dao.delete(entity);
    }
}
