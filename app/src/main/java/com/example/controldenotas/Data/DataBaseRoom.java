package com.example.controldenotas.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.controldenotas.Dao.ActividadDao;
import com.example.controldenotas.Dao.ActividadMateriaDao;
import com.example.controldenotas.Dao.AlumnoDao;
import com.example.controldenotas.Dao.AlumnoMateriaDao;
import com.example.controldenotas.Dao.AlumnoNotaMateriaDao;
import com.example.controldenotas.Dao.DocenteDao;
import com.example.controldenotas.Dao.InstitucionDao;
import com.example.controldenotas.Dao.InstitucionMateriaDao;
import com.example.controldenotas.Dao.MateriaDao;
import com.example.controldenotas.Dao.NotaDao;
import com.example.controldenotas.Models.Actividad;
import com.example.controldenotas.Models.ActividadMateria;
import com.example.controldenotas.Models.Alumno;
import com.example.controldenotas.Models.AlumnoMateria;
import com.example.controldenotas.Models.AlumnoNotaMateria;
import com.example.controldenotas.Models.Docente;
import com.example.controldenotas.Models.Institucion;
import com.example.controldenotas.Models.InstitucionMateria;
import com.example.controldenotas.Models.Materia;
import com.example.controldenotas.Models.Nota;


@Database(entities = {Actividad.class, ActividadMateria.class, Alumno.class,
        AlumnoMateria.class, AlumnoNotaMateria.class, Docente.class, Institucion.class,
        InstitucionMateria.class, Materia.class, Nota.class}, version = 1)
public abstract class DataBaseRoom extends RoomDatabase {

    public abstract ActividadDao actividadDao();
    public abstract ActividadMateriaDao actividadMateriaDao();
    public abstract AlumnoDao alumnoDao();
    public abstract AlumnoMateriaDao alumnoMateriaDao();
    public abstract AlumnoNotaMateriaDao alumnoNotaMateriaDao();
    public abstract DocenteDao docenteDao();
    public abstract InstitucionDao institucionDao();
    public abstract InstitucionMateriaDao institucionMateriaDao();
    public abstract MateriaDao materiaDao();
    public abstract NotaDao notaDao();
}
