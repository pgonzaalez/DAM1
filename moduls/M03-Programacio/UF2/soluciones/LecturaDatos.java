package UF2.soluciones;

import java.util.Scanner;

public class LecturaDatos {

    public static int pideEntero(Scanner in) {
        int n = 0;
        boolean correcte = false;

        do {
            System.out.print("Introdueix un nombre enter: ");
            if (!in.hasNextInt()) {
                System.out.println("No es un enter");
            } else {
                correcte = true;
                n = in.nextInt();
            }
            in.nextLine();
        } while (!correcte);
        return n;
    }
    public static int pideEntero(Scanner in,String mensaje) {
        int n = 0;
        boolean correcte = false;

        do {
            System.out.print("Introdueix un nombre enter ("+mensaje+"): ");
            if (!in.hasNextInt()) {
                System.out.println("No es un enter");
            } else {
                correcte = true;
                n = in.nextInt();
            }
            in.nextLine();
        } while (!correcte);
        return n;
    }
    
    public static double pideDouble(Scanner in,String mensaje){
        double n = 0;
        boolean correcte = false;
        
        do{
            System.out.println("Introdueix un double ("+mensaje+"):");
            if(!in.hasNextDouble()){                
                System.out.println("No es un double");
            }else{
                correcte = true;
                n = in.nextDouble();
            }
            in.nextLine();
        }while(!correcte);
        return n;
    }
    
    
}
