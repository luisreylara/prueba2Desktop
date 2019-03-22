package movilapp.com.competencias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Consultas extends AppCompatActivity {

    Button btnConsulta;
    EditText consu;
    TextView txtCurp,txtNombre,txtEmail,txtEdad,txtPesoinicial,txtFechapesoinicial,txtMasamuscular,txtFechamasa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);

        consu = (EditText)findViewById(R.id.editConsulta);
        btnConsulta = (Button)findViewById(R.id.btnConsulta);

        txtCurp = (TextView) findViewById(R.id.txtCurp);
        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtEmail = (TextView) findViewById(R.id.txtFechaCita);
        txtEdad = (TextView) findViewById(R.id.txtPesoInicial);
        txtPesoinicial = (TextView) findViewById(R.id.txtMasaMuscular);
        txtFechapesoinicial = (TextView) findViewById(R.id.txtDraDr);
        txtMasamuscular = (TextView) findViewById(R.id.txtMasamuscular);
        txtFechamasa = (TextView) findViewById(R.id.txtFechamasa);

        btnConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buscar();
            }
        });
    }

    public void buscar(){
        DB_Pacientes db = new DB_Pacientes(getApplicationContext(),null,null,1);

        String buscar = consu.getText().toString();
        String[] datos;
        datos = db.buscar_reg(buscar);

        txtCurp.setText("Curp : "+datos[0]);
        txtNombre.setText("Nombre : "+datos[1]);
        txtEmail.setText("E-mail : "+datos[2]);
        txtEdad.setText("Edad : "+datos[3]);
        txtPesoinicial.setText("Peso inicial : "+datos[4]);
        txtFechapesoinicial.setText("Fecha de peso inicial : "+datos[5]);
        txtMasamuscular.setText("Masa muscular : "+datos[6]);
        txtFechamasa.setText("Fecha de masa muscular : "+datos[7]);

        Toast.makeText(getApplicationContext(),datos[8],Toast.LENGTH_SHORT).show();
    }
}
