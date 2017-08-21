package io.github.edsonmoreno.www.crud_bbdd;

import android.content.ContentValues;
import android.database.Cursor;
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

                Toast.makeText(getApplicationContext(),"Se guardo el registroo con clave: "
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
                /**
                 * Para leer de una base de datos, utiliza el método query()
                 * , y pasa tus criterios de selección y columnas deseadas.
                 * El método combina elementos de insert() y update(), excepto
                 * que la lista de columnas define los datos que deseas obtener
                 * , en lugar de los datos a insertar. Los resultados de la
                 * consulta se devuelven en un objeto Cursor.
                 */
                //hacer que se pueda leer la base de datos
                  SQLiteDatabase db = mDbHelper.getReadableDatabase();

                    /* Columnas de la base de datos consultadas
                    g* segun el criterio de ebusqueda
                    en este caso siendo criterio el id para que nos
                    devuelva nomvre y apellido
                    * .*/
                  String[] projection = {EstructuraBaseDeDatos.NOMBRE_COLUMNA_DOS,
                                          EstructuraBaseDeDatos.NOMBRE_COLUMNA_TRES
                                          };

                // Filter results WHERE "title" = 'My Title'
                String selection = EstructuraBaseDeDatos.NOMBRE_COLUMNA_UNO + " = ?";
                //ubicamos elcriterio de busqueda elegido por nosotros
                String[] selectionArgs = { texto_id.getText().toString() };

                // Si hayresultados iguales los ordena segun un criterio
               /* String sortOrder =
                        FeedEntry.COLUMN_NAME_SUBTITLE + " DESC";*/
                try {
                    Cursor c = db.query(
                            EstructuraBaseDeDatos.NOMBRE_TABLA,       // The table to query
                            projection,                               // The columns to return
                            selection,                                // The columns for the WHERE clause
                            selectionArgs,                            // The values for the WHERE clause
                            null,                                     // don't group the rows
                            null,                                     // don't filter by row groups
                            null                                 // The sort order
                    );
                    //Ubicamos elcursor en el primer registro de la tabla en memoria
                    c.moveToFirst();
                    //obtenemos la informacion de la primera columna de la tabla resultado
                    texto_nombre.setText(c.getString(0));
                    texto_apellido.setText(c.getString(1));
                }catch(Exception e ){
                    /*
                    * Si al hacer una consulta el id no existe la instruccion
                    * db.query nos devolvera un registro baio, osea un puntero
                    * nulo al itentar ubicar el curr al inicio de este puntero
                    * nulo se genera una  excepcion que  originaria que el
                    * programa se callera, con este try catch hacemis que al
                    * encontrar la falla, el programa este autorizado a seguir
                    * solo informandonos que la consulta no arrojo ningun
                    * resultado. 
                    * */
                    Toast.makeText(getApplicationContext(),"No se encontro el registroe: ",
                            Toast.LENGTH_LONG).show();
                }
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
