package com.apptama.miexamen.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.apptama.miexamen.R;
import com.apptama.miexamen.datos.entity.Curso;
import com.apptama.miexamen.view.activity.ExamenActivity;

import java.util.List;

/**
 * Created by jose_ on 13/11/2018.
 */

public class MiAdapterGridView extends BaseAdapter {

    private Context context;
    private int layout;

    public MiAdapterGridView(Context context, int layout, List<Curso> cursoList) {
        this.context = context;
        this.layout = layout;
        this.cursoList = cursoList;
    }

    private List<Curso> cursoList;


    @Override
    public int getCount() {
        return this.cursoList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.cursoList.get(position);
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
        v = layoutInflater.inflate(R.layout.grid_item, null);

        //nos traemos los valores actuales dependiente de la posicion
        String nombre = cursoList.get(position).getNombre();
        String colorfondo = cursoList.get(position).getColor();

        //referenciamos el elemento a modificar y lo rellenamos
        TextView txtNombreCurso = (TextView) v.findViewById(R.id.txtNombreCurso);

        SpannableString mitextoU = new SpannableString(nombre);
        mitextoU.setSpan(new UnderlineSpan(), 0, mitextoU.length(), 0);
        txtNombreCurso.setText(mitextoU);
        txtNombreCurso.setBackgroundColor(Color.parseColor(colorfondo));


        txtNombreCurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer mIdCurso = cursoList.get(position).getIdCurso();
                String mNombre = cursoList.get(position).getNombre();

                Intent intent = new Intent(v.getContext(), ExamenActivity.class);
                intent.putExtra("IdCurso", mIdCurso);
                intent.putExtra("Nombre",mNombre);
                v.getContext().startActivity(intent);


            }
        });

        //devolvemos la vista inflada y modificada con nuestros datos
        return v;

    }
}
