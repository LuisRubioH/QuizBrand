package com.example.luisrubiohernan.quizbrand;

public class Puntuacion {
    private static int puntuacion_nombres = 0;
    private static int puntuacion_paises  = 0;
    private static int puntuacion_sectores  = 0;

    public static int getPuntuacionNombres(){
        return puntuacion_nombres;
    }
    public static void setPuntuacionNombres(int argPuntuacionNombres){
        puntuacion_nombres = argPuntuacionNombres;
    }

    public static int getPuntuacionPaises(){
        return puntuacion_paises;
    }
    public static void setPuntuacionPaises(int argPuntuacionpaises){
        puntuacion_paises = argPuntuacionpaises;
    }

    public static int getPuntuacionSectores(){
        return puntuacion_sectores;
    }
    public static void setPuntuacionSectores(int argPuntuacionSectores){
        puntuacion_sectores = argPuntuacionSectores;
    }
}
