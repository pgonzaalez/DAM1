package UF2.soluciones;

import java.util.Scanner;

public class Ex02_TaulesMultiplicar_final {

    static int COLUMNES_MOSTRAR = 4;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalTaules = demanaInt("Introdueix fins a quina taula vols arribar", in);
        int taulaFinal;
        for (int taula = 1; taula <= totalTaules; taula += COLUMNES_MOSTRAR) {
            taulaFinal = Math.min(totalTaules, taula + COLUMNES_MOSTRAR - 1);
                        /*
                        //BLOCK EXPLICATIU
                        Imaginem que l'usuari posa 6 taules
                            A la primera volta del bucle tindrem (TAULA = 1):
                                       taulaFinal = Math.min (6,(1+4-1))
                                           taulaFinal = Math.min (6,4)
                                                taulaFinal = 4;
                            A la segona volta del bucle tindrem (TAULA = 5):
                                       taulaFinal = Math.min (6,(5+4-1))
                                           taulaFinal = Math.min (6,8)
                                                taulaFinal = 6;
                        System.out.println("Taula FInal = " + taulaFinal);
                        */
            generaBlocsTaules(taula, taulaFinal);
        }

    }

    public static void generaBlocsTaules(int taulaInici, int taulaFinal) {
        for (int j = 1; j <= 10; j++) {
            System.out.println(mostraLinea(j,taulaInici,taulaFinal));
        }
        System.out.println("");
    }

    public static String mostraLinea(int taula, int taulaInici, int taulaFinal) {
        String linea = "";
        for (int i = taulaInici; i <= taulaFinal; i++) {
            linea += lineaTaula(i,taula) + "\t";
        }
        return linea;
    }

    public static String lineaTaula(int taula, int num) {
        return  taula+ " x " + num + " = " + taula * num;
    }

    public static int demanaInt(String missatge, Scanner in) {
        int num = 0;
        do {
            System.out.println(missatge);
            if (in.hasNextInt()) {
                num = in.nextInt();
            }
            in.nextLine();
        } while (num == 0);
        return num;
    }
}
