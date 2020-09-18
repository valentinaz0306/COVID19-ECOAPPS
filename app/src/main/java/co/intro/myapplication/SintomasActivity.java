package co.intro.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

public class SintomasActivity extends AppCompatActivity {

    private CheckBox opcion1;
    private CheckBox opcion2;
    private CheckBox opcion3;
    private CheckBox opcion4;
    private CheckBox opcion5;
    private CheckBox opcion6;
    private CheckBox opcion7;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintomas);

        opcion1 = findViewById(R.id.checkBox9);
        opcion2 = findViewById(R.id.checkBox10);
        opcion3 = findViewById(R.id.checkBox11);
        opcion4 = findViewById(R.id.checkBox12);
        opcion5 = findViewById(R.id.checkBox13);
        opcion6 = findViewById(R.id.checkBox14);
        opcion7 = findViewById(R.id.checkBox15);
        button = findViewById(R.id.button4);
        button.setEnabled(false);
        opcion1.setOnClickListener(
                (V)->{
                    activarButton();
                    if (opcion1.isChecked())
                        opcion7.setChecked(false);
                }
        );

        opcion2.setOnClickListener(
                (V)->{
                    activarButton();
                    if (opcion2.isChecked())
                        opcion7.setChecked(false);
                }
        );

        opcion3.setOnClickListener(
                (V)->{
                    activarButton();
                    if (opcion3.isChecked())
                        opcion7.setChecked(false);
                }
        );

        opcion4.setOnClickListener(
                (V)->{
                    activarButton();
                    if (opcion4.isChecked())
                        opcion7.setChecked(false);
                }
        );

        opcion5.setOnClickListener(
                (V)->{
                    activarButton();
                    if (opcion5.isChecked())
                        opcion7.setChecked(false);
                }
        );

        opcion6.setOnClickListener(
                (V)->{
                    activarButton();
                    if (opcion6.isChecked())
                        opcion7.setChecked(false);
                }
        );

        opcion7.setOnClickListener(
                (V)->{
                    activarButton();
                    if (opcion7.isChecked()){
                        opcion1.setChecked(false);
                        opcion2.setChecked(false);
                        opcion3.setChecked(false);
                        opcion4.setChecked(false);
                        opcion5.setChecked(false);
                        opcion6.setChecked(false);

                    }


                }
        );

        button.setOnClickListener(
                (v) ->{

                    int puntaje = 0;

                    if (opcion1.isChecked())
                        puntaje = puntaje + 4;
                    if (opcion2.isChecked())
                        puntaje = puntaje + 4;
                    if (opcion3.isChecked())
                        puntaje = puntaje + 4;
                    if (opcion4.isChecked())
                        puntaje = puntaje + 4;
                    if (opcion5.isChecked())
                        puntaje = puntaje + 4;
                    if (opcion6.isChecked())
                        puntaje = puntaje + 4;
                    if (opcion7.isChecked())
                        puntaje = 0;

                    String name = getIntent().getExtras().getString("nombre");
                    int puntaje2 = getIntent().getExtras().getInt("puntaje");

                    int puntajeF = puntaje + puntaje2;

                    String info = name+"  "+puntajeF+"#";
                    SharedPreferences names = getSharedPreferences("namesSP", MODE_PRIVATE);
                    String info2 = names.getString("names", "");
                    if(info2.equals(""))
                        names.edit().putString("names", info).apply();
                    else{
                        info2 = info2 + info;
                        names.edit().putString("names", info2).apply();
                    }

                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);

                }
        );
    }

    public void activarButton(){
        if(opcion1.isChecked()||opcion2.isChecked()||opcion3.isChecked()||opcion4.isChecked()||opcion5.isChecked()||opcion6.isChecked()||opcion7.isChecked()){
            button.setEnabled(true);
            button.getBackground().setTint(Color.rgb(240,23,86));
        }else{
            button.setEnabled(false);
            button.getBackground().setTint(Color.rgb(215,215,215));


        }
}}