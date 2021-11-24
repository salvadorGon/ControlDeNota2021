package com.example.controldenotas.Dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.controldenotas.Models.Usuario;

import java.util.List;

@Dao
public interface UsuarioDao {
    @Query("SELECT * FROM Usuario")
    public List<Usuario> getAll();

    @Query("SELECT * FROM Usuario WHERE idUsuario = :id")
    public Usuario get(int id);

    @Insert
    public void save(Usuario entity);

    @Delete
    public void delete(Usuario entity);

    @Update
    public void update(Usuario entity);
}
