
/* Write a program that receives a grade (with decimals or not) and tells you 
if it is 'suficient', 'be', 'notable', 'excel.lent' o 'matrícula d'honor' */

package bloc2;

import java.util.Scanner;

public class bloc2ej15 {

    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);

        int nota;
        System.out.println("Intro nota");
        nota = teclat.nextInt();
        
        if(nota < 10 && nota > 0) {
            if(nota >= 5){
                if (nota < 6){
                    System.out.println("Suficient");
                } else {
                    if (nota < 7){
                    System.out.println("Bé");
                    } else {
                        if (nota < 9){
                        System.out.println("Notable");
                        } else {
                          if (nota < 10){
                         System.out.println("Excelent");
                        }
                       }
                    }
                }
            } else {
                System.out.println("Suspès");
            }
        } else {
            System.out.println("Aquesta nota no es valida");
        }
    }

}
