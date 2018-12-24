package com.apptama.miexamen.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.apptama.miexamen.R;
import com.apptama.miexamen.datos.entity.Examen;

import java.util.List;

/**
 * Created by jose_ on 16/11/2018.
 */

public class MiAdapterListView extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Examen> examenList;
    private int selectedPosition = -1;

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
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {

            //inflamos la vista que nos ha llegado con nuestro layout personalizado
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.list_tem, null);

            holder = new ViewHolder();

            holder.txtNroPregunta = (TextView) convertView.findViewById(R.id.txtNro);
            holder.txtPregunta = (TextView) convertView.findViewById(R.id.txtPregunta);
            holder.rdbRspta1 = (RadioButton) convertView.findViewById(R.id.rdbRspta1);
            holder.rdbRspta2 = (RadioButton) convertView.findViewById(R.id.rdbRspta2);
            holder.rdbRspta3 = (RadioButton) convertView.findViewById(R.id.rdbRspta3);
            holder.rdbRspta4 = (RadioButton) convertView.findViewById(R.id.rdbRspta4);

            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();


        }

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

        holder.txtNroPregunta.setText(nroPregunta);
        holder.txtPregunta.setText(pregunta);
        holder.rdbRspta1.setText(rspta1);
        holder.rdbRspta1.setChecked(isRspta1);
        holder.rdbRspta2.setText(rspta2);
        holder.rdbRspta2.setChecked(isRspta2);
        holder.rdbRspta3.setText(rspta3);
        holder.rdbRspta3.setChecked(isRspta3);
        holder.rdbRspta4.setText(rspta4);
        holder.rdbRspta4.setChecked(isRspta4);


        holder.rdbRspta1.setTag(position);
        holder.txtNroPregunta.setTag(position);
        holder.rdbRspta1.setTag(position);
        holder.rdbRspta2.setTag(position);
        holder.rdbRspta3.setTag(position);
        holder.rdbRspta4.setTag(position);

        holder.rdbRspta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemCheckChanged(v, 1);

            }
        });

        holder.rdbRspta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemCheckChanged(v, 2);
            }
        });

        holder.rdbRspta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemCheckChanged(v, 3);
            }
        });


        holder.rdbRspta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemCheckChanged(v, 4);
            }
        });


        //devolvemos la vista inflada y modificada con nuestros datos
        return convertView;

    }

    static class ViewHolder {

        TextView txtNroPregunta;
        TextView txtPregunta;
        RadioButton rdbRspta1;
        RadioButton rdbRspta2;
        RadioButton rdbRspta3;
        RadioButton rdbRspta4;


    }

    private void itemCheckChanged(View view, Integer rspta) {

        selectedPosition = (Integer) view.getTag();
        examenList.get(selectedPosition).setIsRspta1(1 == rspta);
        examenList.get(selectedPosition).setIsRspta2(2 == rspta);
        examenList.get(selectedPosition).setIsRspta3(3 == rspta);
        examenList.get(selectedPosition).setIsRspta4(4 == rspta);
        notifyDataSetChanged();

    }

}
