package classes.entidadesMarinas;

import java.awt.*;

public abstract class EntidadMarina {
    private String oceano;
    private double x;
    private double y;


    public String getUbicacion(){
        return oceano +";"+ x +";"+ y;
    }
}
