package me.andrescampo.listview;

/**
 * Created by USER on 25/09/2017.
 */

public class Operaciones {

    private String Operaciones,resultados,datos;


    public Operaciones(String operaciones, String resultados, String datos) {
        this.Operaciones = operaciones;
        this.resultados = resultados;
        this.datos = datos;
    }
    public String getOperaciones() {

        return Operaciones;
    }

    public void setOperaciones(String operaciones) {

        Operaciones = operaciones;
    }

    public String getResultados() {

        return resultados;
    }

    public void setResultados(String resultados) {

        this.resultados = resultados;
    }

    public String getDatos() {

        return datos;
    }

    public void setDatos(String datos) {

        this.datos = datos;
    }

    public void guardar(){

        Datos.guardar(this);
    }
}
