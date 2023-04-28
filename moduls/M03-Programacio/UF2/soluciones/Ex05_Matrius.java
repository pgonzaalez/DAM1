package UF2.soluciones;

import java.util.Scanner;

public class Ex05_Matrius {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LecturaDatos lectura = new LecturaDatos();
        boolean sortir = false;
        while (!sortir) {
            System.out.println("1 = manual | 2 = random | 3 = sortir");
            int[][] matriu = new int[0][0];
            switch (in.nextLine()) {
                case "1":
                    matriu = demanaMatriu(lectura.pideEntero(in, "total files"), lectura.pideEntero(in, "total columnes"));
                    mostraMatriu(matriu);
                    break;
                case "2":
                    matriu = generaMatriu(lectura.pideEntero(in, "total files"), lectura.pideEntero(in, "total columnes"), lectura.pideEntero(in, "minim Random"), lectura.pideEntero(in, "maxim Random"));
                    mostraMatriu(matriu);
                    break;
                case "3":
                    sortir = true;
                    break;
            }
        }

    }

    public static void mostraMatriu(int[][] matriu) {
        for (int posFila = 0; posFila < matriu.length; posFila++) {
            System.out.print("|");
            for (int posColumna = 0; posColumna < matriu[0].length; posColumna++) {
                System.out.print("  " + matriu[posFila][posColumna] + "  ");
            }
            System.out.println("|");
        }
    }

    public static int[][] demanaMatriu(int files, int columnes) {
        Scanner in = new Scanner(System.in);//Explicar que això es podria passar per paràmetres
        LecturaDatos lectura = new LecturaDatos();//Explicar que això es podria passar per paràmetres
        int[][] matriu = new int[files][columnes];
        for (int posFila = 0; posFila < files; posFila++) {
            for (int posColumna = 0; posColumna < files; posColumna++) {
                matriu[posFila][posColumna] = lectura.pideEntero(in, posFila + "-" + posColumna);
            }
        }
        return matriu;
    }

    public static int[][] generaMatriu(int files, int columnes, int min, int max) {
        int[][] matriu = new int[files][columnes];
        for (int posFila = 0; posFila < files; posFila++) {
            for (int posColumna = 0; posColumna < files; posColumna++) {
                matriu[posFila][posColumna] = (int) Math.floor(Math.random() * (max - min + 1) + min);
            }
        }
        return matriu;
    }

}