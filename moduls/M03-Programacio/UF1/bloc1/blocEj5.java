
// read two integers from the keyboard and calculate the remainder of the integer division

package bloc1;

import java.util.Scanner;

public class blocEj5 {

    public static void main(String[] args) {
        int num1,num2, div ;
        Scanner teclat = new Scanner(System.in);

        System.out.println("Intro num1");
        num1 = teclat.nextInt();
        
        System.out.println("Intro num2");
        num2 = teclat.nextInt();
        
        div = num1 % num2;
        
        System.out.println("La resta del 2 digits és " + div);
    }

}

