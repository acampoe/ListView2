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

public class Esfera extends AppCompatActivity {
    private EditText radio;
    private Intent i;
    private Bundle b;
    private Resources resources;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.esfera);
        resources = this.getResources();
        radio = (EditText) findViewById(R.id.txtRadiio);
        i = new Intent(this, Principal.class);
        b = new Bundle();
    }

    public void areaEsfera(View v){
        if (validar()){
            double pi=3.14159;
            double numero;
            double resultado;
            String operacion = "", dato="";
            numero = Double.parseDouble((radio.getText().toString()));
            resultado = (4 * pi *(numero * numero * numero)/3 );
            dato = resources.getString(R.string.radio) + radio.getText().toString();
            operacion = resources.getString(R.string.operacion_esfera);

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
        radio.setText("");
        radio.requestFocus();
    }
    public boolean validar(){
        if (radio.getText().toString().isEmpty()){
            radio.setError(resources.getString(R.string.ingrese_radio));
            return false;
        }
        return true;
    }
}
