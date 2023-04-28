package UF2.Ordenacio;

import java.util.Scanner;
public class ordenaPais {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numPosicion = in.nextInt();

        String[] array = generaVector(numPosicion);

        ordenaBombolla(array);
        System.out.println("Països ordenats:");
        for (String pais : array) {
            System.out.println(pais);
        }
    }

    public static String[] generaVector(int numElements) {
        Scanner in = new Scanner(System.in);
        String[] vector = new String[numElements];
        for (int i = 0; i < numElements; i++) {
            vector[i] = in.nextLine();
        }
        return vector;
    }

    public static void ordenaBombolla(String[] paisos){
        int vector = paisos.length;
        for (int i = 0; i < vector-1; i++) {
            for (int j = 0; j < vector-i-1; j++) {
                if (paisos[j].compareTo(paisos[j+1]) > 0) {
                    String temp = paisos[j];
                    paisos[j] = paisos[j+1];
                    paisos[j+1] = temp;
                }
            }
        }
    }
}
