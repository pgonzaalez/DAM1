/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package UF4.Objetos.lords_of_steel;

public class Nan extends Personatge{
    public Nan(String nom,int força, int constitucio, int velocitat, int intelligencia, int sort, Arma arma){
        super(nom,força,constitucio,velocitat,intelligencia,sort,arma);
    }
    
    @Override
    protected void calculDeEstadistiquesDerivades() {
        super.calculDeEstadistiquesDerivades();
        pd=(força+arma.getWpow()+constitucio)/4;

    }

    @Override
    public void mostrarNomTipus() {
        System.out.println("Nan");
    }
}
