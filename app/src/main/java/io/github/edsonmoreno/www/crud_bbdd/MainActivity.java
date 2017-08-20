package io.github.edsonmoreno.www.crud_bbdd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Botones
        insertar = (Button) findViewById(R.id.insertar);
        actualizar = (Button) findViewById(R.id.actualizar);
        borrar = (Button) findViewById(R.id.borrar);
        buscar = (Button) findViewById(R.id.buscar);

        //Cuadros de texto
        texto_id = (EditText) findViewById(R.id.id);
        texto_apellido = (EditText) findViewById(R.id.aapellido);
        texto_nombre = (EditText) findViewById(R.id.nombre);

        //Crendo eventos
        insertar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        actualizar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        buscar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        borrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
    }

    private Button insertar, actualizar, borrar, buscar;
    private EditText texto_id, texto_nombre, texto_apellido;
}
