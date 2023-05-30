package UF3;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TresEnRatlla {

    static Scanner in = new Scanner(System.in);
    private static final String RANKING_FILE = "ranking.txt";
    private static Map<String, Integer> ranking = new HashMap<>();
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";
    private static List<String> historico = new ArrayList<>();
    private static final String HISTORICO_FILE = "rankingHistorico.txt";

    public static void main(String[] args) {
        cargarDatos();

        char NombreJugador1;
        char NombreJugador2;

        System.out.println(ANSI_PURPLE + "------------" + ANSI_RESET);
        System.out.println("BENVINGUTS AL 3 EN RATLLA");
        System.out.println(ANSI_PURPLE + "------------" + ANSI_RESET);

        int opcion;
        do {
            System.out.println("Tria l'opció que vols:");
            System.out.println("1.- Jugar");
            System.out.println("2.- Veure Ranking");
            System.out.println("3.- Veure històric de partides");
            System.out.println("0.- Sortir");

            opcion = in.nextInt();
            switch (opcion) {
                case 1:
                    // Player 1
                    System.out.println("Introdueix el nom del jugador 1:");
                    NombreJugador1 = in.next().charAt(0);
                    int punts = Jugador.getPunts(String.valueOf(NombreJugador1));
                    if (punts == -1) {
                        System.out.println("Benvingut " + NombreJugador1);
                    } else {
                        System.out.println("Ets el jugador " + punts + " del ranking.");
                    }

                    // Player 2
                    System.out.println("Introdueix el nom del jugador 2:");
                    NombreJugador2 = in.next().charAt(0);
                    int puntsJugador2 = Jugador.getPunts(String.valueOf(NombreJugador2));
                    if (puntsJugador2 == -1) {
                        System.out.println("Benvingut " + NombreJugador2);
                    } else {
                        System.out.println("Ets el jugador " + puntsJugador2 + " del ranking.");
                    }
                    jugar(NombreJugador1, NombreJugador2);
                    break;
                case 2:
                    mostrarRanking();
                    break;
                case 3:
                    MostraPartidesHistoricas();
                    break;
                case 0:
                    System.out.println("Fins aviat!");
                    break;
                default:
                    System.out.println("Opció invàlida.");
                    break;
            }
        } while (opcion != 0);

        guardarDatos();
    }

    public static void jugar(char NombreJugador1, char NombreJugador2) {
        NombreJugador1 = 'X';
        NombreJugador2 = 'O';
        int PuntosJugador1 = 0;
        int PuntosJugador2 = 0;
        char vacio = '-';
        String tornaJugar = " ";
        boolean turno = true;
        char tablero[][] = new char[3][3];

        int fila, columna;
        boolean posValida, correcto;

        do {
            System.out.println("Vols començar a jugar? [s/n] ");
            tornaJugar = in.next().toLowerCase();
            rellenarTablero(tablero, vacio);
            if (tornaJugar.equals("n")) {
            } else {
                while (!acabaPartida(tablero, vacio)) {
                    do {
                        mostrarTurnoActual(turno);
                        mostraTablero(tablero);
                        correcto = false;

                        System.out.println(ANSI_PURPLE + "------------" + ANSI_RESET);
                        System.out.println(ANSI_YELLOW + "Introdueix la fila  [0 - 2]" + ANSI_RESET);
                        fila = in.nextInt();
                        System.out.println(ANSI_PURPLE + "------------" + ANSI_RESET);
                        System.out.println(ANSI_YELLOW + "Introdueix la columna [0 - 2]" + ANSI_RESET);
                        columna = in.nextInt();

                        posValida = validarPosicion(tablero, fila, columna);

                        if (posValida) {
                            if (!comprobaPosicion(tablero, fila, columna, vacio)) {
                                correcto = true;
                            } else {
                                System.out.println("Aquesta casella ja està seleccionada");
                            }
                        } else {
                            System.out.println("La posició escollida no és vàlida en el tauler");
                        }
                    } while (!correcto);

                    if (turno) {
                        insertarValor(tablero, fila, columna, NombreJugador1);
                    } else {
                        insertarValor(tablero, fila, columna, NombreJugador2);
                    }

                    turno = !turno;
                }

                mostraTablero(tablero);
                String resultado = mostraGanador(tablero, NombreJugador1, vacio);

                if (resultado.equals("Empate")) {
                    System.out.println("La partida ha acabat amb un empat!");
                    PuntosJugador1 += 1;
                    PuntosJugador2 += 1;
                } else if (resultado.equals("X")) {
                    System.out.println("Ha guanyat " + NombreJugador1 + "!");
                    PuntosJugador1 += 3;
                } else if (resultado.equals("O")) {
                    System.out.println("Ha guanyat " + NombreJugador2 + "!");
                    PuntosJugador2 += 3;
                }

                ranking.put(String.valueOf(NombreJugador1), PuntosJugador1);
                ranking.put(String.valueOf(NombreJugador2), PuntosJugador2);

                mostraGanador(tablero, NombreJugador1, vacio);
            }
        } while (tornaJugar.equals("s"));
    }

    public static void mostrarRanking() {
        System.out.println("RANKING\n");

        if (ranking.isEmpty()) {
            System.out.println("No hi ha jugadors en el ranking.");
        } else {
            System.out.println("Nom del jugador - Punts");

            for (Map.Entry<String, Integer> entry : ranking.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }

        System.out.println();
    }

    public static void guardarRanking() {
        try {
            FileWriter fileWriter = new FileWriter(RANKING_FILE);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("RANKING");
            bufferedWriter.newLine();

            if (!ranking.isEmpty()) {
                for (Map.Entry<String, Integer> entry : ranking.entrySet()) {
                    bufferedWriter.write(entry.getKey() + "-" + entry.getValue());
                    bufferedWriter.newLine();
                }
            }

            bufferedWriter.write("FIN_RANKING");
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error al guardar el ranking.");
            e.printStackTrace();
        }
    }

    public static void cargarRanking() {
        try {
            FileReader fileReader = new FileReader(RANKING_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals("RANKING")) {
                    ranking.clear();
                    while (!(line = bufferedReader.readLine()).equals("FIN_RANKING")) {
                        String[] data = line.split("-");
                        ranking.put(data[0], Integer.parseInt(data[1]));
                    }
                }
            }

            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de ranking. Se creará uno nuevo al finalizar la ejecución.");
        } catch (IOException e) {
            System.out.println("Error al cargar el ranking.");
            e.printStackTrace();
        }
    }

    public static int contarPartidas(String jugador) {
        int count = 0;

        for (String partida : historico) {
            if (partida.contains(jugador)) {
                count++;
            }
        }

        return count;
    }

    private static void MostraPartidesHistoricas() {
        System.out.println("HISTÒRIC DE PARTIDES\n");

        if (historico.isEmpty()) {
            System.out.println("No hi ha partides en l'històric.");
        } else {
            for (String partida : historico) {
                System.out.println(partida);
            }
        }

        System.out.println();
    }

    public static String getFechaActual() {
        Date fecha = new Date();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(fecha);
    }

    public static void guardarHistorico() {
        try {
            FileWriter fileWriter = new FileWriter(HISTORICO_FILE);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("HISTORICO");
            bufferedWriter.newLine();

            if (!historico.isEmpty()) {
                for (String partida : historico) {
                    bufferedWriter.write(partida);
                    bufferedWriter.newLine();
                }
            }

            bufferedWriter.write("FIN_HISTORICO");
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error al guardar el histórico de partidas.");
            e.printStackTrace();
        }
    }

    public static void cargarHistorico() {
        try {
            FileReader fileReader = new FileReader(HISTORICO_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals("HISTORICO")) {
                    historico.clear();
                    while (!(line = bufferedReader.readLine()).equals("FIN_HISTORICO")) {
                        historico.add(line);
                    }
                }
            }

            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de histórico. Se creará uno nuevo al finalizar la ejecución.");
        } catch (IOException e) {
            System.out.println("Error al cargar el histórico de partidas.");
            e.printStackTrace();
        }
    }

    public static void cargarDatos() {
        cargarRanking();
        cargarHistorico();
    }

    public static void guardarDatos() {
        guardarRanking();
        guardarHistorico();
    }

    public static int obtenerPosicionJugador(String nombreJugador) {
        List<String> rankingOrdenado = new ArrayList<>(ranking.keySet());

        rankingOrdenado.sort((jugador1, jugador2) -> {
            int puntosJugador1 = ranking.get(jugador1);
            int puntosJugador2 = ranking.get(jugador2);

            if (puntosJugador1 != puntosJugador2) {
                return Integer.compare(puntosJugador2, puntosJugador1);
            } else {
                return Integer.compare(contarPartidas(jugador1), contarPartidas(jugador2));
            }
        });

        int posicion = rankingOrdenado.indexOf(nombreJugador);
        return posicion != -1 ? posicion + 1 : -1;
    }

    // Métodos del juego
    public static void rellenarTablero(char[][] tablero, char vacio) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = vacio;
            }
        }
    }

    public static void mostraTablero(char[][] tablero) {
        for (int posFila = 0; posFila < tablero.length; posFila++) {
            System.out.print("| ");
            for (int posColumna = 0; posColumna < tablero.length; posColumna++) {
                System.out.print(tablero[posFila][posColumna] + " ");
            }
            System.out.println("|");
        }
    }

    public static void mostrarTurnoActual(boolean turno) {
        if (turno) {
            System.out.println(ANSI_GREEN + "Le toca al jugador 1" + ANSI_RESET);
        } else {
            System.out.println(ANSI_GREEN + "Le toca al jugador 2" + ANSI_RESET);
        }
    }

    public static boolean validarPosicion(char[][] tablero, int fila, int columna) {
        if (fila >= 0 && fila < tablero.length && columna >= 0 && columna < tablero.length) {
            return true;
        }
        return false;
    }

    public static boolean comprobaPosicion(char[][] matriz, int fila, int columna, char vacio) {
        if (matriz[fila][columna] != vacio) {
            return true;
        }
        return false;
    }

    public static void insertarValor(char[][] matriz, int fila, int columna, char jugador) {
        matriz[fila][columna] = jugador;
    }

    public static char comprobaLinea(char[][] tablero, char vacio) {
        char valorMatriu;
        boolean coincidencia;

        for (int i = 0; i < tablero.length; i++) {
            coincidencia = true;
            valorMatriu = tablero[i][0];
            if (valorMatriu != vacio) {
                for (int j = 1; j < tablero.length; j++) {
                    if (valorMatriu != tablero[i][j]) {
                        coincidencia = false;
                    }
                }
                if (coincidencia) {
                    return valorMatriu;
                }
            }
        }
        return vacio;
    }

    public static char comprobaColumna(char[][] tablero, char vacio) {
        char valorMatriu;
        boolean coincidencia;

        for (int j = 0; j < tablero.length; j++) {
            coincidencia = true;
            valorMatriu = tablero[0][j];
            if (valorMatriu != vacio) {
                for (int i = 1; i < tablero.length; i++) {
                    if (valorMatriu != tablero[i][j]) {
                        coincidencia = false;
                    }
                }
                if (coincidencia) {
                    return valorMatriu;
                }
            }
        }
        return vacio;
    }

    public static char comprobaDiagonal(char[][] tablero, char vacio) {
        char valorMatriu;
        boolean coincidencia = true;

        // Diagonal Esquerra-Dreta
        valorMatriu = tablero[0][0];
        if (valorMatriu != vacio) {
            for (int i = 1; i < tablero.length; i++) {
                if (valorMatriu != tablero[i][i]) {
                    coincidencia = false;
                }
            }
            if (coincidencia) {
                return valorMatriu;
            }
        }

        // Diagonal Dreta-Esquerra
        valorMatriu = tablero[0][2];
        if (valorMatriu != vacio) {
            for (int i = 1, j = 1; i < tablero.length; i++, j--) {
                if (valorMatriu != tablero[i][j]) {
                    coincidencia = false;
                }
            }
            if (coincidencia) {
                return valorMatriu;
            }
        }
        return vacio;
    }

    public static boolean empate(char[][] matriz, char vacio) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == vacio) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void defineGanador(char simbolo, String player1, int tipo) {
        switch (tipo) {
            case 1:
                if (player1.equals(String.valueOf(simbolo))) {
                    System.out.println("Ha guanyat el Jugador 1");
                } else {
                    System.out.println("Ha guanyat el Jugador 2");
                }
                break;
            case 2, 3:
                if (player1.equals(String.valueOf(simbolo))) {
                    System.out.println("Ha guanyat el Jugador 2");
                } else {
                    System.out.println("Ha guanyat el Jugador 1");
                }
                break;
        }
    }

    public static String mostraGanador(char[][] tablero, char player1, char vacio) {
        char simbolo = comprobaLinea(tablero, vacio);

        if (simbolo != vacio) {
            defineGanador(simbolo, String.valueOf(player1), 1);
            return null;
        }

        simbolo = comprobaColumna(tablero, vacio);

        if (simbolo != vacio) {
            defineGanador(simbolo, String.valueOf(player1), 2);
            return null;
        }

        simbolo = comprobaDiagonal(tablero, vacio);

        if (simbolo != vacio) {
            defineGanador(simbolo, String.valueOf(player1), 3);
            return null;
        }

        System.out.println("Hi ha empat");
        return null;
    }

    public static boolean acabaPartida(char[][] matriz, char vacio) {
        if (empate(matriz, vacio) || comprobaLinea(matriz, vacio) != vacio || comprobaColumna(matriz, vacio) != vacio || comprobaDiagonal(matriz, vacio) != vacio) {
            return true;
        }
        return false;
    }
}
