package me.andrescampo.listview;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by USER on 26/09/2017.
 */

public class Volumen extends AppCompatActivity {
    private ListView l;
    private Resources res;
    private String [] opc2;
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen);
        l = (ListView)findViewById(R.id.menu_volumen);
        res = this.getResources();
        opc2 = res.getStringArray(R.array.Volumen);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,opc2);
        l.setAdapter(adapter);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        i = new Intent(Volumen.this, Esfera.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(Volumen.this, Cilindro.class);
                        startActivity(i);
                        break;
                    case 2:
                        i = new Intent(Volumen.this, Cono.class);
                        startActivity(i);
                        break;
                    case 3:
                        i = new Intent(Volumen.this, Cubo.class);
                        startActivity(i);
                        break;

                }
            }
        });
    }
}
