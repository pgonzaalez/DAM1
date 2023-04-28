package UF2.Ordenacio;
import java.util.Arrays;


public class Ordenacio {
    public static void main(String[] args) {

        final int TOTAL = 1000000;
        // Ordenació per selecció
        int[] nombres = generaArray(TOTAL); //{8,5,2,9,3,14,19,10,7,6};
        //System.out.println("Valors inicials:");
        //mostraArray(nombres);

        // Mesurem el temps d'ordenació
        long tempsInicial = System.currentTimeMillis();

        ordenaSeleccio(nombres);

        long tempsFinal = System.currentTimeMillis();

        //System.out.println("Valors ordenats:");
        //mostraArray(nombres);
        System.out.println("Temps que ha trigat per selecció: " +
                (tempsFinal-tempsInicial) + " ms");


        // Ordenació per bombolla
        nombres = generaArray(TOTAL);
        tempsInicial = System.currentTimeMillis();
        ordenaBombolla(nombres);
        tempsFinal = System.currentTimeMillis();
        System.out.println("Temps que ha trigat per bombolla: " +
                (tempsFinal-tempsInicial) + " ms");

        // Ordenació òptima
        nombres = generaArray(TOTAL);
        tempsInicial = System.currentTimeMillis();
        Arrays.sort(nombres);
        tempsFinal = System.currentTimeMillis();
        System.out.println("Temps que ha trigat per algorisme òptim: " +
                (tempsFinal-tempsInicial) + " ms");


    }

    static void ordenaSeleccio(int[] array) {

        for (int i = 0; i < array.length-1; ++i) {
            for (int j = i+1; j < array.length; ++j) {
                if (array[i] > array[j]) {
                    int aux = array[i];
                    array[i] = array[j];
                    array[j] = aux;
                }

            }
        }
    }

    static void ordenaBombolla(int[] array) {

        for (int i = 0; i < array.length-1; ++i) {
            for (int j = 0; j < array.length-i-1; ++j) {
                if (array[j] > array[j+1]) {
                    // Intercanviem posicions
                    int aux = array[j];
                    array[j] = array[j+1];
                    array[j+1] = aux;
                }
            }
        }
    }


    static void mostraArray(int[] array) {

        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
            if ((i+1) % 20 == 0)
                System.out.println("");
        }
        System.out.println("");

    }

    /*
     *   Crea un array de num enters
     *   de valors aleatoris entre
     *   1 i 2*num de forma que no hagi 2
     *   valors repetits
     */
    static int[] generaArray(int num) {

        int[] resultat = new int[num];

        for (int i = 0; i < num; ++i) {
            boolean repetit = true;
            while (repetit) {
                repetit = false;
                int valor = (int)(Math.random()*(2*num)) + 1;
                for (int j = 0; j < i;++j) {
                    if (resultat[j] == valor) {
                        repetit = true;
                        break;
                    }
                }
                if (!repetit) {
                    resultat[i] = valor;
                }
            }
        }
        return resultat;

    }

}
