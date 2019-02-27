package classes;

import classes.armamento.Canion;
import classes.tripulacion.Tripulacion;
import classes.tripulacion.Tripulante;

import java.util.Collections;
import java.util.LinkedList;

public class Embarcacion extends EntidadMarina {
    private static double distanciaProblematica = 3;
    private int monedasDeOro;
    private Tripulacion tripulacion;
    private LinkedList<Canion> caniones = new LinkedList<Canion>();

    public Embarcacion (int monedasDeOro, Tripulacion tripulacion) {
        this.monedasDeOro = monedasDeOro;
        this.tripulacion = tripulacion;
    }

    public double getPoderDeDanioCanionesMasCorajes (){
        return tripulacion.getSumaCorajes(this) + getDanioCaniones();
    }

    public double getDanioCaniones(){
        return caniones.stream().mapToDouble(canion -> canion.getDanio()).sum();
    }

    public double getCorajeDeTripulacionACargoDelContramaestre (){
        return tripulacion.getCorajeDeTripulacionACargoDelContramaestre(this);
    }

    public Tripulante getTripulanteMasCorajudoIgnorandoCapitanYContramaestre (){
        return tripulacion.getTripulanteMasCorajudoIgnorandoCapitanYContramaestre(this);
    }
//
//    public boolean puedeHaberConflictoEntreEmbarcaciones(Embarcacion embarcacionAjena){
//
//        double distance = Math.hypot(x1-x2, y1-y2);
//    }

}
