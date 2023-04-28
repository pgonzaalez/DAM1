package UF2.soluciones;
import java.util.Scanner;
public class JocDeTaula {
    static final int CASELLESPERFILA = 8;
    static final int TOTALBLANQUES = 20;

    public static void main(String[] args) {

        int[][] tauler = creaTauler();

        final int MAXINTENTS = 10;
        final int MAXFITXESNEGRES = 4;

        Scanner sc = new Scanner(System.in);

        int intents = 0;
        int totalFitxesNegres = 0;
        while (intents < MAXINTENTS && totalFitxesNegres < MAXFITXESNEGRES) {

            System.out.println("Intent " + (intents+1) + ":");

            System.out.print("Fila: ");
            int fila = sc.nextInt();
            System.out.print("Columna: ");
            int columna = sc.nextInt();

            if (tocaVora(fila,columna)) {
                System.out.println("No és vàlida. Toca la vora!");
            } else if (hihaFitxa(tauler,fila,columna)) {
                System.out.println("No és vàlida. Ja hi ha una fitxa!");
            } else {
                System.out.println("Perfecte! La posició és vàlida");
                tauler[fila][columna] = 2;
                totalFitxesNegres++;
            }

            intents++;
        }

        if (totalFitxesNegres == MAXFITXESNEGRES)
            System.out.println("Enhorabona! Has guanyat!");
        else
            System.out.println("Ho sento. Has perdut :-(");

        mostraTauler(tauler);
    }


    public static int[][] creaTauler() {

        int[][] taulerNou = new int[CASELLESPERFILA][CASELLESPERFILA];

        int fitxesBlanques = 0;

        do {
            int fila    = (int)(Math.random()*CASELLESPERFILA);
            int columna = (int)(Math.random()*CASELLESPERFILA);

            if (!hihaFitxa(taulerNou,fila,columna)) {
                taulerNou[fila][columna] = 1;
                fitxesBlanques++;
            }
        } while (fitxesBlanques < TOTALBLANQUES);

        return taulerNou;
    }


    public static boolean tocaVora(int fila,int columna) {

        return (fila == 1 || fila == CASELLESPERFILA ||
                columna == 1 || columna == CASELLESPERFILA);
    }


    public static boolean hihaFitxa(int[][] tauler, int fila, int columna) {

        boolean resultat = false;
        if (tauler[fila][columna] != 0)
            resultat = true;

        return resultat;

    }


    public static void mostraTauler(int[][] tauler) {

        System.out.println("El tauler:");
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
