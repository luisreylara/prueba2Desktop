package movilapp.com.competencias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Citas extends AppCompatActivity {

    EditText editCurp,editNombre,editFecha,editPesoInicial,editMasaMuscular,editDraDr;
    Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);

        editCurp = (EditText)findViewById(R.id.editCurp);
        editNombre = (EditText)findViewById(R.id.editNombre);
        editFecha = (EditText)findViewById(R.id.editFecha);
        editPesoInicial = (EditText)findViewById(R.id.editPesoInicial);
        editMasaMuscular = (EditText)findViewById(R.id.editMasaMuscular);
        editDraDr = (EditText)findViewById(R.id.editDraDr);
        btnRegistro = (Button) findViewById(R.id.btnRegistro);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB_Citas db = new DB_Citas(getApplicationContext(),null,null,1);

                String curp = editCurp.getText().toString();
                String nombre = editNombre.getText().toString();
                String fecha = editFecha.getText().toString();
                String pesoinicial = editPesoInicial.getText().toString();
                String masamuscular = editMasaMuscular.getText().toString();
                String dra_dr = editDraDr.getText().toString();

                String mensaje = db.guardar(curp, nombre, fecha, pesoinicial, masamuscular, dra_dr);
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();

                limpiarEdit();
            }
        });
    }
    public void limpiarEdit(){

        editCurp.setText("");
        editNombre.setText("");
        editFecha.setText("");
        editPesoInicial.setText("");
        editMasaMuscular.setText("");
        editDraDr.setText("");

    }


}
