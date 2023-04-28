
/* write a program that receives a year and tells you whether or not it is a leap year */

package bloc2;

import java.util.Scanner;

public class bloc2ej14 {

    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);

        int año;
        System.out.println("Intro año");
        año = teclat.nextInt();
        
        if (año %4 == 0){
            if(año %100 == 0){
                if (año %400 == 0){
                    System.out.println("Este año es bisiesto");
                } else{
                    System.out.println("Este año no es bisiesto");
                }
            }else {
                System.out.println("Este año es bisiesto");
            } 
            
        } else {
            System.out.println("Este año no es bisiesto");
        }
    }

}
