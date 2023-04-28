
/* Write a program to read two numbers from keyboard and writes
on the screen which of them is the biggest or if they are equal*/

package bloc2;

import java.util.Scanner;

public class bloc2ej2 {

    public static void main(String[] args) {
       Scanner teclat = new Scanner(System.in);
        
        int num1, num2;
        System.out.println("Intro num");
        num1 = teclat.nextInt();
        
        System.out.println("Intro num");
        num2 = teclat.nextInt();
        
        if (num1 > num2 ) {
            System.out.println("El major numero és " + num1);
        } else if (num2 > num1) {
            System.out.println("El major numero és " + num2);
        } else {
            System.out.println("Els numeros son iguals");
        } 
    }

}
