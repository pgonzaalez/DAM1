package UF2.Ordenacio;

public class vectores {
    
    public static void main(String[] args) {
        
        //Funcion para generar un vector y ordenarlo, luego lo mostramos
        int array[] = generarVector(7);
        array = ordenarVector(array);
        imprimirVector(array);
        System.out.println("----------------");
        
        //Funcion para generar un vector sin valores repetidos, ordenarlo y mostrarlo
        int array2[] = generarVectorSinRep(10);
        array2 = ordenarVector(array2);
        imprimirVector(array2);
        System.out.println("----------------");
        
        //Funcion para generar un vector, ordenarlo añadimos una posicion y lo mostramos
        int array3[] = generarVector(7);
        array3 = ordenarVector(array3);
        int n1 = 4;
        array3 = añadirPosicion(array3, n1);
        imprimirVector(array3);
        System.out.println("----------------");
        
        //Funcion para generar un vector, ordenarlo añadimos una posicion ORDENADA y lo mostramos
        int array4[] = generarVector(7);
        array4 = ordenarVector(array4);
        int n2 = 6;
        array4 = añadirPosicionOrdenada(array4, n2);
        imprimirVector(array4);
        System.out.println("----------------");
        
        //Funcion para generar un vector, ordenarlo y borrarle un volar, luego lo mostramos
        int array5[] = generarVector(7);
        array5 = ordenarVector(array5);
        int n3 = 7;
        array5 = borrarValor(array5, n3);
        imprimirVector(array5);
        System.out.println("----------------");
        
        //Funcion para generar un vector, ordenarlo y borrarle una posicion, luego lo mostramos
        int array6[] = generarVector(7);
        array6 = ordenarVector(array6);
        int n4 = 7;
        array6 = borrarPosicion(array6, n4);
        imprimirVector(array6);
        System.out.println("----------------");
        
        
    }
    public static int[] generarVector(int numPosicion){
        int[] vector = new int[numPosicion];
        
        for (int i = 0; i < vector.length; i++) {
            vector[i]=(int) Math.round(Math.random()*9);
        }       
        
        return vector;
    }
    public static boolean isUnique(int [] vector, int candidato){
        boolean unique = true;
        for (int i = 0; i < vector.length ; i++){
            if (vector[i] == candidato){
                unique = false;
            }
        }
        return unique;
    }
    public static int[] generarVectorSinRep(int numPosicion){
        int[] vector = new int[numPosicion];
        
        for (int i = 0; i < vector.length; i++) {
            int candidato =(int) Math.round(Math.random()*100);
            if (isUnique(vector,candidato))
            vector[i] = candidato;
            else {
                i--;
            }
        }       
        
        return vector;
    }
    public static int[] ordenarVector(int[]array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
    
    public static void imprimirVector(int array []) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]+" ");
        }
    }
    public static int[] añadirPosicion(int[] entrada, int n){
        int[] salida = new int[entrada.length+1];
        for (int i = 0; i < entrada.length; i++){
            salida[i] = entrada[i];
        }
        salida[salida.length - 1] = n;
        return salida;
    }
    public static int[] añadirPosicionOrdenada(int[] entrada, int n){
        int[] salida = new int[entrada.length+1];
        int tmp = 0;
        boolean insertar = false;
    for (int i = 0; i < entrada.length; i++){
        if(entrada[i] < n){
            salida[i] = entrada[i];
            tmp++;
        } else if(!insertar){
            
            salida[i] = n;
            insertar = true;
        }
        
        if(insertar && entrada[i] >= n){
            salida[i+1] = entrada[i];
        }
    }
    
    if(!insertar){
        salida[tmp] = n;
    }
    return salida;
}
        
    public static int[] borrarValor(int[] vector, int valor){
        int contador = 0;
    for (int i = 0; i < vector.length; i++) {
        if (vector[i] == valor) {
            contador++;
        }
    }
    int[] nuevoVector = new int[vector.length - contador];
    int j = 0;
    for (int i = 0; i < vector.length; i++) {
        if (vector[i] != valor) {
            nuevoVector[j] = vector[i];
            j++;
        }
    }
    return nuevoVector;
}
    public static int[] borrarPosicion(int[] vector, int posicion){
        int[] nuevoVector = new int[vector.length - 1];
    int j = 0;
    for (int i = 0; i < vector.length; i++) {
        if (i != posicion) {
            nuevoVector[j] = vector[i];
            j++;
        }
    }
    return nuevoVector;
}
    public static boolean update(int[] vector, int valor1, int valor2){
        boolean actualizado = false;
    for (int i = 0; i < vector.length; i++) {
        if (vector[i] == valor1) {
            vector[i] = valor2;
            actualizado = true;
        }
    }
    if (actualizado == true){
        System.out.println("El valor se a modificado correctamente");
    } else {
        System.out.println("No se pudo modificar");
    }
    return actualizado;
}
}

