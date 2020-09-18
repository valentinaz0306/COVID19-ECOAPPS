package co.intro.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResgistroActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText id;
    private Button continuarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgistro);

        nombre = findViewById(R.id.nombre);
        id = findViewById(R.id.id);
        continuarBtn = findViewById(R.id.continuarBtn1);

        continuarBtn.setOnClickListener(

                (view)->{

                    SharedPreferences sh = getSharedPreferences("iDs",  MODE_PRIVATE);

                    String idS = id.getText().toString();
                    String nombreS = nombre.getText().toString();


                   if(sh.getInt(idS, 0) == 0){

                       sh.edit().putInt(idS, 3).apply();
                       Intent i = new Intent(this, EncuestaActivity.class);
                       i.putExtra("nombre", nombreS);
                       startActivity(i);

                   }else{
                       Toast.makeText(this, "Ingrese otro id", Toast.LENGTH_SHORT).show();
                   }

                }
        );


    }
}