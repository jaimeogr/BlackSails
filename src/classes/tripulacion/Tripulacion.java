package classes.tripulacion;

import classes.entidadesMarinas.Embarcacion;
import classes.exceptions.IncorrectRoleException;

import java.util.*;

public class Tripulacion {

    private Double corajeBase = new Double(0);
    //TODO: aca hice esto para implementar el primer item de la clasica batalla, es correcto?
    // ver sus implementaciones en esta clase y en la clase Sistema

    private Tripulante capitan;
    private Tripulante contramaestre;

    private LinkedList<Tripulante> cocineros = new LinkedList<Tripulante>();
    private LinkedList<Tripulante> piratas = new LinkedList<Tripulante>();

    public Tripulacion(LinkedList<Tripulante> cocineros, LinkedList<Tripulante> piratas,
                       Tripulante capitan, Tripulante contramaestre) {
        this.capitan = capitan;
        this.contramaestre = contramaestre;
        this.cocineros = cocineros;
        this.piratas = piratas;
    }

    public double getSumaCorajes(Embarcacion embarcacion) {
        double sumaCorajes = 0;
        sumaCorajes += corajeBase;
        sumaCorajes += capitan.getCorajeTotal(embarcacion);
        sumaCorajes += contramaestre.getCorajeTotal(embarcacion);
        sumaCorajes += cocineros.stream().mapToDouble(c -> c.getCorajeTotal(embarcacion)).sum();
        sumaCorajes += piratas.stream().mapToDouble(p -> p.getCorajeTotal(embarcacion)).sum();
        return sumaCorajes;
    }

    public double getCorajeDeTripulacionACargoDelContramaestre(Embarcacion embarcacion) {
        return cocineros.stream().mapToDouble(c -> c.getCorajeTotal(embarcacion)).sum()
                + piratas.stream().mapToDouble(p -> p.getCorajeTotal(embarcacion)).sum();
    }

    public Tripulante getTripulanteMasCorajudoIgnorandoCapitanYContramaestre(Embarcacion embarcacion) {
        //TODO: testear especialmente este metodo
        Tripulante posibleMasCorajudo1 =
                Collections.max(cocineros, Comparator.comparing(c -> c.getCorajeTotal(embarcacion)));
        Tripulante posibleMasCorajudo2 =
                Collections.max(piratas, Comparator.comparing(p -> p.getCorajeTotal(embarcacion)));
        if (posibleMasCorajudo1.getCorajeTotal(embarcacion) > posibleMasCorajudo2.getCorajeTotal(embarcacion)) {
            return posibleMasCorajudo1;
        } else {
            return posibleMasCorajudo2;
        }
    }

    public List<Tripulante> ganarUnaBatallaClasica(Embarcacion embPropia) {
        aumentarCorajeBase(new Double(5));
        ArrayList<Tripulante> tripulantesQueSeCambianDeTripulacion = new ArrayList<Tripulante>();
        for (int i = 0; i < 3; i++) {
            Tripulante tripulanteQueCambiaDeTripulacion =
                    getTripulanteMasCorajudoIgnorandoCapitanYContramaestre(embPropia);
            tripulantesQueSeCambianDeTripulacion.add(tripulanteQueCambiaDeTripulacion);
            removerCocineroOPirata(tripulanteQueCambiaDeTripulacion);
        }
        tripulantesQueSeCambianDeTripulacion.add(reemplazarAlContramaestreConElMasCorajudo(embPropia));
        return tripulantesQueSeCambianDeTripulacion;
    }

    public void perderUnaBatallaClasica(Embarcacion embPropia, List<Tripulante> tripulantesVencedores) {
        //TODO: ¿podria haber hecho que el metodo ganarunabatalla retorne un tripulante que podria ser el parametro
        // del nuevo capitan para la embarcacion que perdio?
        // eso seria mejor que la implementacion actual?
        for (int i = 0; i < 3; i++) {
            eliminarAlTripulanteMenosCorajudo(embPropia);
        }
        for (Tripulante t : tripulantesVencedores) {
            if (t.getClass().getName().equals("Contramaestre")) {
                t.cambiarTipo(new Capitan());
                this.capitan = t;
            } else if (t.getClass().getName().equals("Cocinero")) {
                try {
                    agregarCocinero(t);
                } catch (IncorrectRoleException e) {
                    System.out.println("el tripulante nuevo no corresponde al rol de cocinero");
                }
            } else if (t.getClass().getName().equals("Pirata")) {
                try {
                    agregarPirata(t);
                } catch (IncorrectRoleException e) {
                    System.out.println("el tripulante nuevo no corresponde al rol de pirata");
                }
            }
        }
    }


    private void removerCocineroOPirata(Tripulante tripulante) {
        if (tripulante.getClass().getName().equals("Cocinero"))
            cocineros.remove(tripulante);
        else
            piratas.remove(tripulante);
    }

    private void aumentarCorajeBase(Double valorEnQueSeIncrementara) {
        corajeBase += valorEnQueSeIncrementara;
    }

    private void eliminarAlTripulanteMenosCorajudo(Embarcacion emb) {
        //TODO: como podria haber implementado esto de mejor manera?
        Tripulante posibleMenosCorajudo1 =
                Collections.max(cocineros, Comparator.comparing(c -> c.getCorajeTotal(emb)));
        Tripulante posibleMenosCorajudo2 =
                Collections.max(piratas, Comparator.comparing(p -> p.getCorajeTotal(emb)));
        Tripulante auxiliarMenosCorajudo =
                obtenerTripulanteMenosCorajudoDeDos(posibleMenosCorajudo1, posibleMenosCorajudo2, emb);
        // por ahora voy a suponer que el menos corajudo es siempre un cocinero o pirata
        //    auxiliarMenosCorajudo = obtenerTripulanteMenosCorajudoDeDos(auxiliarMenosCorajudo,contramaestre, emb);
        //   auxiliarMenosCorajudo = obtenerTripulanteMenosCorajudoDeDos(auxiliarMenosCorajudo,capitan, emb);
        if (auxiliarMenosCorajudo.obtenerNombreDelRol().equals("Cocinero"))
            cocineros.remove(auxiliarMenosCorajudo);
        if (auxiliarMenosCorajudo.obtenerNombreDelRol().equals("Pirata"))
            piratas.remove(auxiliarMenosCorajudo);
    }

    private Tripulante obtenerTripulanteMenosCorajudoDeDos(Tripulante t1, Tripulante t2, Embarcacion emb) {
        return t1.getCorajeTotal(emb) < t2.getCorajeTotal(emb) ? t1 : t2;
    }

    public void agregarCocinero(Tripulante t) {
        if (t.obtenerNombreDelRol().equals("Cocinero")) {
            cocineros.add(t);
        } else {
            throw new IncorrectRoleException("El Tripulante que se intento agregar como cocinero a la" +
                    " tripulacion no coincide con el rol ´Cocinero´ ");
        }
    }

    public void agregarPirata(Tripulante t) {
        if (t.obtenerNombreDelRol().equals("Pirata")) {
            piratas.add(t);
        } else {
            throw new IncorrectRoleException("El Tripulante que se intento agregar como cocinero a la" +
                    " tripulacion no coincide con el rol ´Pirata´ ");
        }
    }

    public Tripulante reemplazarAlContramaestreConElMasCorajudo(Embarcacion emb) {
        Tripulante contramaestreViejo = contramaestre;
        Tripulante contramaestreNuevo = getTripulanteMasCorajudoIgnorandoCapitanYContramaestre(emb);
        contramaestreNuevo.cambiarTipo(new Contramaestre());
        this.contramaestre = contramaestreNuevo;
        return contramaestreViejo;
    }
}
