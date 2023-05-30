package UF3.ex;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileTest2 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        String fileIN =  sc.next();
        String fileOUT =  sc.next();;

        File in = new File(fileIN);
        File out = new File(fileOUT);

        Scanner fin = new Scanner(out);
        int i= 0;
        while(fin.hasNextLine()){
            System.out.println(i + "-. " + fin.nextLine());
            i++;
        }
    }



}
