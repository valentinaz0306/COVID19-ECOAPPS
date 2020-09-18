    package co.intro.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

    public class EncuestaActivity extends AppCompatActivity {

    private CheckBox cB1;
    private CheckBox cB2;
    private CheckBox cB3;
    private CheckBox cB4;
    private CheckBox cB5;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        cB1 = findViewById(R.id.checkBox);
        cB2 = findViewById(R.id.checkBox2);
        cB3 = findViewById(R.id.checkBox3);
        cB4 = findViewById(R.id.checkBox4);
        cB5 = findViewById(R.id.checkBox5);
        button = findViewById(R.id.button3);
        button.setEnabled(false);
        cB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                activarButton();
                if(((CheckBox)view).isChecked()){
                    //Perform
                    cB1.setChecked(false);
                    cB2.setChecked(false);
                    cB3.setChecked(false);
                    cB5.setChecked(false);


                }

            }
        });
        cB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activarButton();
                if(((CheckBox)view).isChecked()){
                    //Perform
                    cB4.setChecked(false);


                }

            }
        });
        cB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                activarButton();

                if(((CheckBox)view).isChecked()) {
                    cB4.setChecked(false);

                }

            }
        });
        cB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activarButton();
                if(((CheckBox)view).isChecked()){
                    //Perform
                    cB4.setChecked(false);
                }

            }
        });

        cB5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activarButton();
                if(((CheckBox)view).isChecked()){
                    //Perform
                    cB4.setChecked(false);
                }

            }
        });

        button.setOnClickListener(
                (v)->{
                    int puntajeR=0;

                    if(cB5.isChecked())
                        puntajeR = puntajeR +3;
                    if(cB1.isChecked())
                        puntajeR = puntajeR +3;
                    if(cB2.isChecked())
                        puntajeR = puntajeR +3;
                    if(cB3.isChecked())
                        puntajeR = puntajeR +3;
                    if(cB4.isChecked())
                        puntajeR = 0;

                    String name = getIntent().getExtras().getString("nombre");

                    Intent i = new Intent(this, SintomasActivity.class);
                    i.putExtra("nombre", name);
                    i.putExtra("puntaje", puntajeR);
                    startActivity(i);


                }

        );

    }

    public void activarButton(){
        if(cB1.isChecked()||cB2.isChecked()||cB3.isChecked()||cB4.isChecked()||cB5.isChecked()){
            button.setEnabled(true);
            button.getBackground().setTint(Color.rgb(240,23,86));
        }else{
            button.setEnabled(false);
            button.getBackground().setTint(Color.rgb(215,215,215));


    }
}}