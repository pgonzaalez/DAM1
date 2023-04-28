package UF2.provaUF2;
public class MatriusATope_PolGonzalez {

    public static void main(String[] args) {

        int[][] matriu = {{1, 7, 8, 2, 3},
                          {5, 9, 2, 1, 6},
                          {6, 2, 8, 2, 6}};


        System.out.println("Matriz Original");
        imprimirMatriu(matriu);
        System.out.println("----------------");

        System.out.println("Afegir Fila");
        int[][] matriu2 = afegirFila(1, matriu);
        imprimirMatriu(matriu2);
        System.out.println("----------------");

        System.out.println("Afegir Columna");
        int[][] matriu3 = afegirColumna(1, matriu);
        imprimirMatriu(matriu3);
        System.out.println("----------------");

        System.out.println("Borrar Fila");
        int[][] matriu4 = esborrarFila(1, matriu);
        imprimirMatriu(matriu4);
        System.out.println("----------------");

        System.out.println("Borrar Columna");
        int[][] matriu5 = esborrarColumna(1, matriu);
        imprimirMatriu(matriu5);
        System.out.println("----------------");

        System.out.println("Intercambiar Fila");
        intercanviarFila(2, 3, matriu);
        imprimirMatriu(matriu);
        System.out.println("----------------");

        System.out.println("Intercambiar Columna");
        intercanviarColumna(1, 3, matriu);
        imprimirMatriu(matriu);
        System.out.println("----------------");

        System.out.println("Ordenar Matriu");
        ordenar(matriu);
        imprimirMatriu(matriu);
        System.out.println("----------------");

    }

    public static void imprimirMatriu(int[][] matriz) {

        System.out.println("Imprimim la matriu:");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] afegirFila(int fila, int[][] matriu) {
        int[][] nuevaMatriz = new int[matriu.length + 1][matriu[0].length];
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[0].length; j++) {
                nuevaMatriz[i][j] = matriu[i][j];
            }
        }
        for (int j = 0; j < matriu[0].length; j++) {
            nuevaMatriz[matriu.length][j] = fila;
        }
        return nuevaMatriz;
    }

    static int[][] afegirColumna(int columna, int[][] matriu) {
        int[][] novaMatriu = new int[matriu.length][matriu[0].length + 1];

        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[0].length; j++) {
                novaMatriu[i][j] = matriu[i][j];
            }
            novaMatriu[i][matriu[0].length] = columna;
        }

        return novaMatriu;
    }

    static int[][] esborrarFila(int fila, int[][] matriu) {

        int numFilas = matriu.length;
        int numColumnas = matriu[0].length;

        int[][] nuevaMatriu = new int[numFilas - 1][numColumnas];

        int j = 0;
        for (int i = 0; i < numFilas; i++) {
            if (i != fila) {
                nuevaMatriu[j] = matriu[i];
                j++;
            }
        }

        return nuevaMatriu;

    }

    static int[][] esborrarColumna(int fila, int[][] matriu) {
        int numFilas = matriu.length;
        int numColumnas = matriu[0].length;

        int[][] nuevaMatriu = new int[numFilas][numColumnas - 1];

        for (int i = 0; i < numFilas; i++) {
            int k = 0;
            for (int j = 0; j < numColumnas; j++) {
                if (j != fila) {
                    nuevaMatriu[i][k] = matriu[i][j];
                    k++;
                }
            }
        }

        return nuevaMatriu;

    }

    static boolean intercanviarFila(int fila1, int fila2, int[][] matriu) {
        boolean actualizado = false;
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[0].length; j++) {
                if (matriu[i][j] == fila1) {
                    matriu[i][j] = fila2;
                    actualizado = true;
                }
            }
        }
        return actualizado;
    }

    static boolean intercanviarColumna(int columna1, int columna2, int[][] matriu) {
        int numFilas = matriu.length;
        int numColumnas = matriu[0].length;

        int[][] nuevaMatriu = new int[numFilas][numColumnas - 1];

        for (int i = 0; i < numFilas; i++) {
            int cont = 0;
            for (int j = 0; j < numColumnas; j++) {
                if (j != columna1) {
                    nuevaMatriu[i][cont] = matriu[i][j];
                    cont++;
                }
            }
        }

        return true;
    }

    static int[][] ordenar(int[][] matriu) {
        int n = matriu.length;
        int m = matriu[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int x = j + 1; x < m; x++) {
                    if (i % 2 == 0 && matriu[i][j] > matriu[i][x]
                     || i % 2 == 1 && matriu[i][j] < matriu[i][x]) {
                        int tmp = matriu[i][j];
                        matriu[i][j] = matriu[i][x];
                        matriu[i][x] = tmp;
                    }
                }
            }
        }
        return matriu;
    }
}
