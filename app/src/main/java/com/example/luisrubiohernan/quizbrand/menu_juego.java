package com.example.luisrubiohernan.quizbrand;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class menu_juego extends AppCompatActivity {

    private int puntuaciones;

    public int getPuntuaciones() {
        return puntuaciones;
    }

    public void setPuntuaciones(int _puntuaciones) {
        this.puntuaciones = _puntuaciones;
    }


    private int puntuacion_nombres;
    private int puntuacion_paises;
    private int puntuacion_sectores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_juego);
    }

    public void onClickJuegoNombresActivity(View v){
        Intent view =new Intent(getApplicationContext(),JuegoNombresActivity.class);
        startActivity(view);
    }

    public void onClickJuegoPaisesActivity(View view) {
        Intent intent = new Intent(this, JuegoPaisesActivity.class);
        startActivityForResult(intent, 0);
    }

    public void onClickJuegoSectoresActivity(View view) {
        Intent intent = new Intent(this, JuegoSectoresActivity.class);
        startActivityForResult(intent, 0);
    }

    public void onClickHighScoresActivity(View view) {
        Intent intent = new Intent(this, HighScoresActivity.class);
        startActivityForResult(intent, 0);
    }
}
