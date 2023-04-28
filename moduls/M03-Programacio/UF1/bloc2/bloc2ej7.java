
/* Write a program that reads a number and 
says if it is multiple of two, three, of both or of none of them. */

package bloc2;

import java.util.Scanner;

public class bloc2ej7 {

    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        int num;
        System.out.println("Intro num");
        num = teclat.nextInt();
        
        
        if (num %2 == 0 ) {
            System.out.println("Es multiple de 2");
            if (num %3 == 0) {
                System.out.println("Es multiple de 2 i de 3");
            }
        } else if (num %3 == 0){
            System.out.println("Es multiple de 3");
            if (num %2 == 0) {
                System.out.println("Es multiple de 2 i de 3");
            }
        } else {
            System.out.println("No es multiple ni de 2 ni de 3");
        }
    }

}
