package UF2.Ordenacio;

import java.util.Scanner;
public class ordenacioMatrius {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Digues les files");
        int fila = in.nextInt();

        System.out.println("Digues les columnes");
        int columna = in.nextInt();

        int[][] matriu = new int[fila][columna];

        mostraMatriu(matriu);

    }

    public static void mostraMatriu(int[][] matriu) {
        for (int posFila = 0; posFila < matriu.length; posFila++) {
            System.out.print("| ");
            for (int posColumna = 0; posColumna < matriu.length; posColumna++) {
                matriu[posFila][posColumna] = (int) (Math.random() * 9 + 1);
                System.out.print(matriu[posFila][posColumna] + " ");
            }
            System.out.println("|");
        }

    }
}
