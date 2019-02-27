package classes.armamento;

public class Insulto implements Armamento {

    private int cantidadDePalabras;
    private double coraje;

    public Insulto (int cantidadDePalabras, double coraje){
        this.cantidadDePalabras = cantidadDePalabras;
        this.coraje = coraje;
    }

    @Override
    public double getDanio() {
        return cantidadDePalabras*coraje;
    }

}
