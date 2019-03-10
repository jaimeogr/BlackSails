package classes.armamento;

public class Canion implements Armamento {


    private double danio;
    private int anios;

    public Canion (double danio, int anios){
        this.danio = danio;
        this.anios = anios;
    }

    @Override
    public double getDanio() {
        return danio * Math.max(0,  (1 - anios/100));
    }

    //TODO: desgastar segun el año y el daño recibido (verificar esto, creo q es cuando lo ataca una ballena)
}
