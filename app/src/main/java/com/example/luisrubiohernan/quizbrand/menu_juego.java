package com.example.luisrubiohernan.quizbrand;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class menu_juego extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_juego);
    }

    public void onClickJuegoNombresActivity(View v){
        Intent view =new Intent(getApplicationContext(),JuegoNombresActivity.class);
        startActivity(view);
    }
}
