package UF2.soluciones;

import java.io.IOException;
import java.util.Scanner;

public class Ex03_Penjat_final {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        final int MAX_INTENTS = 8;

        final char[][] estatPenjatInicial
                = {
                    {' ', ' ', ' ', ' ', '_', '_', '_', '_', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', '_', '_', '|', '_', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {'|', ' ', ' ', ' ', ' ', '|', '_', '_', '_', '_', '_', ' '},
                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                    {'|', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '|'}
                };

        // Llista de paraules a endevinar
        final String[] paraules = {
            "balandrau", "bassegoda", "bastiments",
            "bellmunt", "cabrera", "campirme", "canigo",
            "carlit", "caro", "castellsapera", "collbaix",
            "comabona", "comanegra", "comapedrosa", "costabona", "gallinova",
            "matagalls", "montalt", "montardo", "montau",
            "montarbat", "montcau", "montclar", "montcorbisson",
            "monteixo"};

        boolean novaPartida = true;

        do {
            netejaPantalla();

            // Estat gràfic del joc durant la partida
            char[][] estatPenjat = new char[10][12];

            // Inicialitzar el dibuix del penjat
            inicialitzarEstatPenjat(estatPenjatInicial, estatPenjat);
            //mostrarEstatPenjat(estatPenjat);

            // Seleccionar la paraula aleatòriament
            int aleatori = (int) (Math.random() * paraules.length);
            String paraula = paraules[aleatori];
            //char[] paraula = paraulaAEndevinar.toCharArray();

            int totalEncerts = 0, totalErrors = 0;

            // Estructra de dades (array) per saber quines lletres portem encertades
            boolean[] lletresEncertades = new boolean[paraula.length()];

            // Llistat de lletres que hem introduït
            String lletres = "";
            do {
                // Mostrem el penjat
                mostrarEstatPenjat(estatPenjat);

                // Mostrem paraula amb les lletres encertades o no (*)
                mostrarParaula(paraula, lletresEncertades);

                // Mostrem la llista de lletres introduïdes
                mostrarLletresIntroduides(lletres);

                lletres += demanarLletra(lletres);
                char ultimaLletra = lletres.charAt(lletres.length() - 1);

                // Comprovem si la lletra està dins de la paraula.
                // encerts tindrà el total de lletres encertades fins el moment
                int encerts = actualitzarEncerts(paraula,
                        ultimaLletra,
                        lletresEncertades);

                if (encerts > totalEncerts) {
                    totalEncerts = encerts;
                } else {
                    totalErrors++;
                    actualitzarEstatPenjat(estatPenjat, totalErrors);
                }

                netejaPantalla();
            } while (totalEncerts < paraula.length() && totalErrors < MAX_INTENTS);

            mostrarEstatPenjat(estatPenjat);
            mostrarParaula(paraula, lletresEncertades);
            mostrarLletresIntroduides(lletres);

            if (totalErrors < MAX_INTENTS) {
                System.out.println("Enhorabona! Has endevinat la paraula secreta.");
            } else {
                System.out.println("OOOOOoooohhhh! Has perdut!!");
                System.out.println("La paraula secreta era: " + paraula);
            }

            System.out.println("");
            System.out.print("Vols jugar una nova partida? [S/n]: ");
            String resposta = entrada.nextLine().toUpperCase();
            if (resposta.length() == 1 && resposta.charAt(0) != 'S') {
                novaPartida = false;
            }

        } while (novaPartida);

    }

    static void mostrarEstatPenjat(char[][] estat) {
        for (char[] fila : estat) {
            System.out.println(fila);
        }
        System.out.println("");
    }

    static void inicialitzarEstatPenjat(char[][] estatPenjatIni, char[][] estat) {

        for (int i = 0; i < estat.length; ++i) {
            for (int j = 0; j < estat[0].length; ++j) {
                estat[i][j] = estatPenjatIni[i][j];
            }
        }
    }

    static void mostrarParaula(String paraula, boolean[] encertades) {
        System.out.print("Paraula: ");
        for (int i = 0; i < paraula.length(); ++i) {
            if (encertades[i]) {
                System.out.print(paraula.charAt(i));
            } else {
                System.out.print("*");
            }
        }
        System.out.println("");
    }

    static void mostrarLletresIntroduides(String lletres) {
        System.out.print("Lletres: ");
        for (int i = 0; i < lletres.length(); ++i) {
            System.out.print(lletres.charAt(i));
        }
        System.out.println("");
    }

    static String demanarLletra(String lletres) {

        String lletra = "";
        while (true) {
            System.out.print("Introdueix lletra: ");
            lletra = entrada.nextLine().toLowerCase();
            if (lletra.length() == 1 && !existeixLletra(lletres, lletra.charAt(0))) {
                break;
            }
        }

        return lletra;
    }

    static boolean existeixLletra(String lletres, char lletra) {

        for (int i = 0; i < lletres.length(); ++i) {
            if (lletres.charAt(i) == lletra) {
                return true;
            }
        }
        return false;
    }

    static int actualitzarEncerts(String paraula, char lletra, boolean[] lletresEncertades) {

        int totalEncerts = 0;
        for (int i = 0; i < paraula.length(); ++i) {
            if (lletresEncertades[i]) {
                totalEncerts++;
            } else if (paraula.charAt(i) == lletra) {
                lletresEncertades[i] = true;
                totalEncerts++;
            }
        }

        return totalEncerts;
    }

    public static void actualitzarEstatPenjat(char[][] penjat, int errors) {

        switch (errors) {
            case 1:
                penjat[1][7] = '|';
                break;
            case 2:
                penjat[2][7] = 'O';
                break;
            case 3:
                penjat[3][7] = '|';
                break;
            case 4:
                penjat[3][6] = '/';
                break;
            case 5:
                penjat[3][8] = '\\';
                break;
            case 6:
                penjat[4][7] = '|';
                break;
            case 7:
                penjat[5][6] = '/';
                break;
            case 8:
                penjat[5][8] = '\\';
                break;
        }
    }

    static void netejaPantalla() {

        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
        }
    }
}
