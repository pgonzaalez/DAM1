
// calculate the  circumference length if we type the length of the radius

package bloc1;

import java.util.Scanner;

public class blocEj8 {

    public static void main(String[] args) {
        double radi, lon;
        Scanner teclat = new Scanner(System.in);

        System.out.println("Intro radi");
        radi = teclat.nextDouble();
        lon = radi *2 * Math.PI;
        
        System.out.printf("La longitud de la circumferencia és %.2f ", lon);
    }

}

