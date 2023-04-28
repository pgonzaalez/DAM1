package UF2.soluciones;

import java.util.Scanner;

/*Que demani el tipus de figura 2D (quadrat, rectangle, triangle isòsceles o cercle) i a continuació demani 
les dades necessàries per a cadascun i en mostri el perímetre i la superfície*/
public class Ex02_Figures2D {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LecturaDatos lectura = new LecturaDatos();
        double costat, base, altura, radi, perimetre = 0, superficie = 0;
        boolean sortir = false;
        String figura;

        while (!sortir) {
            System.out.println("Indiqui el tipus de figura (quadrat, rectangle, triangle o cercle) o sortir");
            figura = in.nextLine().toLowerCase();
            switch (figura) {
                case "quadrat":
                    costat = lectura.pideDouble(in, "costat");
                    perimetre = perimetreQuadrat(costat);
                    superficie = superficieQuadrat(costat);
                    break;
                case "rectangle":
                    base = lectura.pideDouble(in, "rectangle");
                    altura = lectura.pideDouble(in, "altura");
                    perimetre = perimetreRectangle(base, altura);
                    superficie = superficieRectangle(base, altura);
                    break;
                case "triangle":
                    base = lectura.pideDouble(in, "base");
                    altura = lectura.pideDouble(in, "altura");

                    perimetre = perimetreTriangleIso(base, altura);
                    superficie = superficieTriangleIso(base, altura);
                    break;
                case "cercle":
                    radi = lectura.pideDouble(in, "radi");
                    perimetre = perimetreCercle(radi);
                    superficie = superficieCercle(radi);
                    break;
                case "sortir":
                    sortir = true;
                    break;
            }
            if (sortir != true) {
                System.out.println("Perimetre " + figura + " = " + perimetre);
                System.out.println("Superficie rectangle = " + superficie);
            }
        }
    }

    static double perimetreQuadrat(double costat) {
        return costat * 4;
    }

    static double superficieQuadrat(double costat) {
        return costat * costat;
    }

    static double perimetreRectangle(double base, double altura) {
        return base * 2 + altura * 2;
    }

    static double superficieRectangle(double base, double altura) {
        return base * altura;
    }

    static double perimetreTriangleIso(double base, double altura) {
        double lado = Math.sqrt((base / 2) * (base / 2) + altura * altura);
        return base + 2 * lado;
    }

    static double superficieTriangleIso(double base, double altura) {
        return base * altura / 2;
    }

    static double perimetreCercle(double radi) {
        return 2 * Math.PI * radi;
    }

    static double superficieCercle(double radi) {
        return Math.PI * radi * radi;
    }

}
