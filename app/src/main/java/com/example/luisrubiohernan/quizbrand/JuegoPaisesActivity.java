package com.example.luisrubiohernan.quizbrand;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.List;

import static junit.framework.Assert.assertEquals;


public class JuegoPaisesActivity extends AppCompatActivity {

    private Logo[] logosArray;
    private Gson gson;
    private TextView titleview_pais;
    private Button btn_opciones;
    private Button btn_pais1;
    private Button btn_pais2;
    private Button btn_pais3;
    private Button btn_pais4;
    private ImageView logoImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego_paises);

        gson = new Gson();

        try {
            InputStream stream = getAssets().open("CompanyList.json");
            InputStreamReader reader = new InputStreamReader(stream);
            logosArray = gson.fromJson(reader, Logo[].class);
        }
        catch (IOException e) {
            Toast.makeText(this, "No se ha podido leer CompanyList.json", Toast.LENGTH_SHORT)
                    .show();
        }

        titleview_pais = findViewById(R.id.textview_selectCountry);
        btn_pais1 = findViewById(R.id.btn_pais1);
        btn_pais2 = findViewById(R.id.btn_pais2);
        btn_pais3 = findViewById(R.id.btn_pais3);
        btn_pais4 = findViewById(R.id.btn_pais4);
        btn_opciones = findViewById(R.id.btn_config);
        String nombrecillo = logosArray[1].getName();

        btn_pais1.setText(nombrecillo);

//        Glide.with(this)
//                .load("file:///android_asset/lord.jpg")
//                .into(logoImage);
    }

}
