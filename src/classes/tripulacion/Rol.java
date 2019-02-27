package classes.tripulacion;

import classes.entidadesMarinas.Embarcacion;

public abstract class Rol {

    protected abstract double getCorajeComplementario(Embarcacion embarcacion); // TODO: como podria resolver por diseño para no mandar un valor null en el caso de los roles que no utilizan armas?
}
