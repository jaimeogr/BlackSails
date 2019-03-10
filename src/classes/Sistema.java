package classes;

import classes.entidadesMarinas.Embarcacion;

import java.util.ArrayList;

public class Sistema {
    private static Sistema ourInstance = new Sistema();
    public static Sistema getInstance() {
        return ourInstance;
    }

    private static double distanciaProblematica = 3;

    private Sistema() {


    }

    private void configurar (){
        //TODO: crear threads que verifiquen los conflictos entre entidades marinas y llamar a este metodo en el constructor;
        ArrayList<Embarcacion> embarcaciones = new ArrayList<Embarcacion>();

    }

    public void clasicaBatalla (){


    }

    private boolean puedeHaberConflictoEntreDosEmbarcaciones(Embarcacion embarcacion1, Embarcacion embarcacion2) {
        boolean resultado = true;
        if (!embarcacion1.getOceano().equals(embarcacion2.getOceano())) { //si los oceanos son diferentes, ya retorna false
            resultado = false;
        } else {
            Double distanciaActual = embarcacion1.getEjesCartesianos().distance(embarcacion2.getEjesCartesianos());
            if (distanciaActual > distanciaProblematica)
                resultado = false;
        }
        return resultado;
    }


}
