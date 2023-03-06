import java.util.Scanner;
public class PracticaM03 {
    
    // @author pgonzalez

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char player1 = 'X';
        char player2 = 'O';
        char vacio = '-';
        String tornaJugar = " ";
        boolean turno = true;

        char tablero[][] = new char[3][3];

        rellenarTablero(tablero, vacio);

        int fila, columna;
        boolean posValida, correcto;

        int empezar = 0;
        System.out.println(ANSI_PURPLE + "------------" + ANSI_RESET);
        System.out.println("Benvingut al 3 en ratlla");
        System.out.println(ANSI_PURPLE + "------------" + ANSI_RESET);
        System.out.println("Les normes del joc son les següents:");
        System.out.println("Els valors introduits han de ser entre els limits establerts");
        System.out.println("El primer que formi una fila de 3 guanyará la partida");
        System.out.println("Una vegada acabada la partida podrás tornar a jugar escribin 'Si' o 'No' ");
        System.out.println(ANSI_PURPLE + "------------" + ANSI_RESET);
        System.out.println("Per començar la partida introdueix el valor 555");
        System.out.println(ANSI_PURPLE + "------------" + ANSI_RESET);


        do {
            empezar = in.nextInt();
        } while (empezar != 555);

        do {
            System.out.println("Vols començar a jugar?");
            tornaJugar = in.next();
            if ( tornaJugar.equals("No")) {

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

                        //Si no hay marca, significa que es correcto
                        if (!comprobaPosicion(tablero, fila, columna, vacio)) {
                            correcto = true;
                        } else {
                            System.out.println("Esa casilla ya esta elegida");
                        }
                    } else {
                        System.out.println("La posicion escogida no es valida en el tablero");
                    }

                } while (!correcto);

                if (turno) {
                    insertarValor(tablero, fila, columna, player1);
                } else {
                    insertarValor(tablero, fila, columna, player2);
                }


                turno = !turno;
            }

            mostraTablero(tablero);

            mostraGanador(tablero, player1, player2, vacio);

            }
        } while(tornaJugar.equals("Si"));
    }
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
                for (int j = 1; j < tablero[0].length; j++) {
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
                for (int i = 1; i < tablero[0].length; i++) {
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

        //Diagonal Esquerra-Dreta
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

        //Diagonal Dreta-Esquerra
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

    public static void defineGanador(char simbolo, char player1, int tipo) {

        switch (tipo) {
            case 1:
                if (simbolo == player1) {
                    System.out.println("Ha ganado el Jugador 1");
                } else {
                    System.out.println("Ha ganado el Jugador 2");
                }

                break;
            case 2:
                if (simbolo == player1) {
                    System.out.println("Ha ganado el Jugador 2");
                } else {
                    System.out.println("Ha ganado el Jugador 1");
                }
                break;
            case 3:
                if (simbolo == player1) {
                    System.out.println("Ha ganado el Jugador 2 ");
                } else {
                    System.out.println("Ha ganado el Jugador 1 ");
                }
                break;
        }

    }


    public static void mostraGanador(char[][] tablero, char player1, char player2, char vacio) {

        char simbolo = comprobaLinea(tablero, vacio);

        if (simbolo != vacio) {

            defineGanador(vacio, player1, 1);

            return;

        }

        simbolo = comprobaColumna(tablero, vacio);

        if (simbolo != vacio) {

            defineGanador(vacio, player1, 2);

            return;

        }

        simbolo = comprobaDiagonal(tablero, vacio);

        if (simbolo != vacio) {

            defineGanador(vacio, player1, 3);

            return;

        }

        System.out.println("Hay empate");

    }

    public static boolean acabaPartida(char[][] matriz, char vacio) {

        if (empate(matriz, vacio) || comprobaLinea(matriz, vacio) != vacio || comprobaColumna(matriz, vacio) != vacio || comprobaDiagonal(matriz, vacio) != vacio) {
            return true;
        }

        return false;
    }





    // Metodes per els colors
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

}
