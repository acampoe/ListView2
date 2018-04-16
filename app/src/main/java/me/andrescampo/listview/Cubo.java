package me.andrescampo.listview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by USER on 26/09/2017.
 */

public class Cubo extends AppCompatActivity {
    private EditText arista;
    private Intent i;
    private Bundle b;
    private Resources resources;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cubo);
        resources = this.getResources();

        arista = (EditText)findViewById(R.id.txtAristaCubo);
        i = new Intent(this, Principal.class);
        b = new Bundle();
    }

    public void Cubo (View v){
        if (validar()){
            String operacion="", dato="";
            double arista;
            double resultado;

            arista = Double.parseDouble((this.arista.getText().toString()));
            resultado = arista * arista * arista ;
            dato = resources.getString(R.string.arista_puntos) + this.arista.getText().toString();
            operacion = resources.getString(R.string.operacion_cubo);

            b.putDouble(resources.getString(R.string.area_sin_puntos), resultado);
            i.putExtras(b);
            Operaciones ope = new Operaciones(operacion,dato,String.valueOf(resultado));
            ope.guardar();
            mostrarMensaje(String.valueOf(resultado));
        }
    }
    public void mostrarMensaje(String resultado){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(resources.getString(R.string.volumen) + resultado)
                .setTitle( resources.getString(R.string.resultado))
                .setCancelable(false)
                .setNeutralButton(resources.getString(R.string.ok),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                startActivity(i);
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void borrar(View v){
        arista.setText("");
        arista.requestFocus();
    }
    public boolean validar(){
        if (arista.getText().toString().isEmpty()){
            arista.setError(resources.getString(R.string.ingrese_radio));
            return false;
        }
        return true;
    }

}
