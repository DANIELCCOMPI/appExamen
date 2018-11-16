package com.apptama.miexamen.datos;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.net.FileNameMap;

/**
 * Created by jose_ on 16/11/2018.
 */

public class DatabaseOpenHelper extends SQLiteOpenHelper {


    final String CREATE_TABLA_CURSO = "CREATE TABLE CURSOS(idCurso INTEGER NOT NULL PRIMARY KEY,nombre TEXT,color  TEXT)";
    final String CREATE_TABLA_EXAMEN = "CREATE TABLE EXAMENES(idCurso INTEGER,nroPregunta INTEGER,pregunta TEXT,Rspta1 TEXT," +
            "isRspta1   INTEGER,Rspta2  TEXT,isRspta2  INTEGER,Rspta3  TEXT,isRspta3  INTEGER,Rspta4  TEXT,isRspta4 INTEGER)";


    public DatabaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLA_CURSO);
        db.execSQL(CREATE_TABLA_EXAMEN);

        db.execSQL("INSERT INTO CURSOS(idCurso,nombre,color) VALUES(1,'Literatura','#ffc30f')");
        db.execSQL("INSERT INTO CURSOS(idCurso,nombre,color) VALUES(2,'Matemática','#7c4dff')");
        db.execSQL("INSERT INTO CURSOS(idCurso,nombre,color) VALUES(3,'Filosofía','#00bfa5')");
        db.execSQL("INSERT INTO CURSOS(idCurso,nombre,color) VALUES(4,'Historia','#8c008c')");

        db.execSQL("INSERT INTO EXAMENES(idCurso,nroPregunta,pregunta,Rspta1,isRspta1,Rspta2,isRspta2,Rspta3,isRspta3,Rspta4,isRspta4)" +
                " VALUES(1,1,'¿Quién escribió \"Cien años de soledad\"?','Mario Vargas Llosa',0,'Gabriel García Marquez',1,'Carlos Fuentes',0,'Julio Cortázar',0)");

        db.execSQL("INSERT INTO EXAMENES(idCurso,nroPregunta,pregunta,Rspta1,isRspta1,Rspta2,isRspta2,Rspta3,isRspta3,Rspta4,isRspta4)" +
                " VALUES(1,2,'¿En que libro aparece la famosa frase \"ser o no ser, he ahí el dilema\"? ','Otello',0,'El rey lear',0,'Macbeth',0,'Hamlet',1)");

        db.execSQL("INSERT INTO EXAMENES(idCurso,nroPregunta,pregunta,Rspta1,isRspta1,Rspta2,isRspta2,Rspta3,isRspta3,Rspta4,isRspta4)" +
                " VALUES(1,3,'¿A qué cultura pertenece el Popol Vuh?','Tolteca',0,'Maya',1,'Azteca',0,'Olmeca',0)");


        db.execSQL("INSERT INTO EXAMENES(idCurso,nroPregunta,pregunta,Rspta1,isRspta1,Rspta2,isRspta2,Rspta3,isRspta3,Rspta4,isRspta4)" +
                " VALUES(1,4,'¿Cómo se llama el caballo del Quijote?','Rocinante',1,'Anselomo',0,'Crespo',0,'Babieca',0)");

        db.execSQL("INSERT INTO EXAMENES(idCurso,nroPregunta,pregunta,Rspta1,isRspta1,Rspta2,isRspta2,Rspta3,isRspta3,Rspta4,isRspta4)" +
                " VALUES(1,5,'¿Quién es el autor de Moby Dick?','Hernan Melville',1,'Charles Dickens',0,'Ernest Hemingway',0,'Herman Hesse',0)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS CURSOS");
        db.execSQL("DROP TABLE IF EXISTS EXAMENES");
        db.execSQL(CREATE_TABLA_CURSO);

    }


}
