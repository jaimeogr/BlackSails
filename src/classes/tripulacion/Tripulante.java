package classes.tripulacion;

import classes.Embarcacion;

public class Tripulante {
    private double corajeBase;
    private Rol tipo;

    public Tripulante (double corajeBase, Rol tipo){
        this.corajeBase = corajeBase;
    }

    public double getCorajeTotal(Embarcacion embarcacion) {
        return corajeBase + tipo.getCorajeComplementario(embarcacion);
    }

    public void cambiarTipo (Rol tipo){
        this.tipo = tipo;
    }
}
