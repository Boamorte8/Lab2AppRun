package lab2apprun.gr11.compumovil.udea.edu.co.lab2apprun;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by sala__000 on 31/03/2016.
 */
public class DataBaseManager {

    //Tabla Usuarios
    public static final String TABLE_NAME = "corredores";
    public static final String CR_ID = "_id";
    public static final String CR_NOM = "nombre";
    public static final String CR_USER = "usuario";
    public static final String CR_PASS = "contraseña";


    public static final String CREATE_TABLE = "create table " + TABLE_NAME + "("
            + CR_ID + " integer primary key autoincrement,"
            + CR_NOM + " text not null,"
            + CR_USER + " text not null,"
            + CR_PASS + " text not null);";


    //Tabla Eventos
    public static final String TABLE_NAME2 = "eventos";
    public static final String CAR_ID = "_id";
    public static final String CAR_NOM = "nombre";
    public static final String CAR_DESC = "descripcion";
    public static final String CAR_LUG = "lugar";
    public static final String CAR_FECH = "fecha";
    public static final String CAR_DIST = "distancia";
    public static final String CAR_EMAIL = "correo";
    public static final String CAR_TEL = "telefono";



    private BDHelper helper;
    private SQLiteDatabase db;

    public DataBaseManager(Context context){
        helper = new BDHelper(context);
        db = helper.getWritableDatabase();
    }

    private ContentValues generarCorredoresContentValues(String nombre, String usuario, String password) {
        ContentValues valores = new ContentValues();
        valores.put(CR_NOM, nombre);
        valores.put(CR_USER, usuario);
        valores.put(CR_PASS, password);
        return valores;
    }
    public void insertarCorredor(String nombre, String usuario, String password) {
        //bd.insert(TABLA, NullColumnHack, ContentValues);
        db.insert(TABLE_NAME, null, generarCorredoresContentValues(nombre, usuario, password));
    }
    public void insertarCorredor2(String nombre, String usuario, String password) {
        //INSERT INTO contactos   VALUES (null,'paco',9999)
        db.execSQL("insert into " + TABLE_NAME + " values (null,'" + nombre + "', '" + usuario + "', " + password + ")");
    }
    public void eliminarCorredor(String usuario) {
        //bd.delete (Tabla, Claúsula Where, Argumentos Where)
        db.delete(TABLE_NAME, CR_USER + "=?", new String[]{usuario});
    }

    public void modificarNombre(String usuario, String nuevoNombre, String password) {
        /*bd.update(TABLA, ContentValues, Clausula Where, Argumentos Where)*/
        db.update(TABLE_NAME, generarCorredoresContentValues(nuevoNombre, usuario, password), CR_USER + "=?", new String[]{usuario});
    }

    public boolean loguearUsuario(String usuario, String password) {
        Boolean logueado;
        logueado = false;


        return logueado = true;
    }

    }
