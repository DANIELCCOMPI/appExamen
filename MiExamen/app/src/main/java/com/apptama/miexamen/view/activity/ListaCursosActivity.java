package com.apptama.miexamen.view.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import com.apptama.miexamen.R;
import com.apptama.miexamen.datos.DatabaseOpenHelper;
import com.apptama.miexamen.datos.entity.Curso;
import com.apptama.miexamen.view.adapter.MiAdapterGridView;
import com.apptama.miexamen.view.util.Constantes;

import java.util.ArrayList;
import java.util.List;

public class ListaCursosActivity extends AppCompatActivity {

    GridView grvCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cursos);

        grvCursos = (GridView) findViewById(R.id.grvCursos);

        List<Curso> cursoList = new ArrayList<>();

        DatabaseOpenHelper conn = new DatabaseOpenHelper(this, Constantes.nameBD,null,Constantes.versionBD);

        SQLiteDatabase db = conn.getWritableDatabase();
        String sql = "SELECT  idCurso,nombre,color  FROM CURSOS    order by  idCurso asc ";
        Log.d("sql", sql);
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {

            Curso curso = new Curso();
            curso.setIdCurso(cursor.getInt(0));
            curso.setNombre(cursor.getString(1));
            curso.setColor(cursor.getString(2));
            cursoList.add(curso);
        }
        cursor.close();





        MiAdapterGridView miAdapterGridView = new MiAdapterGridView(this, R.layout.grid_item, cursoList);
        grvCursos.setAdapter(miAdapterGridView);

    }
}
