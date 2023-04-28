
/* Program that reads a quantity by keyboard; if it exceeds 10000, 
make a 10% discount; if not, just make a 5% discount. The program must 
write down the discount made and the final amount. */

package bloc2;

import java.util.Scanner;

public class bloc2ej11 {

    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        
        int num,des,res;
       
        System.out.println("Intro num");
        num = teclat.nextInt();
        
        if (num > 10000){
            des = 10/100;
            res = num - (num * des);
            System.out.println("El preu total és de " + res);
        } else {
            des = 5/100;
            res = num - (num * des);
            System.out.println("El preu total és de " + res);
        }
    }

}
