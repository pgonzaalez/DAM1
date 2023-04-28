
/* Write a program to read one number from 
keyboard and writes on the screen if it is even or odd. */

package bloc2;

import java.util.Scanner;


public class bloc2ej4 {

    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        
        int num;
        System.out.println("Intro num");
        num = teclat.nextInt();
        
        if (num %2 == 0) {
            System.out.println("El numero és par");
        } else  {
            System.out.println("El numero és impar ");
        } 
    }

}
