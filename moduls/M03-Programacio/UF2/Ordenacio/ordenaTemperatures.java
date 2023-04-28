package UF2.Ordenacio;

import java.util.Scanner;

public class ordenaTemperatures {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        double[] array = generaVector(n);

        ordenar(array);

    }
    public static double[] generaVector(double n) {
        Scanner in = new Scanner(System.in);
        double[] vector = new double[(int) n];
        for (int i = 0; i < n; i++) {
            vector[i] = in.nextDouble();
        }
        return vector;
    }


    public static double[] ordenar(double[] vector) {
        int n = vector.length;
        int cont = 0;
        for (int i = 0; i < n-1; i++) {
            cont++;
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (vector[j] < vector[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                cont++;
                double temp = vector[minIndex];
                vector[minIndex] = vector[i];
                vector[i] = temp;
            }
        }
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
        System.out.println("Total passades: " + cont);
        return vector;
    }
}
