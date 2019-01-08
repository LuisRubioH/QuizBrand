package com.example.luisrubiohernan.quizbrand;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HighScoresActivity extends AppCompatActivity {
    TextView puntuacionNombres;
    TextView puntuacionPaises;
    TextView puntuacionSectores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);

        puntuacionNombres = findViewById(R.id.textViewPuntNom);
        puntuacionPaises = findViewById(R.id.textViewPuntPais);
        puntuacionSectores = findViewById(R.id.textViewPuntSect);

        
        puntuacionPaises.setText(Integer.toString(Puntuacion.getPuntuacionPaises()));
        puntuacionSectores.setText(Integer.toString(Puntuacion.getPuntuacionSectores()));

    }


    public void onClickReset(View view) {
        puntuacionNombres.setText("0");
        puntuacionPaises.setText("0");
        puntuacionSectores.setText("0");
    }
}
