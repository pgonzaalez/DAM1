
/* Resolution of a second degree equation. Make a 
program that reads three values ​​A, B and C that are 
the coefficients of the equation, and give the 
solutions by applying the resolution formula. */

package bloc2;

import java.util.Scanner;

public class bloc2ej8 {

    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        
        double num1,num2,num3,res;
        System.out.println("Intro num1");
        num1 = teclat.nextFloat();
        
        System.out.println("Intro num2");
        num2 = teclat.nextFloat();
        
        System.out.println("Intro num3");
        num3 = teclat.nextFloat();

        res= (-num2 * (Math.pow(num2, 2)-4*num1 * num3)) / (2*num1);
        System.out.printf("El resultat de la equiacio és %.2f euros", res) ;
        
    }

}
