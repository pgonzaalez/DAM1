package UF2.soluciones;

import java.util.Scanner;

public class Ex06_Buscamines {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Digues les files");
        int fila= in.nextInt();
        System.out.println("Digues les columnes");
        int columna= in.nextInt();
        int[][] matriu = generaMatriu(fila, columna, -1, 0);
        mostraMatriu(matriu);
        System.out.println();
        int[][] tauler = comptaMines(matriu);
        mostraMatriu(tauler);
    }

    public static int[][] comptaMines(int[][] entrada) {
        int filas = entrada.length;
        int columnas = entrada[0].length;
        int[][] salida = new int[filas][columnas];

        for (int i = 0; i < entrada.length; i++) {
            for (int j = 0; j < entrada[0].length; j++) {
                if (!esMina(entrada[i][j])) {
                    salida[i][j] = calculaCostats(i, j, entrada);
                } else {
                    salida[i][j] = -1;
                }
            }
        }

        return salida;
    }

    public static int calculaCostats(int fila, int columna, int[][] matriu) {
        int cont = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((fila + i) > -1 && (fila + i) < matriu.length && (columna + j) > -1 && (columna + j) < matriu[0].length) {  //Mirem que no surti del rang de la matriu de 0 al length
                    if (esMina(matriu[(fila + i)][(columna + j)])) {
                        cont++;
                    }
                }
            }
        }
        return cont;
    }
    public static boolean esMina(int posicion) {
        if (posicion < 0) {
            return true;
        }
        return false;
    }

    public static int[][] generaMatriu(int files, int columnes, int min, int max) {
        int[][] matriu = new int[files][columnes];
        for (int posFila = 0; posFila < files; posFila++) {
            for (int posColumna = 0; posColumna < files; posColumna++) {
                int random = (int) Math.floor(Math.random() * (max - min + 1) + min);
                matriu[posFila][posColumna] = random;
            }
        }
        return matriu;

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

}





















