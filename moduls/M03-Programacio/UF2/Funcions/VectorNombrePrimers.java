/**
 * @author pgonzalez
 */
import java.util.Scanner;

public class VectorNombrePrimers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();
        int[] primers = generarVectorNombresPrimers(numero);
        mostrarVector(primers);
    }

    static boolean esNombrePrimer(int num1) {
        if (num1 <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num1); i++) {
            if (num1 % i == 0) {
                return false;
            }
        }
        return true;
    }


    static int[] generarVectorNombresPrimers(int n) {
        int[] primers = new int[n];
        int num = 2;
        int i = 0;
        while (i < n) {
            if (esNombrePrimer(num)) {
                primers[i] = num;
                i++;
            }
            num++;
        }
        return primers;
    }

    static void mostrarVector(int[] primers) {

        for (int i = 0; i < primers.length; i++) {
            System.out.print(primers[i]);
            if (i < primers.length - 1) {
                System.out.print(", ");
            } else{
                System.out.print(".");
            }
            if ((i + 1) % 10 == 0){
                System.out.println();
            }

        }

    }

}

