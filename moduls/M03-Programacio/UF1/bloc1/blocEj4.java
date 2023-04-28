
//read two integers from the keyboard and calculate the integer division , (with no  decimal number)

package bloc1;

import java.util.Scanner;

public class blocEj4 {

    public static void main(String[] args) {
        int num1,num2, div  ;
        Scanner teclat = new Scanner(System.in);

        System.out.println("Intro num1");
        num1 = teclat.nextInt();
        
        System.out.println("Intro num2");
        num2 = teclat.nextInt();
        
        div = num1 / num2;
        System.out.println("La divisió del 2 digits és " + div);
    }

}
