package examen;

/**
 * @author pgonzalez
 */
import java.util.Scanner;

public class Examen_Figuras2D {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String figura = "x";

        do {
            figura = demanaFigura(figura);
            if ("s".equals(figura)) {
            } else {
                switch (figura.toLowerCase()) {
                    case "q":
                        System.out.println("==Quadrat==");
                        double costat = demanarDadesQuadrat(in);
                        double perimetre = perimetreQuadrat(costat);
                        double superficie = superficieQuadrat(costat);

                        mostrarResultats(perimetre, superficie);
                        break;

                    case "r":
                        System.out.println("==Rectangle==");
                        double altura = demanarAlturaRectangle(in);
                        double base = demanarBaseRectangle(in);
                        
                        perimetre = perimetreRectangle(base, altura);
                        superficie = superficieRectangle(base, altura);

                        mostrarResultats(perimetre, superficie);
                        break;
                    case "t":
                        System.out.println("==Triangle isòsceles==");
                        costat = demanarCostatTriangle(in);
                        base = demanarBaseTriangle(in);
                        altura = Math.sqrt(Math.pow(costat, 2) - Math.pow(base/2, 2));

                        perimetre = perimetreTriangle(base, costat);
                        superficie = superficieTriangle(base, altura);
                        mostrarResultats(perimetre, superficie);
                        break;
                    case "c":
                        System.out.println("==Cercle==");
                        double radi = demanarRadiCercle(in);

                        perimetre = perimetreCercle(radi);
                        superficie = superficieCercle(radi);
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

    public static double demanarDadesQuadrat(Scanner in) {
        double costat = in.nextDouble();
        return costat;
    }

    public static double demanarBaseRectangle(Scanner in) {
        double base = in.nextDouble();
        return base;
    }

    public static double demanarAlturaRectangle(Scanner in) {
        double altura = in.nextDouble();
        return altura;
    }

    public static double demanarBaseTriangle(Scanner in) {
        double base = in.nextDouble();
        return base;
    }

    public static double demanarCostatTriangle(Scanner in) {
        double costat = in.nextDouble();
        return costat;
    }

    public static double demanarRadiCercle(Scanner in) {
        double radi = in.nextDouble();
        return radi;
    }

    public static double perimetreQuadrat(double costat) {
        return costat * 4;
    }

    public static double superficieQuadrat(double costat) {
        return costat * costat;
    }

    public static double perimetreRectangle(double base, double altura) {
        return 2 * base + 2 * altura;
    }

    public static double superficieRectangle(double base, double altura) {
        return base * altura;
    }

    public static double perimetreTriangle(double base, double costat) {
        return 2 * costat + base;
    }

    public static double superficieTriangle(double base, double altura) {
        return base * altura / 2;
    }

    public static double perimetreCercle(double radi) {
        return 2 * Math.PI * radi;
    }

    public static double superficieCercle(double radi) {
        return Math.PI * radi * radi;
    }

    public static void mostrarResultats(double perimetre, double superficie) {
        System.out.printf("Perímetre: %.2f%n", perimetre);
        System.out.printf("Superfície: %.2f%n", superficie);
    }
}
