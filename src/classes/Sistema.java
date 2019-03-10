package classes;

import classes.entidadesMarinas.Embarcacion;
import classes.tripulacion.Tripulante;

import java.util.ArrayList;
import java.util.List;

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

    public void clasicaBatalla (Embarcacion emb1, Embarcacion emb2){
        Embarcacion embGanadora = emb1;
        Embarcacion embPerdedora = emb2;
        if(emb1.getPoderDeDanioCanionesMasCorajes() < emb2.getPoderDeDanioCanionesMasCorajes()){
            embGanadora = emb2;
            embPerdedora = emb1;
        }
        List<Tripulante> tripulantesNuevos = embGanadora.ganarClasicaBatalla();
        embPerdedora.perderClasicaBatalla(tripulantesNuevos);

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
