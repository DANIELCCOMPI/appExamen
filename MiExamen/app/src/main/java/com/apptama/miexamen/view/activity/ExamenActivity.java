package com.apptama.miexamen.view.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.apptama.miexamen.R;
import com.apptama.miexamen.datos.DatabaseOpenHelper;
import com.apptama.miexamen.datos.entity.Examen;
import com.apptama.miexamen.view.adapter.MiAdapterListView;
import com.apptama.miexamen.view.util.Constantes;

import java.util.ArrayList;
import java.util.List;

public class ExamenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen_curso);

        Bundle bundle = this.getIntent().getExtras();
        Integer idCurso =  bundle.getInt("IdCurso");
        String nombre = bundle.getString("Nombre");

        SpannableString titulo = new SpannableString(nombre);
        titulo.setSpan(new UnderlineSpan(), 0, titulo.length(), 0);

        TextView txtTitulo = (TextView) findViewById(R.id.txtTitulo);
        txtTitulo.setText(titulo);

        ListView lstExamen = (ListView)findViewById(R.id.lstExamen);

        List<Examen> examenList = new ArrayList<>();

        DatabaseOpenHelper conn = new DatabaseOpenHelper(this, Constantes.nameBD,null,Constantes.versionBD);

        SQLiteDatabase db = conn.getWritableDatabase();
        String sql = "SELECT  idCurso,nroPregunta,pregunta,Rspta1,isRspta1,Rspta2,isRspta2,Rspta3,isRspta3,Rspta4,isRspta4  FROM EXAMENES WHERE  idCurso="+ idCurso +"  order by  nroPregunta asc ";
        Log.d("sql", sql);
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {

            Examen examen = new Examen();
            examen.setIdCurso(cursor.getInt(0));
            examen.setNroPregunta(cursor.getInt(1));
            examen.setPregunta(cursor.getString(2));
            examen.setRspta1(cursor.getString(3));
            examen.setIsRspta1(cursor.getInt(4) == 1);
            examen.setRspta2(cursor.getString(5));
            examen.setIsRspta2(cursor.getInt(6) == 1);
            examen.setRspta3(cursor.getString(7));
            examen.setIsRspta3(cursor.getInt(8) == 1);
            examen.setRspta4(cursor.getString(9));
            examen.setIsRspta4(cursor.getInt(10) == 1);

            examenList.add(examen);
        }
        cursor.close();





        MiAdapterListView  miAdapterListView = new MiAdapterListView(this, R.layout.list_tem, examenList);
        lstExamen.setAdapter(miAdapterListView);


    }
}
