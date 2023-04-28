
// write two numbers and calculate the multiplication

package bloc1;

import java.util.Scanner;

public class blocEj3 {

    public static void main(String[] args) {
        int num1,num2, mul;
        Scanner teclat = new Scanner(System.in);

        System.out.println("Intro num1");
        num1 = teclat.nextInt();
        
        System.out.println("Intro num2");
        num2 = teclat.nextInt();
        
        mul = num1 * num2;
        System.out.println("La multiplicació del 2 digits és " + mul);
    }

}
