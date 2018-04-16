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
 * Created by USER on 25/09/2017.
 */

public class Cuadrado  extends AppCompatActivity {
    private Resources resources;
    private EditText lado;
    private Intent i;
    private Bundle b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuadrado);
        resources = this.getResources();

        lado = (EditText) findViewById(R.id.txtCuadro);
        i = new Intent(this, Principal.class);
        b = new Bundle();
    }

    public void areaCuadrado(View v){
        if (validar()){
            double numero, resultado;
            String operacion="", dato="";
            numero = Double.parseDouble((lado.getText().toString()));
            resultado = numero * numero;
            dato = resources.getString(R.string.lado_puntos) + lado.getText().toString();
            operacion = resources.getString(R.string.operacion_cuadrado);
            b.putDouble(resources.getString(R.string.area_sin_puntos), resultado);
            i.putExtras(b);

            Operaciones ope = new Operaciones(operacion,dato,String.valueOf(resultado));
            ope.guardar();
            mostrarMensaje(String.valueOf(resultado));
        }
    }

    public void mostrarMensaje(String resultado){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(resources.getString(R.string.area_puntos) + resultado)
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

    public void borrar (View v){
        lado.setText("");
        lado.requestFocus();
    }
    public boolean validar(){
        if (lado.getText().toString().isEmpty()){
            lado.setError(resources.getString(R.string.ingrese_valor_del_lado));
            return false;
        }
        return true;
    }

}

