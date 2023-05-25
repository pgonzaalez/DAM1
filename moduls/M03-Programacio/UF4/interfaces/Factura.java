package UF4.Objetos.interfaces;

public class Factura implements Constantes, Variaciones {
    private double totalSinIva;
    public final static double IVA = 0.16;

    public double sinIVA() {
        return totalSinIva;
    }

    public double conIVA() {
        return totalSinIva;
    }

    ;

    public void asignaValor(double x) {
        if (valorMin<x){

        }
    }

    public void rebaja(double t) {

    }
}

