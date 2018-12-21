package com.example.luisrubiohernan.quizbrand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class JuegoNombresActivity extends AppCompatActivity {

    private boolean[] btn_apretado;
    private ArrayList<LogoItem> itemList;
    private int buttons[]={R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,
            R.id.btn8,R.id.btn9,R.id.btn10,R.id.btn11,R.id.btn12,R.id.btn13,R.id.btn14};
    private int buttons_resp[]={R.id.btn_resp1,R.id.btn_resp2,R.id.btn_resp3,R.id.btn_resp4,R.id.btn_resp5,
            R.id.btn_resp6,R.id.btn_resp7,R.id.btn_resp8,R.id.btn_resp9,R.id.btn_resp10,
            R.id.btn_resp11,R.id.btn_resp12,R.id.btn_resp13,R.id.btn_resp14, R.id.btn_resp15, R.id.btn_resp16};
    private int current_question;
    private int contador;
    private int contador_letras_sin_espacios;


    private  int cpp; //contador primera palabra
    private int csp; //contador segunda palabra
    private int ctp; //contador tercera palabra

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego_nombres);


        current_question =0;

        itemList = new ArrayList<>();
        itemList.add(new LogoItem("CBOAXPABRHRTNI","BP",10));
        itemList.add(new LogoItem("BACDMAUXROIJNB","AUDI",10));
        itemList.add(new LogoItem("ETHRNJPSTIRSOJ","INTERSPORT",10));
        itemList.add(new LogoItem("UNOIOGHTPSABRP","TOSHIBA",10));
        itemList.add(new LogoItem("TAARSUMNTIOMLY","LOTUS",10));
        itemList.add(new LogoItem("HLNOURANALEPRN","RALPH LAUREN",10));
        itemList.add(new LogoItem("ESTRELLADAMMOU","ESTRELLA DAMM",10));





        btn_apretado = new boolean[buttons.length];

        repartidorDeLetras(itemList);
        contadorDeLetrasRespuesta(itemList);


        if (current_question==0){
            Button btn=findViewById(R.id.btn_before);
            btn.setVisibility(View.INVISIBLE);
        }







        //TODO COMPLETAR AIXO
       /* boolean spsp=false; //salto de primera a segunda palabra
        boolean sstp=false; //salto de segunda a tercera palabra

        if (spsp==false){
            Button btn_continue =(Button)findViewById(R.id.btn_continue);
            if(cpp<9){
                btn_continue.setVisibility(View.GONE);
            }else{
                btn_continue.setVisibility(View.VISIBLE);

        }else if(sstp==false){
            if (cpp<9 && csp<9){
                if (cpp+csp<8){ //ponemos 8 porque sabemos que hay un espacio entre las dos palabras



                }else{
                    for(int j=0;j++;j<cpp){
                        Button btn = (Button) findViewById(button_resp[j]);
                        btn=setVisibility(View.VISIBLE);
                    }
                    for(int j=cpp;j++;j<9){
                        Button btn = (Button) findViewById(button_resp[j]);
                        btn=setVisibility(View.GONE)

                }
            }else if(cpp>7){

            }else{

            }
        }else{

        }*/









    }


    private void repartidorDeLetras(List<LogoItem> itemList) {  //Reparte las letras random_letter

        String itemLista = itemList.get(current_question).getRandom_letter() ;
        char[] c_arr = itemLista.toCharArray();

        for (int i=0; i<c_arr.length; i++){ //això està per complir els exemples amb quatre botons
            Button btn = (Button) findViewById(buttons[i]);
            char a = itemLista.charAt(i);
            String name = String.valueOf(a);
            btn.setText(name);
            btn_apretado[i]=false;
        }
    }

    private void repartidorDeLetrasRespuestaCorrecta(List<LogoItem> itemList) {  //Reparte las letras answer

        String itemLista = itemList.get(current_question).getAnswer() ;
        char[] c_arr = itemLista.toCharArray();

        for (int j=0; j<c_arr.length; j++){ //això està per complir els exemples amb quatre botons
            Button btn = (Button) findViewById(buttons_resp[j]);
            char a = itemLista.charAt(j);
            String name = String.valueOf(a);
            btn.setText(name);
        }
    }

    private void contadorDeLetrasRespuesta(List<LogoItem> itemList){ //Cuenta las letras answer y coloca la puntuación

        String itemLista_resp = itemList.get(current_question).getAnswer();
        char[] c_arr_resp = itemLista_resp.toCharArray();

        contador=0;
        cpp=0;
        csp=0;
        ctp=0;

        boolean spsp=false; //salto de primera a segunda palabra de la marca
        boolean sstp=false; //salto de segunda a tercera palabra de la marca

        for(int j=0;j<c_arr_resp.length;j++){

            Button btn_aparecer=findViewById(buttons_resp[j]);
            btn_aparecer.setVisibility(View.VISIBLE);

            char a = itemLista_resp.charAt(j);
            String letra = String.valueOf(a);

            if(!spsp){
                cpp++;
                if (letra.equals(" ")){
                    spsp=true;
                    btn_aparecer.setText(" ");
                    if (cpp==8 || cpp==9){
                        btn_aparecer.setVisibility(View.GONE);
                    }else{
                        btn_aparecer.setVisibility(View.INVISIBLE);
                    }
                    cpp--;
                }
            }else if(!sstp){
                csp++;
                if (letra.equals(" ")){
                    sstp=true;
                    btn_aparecer.setText(" ");
                    if (cpp+1+csp==8 || cpp+1+csp==9){
                        btn_aparecer.setVisibility(View.GONE);
                    }else{
                        btn_aparecer.setVisibility(View.INVISIBLE);
                    }
                    csp--;
                }
            }else{
                ctp++;
            }

            contador++;
        }

        for(int c=contador;c<buttons_resp.length;c++){
            Button btn_eliminar = findViewById(buttons_resp[c]);
            btn_eliminar.setVisibility(View.GONE);
        }

        indicadorDeContinuidad();

        Button btn_score= (Button)findViewById(R.id.btn_score); //aquí se muestra la puntuación
        String a=String.valueOf(itemList.get(current_question).getScore());
        btn_score.setText(a);



    }


    private void transportarLaLetra(Button btn) { //transporta la letra clicada a la respuesta
        for (int j=0; j<contador;j++){
            Button btn_resp = findViewById(buttons_resp[j]);
            String b = btn_resp.getText().toString();

            if(b.equals("")){
                String lletra = btn.getText().toString();
                btn_resp.setText(lletra);
                j=contador;

                btn.setVisibility(View.INVISIBLE);
            }
        }
    }


    public void onClickDelete(View view){

        for (int j=buttons_resp.length-1; j>-1;j--){
            Button btn_resp = findViewById(buttons_resp[j]);
            String b = btn_resp.getText().toString();

            if(!b.equals("")&& !b.equals(" ")){

                btn_resp.setText("");

                for (int i=0; i<buttons.length; i++){
                    Button btn = (Button) findViewById(buttons[i]);
                    String lletra_retorn = btn.getText().toString();

                    if(lletra_retorn.equals(b)&& (btn_apretado[i])){
                        btn_apretado[i]=false;
                        btn.setVisibility(View.VISIBLE);

                        i=buttons.length;
                        j=-1;
                    }
                }
            }
        }
    }

    public void onClickNext(View view){
        Button btn_next=findViewById(R.id.btn_next);
        Button btn_before=findViewById(R.id.btn_before);

        current_question++;

        if (!itemList.get(current_question).getAnswered()){


            limpiezaDeLetras(); //tiene que ir antes que repartidorDeLetras
            repartidorDeLetras(itemList);
            contadorDeLetrasRespuesta(itemList);

            devolverVisibilidad();
        }else{
            contadorDeLetrasRespuesta(itemList);
            acertada();
            repartidorDeLetrasRespuestaCorrecta(itemList);


        }

        if (current_question != 0) {
            btn_before.setVisibility(View.VISIBLE);
        }

        if (current_question == 39) {
            btn_next.setVisibility(View.INVISIBLE);
        }


    }


    public void onClickBefore(View view){
        Button btn_before=findViewById(R.id.btn_before);
        Button btn_next=findViewById(R.id.btn_next);

        current_question--;

        if (!itemList.get(current_question).getAnswered()){

            limpiezaDeLetras();
            repartidorDeLetras(itemList);
            contadorDeLetrasRespuesta(itemList);

            devolverVisibilidad();
        }else{
            contadorDeLetrasRespuesta(itemList);
            acertada();
            repartidorDeLetrasRespuestaCorrecta(itemList);
        }

        if (current_question == 0){
            btn_before.setVisibility(View.INVISIBLE);
        }

        if(current_question!=39){
            btn_next.setVisibility(View.VISIBLE);
        }



    }


    private void limpiezaDeLetras() {
        for(int i=0; i<buttons.length;i++){
            Button btn=(Button) findViewById(buttons[i]);
            btn.setText("");
        }

        for(int j=0;j<buttons_resp.length;j++){
            Button btn=(Button) findViewById(buttons_resp[j]);
            btn.setText("");
        }
    }

    private void devolverVisibilidad() {



        for (int j = 0; j < buttons_resp.length; j++) {

            for (int i = 0; i < buttons.length; i++) {
                Button btn = (Button) findViewById(buttons[i]);
                btn.setVisibility(View.VISIBLE);
                btn_apretado[i]=false;
            }

        }

        Button btnok= findViewById(R.id.buttonOK);
        Button btneliminar=findViewById(R.id.btn_delete);
        btnok.setVisibility(View.VISIBLE);
        btneliminar.setVisibility(View.VISIBLE);

        for(int j=0;j<buttons_resp.length;j++){
            Button btn_resp=findViewById(buttons_resp[j]);
            btn_resp.setEnabled(true);
        }




    }

    private void acertada(){
        for (int i=0;i<buttons.length;i++){
            Button btn=(Button) findViewById(buttons[i]);
            btn.setVisibility(View.GONE);
        }

        Button btnok= findViewById(R.id.buttonOK);
        Button btneliminar=findViewById(R.id.btn_delete);
        btnok.setVisibility(View.GONE);
        btneliminar.setVisibility(View.GONE);

        for(int j=0;j<buttons_resp.length;j++){
            Button btn_resp=findViewById(buttons_resp[j]);
            btn_resp.setEnabled(false);
        }
    }


    private void indicadorDeContinuidad(){
        Button btncontinuar=findViewById(R.id.btn_continue);
        if (contador>8) {
            String itemLista_resp = itemList.get(current_question).getAnswer() ;
            char[] c_arr = itemLista_resp.toCharArray();

            String alpha,betta;

            alpha = String.valueOf(c_arr[7]);
            betta = String.valueOf(c_arr[8]);

            if (!alpha.equals("") && !betta.equals("")) {
                btncontinuar.setVisibility(View.VISIBLE);
            } else {
                btncontinuar.setVisibility(View.INVISIBLE);
            }
        }else{
            btncontinuar.setVisibility(View.INVISIBLE);
        }

        if (cpp==8 || cpp+1+csp==8 || cpp+1+csp+1==8){
            btncontinuar.setVisibility(View.INVISIBLE);
        }
    }


    public void onClickOK(View view){
        Button btnok=findViewById(R.id.buttonOK);
        String palabra="";
        for (int j=0;j<buttons_resp.length;j++){
            Button btn=findViewById(buttons_resp[j]);
            String letra=btn.getText().toString();
            palabra += letra;
        }

        if (palabra.equals(itemList.get(current_question).getAnswer())){

            itemList.get(current_question).setAlreadyAnswered();

            Toast.makeText(this, "Esta es la respuesta", Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, String.valueOf(itemList.get(current_question).getAnswered()), Toast.LENGTH_SHORT).show();

            acertada();


        }else{
            Toast.makeText(this, "Esta no es la respuesta", Toast.LENGTH_SHORT).show();

            itemList.get(current_question).setNewScore();

            Button btn_score=(Button)findViewById(R.id.btn_score);
            btn_score.setText(String.valueOf(itemList.get(current_question).getScore()));
        }

    }


    public void onClickNumber1(View view){
        Button btn = (Button)view;
        btn_apretado[0]=true;
        transportarLaLetra(btn);
    }

    public void onClickNumber2(View view){
        Button btn = (Button)view;
        btn_apretado[1]=true;
        transportarLaLetra(btn);
    }

    public void onClickNumber3(View view){
        Button btn = (Button)view;
        btn_apretado[2]=true;
        transportarLaLetra(btn);
    }

    public void onClickNumber4(View view) {
        Button btn = (Button) view;
        btn_apretado[3] = true;
        transportarLaLetra(btn);
    }

    public void onClickNumber5(View view){
        Button btn = (Button)view;
        btn_apretado[4]=true;
        transportarLaLetra(btn);
    }

    public void onClickNumber6(View view){
        Button btn = (Button)view;
        btn_apretado[5]=true;
        transportarLaLetra(btn);
    }
    public void onClickNumber7(View view){
        Button btn = (Button)view;
        btn_apretado[6]=true;
        transportarLaLetra(btn);
    }

    public void onClickNumber8(View view){
        Button btn = (Button)view;
        btn_apretado[7]=true;
        transportarLaLetra(btn);
    }

    public void onClickNumber9(View view){
        Button btn = (Button)view;
        btn_apretado[8]=true;
        transportarLaLetra(btn);
    }

    public void onClickNumber10(View view){
        Button btn = (Button)view;
        btn_apretado[9]=true;
        transportarLaLetra(btn);
    }

    public void onClickNumber11(View view){
        Button btn = (Button)view;
        btn_apretado[10]=true;
        transportarLaLetra(btn);
    }

    public void onClickNumber12(View view){
        Button btn = (Button)view;
        btn_apretado[11]=true;
        transportarLaLetra(btn);
    }

    public void onClickNumber13(View view){
        Button btn = (Button)view;
        btn_apretado[12]=true;
        transportarLaLetra(btn);
    }

    public void onClickNumber14(View view){
        Button btn = (Button)view;
        btn_apretado[13]=true;
        transportarLaLetra(btn);
    }

    public void onClickResp(View view){

        Button btn_resp=(Button) view;


        transporteDeLetraDeLaRespuesta(btn_resp);

    }

    private void transporteDeLetraDeLaRespuesta(Button btn_resp) {

        for (int i=0; i<buttons.length; i++){
            Button btn = (Button) findViewById(buttons[i]);
            String lletra_retorn = btn.getText().toString();

            if(lletra_retorn.equals(btn_resp.getText().toString())&& (btn_apretado[i])){
                btn_apretado[i]=false;
                btn.setVisibility(View.VISIBLE);

                i=buttons.length;

            }
        }

        btn_resp.setText("");
    }
}
