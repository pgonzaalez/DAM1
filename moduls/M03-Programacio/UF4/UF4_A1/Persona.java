package UF4.Objetos.UF4_A1;

public class Persona extends Animal{
    public String nom;
    public int dni;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void hablar(){
        System.out.println("Buenos Dias");
    }
}
