/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UF2.soluciones;

/**
 *
 * @author rferrero
 */
public class Matrius {

    static final int ELEMENTS = 10;
    
    public static void main(String[] args) {     
       
        
        // A[]
        int[] a = creaVector(ELEMENTS,0,9);
        // B[]
        int[] b = creaVector(ELEMENTS,100,999);  // entre 100 i 999
        // C[]
        int[] c = creaVector(a,b);

        // Mostrar resultats A[], B[] i C[]        
        imprimirVector("A",a);        
        imprimirVector("B",b);        
        imprimirVector("C",c);                
    }
    
    
    static void imprimirVector(String nomMatriu,int[] v) {
        System.out.print(nomMatriu + "[] = ");
        /*for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }*/
        for (int valor : v)
            System.out.print(valor + " ");
        
        System.out.println();                
    }
    
    static int[] creaVector(int totalElements,int min,int max) {
        int[] v = new int[totalElements];
        for (int i = 0; i < totalElements; i++) {
            v[i] = (int)(Math.random()*(max-min+1)) + min;
        }
        
        return v;
    }
    
    static int[] creaVector(int[] v1, int[] v2) {  // v1.length == v2.length
        
        int[] v = new int[v1.length + v2.length];
        for (int i = 0; i < v1.length + v2.length; i++)
        {
            if (i % 2 == 0)     // Índex parell
                v[i] = v1[i/2];
            else                // Índex senar
                v[i] = v2[i/2]; 
        }
        return v;
    }
}
