package UF3.practica;

public class Jugador {
     String nom;
     static int punts;
     int posicio;
     int numeroPartides;

    public Jugador(String nom) {
        this.nom = nom;
    }

    public Jugador(String nom, int punts) {
        this.nom = nom;
        this.punts = punts;
    }

    public int getNumeroPartides() {
        return numeroPartides;
    }


    public String getNom() {
        return nom;
    }

    public static int getPunts(String jugador) {
        return punts;
    }

    public void incrementarPunts(int punts) {
        this.punts += punts;
    }


    public int getPosicio() {
        return posicio;
    }


}
