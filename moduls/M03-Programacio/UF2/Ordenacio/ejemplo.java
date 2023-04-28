package UF2.Ordenacio;

public class ejemplo {

    public static void main(String args[]) {

        int vector[] = generarVectorSinRep(5);
        mostrarVector(vector);
        vector = ordenarVector(vector);
        mostrarVector(vector);
        int valor = 15;
        int vector2[] = anadirPosicionOrdenada(vector, valor);
        mostrarVector(vector2);

        int vector3[] = borrarValor(vector2, valor);
        mostrarVector(vector3);
    }

    public static int[] generarVector(int numPoscicion) {
        int[] vector = new int[numPoscicion];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) Math.round(Math.random() * 9);
        }
        return vector;
    }

    public static boolean isUnique(int[] vector, int candidato) {
        boolean unique = true;
        for (int i = 0; i < vector.length; i++) {
            if (candidato == vector[i]) {
                unique = false;
            }
        }
        return unique;
    }

    public static int[] generarVectorSinRep(int numPoscicion) {
        int[] vector = new int[numPoscicion];

        for (int i = 0; i < vector.length; i++) {
            int candidato = (int) Math.round(Math.random() * 100);
            if (isUnique(vector, candidato))
                vector[i] = candidato;
            else {
                i--;
            }
        }
        return vector;
    }

    public static int[] ordenarVector(int[] vector) {
        for (int i = 0; i < vector.length - 1; i++) {
            for (int j = i + 1; j < vector.length; j++) {
                if (vector[i] > vector[j]) {
                    int tmp = vector[i];
                    vector[i] = vector[j];
                    vector[j] = tmp;
                }
            }
        }
        return vector;
    }

    public static void mostrarVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }

    public static int[] anadirPosicion(int[] entrada, int n) {
        int[] salida = new int[entrada.length + 1];

        for (int i = 0; i < entrada.length; i++) {
            salida[i] = entrada[i];
        }
        salida[salida.length - 1] = n;

        return salida;
    }

    public static int[] anadirPosicionOrdenada(int[] entrada, int n) {
        int[] salida = new int[entrada.length + 1];
        int tmp = 0;
        for (int i = 0; i < entrada.length; i++) {

            if (entrada[i] < n) {
                salida[i] = entrada[i];
                tmp++;
            } else {
                salida[i + 1] = entrada[i];
            }
        }
        salida[tmp] = n;

        return salida;
    }

    public static int[] borrarPosicion(int[] vector, int posicion) {
        int[] salida = new int[vector.length - 1];

        if (posicion < 0 || posicion >= vector.length) {

            System.out.print("Posición no valida.");

        } else {
            for (int i = 0; i < salida.length; i++) {
                if (posicion > i) {
                    salida[i] = vector[i];

                } else {
                    salida[i] = vector[i + 1];
                }

            }

        }
        return salida;

    }

    public static int[] borrarValor(int[] vector, int valor) {
        int[] salida = new int[vector.length - 1];
        int posicion = -1;
        for (int i = 0; i < vector.length; i++) {
            if (valor == vector[i]) {
                posicion = i;
                break;
            }
        }
        if (posicion != -1) {
            salida = borrarPosicion(vector, posicion);
        }
        return salida;
    }
}