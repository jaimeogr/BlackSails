package classes.tripulacion;

import classes.entidadesMarinas.Embarcacion;

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
