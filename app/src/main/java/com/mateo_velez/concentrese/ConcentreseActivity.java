package com.mateo_velez.concentrese;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ConcentreseActivity extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences preferencias;
    SharedPreferences.Editor editor_preferencias;
    int nivelcon;
    long puntaje;
    Button button[] = new Button[42];
    boolean isButtonClicked[]= new boolean[42];

    int buttonsId[]={R.id.img1,R.id.img2,R.id.img3,R.id.img4,R.id.img5,R.id.img6,
            R.id.img7,R.id.img8,R.id.img9,R.id.img10,R.id.img11,R.id.img12,
            R.id.img13,R.id.img14,R.id.img15,R.id.img16,R.id.img17,R.id.img18,
            R.id.img19,R.id.img20,R.id.img21,R.id.img22,R.id.img23,R.id.img24,
            R.id.img25,R.id.img26,R.id.img27,R.id.img28,R.id.img29,R.id.img30,
            R.id.img31,R.id.img32,R.id.img33,R.id.img34,R.id.img35,R.id.img36,
            R.id.img37,R.id.img38,R.id.img39,R.id.img40,R.id.img41,R.id.img42};

    List <Integer> pictures = Arrays.asList(R.drawable.astronauta,R.drawable.batman,R.drawable.bombero,
            R.drawable.chickenhawk,R.drawable.garfield, R.drawable.hulk,
            R.drawable.lisa,R.drawable.lobo,R.drawable.luigi,
            R.drawable.mago,R.drawable.marciano,R.drawable.pajaroloco,
            R.drawable.panterarosa,R.drawable.perro,R.drawable.piolin,
            R.drawable.samurai,R.drawable.shrek,R.drawable.spiderman,
            R.drawable.ubuntu,R.drawable.ubuntu1,R.drawable.vaca2);

    List<Integer> mostrar = new ArrayList<>();

    int linearsId[]={R.id.linear1,R.id.linear2,R.id.linear3,R.id.linear4,R.id.linear5,R.id.linear6,R.id.linear7};

    LinearLayout linearLayout[]=new LinearLayout[7];
    LinearLayout fondocon;
    TextView tpuntaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concentrese);

        tpuntaje=(TextView) findViewById(R.id.tpuntaje);
        tpuntaje.setText("Puntaje: "+String.valueOf(puntaje));

        //Enlazo botones con variables------
        fondocon =(LinearLayout) findViewById(R.id.fondocon);

        for(int i=0;i<42;i++){
            button[i] = (Button) findViewById(buttonsId[i]);
        }

        for(int i =0;i<7;i++){
            linearLayout[i] = (LinearLayout) findViewById(linearsId[i]);
        }
        //----------------------------------

        // Se define el archivo "Preferencias" donde se almacenaran los valores de las preferencias
        preferencias = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        //se declara instancia el editor de "Preferencias"
        editor_preferencias = preferencias.edit();

        //Obtengo el nivel del juego de preferencias
        nivelcon=preferencias.getInt("nivelCon",1);
        Log.d("nivelconI",String.valueOf(nivelcon));


        //Inicia la interfaz del juego según el nivel
        //Nivel 1: 3x4
        if(nivelcon==1){
            Toast.makeText(this, "NIVEL 1", Toast.LENGTH_SHORT).show();
            int numTag=0;
            Log.d("Pictures",String.valueOf(pictures));
            Collections.shuffle(pictures);
            Log.d("Pictures",String.valueOf(pictures));
            mostrar.clear();
            for(int i=0, j=0; j<6; i+=2, j++){
                mostrar.add(i,pictures.get(j));
                mostrar.add(i+1,pictures.get(j));
            }
            Log.d("mostrar",String.valueOf(mostrar));
            Collections.shuffle(mostrar);
            Log.d("mostrar",String.valueOf(mostrar));

            for(int i=0;i<42;i++){
                if((i>12 && i<17)||(i>18 && i<23)||(i>24 && i<29)){
                    button[i].setVisibility(View.VISIBLE);
                    button[i].setBackgroundResource(R.drawable.incognita);
                    button[i].setOnClickListener(this);
                    button[i].setTag("Button"+numTag);
                    numTag++;
                }else{
                    button[i].setVisibility(View.INVISIBLE);
                }
            }
        }

        //Nivel 2: 5x4
        else if(nivelcon==2){
            Toast.makeText(this, "NIVEL 2", Toast.LENGTH_SHORT).show();
            int numTag=0;
            Log.d("Pictures",String.valueOf(pictures));
            Collections.shuffle(pictures);
            Log.d("Pictures",String.valueOf(pictures));
            mostrar.clear();
            for(int i=0, j=0; j<10; i+=2, j++){
                mostrar.add(i,pictures.get(j));
                mostrar.add(i+1,pictures.get(j));
            }
            Log.d("mostrar",String.valueOf(mostrar));
            Collections.shuffle(mostrar);
            Log.d("mostrar",String.valueOf(mostrar));

            for(int i=0;i<42;i++){
                if((i>6 && i<11)||(i>12 && i<17)||(i>18 && i<23)||(i>24 && i<29)||(i>30 && i<35)){
                    button[i].setVisibility(View.VISIBLE);
                    button[i].setBackgroundResource(R.drawable.incognita);
                    button[i].setOnClickListener(this);
                    button[i].setTag("Button"+numTag);
                    numTag++;
                }else{
                    button[i].setVisibility(View.INVISIBLE);
                }
            }
        }

        //Nivel 3: 5x6
        else if(nivelcon==3){
            Toast.makeText(this, "NIVEL 3", Toast.LENGTH_SHORT).show();
            int numTag=0;
            Log.d("Pictures",String.valueOf(pictures));
            Collections.shuffle(pictures);
            Log.d("Pictures",String.valueOf(pictures));
            mostrar.clear();
            for(int i=0, j=0; j<15; i+=2, j++){
                mostrar.add(i,pictures.get(j));
                mostrar.add(i+1,pictures.get(j));
            }
            Log.d("mostrar",String.valueOf(mostrar));
            Collections.shuffle(mostrar);
            Log.d("mostrar",String.valueOf(mostrar));

            for(int i=0;i<42;i++){
                if(i>5 && i<36){
                    button[i].setVisibility(View.VISIBLE);
                    button[i].setBackgroundResource(R.drawable.incognita);
                    button[i].setOnClickListener(this);
                    button[i].setTag("Button"+numTag);
                    numTag++;
                }else{
                    button[i].setVisibility(View.INVISIBLE);
                }
            }
        }

        //Nivel 4: 7x6
        else if(nivelcon==4){
            Toast.makeText(this, "NIVEL 4", Toast.LENGTH_SHORT).show();
            int numTag=0;
            Log.d("Pictures",String.valueOf(pictures));
            Collections.shuffle(pictures);
            Log.d("Pictures",String.valueOf(pictures));
            mostrar.clear();
            for(int i=0, j=0; j<21; i+=2, j++){
                mostrar.add(i,pictures.get(j));
                mostrar.add(i+1,pictures.get(j));
            }
            Log.d("mostrar",String.valueOf(mostrar));
            Collections.shuffle(mostrar);
            Log.d("mostrar",String.valueOf(mostrar));

            for(int i=0;i<42;i++){
                    button[i].setVisibility(View.VISIBLE);
                    button[i].setBackgroundResource(R.drawable.incognita);
                    button[i].setOnClickListener(this);
                    button[i].setTag("Button"+numTag);
                    numTag++;
            }
        }
    }

    int presionados=0, img1=0, img2=0, pos1=0, pos2=0, auxid=0;
    Button auxbutton=null;
    boolean tiempocumplido=false;
    View auxv;

    @Override
    public void onClick(View v) {
        auxv=v;
        String tag = String.valueOf(auxv.getTag());

        Log.d("TagPresionado", tag);
        Log.d("IdPresionado",String.valueOf(auxv.getId()));

        int numeroBotones=0, auxpos=0;
        boolean verificar=false;

        //Se define numero de botones por nivel
        if(nivelcon==1) numeroBotones=12;
        else if(nivelcon==2) numeroBotones=20;
        else if(nivelcon==3) numeroBotones=30;
        else if(nivelcon==4) numeroBotones=42;

        Log.d("nivelcon",String.valueOf(nivelcon));
        Log.d("numerobotones",String.valueOf(numeroBotones));

        //Cuando se presiona un nivel del botón, se verifica cual botón se presionó y se toma una acción;
        for(int i=0;i<numeroBotones;i++){
            if(tag.equals("Button"+String.valueOf(i))){
                auxpos=i;
                isButtonClicked[i] = !isButtonClicked[i];

                Log.d("auxpos",String.valueOf(auxpos));
                Log.d("botonPresionado",String.valueOf(isButtonClicked[i]));

                //Log.d("Presiono1",String.valueOf(isButtonClicked[i]));
                auxv.setBackgroundResource(isButtonClicked[i]? mostrar.get(i) : R.drawable.incognita);
                //v.setBackgroundResource(nombre3);
                //fondocon.setBackgroundColor(Color.GREEN); //tpuntaje.setText("Eres la hostia");
            }
        }

        for(int j=1; j<numeroBotones; j++){
            verificar = verificar | isButtonClicked[j-1] | isButtonClicked[j];
            Log.d("verificar",String.valueOf(verificar));
        }

        Log.d("verificar2",String.valueOf(verificar));

        if(verificar){
            presionados=presionados+1;
            Log.d("presionados",String.valueOf(presionados));
        }
        else{
            presionados=0;
        }

        Log.d("presionados2",String.valueOf(presionados));

        if(presionados==0){
            auxid=0;
            auxbutton=null;
        }
        else if(presionados==1){
            pos1=auxpos;
            auxid = auxv.getId();
            auxbutton = (Button) findViewById(auxid);
            img1=mostrar.get(pos1);
        }

        else if(presionados==2){
            pos2=auxpos;
            img2=mostrar.get(pos2);

            TimerTask task = new TimerTask() {
                @Override
                public void run() {


                }
            };

            Timer timer = new Timer();
            timer.schedule(task,1000);

            if(img2==img1){
                auxbutton.setVisibility(View.INVISIBLE);
                auxv.setVisibility(View.INVISIBLE);
            }
            else{
                auxbutton.setBackgroundResource(R.drawable.incognita);
                auxv.setBackgroundResource(R.drawable.incognita);
            }
            isButtonClicked[pos1]=false;
            isButtonClicked[auxpos]=false;
            presionados=0;

        }

    }
}
