package classes.tripulacion;

import classes.Embarcacion;
import classes.armamento.Armamento;

import java.util.LinkedList;

public class Pirata extends Rol {

    //TODO: como podria limitar por disenio para que pirata no pueda tener un canion como arma?

    private LinkedList<Armamento> armas = new LinkedList<Armamento>();
    @Override
    protected double getCorajeComplementario(Embarcacion embarcacion) {
        return armas.stream().mapToDouble(a -> a.getDanio()).sum();
    }
}
