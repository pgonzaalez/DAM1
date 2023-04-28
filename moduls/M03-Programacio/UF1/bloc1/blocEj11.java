
//Write a program that ask for the hour ( with minutes) 
// and shows the minutes that have passed  from midnight

package bloc1;

import java.util.Scanner;

public class blocEj11 {

    public static void main(String[] args) {
        float hora,min, sum ;
        Scanner teclat = new Scanner(System.in);

        System.out.println("Intro hora");
        hora = teclat.nextFloat();
        System.out.println("Intro min");
        min = teclat.nextFloat();
        
        sum = (hora * 60) + min;
        
        System.out.printf("Han pasat %.2f desde les 00:00", sum);
    }

}

