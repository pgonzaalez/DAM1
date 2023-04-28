import java.util.Scanner;

public class Figures3D {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String figura = "x";

        do {
            figura = demanaFigura(figura);
            if ("s".equals(figura)) {
            } else {
                switch (figura.toLowerCase()) {
                    case "c":
                        System.out.println("==Cilindre==");
                        double radi = demanarRadiCilindre(in);
                        double altura = demanaralturaCilindre(in);

                        double perimetre = perimetreCilindre(radi);
                        double superficie = superficieCilindre(radi, altura);

                        mostrarResultats(perimetre, superficie);
                        break;

                    case "h":
                        System.out.println("==Hexaedre==");
                        double alturaHexaedre = demanarCostatHexaedre(in);

                        perimetre = perimetreHexaedre(alturaHexaedre);
                        superficie = superficieHexaedre(alturaHexaedre);
                        mostrarResultats(perimetre, superficie);
                        break;
                    case "t":
                        System.out.println("==Triangle isòsceles==");
                        double aresta = demanarArestaTetraedre(in);

                        perimetre = perimetreTetraedre(aresta);
                        superficie = superficieTetraedre(aresta);
                        mostrarResultats(perimetre, superficie);
                        break;
                    case "e":
                        System.out.println("==Esfera==");
                        radi = demanarRadiEsfera(in);

                        perimetre = perimetreEsfera(radi);
                        superficie = superficieEsfera(radi);
                        mostrarResultats(perimetre, superficie);
                        break;
                }
            }
        } while (!"s".equals(figura));

    }

    public static String demanaFigura(String figura) {
        Scanner in = new Scanner(System.in);
        figura = in.next();
        return figura;
    }

    //Funcions per demandar dades

    public static double demanarRadiCilindre(Scanner in) {
        double radi = in.nextDouble();
        return radi;
    }

    public static double demanaralturaCilindre(Scanner in) {
        double altura = in.nextDouble();
        return altura;
    }

    public static double demanarCostatHexaedre(Scanner in) {
        double altura = in.nextDouble();
        return altura;
    }

    public static double demanarArestaTetraedre(Scanner in) {
        double aresta = in.nextDouble();
        return aresta;
    }

    public static double demanarRadiEsfera(Scanner in) {
        double radi = in.nextDouble();
        return radi;
    }

    //Funcions per realitzar les operacions

    public static double perimetreCilindre(double radi) {
        double resultat =
                resultat = (radi * 2) * Math.PI;

        return resultat;
    }

    public static double superficieCilindre(double radi, double altura) {
        double resultat;
        resultat = (2 * Math.PI * radi * altura) + (2 * Math.PI * Math.pow(radi, 2));
        return resultat;
    }

    public static double perimetreHexaedre(double altura) {
        double resultat;
        resultat = Math.pow(altura, altura) * altura;
        return resultat;
    }

    public static double superficieHexaedre(double altura) {
        double resultat;
        resultat = 6 * Math.pow(altura, 2);
        return resultat;
    }

    public static double perimetreTetraedre(double aresta) {
        double resultat;
        resultat = aresta / Math.sqrt(6);
        return resultat;

    }

    public static double superficieTetraedre(double aresta) {
        double resultat = 0;
        resultat = Math.pow(aresta, 2) * Math.sqrt(3);

        return resultat;
    }

    public static double perimetreEsfera(double radi) {
        double resultat = 0;
        resultat = 4 * Math.PI * Math.pow(radi, 2);
        return resultat;
    }

    public static double superficieEsfera(double radi) {
        double resultat = 0;
        resultat = (4 / 3) * Math.PI * Math.pow(radi, 3);
        return resultat;
    }


    // Mostra els resultats
    public static void mostrarResultats(double perimetre, double superficie) {
        System.out.printf("Superfície: %.2f%n", superficie);
        System.out.printf("Volum: %.2f%n", perimetre);

    }
}
