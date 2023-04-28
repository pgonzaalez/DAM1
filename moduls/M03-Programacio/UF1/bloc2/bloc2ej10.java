
/* Write a program that calculates the area of ​​a geometric 
figure to choose from a menu with the different options of 
the available geometric figures (square, rectangle, circle 
and cylinder) will be shown on the screen, the user will 
choose one and then, the program will request the information 
you need for the calculation and finally show the value of 
the area.*/

package bloc2;

import java.util.Scanner;
import java.lang.Math;

public class bloc2ej10 {

    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        
        double num1, num2, opcion,res;
        System.out.println("1.Cuadrat");
        System.out.println("2.Cercle");
        System.out.println("3.Rectangle");
        System.out.println("4.Cilindre");
        
        System.out.println("Intro num1");
        num1 = teclat.nextInt();
        System.out.println("Intro num2");
        num2 = teclat.nextInt();
        
        System.out.println("Escull opció");
        opcion = teclat.nextInt();
        
        System.out.println("La opcio escollida es la " + opcion);
        
        if (opcion == 1){
            res = num1 * num2;
            System.out.printf("L'area del cuadrat és " + res);
        } else if (opcion == 2) {
            res = (num1 *2) * Math.PI;
            System.out.printf("L'area del cercle és " + res);
        } else if (opcion == 3){
            res = num1 * num2;
            System.out.printf("L'area del rectangle és " + res);
        } else if(opcion == 4){
            res = (Math.PI * 2)* num1 * num2;
            System.out.printf("L'area del cilindre és  " + res);
        } else {
            System.out.println("La opció escollida no es valida");
        }
    }

}
