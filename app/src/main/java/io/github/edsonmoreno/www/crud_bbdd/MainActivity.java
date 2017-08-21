package io.github.edsonmoreno.www.crud_bbdd;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.security.AccessController.getContext;

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

        //instanciadapara acceder a labase de datos
        final BBDDHelper mDbHelper = new BBDDHelper(this);

        //Crendo eventos
        insertar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Gets the data repository in write mode
                SQLiteDatabase db = mDbHelper.getWritableDatabase();

                // Create a new map of values, where column names are the keys
                ContentValues values = new ContentValues();
                //obtenemos el valor del campo uno y lo guardamos en la base de datos
                //una para cada tabla
                values.put(EstructuraBaseDeDatos.NOMBRE_COLUMNA_UNO, texto_id.getText().toString());
                values.put(EstructuraBaseDeDatos.NOMBRE_COLUMNA_DOS, texto_nombre.getText().toString());
                values.put(EstructuraBaseDeDatos.NOMBRE_COLUMNA_TRES, texto_apellido.getText().toString());

                //values.put(EstructuraBaseDeDatos.COLUMN_NAME_SUBTITLE, subtitle);

                // Insert the new row, returning the primary key value of the new row
                long newRowId = db.insert(EstructuraBaseDeDatos.NOMBRE_TABLA, null, values);

                Toast.makeText(getApplicationContext(),"Se guardo el registr con clave: "
                        +newRowId, Toast.LENGTH_LONG).show();
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
