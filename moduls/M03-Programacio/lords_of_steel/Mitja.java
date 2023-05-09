/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF4.lords_of_steel;
public class Mitja extends Personatge{
    public Mitja(String nom,int força, int constitucio, int velocitat, int intelligencia, int sort, Arma arma){
        super(nom,força,constitucio,velocitat,intelligencia,sort, arma);
    }
    
    protected void calculDeEstadistiquesDerivades() {
        super.calculDeEstadistiquesDerivades();        
        pe=velocitat+sort+inteligencia+força;

    }
    @Override
    public void mostrarNomTipus() {
        System.out.println("Mitja");
    }
}
