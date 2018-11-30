package com.example.luisrubiohernan.quizbrand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private ImageView title;
    private ImageView subtitle;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        title = findViewById(R.id.title);
        subtitle = findViewById(R.id.subtitle);

        gson = new Gson();
/*
       Glide.with(this)
                .load("file:///android_asset/fondo.jpg")
                .into(title);

        Glide.with(this)
                .load("file:///android_asset/foto.jpg")
                .apply(RequestOptions.circleCropTransform())
                .into(subtitle);*/
    }
}
