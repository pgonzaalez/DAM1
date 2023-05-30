package UF3.ex;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class FileTest {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        crearFitxerHola(3, new File("C:\\Users\\iamno\\IdeaProjects\\PracticaM03\\src\\UF3\\ex\\hola.txt"));
        mostraFitxerHola(new File("C:\\Users\\iamno\\IdeaProjects\\PracticaM03\\src\\UF3\\ex\\hola.txt"));
    }

    static void crearFitxerHola(int n , File f) throws IOException {
        PrintWriter pw = new PrintWriter(f);
        for (int i = 0 ; i < n ; i++){
            pw.println("Hola mundo");
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
