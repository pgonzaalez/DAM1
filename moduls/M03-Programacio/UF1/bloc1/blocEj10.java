
// Write a program that ask for two ages and shows the addition of theses ages

package bloc1;

import java.util.Scanner;

public class blocEj10 {

    public static void main(String[] args) {
        float edat1,edat2, sum ;
        Scanner teclat = new Scanner(System.in);

        System.out.println("Intro edat 1");
        edat1 = teclat.nextFloat();
        System.out.println("Intro edat 2");
        edat2 = teclat.nextFloat();
        
        sum = edat1 + edat2;
        
        System.out.printf("La divisió dels 2 digits és %.2f ", sum);
    }

}

