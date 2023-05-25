package UF4.Objetos.UF4_A1;


public class Persones {
    private String nom;
    private int edat;
    private char sexe;
    private int dni;

    public static void main(String[] args) {
        Persones p1 = new Persones(1);
        Persones p2 = new Persones("Juan", 12, 'h', 1);
        p1.setDni(124);
        p2.setDni(125);
        System.out.println(p1.edat + " " + p1.nom + " " + p1.sexe + " " + p1.dni);
        System.out.println(p2.edat + " " + p2.nom + " " + p2.sexe + " " + p2.dni);
        p2.aumentaEdat();
        System.out.println(p1.edat + " " + p1.nom + " " + p1.sexe + " " + p1.dni);
        System.out.println(p2.edat + " " + p2.nom + " " + p2.sexe + " " + p2.dni);
        p1.expresaEnSegons();
        p2.expresaEnSegons();

    }


    public Persones(int dni) {
        this.dni = dni;
    }

    public Persones(String nom, int edat, char sexe, int dni) {
        this.nom = nom;
        this.edat = edat;
        this.sexe = sexe;
        this.dni = dni;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        if (sexe == 'h' || sexe == 'H' || sexe == 'd' || sexe == 'D') {
            this.sexe = sexe;
        } else {
            System.out.println("No has posat un sexe vàlid");
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public void aumentaEdat() {
        this.edat++;
    }

    public void expresaEnSegons() {
        System.out.println(this.edat * 365 * 24 * 60 * 60);
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