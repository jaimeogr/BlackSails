package classes.armamento;

public class Pistola implements Armamento {
    private double calibre;
    private double indiceDeDureza;

    public Pistola(double calibre, double indiceDeDureza) {
        this.calibre = calibre;
        this.indiceDeDureza = indiceDeDureza;
    }

    @Override
    public double getDanio() {
        return calibre * indiceDeDureza;
    }
}
