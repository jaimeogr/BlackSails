package classes.tripulacion;

import classes.entidadesMarinas.Embarcacion;

public class Contramaestre extends Rol{
    @Override
    protected double getCorajeComplementario(Embarcacion embarcacion) {
        return embarcacion.getCorajeDeTripulacionACargoDelContramaestre() * 0.1;
    }
}
