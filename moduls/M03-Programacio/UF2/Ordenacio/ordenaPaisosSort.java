package UF2.Ordenacio;

import java.util.Arrays;
import java.util.Scanner;

public class ordenaPaisosSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numPosicion = in.nextInt();
        String[] array = new String[numPosicion];
        for (int i = 0; i < numPosicion; i++) {
            array[i] = in.next();
        }
        Arrays.sort(array);
        System.out.println("Països ordenats:");
        for (String pais : array) {
            System.out.println(pais);
        }

    }

}
