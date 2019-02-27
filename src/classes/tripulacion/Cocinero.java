package classes.tripulacion;

import classes.entidadesMarinas.Embarcacion;
import classes.armamento.Cuchillo;

import java.util.LinkedList;

public class Cocinero extends Rol {

    private LinkedList<Cuchillo> armas;

    public Cocinero(){
        armas = new LinkedList<Cuchillo>();
        armas.add(new Cuchillo());
        armas.add(new Cuchillo());
    }

    @Override
    protected double getCorajeComplementario(Embarcacion embarcacion) {
        return armas.stream().mapToDouble(a -> a.getDanio()).sum();
    }
}
