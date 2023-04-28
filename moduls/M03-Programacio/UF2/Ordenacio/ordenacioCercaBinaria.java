package UF2.Ordenacio;
import java.util.Arrays;
import java.util.Scanner;

public class ordenacioCercaBinaria {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numPosicion = in.nextInt();
        in.nextLine();
        String[] array = new String[numPosicion];
        for (int i = 0; i < numPosicion; i++) {
            array[i] = in.nextLine();
        }

        Arrays.sort(array);
        String pais = in.next();
        int posicio= cercaBinaria(array, pais);

        if (posicio==-1) {
            System.out.println("No trobat");
        } else {
            System.out.println("Trobat a la posició: "+posicio);
        }

    }

    public static int cercaBinaria(String[] array, String pais) {
        int resultat = -1;
        int esquerra = 0;
        int dreta = array.length - 1;
        int meitat;
        int passades = 0;
        while (esquerra <= dreta) {
            meitat = (esquerra + dreta) / 2;
            passades++;

            if (array[meitat].equalsIgnoreCase(pais)) {
                resultat = meitat;
                break;
            } else if (array[meitat].compareToIgnoreCase(pais) < 0) {
                esquerra = meitat + 1;
            } else {
                dreta = meitat - 1;
            }
        }
        System.out.println("Total passades: " + passades);
        return resultat;
    }
}
