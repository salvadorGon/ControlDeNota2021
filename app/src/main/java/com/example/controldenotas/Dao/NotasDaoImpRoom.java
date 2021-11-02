package com.example.controldenotas.Dao;

import android.content.Context;

import androidx.room.Room;

import com.example.controldenotas.Data.DataBaseRoomNotas;
import com.example.controldenotas.Models.Notas;

import java.util.List;

public class NotasDaoImpRoom implements NotasDao{
    DataBaseRoomNotas db;

    NotasDao dao;

    public NotasDaoImpRoom(Context context){
        db= Room.databaseBuilder(context, DataBaseRoomNotas.class,"db")
                .allowMainThreadQueries().build();
        dao= db.Notasdao();
    }

    @Override
    public List<Notas> getAll() {
        return dao.getAll();
    }

    @Override
    public Notas get(int id) {
        return dao.get(id);
    }

    @Override
    public void save(Notas entity) {
        dao.save(entity);
    }

    @Override
    public void delete(Notas entity) {
        dao.delete(entity);
    }

    @Override
    public void update(Notas entity) {
        dao.update(entity);
    }
}
