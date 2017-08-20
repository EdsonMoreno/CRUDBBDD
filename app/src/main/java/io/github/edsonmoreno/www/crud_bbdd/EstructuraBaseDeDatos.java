package io.github.edsonmoreno.www.crud_bbdd;

import android.provider.BaseColumns;

/**
 * Created by Diego on 20/08/2017.
 */

public class EstructuraBaseDeDatos {
    private EstructuraBaseDeDatos(){}

    //Definir estructura de la base de datos
    public static final String NOMBRE_TABLA = "DatosPersoaales";
    public static final String NOMBRE_COLUMNA_UNO = "id";
    public static final String NOMBRE_COLUMNA_DOS = "nombre";
    public static final String NOMBRE_COLUMNA_TRES = "apellido";

    /**
     * Una vez que has definido el aspecto de la base de datos,
     * debes implementar métodos para crear y mantener la base
     * de datos y las tablas. Estas son algunas instrucciones
     * típicas para crear y eliminar una tabla:
     */
    public static final String TEXT_TYPE = " TEXT";
    public static final String COMMA_SEP = ",";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + EstructuraBaseDeDatos.NOMBRE_TABLA + " (" +
                    EstructuraBaseDeDatos.NOMBRE_COLUMNA_UNO + " INTEGER PRIMARY KEY," +
                    EstructuraBaseDeDatos.NOMBRE_COLUMNA_DOS + TEXT_TYPE + COMMA_SEP +
                    EstructuraBaseDeDatos.NOMBRE_COLUMNA_TRES + TEXT_TYPE + " )";

    //elimina las tablas si ya existen
    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + EstructuraBaseDeDatos.NOMBRE_TABLA;
}
