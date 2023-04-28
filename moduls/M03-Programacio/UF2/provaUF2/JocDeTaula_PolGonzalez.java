package UF2.provaUF2;

import java.util.Scanner;

public class JocDeTaula_PolGonzalez {

    public static void main(String[] args) {

        int[][] tauler = creaTauler();

        int maxIntents = 10;
        int numfitxes = 4;

        Scanner sc = new Scanner(System.in);

        int intents = 0;
        int FitxesNegres = 0;
        while (intents < maxIntents && FitxesNegres < numfitxes) {

            System.out.println("Intent " + (intents + 1) + ":");

            System.out.print("Fila: ");
            int fila = sc.nextInt();
            System.out.print("Columna: ");
            int columna = sc.nextInt();

            if (tocaVora(fila, columna)) {
                System.out.println("No és vàlida. Toca la vora!");
            } else if (existeixFitxa(tauler, fila, columna)) {
                System.out.println("No és vàlida. Ja hi ha una fitxa!");
            } else {
                System.out.println("Perfecte! La posició és vàlida");
                tauler[fila][columna] = 2;
                FitxesNegres++;
            }

            intents++;
        }

        if (FitxesNegres == numfitxes)
            System.out.println("Perfecte! La posició és vàlida Enhorabona! Has guanyat!\n");
        else
            System.out.println("Ho sento. Has perdut :-(");

        mostraTauler(tauler);
    }


    public static int[][] creaTauler() {

        int[][] copiaTauler = new int[8][8];

        int fitxaBlanca = 0;

        do {
            int fila = (int) (Math.random() * 8);
            int columna = (int) (Math.random() * 8);

            if (!existeixFitxa(copiaTauler, fila, columna)) {
                copiaTauler[fila][columna] = 1;
                fitxaBlanca++;
            }
        } while (fitxaBlanca < 20);

        return copiaTauler;
    }


    public static boolean tocaVora(int fila, int columna) {

        return (fila == 1 || fila == 8 ||
                columna == 1 || columna == 8);
    }


    public static boolean existeixFitxa(int[][] tauler, int fila, int columna) {

        boolean hihaFitxa = false;
        if (tauler[fila][columna] != 0)
            hihaFitxa = true;

        return hihaFitxa;

    }


    public static void mostraTauler(int[][] tauler) {

        System.out.println("El tauler: ");
        for (int[] fila : tauler) {
            for (int valor : fila) {
                switch (valor) {
                    case 0:
                        System.out.print(valor + " ");
                        break;
                    case 1:
                        System.out.print("B ");
                        break;
                    case 2:
                        System.out.print("N ");
                        break;
                }
            }
            System.out.println("");
        }

    }

}

