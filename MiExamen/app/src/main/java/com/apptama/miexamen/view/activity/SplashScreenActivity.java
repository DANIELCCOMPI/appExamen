package com.apptama.miexamen.view.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.apptama.miexamen.MainActivity;
import com.apptama.miexamen.R;
import com.apptama.miexamen.datos.DatabaseOpenHelper;
import com.apptama.miexamen.view.util.Constantes;

public class SplashScreenActivity extends AppCompatActivity {

    TextView tv;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        DatabaseOpenHelper conn = new DatabaseOpenHelper(this, Constantes.nameBD, null, Constantes.versionBD);

        tv = (TextView) findViewById(R.id.txvMsj);
        iv = (ImageView) findViewById(R.id.imvLogo);

        Animation mianim = AnimationUtils.loadAnimation(this, R.anim.mi_animacion);
        tv.startAnimation(mianim);
        iv.startAnimation(mianim);

        final Intent intent = new Intent(this, RegistraNombreActivity.class);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(intent);
                    finish();
                }
            }
        };

        timer.start();

    }
}
