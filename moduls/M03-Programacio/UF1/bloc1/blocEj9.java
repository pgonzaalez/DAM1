
// calculate the hypotenuse if we know the length of  the legs

package bloc1;

import java.util.Scanner;
import java.lang.Math;

public class blocEj9 {

    public static void main(String[] args) {
        double num1, num2,arr ;
        Scanner teclat = new Scanner(System.in);

        System.out.println("Intro num1");
        num1 = teclat.nextFloat();
        
        System.out.println("Intro num2");
        num2 = teclat.nextFloat();
        
        arr = Math.sqrt(Math.pow(num1, 2) + Math.pow(num2, 2));
    //  arr= Math.hypot(num1, num2);
        System.out.printf("La hipotenusa és %.2f ", arr);
    }

}

