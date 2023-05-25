package UF4.Objetos.UF4_A1.ejercicios;

import java.util.ArrayList;

public class LlistaDeLaCompra {
    private String nomProducte;

    private int quantitat;

    private double preuUnitat;

    ArrayList llistaCompraItems = new ArrayList<>();

     double getImportTotal(){


         return 2;
     }

     void afegir(ArrayList llistaCompraItems){

     }

     String getTiquetCompra(){
         String a = "re";
         return a;
     }

    public String getNomProducte() {
        return nomProducte;
    }

    public double getPreuUnitat() {
        return preuUnitat;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setNomProducte(String nomProducte) {
        this.nomProducte = nomProducte;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }

    public void setLlistaCompraItems(ArrayList llistaCompraItems) {
        this.llistaCompraItems = llistaCompraItems;
    }

    public void setPreuUnitat(double preuUnitat) {
        this.preuUnitat = preuUnitat;
    }
}
