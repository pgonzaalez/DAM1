
/* Given three numbers entered by keyboard, sort them */

package bloc2;

import java.util.Scanner;

public class bloc2ej13 {

    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        
        int num1,num2,num3;
       
        System.out.println("Intro num1");
        num1 = teclat.nextInt();
        System.out.println("Intro num2");
        num2 = teclat.nextInt();
        System.out.println("Intro num3");
        num3 = teclat.nextInt();
        
        if (num1 > num2){
            if (num1 > num3){
                System.out.println(num1 + ">" + num2 + ">" + num3);
            } else {
                if (num3 > num2){
                    System.out.println(num1 + ">" + num3 + ">" + num2);
                } else{
                    System.out.println(num3 + ">" + num1 + ">" + num2);
                }
            }
        } else if (num2 > num3){
            if (num3 > num1){
                System.out.println(num2 + ">" + num3 + ">" + num1);
            } else {
                System.out.println(num2 + ">" + num1 + ">" + num3);
            }
        } else {
            System.out.println(num3 + ">" + num2 + ">" + num1);
        }
    }
}


