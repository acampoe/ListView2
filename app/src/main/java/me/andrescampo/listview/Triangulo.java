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

public class Triangulo extends AppCompatActivity {
    private EditText base, altura;
    private Intent i;
    private Bundle b;
    private Resources resources;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.triangulo);
        resources = this.getResources();

        base = (EditText) findViewById(R.id.txtBaseTriangulo);
        altura = (EditText)findViewById(R.id.txtAlturaTriangulo);
        i = new Intent(this, Principal.class);
        b = new Bundle();
    }

    public void areaTriangulo(View v){
       if (validar()){
           double base,altura, resultado;
           String operacion="", dato="";
           base = Double.parseDouble((this.base.getText().toString()));
           altura = Double.parseDouble(this.altura.getText().toString());
           resultado = (base * altura)/2;
           dato = resources.getString(R.string.base_puntos) + this.base.getText().toString()+ ", " +
                   resources.getString(R.string.altura_puntos)+ this.altura.getText().toString();

           operacion = resources.getString(R.string.operacion_triangulo);

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
        altura.setText("");
        base.setText("");
        altura.requestFocus();
    }
    public boolean validar(){
        if (altura.getText().toString().isEmpty()){
            altura.setError(resources.getString(R.string.ingrese_altura));
            altura.requestFocus();
            return false;
        }
        if (base.getText().toString().isEmpty()){
            base.setError(resources.getString(R.string.ingrese_base));
            base.requestFocus();
            return false;
        }
        return true;
    }
}
