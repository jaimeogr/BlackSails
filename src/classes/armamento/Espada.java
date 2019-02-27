package classes.armamento;

public class Espada implements Armamento {

    private double danio;

    public Espada (double danio){
        this.danio = danio;
    }

    @Override
    public double getDanio() {
        return danio;
    }
}
