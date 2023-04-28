
//write two numbers and calculate the addition

package bloc1;

import java.util.Scanner;

public class blocEj2 {

    public static void main(String[] args) {
        int num1,num2, sum;
        Scanner teclat = new Scanner(System.in);

        System.out.println("Intro num1");
        num1 = teclat.nextInt();
        
        System.out.println("Intro num2");
        num2 = teclat.nextInt();
        
        sum = num1 + num2;
        System.out.println("La suma del 2 digits és " + sum);
    }

}
