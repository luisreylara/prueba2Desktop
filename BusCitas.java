package movilapp.com.competencias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BusCitas extends AppCompatActivity {

    Button btnConsulta;
    EditText editConsulta;
    TextView txtCurp,txtNombre,txtFechaCita,txtPesoInicial,txtMasaMuscular,txtDraDr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_citas);

        editConsulta = (EditText)findViewById(R.id.editConsulta);
        btnConsulta = (Button)findViewById(R.id.btnConsulta);

        txtCurp = (TextView) findViewById(R.id.txtCurp);
        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtFechaCita = (TextView) findViewById(R.id.txtFechaCita);
        txtPesoInicial = (TextView) findViewById(R.id.txtPesoInicial);
        txtMasaMuscular = (TextView) findViewById(R.id.txtMasaMuscular);
        txtDraDr = (TextView) findViewById(R.id.txtDraDr);

        btnConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscar();
            }
        });
    }

    public void buscar(){
        DB_Citas db = new DB_Citas(getApplicationContext(),null,null,1);

        String buscar = editConsulta.getText().toString();
        String[] datos;
        datos = db.buscar_reg(buscar);

        txtCurp.setText("Curp : "+datos[0]);
        txtNombre.setText("Nombre : "+datos[1]);
        txtFechaCita.setText("Fecha proxima : "+datos[2]);
        txtPesoInicial.setText("Peso inicial : "+datos[3]);
        txtMasaMuscular.setText("Masa muscular inicial : "+datos[4]);
        txtDraDr.setText("Dra./Dr. : "+datos[5]);

        Toast.makeText(getApplicationContext(),datos[6],Toast.LENGTH_SHORT).show();
    }
}
