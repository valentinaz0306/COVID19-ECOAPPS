package co.intro.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button continuar;
    private TextView resultadosTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continuar = findViewById(R.id.continuarBt);
        resultadosTv = findViewById(R.id.resultadosTV);

        continuar.setOnClickListener(

                (v)->{

                    Intent i = new Intent(this, ResgistroActivity.class);
                    startActivity(i);

                }

        );

    }

    @Override
    protected void onResume() {
        super.onResume();

        String info = getSharedPreferences("namesSP", MODE_PRIVATE).getString("names", "Sin regustros");
        String[] partes = info.split("#");

        String mensaje = "";
        for (int i = 0; i<partes.length;i++){

            String x = partes[i];
            mensaje += x +"\n";

        }

        resultadosTv.setText(mensaje);

    }
}