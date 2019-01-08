package com.example.luisrubiohernan.quizbrand;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView resultado;
    private int puntuacion_recibida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultado = findViewById(R.id.textView_resultado);
        Intent intent = getIntent();
        puntuacion_recibida = intent.getIntExtra("puntuacion",0);
        String puntuacionRecibida = Integer.toString(puntuacion_recibida);
        resultado.setText(puntuacionRecibida);
    }

    public void BackToMenu(View view) {
        Intent intent = new Intent(this, menu_juego.class);
        startActivityForResult(intent, 0);
    }
}
