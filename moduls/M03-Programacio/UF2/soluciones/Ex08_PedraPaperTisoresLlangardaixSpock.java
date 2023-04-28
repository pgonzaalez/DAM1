package UF2.soluciones;
import java.util.Scanner;
public class Ex08_PedraPaperTisoresLlangardaixSpock {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
    int[][] resultatJugada = {{0,-1,1,1,-1},
            {1,0,-1,-1,1},
            {-1,1,0,1,-1},
            {-1,1,-1,0,1},
            {1,-1,1,-1,0}};

    String[] jugades = {"pedra","paper","tisores","llangardaix","Spock"};

    boolean finalPartida = false;
    // Bucle de partides
        do {
        int ronda = 1;
        int marcadorHuma = 0, marcadorMaquina = 0;

        // Bucle rondes de una partida
        while (marcadorHuma < 3 && marcadorMaquina < 3) {
            // Mostrar ronda i marcador
            System.out.println("Ronda: " + ronda +
                    " [Jugador: " + marcadorHuma + " - Ordinador: " + marcadorMaquina + "]");

            // Demanar jugada a l'humà
            System.out.print("pedra(0), paper(1), tisores(2), llangardaix(3), Spock(4): ");
            int jugadaHuma = jugadaHuma();

            // Demanar jugada Maquina
            int jugadaMaquina = jugadaOrdinador();

            System.out.print("El jugador ha tret " + jugades[jugadaHuma] + ". ");
            System.out.print("L'ordinador ha tret " + jugades[jugadaMaquina] + ". ");

            // Comprovar qui guanya
            if (resultatJugada[jugadaHuma][jugadaMaquina] == 1) {
                marcadorHuma++;
                System.out.println("Guanya el jugador!!");
            } else if (resultatJugada[jugadaHuma][jugadaMaquina] == -1) {
                marcadorMaquina++;
                System.out.println("Guanya l'ordinador!!");
            } else
                System.out.println("Empat.");

            System.out.println("");

            // Comprovació de si algú ha arribat a guanyar 3 rondes
            if (marcadorHuma == 3 || marcadorMaquina == 3) {
                System.out.println("La partida ha acabat en " + ronda + " rondes.");
                System.out.println("El marcador ha estat:");
                System.out.println("Jugador: " + marcadorHuma +
                        " - Ordinador: " + marcadorMaquina);
                sc.nextLine();
                System.out.print("Vols fer una nova partida? [S/N]: ");

                char seleccio = sc.nextLine().toLowerCase().charAt(0);
                if (seleccio == 'n')
                    finalPartida = true;
                else
                    System.out.println("\n\n");
            }
            ronda++;
        }

    } while (!finalPartida);
}


    public static int jugadaHuma() {



        boolean entradaCorrecte = false;
        int jugada = 0;

        do {
            if (sc.hasNextInt()) {
                jugada = sc.nextInt();
                if (jugada >= 0 && jugada <= 4)
                    entradaCorrecte = true;
            }
            if (!entradaCorrecte) {
                System.out.print("pedra(0), paper(1), tisores(2), llangardaix(3), Spock(4): ");
                sc.nextLine();
            }
        } while (!entradaCorrecte);

        return jugada;
    }


    public static int jugadaOrdinador() {

        return (int)(Math.random()*5);
    }

}
