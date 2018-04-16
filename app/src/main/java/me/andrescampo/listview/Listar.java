package me.andrescampo.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by USER on 25/09/2017.
 */

public class Listar extends AppCompatActivity {
    private TableLayout t;
    private ArrayList<Operaciones> operaciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar);

        t = (TableLayout)findViewById(R.id.tablaOperaciones);
        operaciones = Datos.getOperaciones();

        for (int i = 0;  i < operaciones.size(); i++){
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);
            TextView c4 = new TextView(this);

            c1.setText(""+(i+1));
            c2.setText(operaciones.get(i).getOperaciones());
            c3.setText(operaciones.get(i).getResultados());
            c4.setText(operaciones.get(i).getDatos());

            fila.addView(c1);
            fila.addView(c2);
            fila.addView(c3);
            fila.addView(c4);
            t.addView(fila);
        }
    }
}
