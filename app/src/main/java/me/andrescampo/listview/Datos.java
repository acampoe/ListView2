package me.andrescampo.listview;

import java.util.ArrayList;

/**
 * Created by USER on 25/09/2017.
 */

public class Datos {
    private static ArrayList<Operaciones> operaciones = new ArrayList<>();

    public static void guardar(Operaciones o) {

        operaciones.add(o);
    }

    public static ArrayList<Operaciones> getOperaciones(){
        return operaciones;
    }
}
