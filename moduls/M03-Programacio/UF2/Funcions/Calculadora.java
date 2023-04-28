/**
 * @author pgonzalez
 */
import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1;
        int num2;
        String operacio;
        int resultatOperacio = 0;


        do {
            num1 = in.nextInt();
            if ( num1 == 0 ) {
            } else {
                num2 = in.nextInt();
                operacio = in.next();
                switch (operacio) {
                    case "+":
                        resultatOperacio = suma(num1, num2);
                        System.out.println(num1 + " " + operacio + " " + num2 + " = " + resultatOperacio);
                        break;
                    case "-":
                        resultatOperacio = resta(num1, num2);
                        System.out.println(num1 + " " + operacio + " " + num2 + " = " + resultatOperacio);
                        break;
                    case "x":
                        resultatOperacio = multiplicacio(num1, num2);
                        System.out.println(num1 + " " + operacio + " " + num2 + " = " + resultatOperacio);
                        break;
                    case "/":
                        resultatOperacio = divisio(num1, num2);
                        System.out.println(num1 + " " + operacio + " " + num2 + " = " + resultatOperacio);
                        break;
                    default:
                        System.out.println("Operació no vàlida");
                }

            }
        } while (num1 != 0);
    }

    public static int suma(int num1, int num2) {
        int resultatSuma = 0;

        resultatSuma = num1 + num2;

        return resultatSuma;
    }

    public static int resta(int num1, int num2) {
        int resultatResta = 0;

        resultatResta = num1 - num2;

        return resultatResta;
    }

    public static int multiplicacio(int num1, int num2) {
        int resultatMultiplicacio = 0;
        resultatMultiplicacio = num1 * num2;
        return resultatMultiplicacio;
    }

    public static int divisio(int num1, int num2) {
        int resultatDivisio = 0;
        if(num2 == 0){
            System.out.println("No es pot dividir per 0.");
        }
        resultatDivisio = num1 / num2;
        return resultatDivisio;
    }
}