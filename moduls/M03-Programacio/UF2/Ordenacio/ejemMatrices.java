package UF2.Ordenacio;
import java.util.Arrays;


public class ejemMatrices {
    public static void main(String args[]) {

        int[][] matriz = generarMatrizSinRep(3, 3);
        mostrarMatriz(matriz);
        matriz = ordenarMatriz(matriz);
        mostrarMatriz(matriz);
        System.out.println("----------------");

        int[][] matriz2 = generarMatrizSinRep(3, 3);
        matriz2 = ordenarMatriz(matriz2);
        int[] n1 = new int[4];
        matriz2 = añadirFila(matriz2, n1);
        mostrarMatriz(matriz2);
        System.out.println("----------------");

        int[][] matriz3 = generarMatrizSinRep(3, 3);
        matriz3 = ordenarMatriz(matriz3);
        int n2 = 0;
        matriz3 = añadirPosicionOrdenada(matriz3, n2);
        mostrarMatriz(matriz3);
        System.out.println("----------------");

        int[][] matriz4 = generarMatrizSinRep(3, 3);
        mostrarMatriz(matriz4);
        matriz4 = ordenarMatriz(matriz4);
        int n3 = 3;
        matriz4 = borrarValor(matriz4, n3);
        mostrarMatriz(matriz4);
        System.out.println("----------------");


        int[] [] matriz5 = generarMatriz(3,3);
        matriz5 = ordenarMatriz(matriz5);
        int n4 = 1;
        matriz5 = borrarPosicion(matriz5, n4);
        mostrarMatriz(matriz5);
        System.out.println("----------------");
    }
    public static int[][] generarMatriz(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = (int) Math.round(Math.random() * 9);
            }
        }
        return matriz;
    }

    public static boolean isUnique(int[][] matriz, int candidato) {
        boolean unique = true;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (candidato == matriz[i][j]) {
                    unique = false;
                }
            }
        }
        return unique;
    }

    public static int[][] generarMatrizSinRep(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int candidato = (int) Math.round(Math.random() * 10);
                if (isUnique(matriz, candidato))
                    matriz[i][j] = candidato;
                else {
                    j--;
                }
            }
        }
        return matriz;
    }
    public static int[][] ordenarMatriz(int[][] matriz) {
        int[] temp = new int[matriz.length * matriz[0].length];
        int index = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                temp[index++] = matriz[i][j];
            }
        }
        Arrays.sort(temp);
        index = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = temp[index++];
            }
        }
        return matriz;
    }
    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int[][] añadirFila(int[][] matriz, int[] fila) {
        int[][] nuevaMatriz = new int[matriz.length + 1][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                nuevaMatriz[i][j] = matriz[i][j];
            }
        }
        for (int j = 0; j < matriz[0].length; j++) {
            nuevaMatriz[matriz.length][j] = fila[j];
        }
        return nuevaMatriz;
    }
    public static int[][] añadirPosicionOrdenada(int[][] entrada, int n) {
        int[][] salida = new int[entrada.length + 1][entrada[0].length];
        int tmp = 0;
        boolean insertar = false;
        for (int i = 0; i < entrada.length; i++) {
            if (entrada[i][0] < n) {
                for (int j = 0; j < entrada[i].length; j++) {
                    salida[i][j] = entrada[i][j];
                }
                tmp++;
            } else if (!insertar) {
                for (int j = 0; j < entrada[i].length; j++) {
                    salida[tmp][j] = n;
                }
                insertar = true;
            }

            if (insertar || entrada[i][0] >= n) {
                for (int j = 0; j < entrada[i].length; j++) {
                    salida[insertar ? i + 1 : i][j] = entrada[i][j];
                }
                insertar = true;
            }
        }

        if (!insertar) {
            for (int j = 0; j < entrada[0].length; j++) {
                salida[tmp][j] = n;
            }
        }
        return salida;
    }
    public static int[][] borrarValor(int[][] matriz, int valor) {
        // Buscar la fila y columna que contienen el valor
        int fila = -1, columna = -1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == valor) {
                    fila = i;
                    columna = j;
                    break;
                }
            }
        }

        // Si el valor no está en la matriz, devolver la matriz original
        if (fila == -1 || columna == -1) {
            return matriz;
        }

        // Crear una nueva matriz con una fila o columna menos, según corresponda
        int[][] nuevaMatriz;
        if (matriz.length > 1 && matriz[0].length > 1) {
            nuevaMatriz = new int[matriz.length - 1][matriz[0].length - 1];
        } else if (matriz.length > 1) {
            nuevaMatriz = new int[matriz.length - 1][matriz[0].length];
        } else {
            nuevaMatriz = new int[matriz.length][matriz[0].length - 1];
        }

        // Copiar los valores de la matriz original a la nueva matriz, saltando la fila o columna que contiene el valor
        int nf = 0, nc = 0;
        for (int i = 0; i < matriz.length; i++) {
            if (i != fila) {
                for (int j = 0; j < matriz[0].length; j++) {
                    if (j != columna) {
                        nuevaMatriz[nf][nc] = matriz[i][j];
                        nc++;
                    }
                }
                nf++;
                nc = 0;
            }
        }

        return nuevaMatriz;
    }
    public static int[][] borrarPosicion(int[][] matriz, int posicion) {
        int[][] nuevaMatriz = new int[matriz.length][matriz[0].length - 1];
        int j = 0;
        for (int i = 0; i < matriz.length; i++) {
            int k = 0;
            for (int l = 0; l < matriz[i].length; l++) {
                if (l != posicion) {
                    nuevaMatriz[j][k] = matriz[i][l];
                    k++;
                }
            }
            j++;
        }
        return nuevaMatriz;
    }
    public static boolean update(int[][] matriz, int valor1, int valor2){
        boolean actualizado = false;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == valor1) {
                    matriz[i][j] = valor2;
                    actualizado = true;
                }
            }
        }
        if (actualizado == true){
            System.out.println("El valor se ha modificado correctamente");
        } else {
            System.out.println("No se pudo modificar");
        }
        return actualizado;
    }


}




