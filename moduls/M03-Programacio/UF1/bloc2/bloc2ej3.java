
/* Write a program to read one number from 
keyboard and writes on the screen if it is positive, negative or zero */

package bloc2;

import java.util.Scanner;

public class bloc2ej3 {

    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        
        int num1;
        System.out.println("Intro num");
        num1 = teclat.nextInt();
        
        if (num1 < 0 ) {
            System.out.println("El numero és negatiu");
        } else if (num1 > 0) {
            System.out.println("El numero és positiu");
        } else {
            System.out.println("El numero és 0");
        }
    }

}
