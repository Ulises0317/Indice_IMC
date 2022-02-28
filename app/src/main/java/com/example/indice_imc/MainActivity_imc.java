package com.example.indice_imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_imc extends AppCompatActivity {
    public TextView resultado;
    public Button calcular,volver;
    public EditText peso,altura;
    double imc,pes,altu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_imc);

        resultado = (TextView) findViewById(R.id.lbResultado);
        calcular = (Button) findViewById(R.id.btnCalcular);
        volver = (Button) findViewById(R.id.btnAtras1);
        peso = (EditText) findViewById(R.id.txtPeso);
        altura = (EditText) findViewById(R.id.txtAltura);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( peso.getText().toString().equals("") | altura.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Ingrese todos los datos",Toast.LENGTH_LONG).show();
                }
                else
                {
                    pes = Float.parseFloat(peso.getText().toString());
                    altu = Float.parseFloat(altura.getText().toString());
                    imc = Math.round((pes/(altu*altu))*100.0)/100.0;
                    if(imc <18.5)
                    {
                        resultado.setText("Tu Indice de Masa es: "+imc+", Estas Por deajo del peso normal");
                    }
                    else if(imc >=18.5 && imc <=24.9)
                    {
                        resultado.setText("Tu Indice de Masa es: "+imc+", Tienes un peso Normal");
                    }
                    else if (imc>=25.0 && imc <=29.9)
                    {
                        resultado.setText("Tu Indice de Masa es: "+imc+", Tienes Sobrepeso");
                    }
                    else if (imc>=30.0 && imc <=34.9)
                    {
                        resultado.setText("Tu Indice de Masa es: "+imc+", Tienes Obecidad grado 1");

                    }
                    else if (imc>=35.0 && imc <=39.9)
                    {
                        resultado.setText("Tu Indice de Masa es: "+imc+", Tienes Obecidad grado 2");
                    }
                    else if (imc>=40.0 )
                    {
                        resultado.setText("Tu Indice de Masa es: "+imc+", Tienes Obecidad grado 3 (Extrema) ");
                    }

                }

            }
        });


        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

}
