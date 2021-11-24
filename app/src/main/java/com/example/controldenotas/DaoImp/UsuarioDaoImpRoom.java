package com.example.controldenotas.DaoImp;


import android.content.Context;

import androidx.room.Room;

import com.example.controldenotas.Dao.UsuarioDao;
import com.example.controldenotas.Data.DataBaseRoom;
import com.example.controldenotas.Models.Usuario;

import java.util.List;

public class UsuarioDaoImpRoom implements UsuarioDao{
    DataBaseRoom db;
    UsuarioDao dao;

    public UsuarioDaoImpRoom(Context context){
        this.db = Room.databaseBuilder(context, DataBaseRoom.class, "db").allowMainThreadQueries().build();
        this.dao = db.usuarioDao();
    }

    @Override
    public List<Usuario> getAll() {
        return dao.getAll();
    }

    @Override
    public Usuario get(int id) {
        return dao.get(id);
    }

    @Override
    public void save(Usuario entity) {
        dao.save(entity);
    }

    @Override
    public void delete(Usuario entity) {
        dao.delete(entity);
    }

    @Override
    public void update(Usuario entity) {
        dao.update(entity);
    }
}
