package lab2apprun.gr11.compumovil.udea.edu.co.lab2apprun;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sala__000 on 31/03/2016.
 */
public class BDHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "corredores.sqlite"; //Nombre del archivo de la base de datos
    private static int DB_SCHEME_VERSION = 1; //Version del esquema de la base de datos
                                                // = version de las tablas y la version de la estructura de la base de datos

    public BDHelper(Context context) {
        super(context, DB_NAME, null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataBaseManager.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
