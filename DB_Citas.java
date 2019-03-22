package movilapp.com.competencias;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by urimalagon on 11/12/17.
 */

public class DB_Citas extends SQLiteOpenHelper{

    public DB_Citas(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "DB_Citas", factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table citas(curp varchar(25) primary key, " +
                "nombre text, " +
                "fechacita varchar(50), " +
                "pesoinicial integer, " +
                "masamuscular integer, " +
                "dradr varchar (25))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String guardar(String curp, String nombre, String fechaCita, String pesoInicial, String masaMuscular, String draDr) {
        String mensaje_pc = "";
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contenedor = new ContentValues();
        contenedor.put("curp", curp);
        contenedor.put("nombre", nombre);
        contenedor.put("fechacita",fechaCita);
        contenedor.put("pesoinicial", pesoInicial);
        contenedor.put("masamuscular", masaMuscular);
        contenedor.put("dradr",draDr);

        try {
            database.insertOrThrow("citas", null, contenedor);
            mensaje_pc = "Ingresado";
        } catch (SQLException e) {
            mensaje_pc = "No Ingresado";
        }
        database.close();
        return mensaje_pc;
    }

    public String[] buscar_reg(String buscar){

        String[] datos= new String[7];
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT curp, nombre, fechacita, pesoinicial, masamuscular, dradr FROM citas WHERE curp ='"+buscar+"'";
        Cursor registros = database.rawQuery(q, null);

        if (registros.moveToNext()){
            for(int i = 0 ; i<6; i++){
                datos[i]= registros.getString(i);
            }
            datos[6]= "Encontrado";

        }else{

            datos[6]= "No se encontro a "+buscar;
        }
        database.close();
        return datos;
    }
}
