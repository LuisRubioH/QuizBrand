package com.example.luisrubiohernan.quizbrand;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class HighScoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);

        TextView puntuacionPaises = findViewById(R.id.textViewPuntPais);
        TextView puntuacionSectores = findViewById(R.id.textViewPuntSect);

        puntuacionPaises.setText(Puntuacion.getPuntuacionPaises());
        puntuacionSectores.setText(Puntuacion.getPuntuacionSectores());

    }


}
