package classes.entidadesMarinas;

import classes.armamento.Canion;
import classes.tripulacion.Tripulacion;
import classes.tripulacion.Tripulante;

import java.util.LinkedList;

public class Embarcacion extends EntidadMarina {
    private int monedasDeOro;
    private Tripulacion tripulacion;
    private LinkedList<Canion> caniones = new LinkedList<Canion>();

    public Embarcacion(int monedasDeOro, Tripulacion tripulacion, Double x, Double y, String oceano) {
        super(x, y, oceano);
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

}
