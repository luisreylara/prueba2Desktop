package movilapp.com.competencias;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Uriel on 07/12/2017.
 */

public class DB_Pacientes extends SQLiteOpenHelper {

    public DB_Pacientes(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "DB_Pacientes", factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table paciente(curp varchar(25) primary key, " +
                "nombre text, " +
                "email varchar(50), " +
                "edad integer, " +
                "pesoinicial integer, " +
                "fechapesoinicial varchar (20), " +
                "masamuscular integer, " +
                "fechamasa varchar (25))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String guardar(String curp, String nombre, String email, String edad, String pesoinicial, String fechapesoinicial, String masamuscular, String fechamasa) {
        String mensaje_pc = "";
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contenedor = new ContentValues();
        contenedor.put("curp", curp);
        contenedor.put("nombre", nombre);
        contenedor.put("email", email);
        contenedor.put("edad", edad);
        contenedor.put("pesoinicial", pesoinicial);
        contenedor.put("fechapesoinicial", fechapesoinicial);
        contenedor.put("masamuscular", masamuscular);
        contenedor.put("fechamasa", fechamasa);

        try {
            database.insertOrThrow("paciente", null, contenedor);
            mensaje_pc = "Ingresado";
        } catch (SQLException e) {
            mensaje_pc = "No Ingresado";
        }
        database.close();
        return mensaje_pc;
    }

    public String[] buscar_reg(String buscar){

        String[] datos= new String[9];
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT curp, nombre, email, edad, pesoinicial, fechapesoinicial, masamuscular, fechamasa FROM paciente WHERE curp ='"+buscar+"'";
        Cursor registros = database.rawQuery(q, null);

        if (registros.moveToNext()){
            for(int i = 0 ; i<8; i++){
                datos[i]= registros.getString(i);
            }
            datos[8]= "Encontrado";

        }else{

            datos[8]= "No se encontro a "+buscar;
        }
        database.close();
        return datos;
    }
}