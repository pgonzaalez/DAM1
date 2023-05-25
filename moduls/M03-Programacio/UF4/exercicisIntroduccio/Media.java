package UF4.Objetos.exercicisIntroduccio;

public class Media {
    private String nom;
    private String autor;

    private int duradaSegons;


    public String getNom() {
        return nom;
    }

    public String getAutor() {
        return autor;
    }
    public int getDuradaSegons() {
        return duradaSegons;
    }

    public void setNom(String n) {
        this.nom = n;
    }

    public void setAutor(String a) {
        this.autor = a;
    }

    public void setDuradaSegons(int d) {
        this.duradaSegons = d;
    }

    public static void main(String[] args) {
        Media a = new Media();

        a.setAutor("pgonzalez");
        a.setNom("Pedro");
        a.setDuradaSegons(4);

        System.out.println("Nom = " + a.getNom());
        System.out.println("Autor = " + a.getAutor());
        System.out.println("DuradaSegons = " + a.getDuradaSegons());
    }
}
