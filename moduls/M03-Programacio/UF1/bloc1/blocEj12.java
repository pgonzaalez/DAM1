
// Write a big number of seconds amd the program 
// has to show the days, hours, minutes and seconds that corresponds

package bloc1;

import java.util.Scanner;

public class blocEj12 {

    public static void main(String[] args) {
        long num, dia, hora, min , sec ;
        Scanner teclat = new Scanner(System.in);

        System.out.println("Intro num");
        num = teclat.nextInt();
        
        dia= num /86400;
        hora = (num /3600) - dia ;
        min = (num /60) - hora;
        sec = ((num - dia) - hora) - min;
        System.out.println("Aquest numero son " + dia + " dies, "+ hora + " hores, "+ min +" minuts i "+ sec +" segons" );
    }

}

