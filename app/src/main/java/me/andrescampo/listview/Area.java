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
 * Created by USER on 25/09/2017.
 */

public class Area extends AppCompatActivity{
    private ListView l;
    private Resources res;
    private String [] opc;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.areas);
        l = (ListView)findViewById(R.id.area_opciones);
        res = this.getResources();
        opc = res.getStringArray(R.array.Areas);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,opc);
        l.setAdapter(adapter);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        i = new Intent(Area.this, Cuadrado.class);
                        startActivity(i);
                        break;

                    case 1:
                        i = new Intent(Area.this, Rectangulo.class);
                        startActivity(i);
                        break;
                    case 2:
                        i = new Intent(Area.this, Triangulo.class);
                        startActivity(i);
                        break;
                    case 3:
                        i = new Intent(Area.this, Circulo.class);
                        startActivity(i);
                        break;


                }
            }
        });
    }
}
