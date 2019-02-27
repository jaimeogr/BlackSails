package classes.tripulacion;

import classes.Embarcacion;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Tripulacion {

    private Tripulante capitan;
    private Tripulante contramaestre;

    private LinkedList<Tripulante> cocineros = new LinkedList<Tripulante>();
    private LinkedList<Tripulante> piratas = new LinkedList<Tripulante>();

    public Tripulacion(LinkedList<Tripulante> cocineros, LinkedList<Tripulante> piratas, Tripulante capitan, Tripulante contramaestre) {
        this.capitan = capitan;
        this.contramaestre = contramaestre;
        this.cocineros = cocineros;
        this.piratas = piratas;
    }

    public double getSumaCorajes(Embarcacion embarcacion) {
        double sumaCorajes = 0;
        sumaCorajes += capitan.getCorajeTotal(embarcacion);
        sumaCorajes += contramaestre.getCorajeTotal(embarcacion);
        sumaCorajes += cocineros.stream().mapToDouble(c -> c.getCorajeTotal(embarcacion)).sum(); //TODO: esto esta bien?
        sumaCorajes += piratas.stream().mapToDouble(p -> p.getCorajeTotal(embarcacion)).sum();
        return sumaCorajes;
    }

    public double getCorajeDeTripulacionACargoDelContramaestre(Embarcacion embarcacion) {
        return cocineros.stream().mapToDouble(c -> c.getCorajeTotal(embarcacion)).sum() + piratas.stream().mapToDouble(p -> p.getCorajeTotal(embarcacion)).sum();
    }


    public Tripulante getTripulanteMasCorajudoIgnorandoCapitanYContramaestre(Embarcacion embarcacion) {
        Tripulante posibleMasCorajudo1 = Collections.max(cocineros, Comparator.comparing(c -> c.getCorajeTotal(embarcacion)));
        Tripulante posibleMasCorajudo2 = Collections.max(piratas, Comparator.comparing(p -> p.getCorajeTotal(embarcacion)));
        if(posibleMasCorajudo1.getCorajeTotal(embarcacion) > posibleMasCorajudo2.getCorajeTotal(embarcacion)){
            return posibleMasCorajudo1;
        }else{
            return posibleMasCorajudo2;
        }
    }
}
