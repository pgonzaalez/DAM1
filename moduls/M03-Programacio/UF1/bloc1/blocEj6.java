
//read two float numbers amb obtain the quotient of the division with two decimals

package bloc1;

import java.util.Scanner;

public class blocEj6 {

    public static void main(String[] args) {
        float num1,num2, div ;
        Scanner teclat = new Scanner(System.in);

        System.out.println("Intro num1");
        num1 = teclat.nextFloat();
        
        System.out.println("Intro num2");
        num2 = teclat.nextFloat();
        
        div = num1 / num2;
        
        System.out.printf("La divisió dels 2 digits és %.2f ", div);
    }

}

