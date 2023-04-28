
/* Write a program that shows a menu to add the sum, 
substraction, multiplication, division and square root of two numbers entered by keyboard. */

package bloc2;

import java.util.Scanner;

public class bloc2ej9 {

    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        
        int num1, num2, opcion,res;
        System.out.println("1.Suma");
        System.out.println("2.Resta");
        System.out.println("3.Multiplicació");
        System.out.println("4.Divisió");
        
        System.out.println("Intro num1");
        num1 = teclat.nextInt();
        System.out.println("Intro num2");
        num2 = teclat.nextInt();
        
        System.out.println("Escull opció");
        opcion = teclat.nextInt();
        
        if (opcion == 1){
            res = num1 + num2;
            System.out.println("La suma dels 2 digits és " + res);
        } else if (opcion == 2) {
            res = num1 - num2;
            System.out.println("La resta dels 2 digits és " + res);
        } else if (opcion == 3){
            res = num1 * num2;
            System.out.println("La multiplicació dels 2 digits és " + res);
        } else if(opcion == 4){
            res = num1 / num2;
            System.out.println("La divisió dels 2 digits és " + res);
        } else {
            System.out.println("La opció escollida no es valida");
        }
    }

}
