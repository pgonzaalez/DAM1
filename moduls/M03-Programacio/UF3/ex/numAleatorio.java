package UF3.ex;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class numAleatorio {

    public static void main(String[] args) throws IOException {
        generaFitxer(10 , 10);
        mostraFitxerHola(new File("C:\\Users\\iamno\\IdeaProjects\\PracticaM03\\src\\UF3\\ex\\numAleatori.txt"));
    }
    static void generaFitxer(int fila , int columna ) throws IOException {
        File f = new File("C:\\Users\\iamno\\IdeaProjects\\PracticaM03\\src\\UF3\\ex\\numAleatori.txt");
        PrintWriter pw = new PrintWriter(f);
        for (int i = 0 ; i < fila ; i++){
            for (int j = 0 ; j < columna ; j++){
                pw.println(Math.random()* Math.max(-10,10));
            }
        }
        pw.close();
    }


    static void mostraFitxerHola(File f) throws IOException {
        Scanner fin = new Scanner(f);
        while(fin.hasNextLine()){
            System.out.println(fin.nextLine());
        }
    }
}
