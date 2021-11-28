package com.example.controldenotas.DaoImp;

import android.content.Context;

import androidx.room.Room;

import com.example.controldenotas.Dao.ActividadMateriaGrupoDao;
import com.example.controldenotas.Data.DataBaseRoom;
import com.example.controldenotas.Models.ActividadMateriaGrupo;
import com.example.controldenotas.Models.AlumnoNotaMateria;

import java.util.List;

public class ActividadMateriaGrupoDaoImpRoom implements ActividadMateriaGrupoDao {
    DataBaseRoom db;
    ActividadMateriaGrupoDao dao;
    public ActividadMateriaGrupoDaoImpRoom(Context context){
        this.db = Room.databaseBuilder(context, DataBaseRoom.class, "db").allowMainThreadQueries().build();
        this.dao = db.actividadMateriaGrupoDao();
    }
    @Override
    public List<ActividadMateriaGrupo> getAll() {
        return dao.getAll();
    }

    @Override
    public ActividadMateriaGrupo get(int id) {
        return dao.get(id);
    }

    @Override
    public int get(int id, int id2, int id3) {
        return dao.get(id, id2, id3);
    }

    @Override
    public void save(ActividadMateriaGrupo entity) {
        dao.save(entity);
    }

    @Override
    public void delete(ActividadMateriaGrupo entity) {
        dao.delete(entity);
    }

    @Override
    public void update(ActividadMateriaGrupo entity) {
        dao.update(entity);
    }
}
