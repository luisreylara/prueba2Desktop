package movilapp.com.competencias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    EditText editText,editText2,editText3,editText4,editText5,editText6,editText7,editText8;
    Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);
        editText5 = (EditText)findViewById(R.id.editText5);
        editText6 = (EditText)findViewById(R.id.editText6);
        editText7 = (EditText)findViewById(R.id.editText7);
        editText8 = (EditText)findViewById(R.id.editText8);
        btnRegistrar = (Button)findViewById(R.id.btnRegistrar);


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB_Pacientes db = new DB_Pacientes(getApplicationContext(),null,null,1);
                    String curp = editText.getText().toString();
                        String nombre = editText2.getText().toString();
                            String email = editText3.getText().toString();
                                String edad = editText4.getText().toString();
                                    String pesoinicial = editText5.getText().toString();
                                        String fechapesoinicial = editText6.getText().toString();
                                            String masamuscular = editText7.getText().toString();
                                                String fechamasa = editText8.getText().toString();
                String mensaje = db.guardar(curp, nombre, email, edad, pesoinicial, fechapesoinicial, masamuscular, fechamasa);
                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();

                editText.setText(null);
                editText2.setText(null);
                editText3.setText(null);
                editText4.setText(null);
                editText5.setText(null);
                editText6.setText(null);
                editText7.setText(null);
                editText8.setText(null);
            }
        });
    }
}
