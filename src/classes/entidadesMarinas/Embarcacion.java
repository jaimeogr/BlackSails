package classes.entidadesMarinas;

import classes.armamento.Canion;
import classes.tripulacion.Tripulacion;
import classes.tripulacion.Tripulante;

import java.util.LinkedList;

public class Embarcacion extends EntidadMarina {
    private static double distanciaProblematica = 3;
    private int monedasDeOro;
    private Tripulacion tripulacion;
    private LinkedList<Canion> caniones = new LinkedList<Canion>();

    public Embarcacion(int monedasDeOro, Tripulacion tripulacion) {
        this.monedasDeOro = monedasDeOro;
        this.tripulacion = tripulacion;
    }

    public double getPoderDeDanioCanionesMasCorajes() {
        return tripulacion.getSumaCorajes(this) + getDanioCaniones();
    }

    public double getDanioCaniones() {
        return caniones.stream().mapToDouble(canion -> canion.getDanio()).sum();
    }

    public double getCorajeDeTripulacionACargoDelContramaestre() {
        return tripulacion.getCorajeDeTripulacionACargoDelContramaestre(this);
    }

    public Tripulante getTripulanteMasCorajudoIgnorandoCapitanYContramaestre() {
        return tripulacion.getTripulanteMasCorajudoIgnorandoCapitanYContramaestre(this);
    }

    public boolean puedeHaberConflictoEntreEmbarcaciones(Embarcacion embarcacionAjena) {
        boolean resultado = true;

        String[] coordenadasThis = this.getUbicacion().split(";");
        String[] coordenadasAjenas = embarcacionAjena.getUbicacion().split(";");

        String oceanoThis = coordenadasThis[1]; //obtengo los oceanos
        String oceanoAjeno = coordenadasAjenas[1];

        double xThis = Double.parseDouble(coordenadasThis[2]); //obtengo las coordenadas X
        double xAjeno = Double.parseDouble(coordenadasAjenas[2]);

        double yThis = Double.parseDouble(coordenadasAjenas[3]); //
        double yAjeno = Double.parseDouble(coordenadasAjenas[3]);

        if (oceanoAjeno.equals(oceanoThis)) { //si los oceanos son diferentes
            double distancia = Math.hypot(xAjeno - xThis, yAjeno - yThis);
            if (distancia > distanciaProblematica) { //si no esta lo suficientemente cerca entonces es false
                resultado = false;
            }
        }else{
            resultado = false;
        }
        return resultado;
    }
}
