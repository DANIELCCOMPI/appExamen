package com.apptama.miexamen.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.apptama.miexamen.R;

public class RegistraNombreActivity extends AppCompatActivity {

    EditText edtNombre;
    Button btnComenzar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registra_nombre);

        edtNombre = (EditText) findViewById(R.id.edtNombre);
        btnComenzar = (Button) findViewById(R.id.btnComenzar);

        btnComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = edtNombre.getText().toString().trim();
                if (!nombre.isEmpty()) {
                    Intent intent = new Intent(v.getContext(), ListaCursosActivity.class);
                    intent.putExtra("nombre", nombre);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(v.getContext(), "Falta ingresar su nombre", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
