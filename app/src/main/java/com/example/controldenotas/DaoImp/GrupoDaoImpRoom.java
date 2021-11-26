package com.example.controldenotas.DaoImp;

import android.content.Context;

import androidx.room.Room;

import com.example.controldenotas.Dao.GrupoDao;
import com.example.controldenotas.Data.DataBaseRoom;
import com.example.controldenotas.Models.Grupo;

import java.util.List;

public class GrupoDaoImpRoom implements GrupoDao {

    DataBaseRoom db;
    GrupoDao dao;

    public GrupoDaoImpRoom(Context context){
        db = Room.databaseBuilder(context, DataBaseRoom.class, "db").allowMainThreadQueries().build();
        dao = db.grupoDao();
    }

    @Override
    public List<Grupo> getAll() {
        return dao.getAll();
    }

    @Override
    public List<String> getNombreGrupo() {
        return dao.getNombreGrupo();
    }

    @Override
    public Grupo get(int id) {
        return dao.get(id);
    }

    @Override
    public void save(Grupo entity) {
        dao.save(entity);
    }

    @Override
    public void delete(Grupo entity) {
        dao.delete(entity);
    }

    @Override
    public void update(Grupo entity) {
        dao.update(entity);
    }
}
