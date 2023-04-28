
/*  Write a program that asks for the year, 
month and day of your birth, and the current 
year, month and day and finally returns the age you are. */

package bloc2;

import java.util.Scanner;
import java.util.Date;
public class bloc2ej6 {

    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        
        int año,mes,dia,añoActual,mesActual,diaActual, edat;
        System.out.println("Intro año");
        año = teclat.nextInt();
        
        System.out.println("Intro mes");
        mes = teclat.nextInt();
        
        System.out.println("Intro dia");
        dia = teclat.nextInt();
        
        //System.out.println("Intro año actual");
        añoActual = 2022;
        
        //System.out.println("Intro mes actual");
        mesActual = 10;
        
        //System.out.println("Intro dia actual");
        diaActual = 6;
        
        edat = añoActual - año;
        if (mes >= mesActual) { 
            if (dia > diaActual){
                edat = edat - 1;
                System.out.println("La teva edat és " + edat);
            } else {
                System.out.println("La teva edat és " + edat);
            }
        } else {
            System.out.println("La teva edat és " + edat);
        }
        
    }

}
