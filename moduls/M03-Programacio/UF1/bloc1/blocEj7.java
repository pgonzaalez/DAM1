
//calculate the square root of a float number. Show the result with two decimals

package bloc1;

import java.util.Scanner;
//import java.lang.Math;

public class blocEj7 {

    public static void main(String[] args) {
        double num1, div ;
        Scanner teclat = new Scanner(System.in);

        System.out.println("Intro num1");
        num1 = teclat.nextFloat();

        div = Math.sqrt(num1);
        
        System.out.printf("La arrel cuadrada és %.2f ", div);
    }
}

