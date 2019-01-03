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
import java.util.Random;

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
            InputStream stream = getAssets().open("_CompanyList.json");
            InputStreamReader reader = new InputStreamReader(stream);
            logosArray = gson.fromJson(reader, Logo[].class);
        }
        catch (IOException e) {
            Toast.makeText(this, "No se ha podido leer _CompanyList.json", Toast.LENGTH_SHORT)
                    .show();
        }

        String[] arrayPaises = getResources().getStringArray(R.array.countries);
        titleview_pais = findViewById(R.id.textview_selectCountry);
        btn_pais1 = findViewById(R.id.btn_pais1);
        btn_pais2 = findViewById(R.id.btn_pais2);
        btn_pais3 = findViewById(R.id.btn_pais3);
        btn_pais4 = findViewById(R.id.btn_pais4);
        btn_opciones = findViewById(R.id.btn_config);
        logoImage = findViewById(R.id.imageView_logo);

        //Obtenemos un logo aleatorio del array de logos
        Random random1 = new Random();
        int logoSelector = random1.nextInt(logosArray.length);
        Logo logoElegido = logosArray[logoSelector];

        //Mostramos la imagen del logo
        Glide.with(this)
                .load(logoElegido.getImagePath())
                .into(logoImage);

        //Aleatorizamos la posición de la respuesta correcta
        Random random2 = new Random();
        int buttonRandomizer = random2.nextInt(3);

        //Array de strings auxiliar que se usará dentro del switch
        String[] buttonString_array = new String[3];

        //En el switch se aleatorizan tanto las opciones como sus posiciones (manteniendo siempre una opción correcta)
        switch (buttonRandomizer){
            case 0:
                btn_pais1.setText(logoElegido.getCountry());

                for(int i =0;i<3;i++){
                    Random random3 = new Random();
                    int countryRandomizer = random3.nextInt(arrayPaises.length);

                    while (arrayPaises[countryRandomizer].equals(logoElegido.getName())){
                        random3 = new Random();
                        countryRandomizer = random3.nextInt(arrayPaises.length);
                    }
                    buttonString_array[i] = arrayPaises[countryRandomizer];
                }
                btn_pais2.setText(buttonString_array[0]);
                btn_pais3.setText(buttonString_array[1]);
                btn_pais4.setText(buttonString_array[2]);
                break;
            case 1:
                btn_pais2.setText(logoElegido.getCountry());

                for(int i =0;i<3;i++){
                    Random random3 = new Random();
                    int countryRandomizer = random3.nextInt(arrayPaises.length);

                    while (arrayPaises[countryRandomizer].equals(logoElegido.getName())){
                        random3 = new Random();
                        countryRandomizer = random3.nextInt(arrayPaises.length);
                    }
                    buttonString_array[i] = arrayPaises[countryRandomizer];
                }
                btn_pais1.setText(buttonString_array[0]);
                btn_pais3.setText(buttonString_array[1]);
                btn_pais4.setText(buttonString_array[2]);
                break;
            case 2:
                btn_pais3.setText(logoElegido.getCountry());

                for(int i =0;i<3;i++){
                    Random random3 = new Random();
                    int countryRandomizer = random3.nextInt(arrayPaises.length);

                    while (arrayPaises[countryRandomizer].equals(logoElegido.getName())){
                        random3 = new Random();
                        countryRandomizer = random3.nextInt(arrayPaises.length);
                    }
                    buttonString_array[i] = arrayPaises[countryRandomizer];
                }
                btn_pais1.setText(buttonString_array[0]);
                btn_pais2.setText(buttonString_array[1]);
                btn_pais4.setText(buttonString_array[2]);
                break;
            case 3:
                btn_pais4.setText(logoElegido.getCountry());

                for(int i =0;i<3;i++){
                    Random random3 = new Random();
                    int countryRandomizer = random3.nextInt(arrayPaises.length);

                    while (arrayPaises[countryRandomizer].equals(logoElegido.getName())){
                        random3 = new Random();
                        countryRandomizer = random3.nextInt(arrayPaises.length);
                    }
                    buttonString_array[i] = arrayPaises[countryRandomizer];
                }
                btn_pais1.setText(buttonString_array[0]);
                btn_pais2.setText(buttonString_array[1]);
                btn_pais3.setText(buttonString_array[2]);
                break;
        }


    }

}
