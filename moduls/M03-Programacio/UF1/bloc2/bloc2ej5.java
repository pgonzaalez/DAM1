
/* Write a program that obtains the initial 
amount and the discount in euros made to a 
final amount read by keyboard and that corresponds to 5% discount*/

package bloc2;

import java.util.Scanner;
import java.lang.Math;

public class bloc2ej5 {

    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        
        double val;
        System.out.println("Intro total producte");
        val = teclat.nextFloat();

        double num = val / 0.95;
        System.out.printf("El preu sense el descompte és de %.2f euros", num) ;
        
    }

}
