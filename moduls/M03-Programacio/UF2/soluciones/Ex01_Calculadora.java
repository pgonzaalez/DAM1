package UF2.soluciones;

import java.util.Scanner;


/*"Que demani dos nombres enters i a continuació l’operació a realitzar (suma, resta, multiplicació o divisió) i la realitzi i mostri el resultat"*/
public class Ex01_Calculadora {

    public static void main(String[] args) {
        menu();
        System.out.println("FIN");
    }

    public static void menu() {
        Scanner in = new Scanner(System.in);
        LecturaDatos lectura = new LecturaDatos();

        int ultimResultat = 0;
        int num1 = lectura.pideEntero(in);
        int num2 = lectura.pideEntero(in);

        boolean correcte;
        String operacio;

        do {
            System.out.println("Introduzca la operación a realizar (+,-,*,/):");
            operacio = in.nextLine();
            correcte = true;
            switch (operacio) {
                case "+":
                    ultimResultat = sumar(num1, num2);
                    break;
                case "-":
                    ultimResultat = restar(num1, num2);
                    break;
                case "*":
                    ultimResultat = multiplicar(num1, num2);
                    break;
                case "/":
                    ultimResultat = dividir(num1, num2);
                    break;
                default:
                    correcte = false;
                    break;
            }
        } while (!correcte);

        System.out.println(num1 + " " + operacio + " " + num2 + " = " + ultimResultat);
    }

    static int sumar(int num1, int num2) {
        return num1 + num2;
    }

    static int restar(int num1, int num2) {
        return num1 - num2;
    }

    static int multiplicar(int num1, int num2) {
        return num1 * num2;
    }

    static int dividir(int num1, int num2) {
        return num1 / num2;
    }
}
