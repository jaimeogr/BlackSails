package classes.tripulacion;

import classes.Embarcacion;
import classes.armamento.Armamento;

import java.util.LinkedList;

public abstract class Rol {

    protected abstract double getCorajeComplementario(Embarcacion embarcacion); // TODO: como podria resolver por diseño para no mandar un valor null en el caso de los roles que no utilizan armas?
}
