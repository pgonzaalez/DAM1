/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package UF4.lords_of_steel;
public abstract class Personatge {
    protected String nom;
    protected int força;
    protected int constitucio;
    protected int velocitat;
    protected int inteligencia;
    protected int sort;
    protected Arma arma;

    //Estadistiques derivades

    protected int ps; // punts de salut
    protected int pd; // punts de dany
    protected int pa; // prob. d'atacar
    protected int pe; // prob. d'esquivar

    public Personatge(String nom,int força, int constitucio, int velocitat, int intelligencia, int sort, Arma arma) {
        this.nom = nom;
        this.força = força;
        this.constitucio = constitucio;
        this.velocitat = velocitat;
        this.inteligencia = intelligencia;
        this.sort = sort;
        this.arma = arma;
        calculDeEstadistiquesDerivades();
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setForça(int força) {
        this.força = força;
    }

    public void setConstitucio(int constitucio) {
        this.constitucio = constitucio;
    }

    public void setVelocitat(int velocitat) {
        this.velocitat = velocitat;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public void setPd(int pd) {
        this.pd = pd;
    }

    public void setPa(int pa) {
        this.pa = pa;
    }

    public void setPe(int pe) {
        this.pe = pe;
    }


    protected void calculDeEstadistiquesDerivades() {
        ps=constitucio+força;
        pd=(força+arma.getWpow())/4;
        pa=inteligencia+sort+arma.getWvel();
        pe=velocitat+sort+inteligencia;
    }

    public int getForça() {
        return força;
    }

    public int getConstitucio() {
        return constitucio;
    }

    public int getVelocitat() {
        return velocitat;
    }

    public int getIntelligencia() {
        return inteligencia;
    }

    public int getSort() {
        return sort;
    }

    public String getNom() {
        return nom;
    }

    public Arma getArma() {
        return arma;
    }

    public int getPs() {
        return ps;
    }

    public int getPd() {
        return pd;
    }

    public int getPa() {
        return pa;
    }

    public int getPe() {
        return pe;
    }

    public void restauraPS(){
        this.ps = (int)(this.ps *1.1);
    }
     public boolean Contraatact(Dau ... d){
       int valor = d[0].llencar()+d[1].llencar()+d[2].llencar();
        if (valor<=(this.getPa()/2))
            return true;
        else
            return false;
    }
    public abstract void mostrarNomTipus();

}
