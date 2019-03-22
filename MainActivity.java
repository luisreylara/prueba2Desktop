package movilapp.com.competencias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnNuevo, btnConsul, btnCita, btnBuscarCita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNuevo = (Button)findViewById(R.id.btnNuevo);
        btnConsul = (Button)findViewById(R.id.btnConsul);
        btnCita = (Button)findViewById(R.id.btnCita);
        btnBuscarCita = (Button)findViewById(R.id.btnBuscarCita);

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nuevo = new Intent(MainActivity.this, Registro.class);
                startActivity(nuevo);
            }
        });
        btnCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent citas = new Intent(MainActivity.this, Citas.class);
                startActivity(citas);
            }
        });
        btnConsul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent consul = new Intent(MainActivity.this, Consultas.class);
                startActivity(consul);
            }
        });
        btnBuscarCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buscarcita = new Intent(MainActivity.this, BusCitas.class);
                startActivity(buscarcita);
            }
        });
    }
}
