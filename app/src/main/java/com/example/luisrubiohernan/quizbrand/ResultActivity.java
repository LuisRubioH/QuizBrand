package com.example.luisrubiohernan.quizbrand;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    public void BackToMenu(View view) {
        Intent intent = new Intent(this, menu_juego.class);
        startActivityForResult(intent, 0);
    }
}
