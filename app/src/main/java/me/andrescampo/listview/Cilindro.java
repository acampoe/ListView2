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

public class Cilindro extends AppCompatActivity {
    private EditText radio, altura;
    private Intent i;
    private Bundle b;
    private Resources resources;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cilindro);
        resources = this.getResources();

        radio = (EditText) findViewById(R.id.txtRadiio);
        altura = (EditText)findViewById(R.id.txtAlturaTriangulo);
        i = new Intent(this, Principal.class);
        b = new Bundle();
    }

    public void volumenCilindro(View v){
       if (validar()){
           double radio;
           double altura;
           double resultado;
           double pi = 3.14159;
           String operacion="", dato="";
           radio = Double.parseDouble((this.radio.getText().toString()));
           altura = Double.parseDouble(this.altura.getText().toString());
           resultado = pi * (radio * radio) * altura;
           dato = resources.getString(R.string.radio) + this.radio.getText().toString() + "," +
                   resources.getString(R.string.altura_puntos) + this.altura.getText().toString();
           operacion = resources.getString(R.string.operacion_cilindro);

           b.putDouble(resources.getString(R.string.area_sin_puntos), resultado);
           i.putExtras(b);
           Operaciones ope = new Operaciones(operacion, dato, String.valueOf(resultado));
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
        altura.setText("");
        radio.requestFocus();
    }

    public boolean validar(){
        if (radio.getText().toString().isEmpty()){
            radio.setError(resources.getString(R.string.ingrese_radio));
            return false;
        }

        if (altura.getText().toString().isEmpty()){
            altura.setError(resources.getString(R.string.ingrese_altura));
            altura.requestFocus();
            return false;
        }
        return true;
    }
}
