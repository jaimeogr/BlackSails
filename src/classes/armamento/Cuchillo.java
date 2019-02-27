package classes.armamento;

public class Cuchillo implements Armamento {
    private static double danio;

    public static void setDanio(double danio) {
        Cuchillo.danio = danio;
    }

    @Override
    public double getDanio() {
        return danio;
    }

}
