package classes.entidadesMarinas;

import java.awt.*;

public abstract class EntidadMarina {
    protected String oceano;
    protected Point ejesCartesianos;


    public EntidadMarina (Double x, Double y, String oceano){
        ejesCartesianos.setLocation(x,y);
        this.oceano = oceano;
    }

    public Point getEjesCartesianos(){
        return ejesCartesianos;
    }

    public String getOceano() {
        return oceano;
    }
}
