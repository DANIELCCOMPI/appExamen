package com.apptama.miexamen.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.apptama.miexamen.R;
import com.apptama.miexamen.datos.entity.Curso;
import com.apptama.miexamen.datos.entity.Examen;
import com.apptama.miexamen.view.activity.ExamenActivity;

import java.util.List;

/**
 * Created by jose_ on 16/11/2018.
 */

public class MiAdapterListView extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Examen> examenList;

    public MiAdapterListView(Context context, int layout, List<Examen> examenList) {
        this.context = context;
        this.layout = layout;
        this.examenList = examenList;
    }

    @Override
    public int getCount() {
        return this.examenList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.examenList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //copiamos la vista
        View v = convertView;

        //inflamos la vista que nos ha llegado con nuestro layout personalizado
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.list_tem, null);

        //nos traemos los valores actuales dependiente de la posicion
        String nroPregunta = examenList.get(position).getNroPregunta().toString();
        String pregunta = examenList.get(position).getPregunta();
        String rspta1 = examenList.get(position).getRspta1();
        Boolean isRspta1 = examenList.get(position).isRspta1();
        String rspta2 = examenList.get(position).getRspta2();
        Boolean isRspta2 = examenList.get(position).isRspta2();
        String rspta3 = examenList.get(position).getRspta3();
        Boolean isRspta3 = examenList.get(position).isRspta3();
        String rspta4 = examenList.get(position).getRspta4();
        Boolean isRspta4 = examenList.get(position).isRspta4();

        //referenciamos el elemento a modificar y lo rellenamos
        TextView txtNroPregunta = (TextView) v.findViewById(R.id.txtNro);
        txtNroPregunta.setText(nroPregunta);
        TextView txtPregunta = (TextView) v.findViewById(R.id.txtPregunta);
        txtPregunta.setText(pregunta);
        RadioButton rdbRspta1 = (RadioButton) v.findViewById(R.id.rdbRspta1);
        rdbRspta1.setText(rspta1);
        rdbRspta1.setChecked(false);
        RadioButton rdbRspta2 = (RadioButton) v.findViewById(R.id.rdbRspta2);
        rdbRspta2.setText(rspta2);
        rdbRspta2.setChecked(false);
        RadioButton rdbRspta3 = (RadioButton) v.findViewById(R.id.rdbRspta3);
        rdbRspta3.setText(rspta3);
        rdbRspta3.setChecked(false);
        RadioButton rdbRspta4 = (RadioButton) v.findViewById(R.id.rdbRspta4);
        rdbRspta4.setText(rspta4);
        rdbRspta4.setChecked(false);

        //devolvemos la vista inflada y modificada con nuestros datos
        return v;

    }

}
