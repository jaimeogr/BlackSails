package classes.tripulacion;

import classes.entidadesMarinas.Embarcacion;

public class Tripulante {
    private double corajeBase;
    private Rol tipo;
    private Integer inteligencia;

    public Tripulante (double corajeBase, Rol tipo, Integer inteligencia){
        this.corajeBase = corajeBase;
        this.inteligencia = inteligencia;
        this.tipo = tipo;
    }

    public double getCorajeTotal(Embarcacion embarcacion) {
        return corajeBase + tipo.getCorajeComplementario(embarcacion);
    }

    public void cambiarTipo (Rol tipo){
        this.tipo = tipo;
    }

    public Integer getInteligencia() {
        return inteligencia;
    }

    public String obtenerNombreDelRol(){
        return tipo.getClass().getName();
    }
}
