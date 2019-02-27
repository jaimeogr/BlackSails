package classes.tripulacion;

import classes.entidadesMarinas.Embarcacion;

public class Capitan extends Rol {

    @Override
    protected double getCorajeComplementario(Embarcacion embarcacion) {
        return embarcacion.getDanioCaniones() * 0.05;
    }
}
