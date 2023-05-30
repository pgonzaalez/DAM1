package UF3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Date;
public class A1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quin exercici vols fer?");
        int eleccio = sc.nextInt();
        switch (eleccio) {
            case 1:
                ex1();
                break;
            case 2:
                ex2();
                break;
            case 3:
                ex3();
                break;
            case 4:
                ex4();
                break;
            case 5:
                ex5();
                break;
            case 6:
                ex6();
                break;
            case 7:
                ex7(sc);
                break;
            case 8:
                ex8();
                break;
            case 9:
                ex9();
                break;
            case 10:
                ex10();
                break;
            case 11:
                ex11();
                break;
            case 12:
                ex12(sc);
                break;
        }
    }

    static void ex1() {
        File file = new File("C:\\Users\\iamno\\Documents");
        String[] fileList = file.list();

        for (int i = 0; i < fileList.length; i++) {
            System.out.println(fileList[i]);
        }
    }

    static void ex2() {
        String path = "C:\\Users\\iamno\\Documents";
        File file = new File(path);

        if (file.exists()) {
            System.out.println("El directori o fitxer existeix");
        } else {
            System.out.println("El directori o fitxer no existeix");
        }

    }

    static void ex3() {
        String path = "C:\\Users\\iamno\\Documents\\dembele";
        File file = new File(path);

        if (file.canExecute()) {
            System.out.println("És executable");
        } else {
            System.out.println("No és executable");
        }
        if (file.canRead()) {
            System.out.println("És llegible");
        } else {
            System.out.println("No és llegible");
        }
    }

    static void ex4() {
        String path = "C:\\Users\\iamno\\Documents\\dembele";
        File file = new File(path);

        if (file.isDirectory()) {
            System.out.println("És un directori");
        } else {
            System.out.println("No és un directori");
        }
        if (file.isFile()) {
            System.out.println("És un fitxer");
        } else {
            System.out.println("No és un fitxer");
        }
    }

    static void ex5() {
        String path = "C:\\Users\\iamno\\Documents\\dembele";
        File file = new File(path);
        if (file.exists()) {
            long bytes = file.length();
            double kilobytes = (double) bytes / 1024;
            double megabytes = kilobytes / 1024;

            System.out.println("Tamaño del archivo:");
            System.out.println("Bytes: " + bytes);
            System.out.println("Kilobytes: " + kilobytes);
            System.out.println("Megabytes: " + megabytes);
        } else {
            System.out.println("File doesn't exist");
        }
    }

    static void ex6() {
        String path = "C:\\Users\\iamno\\Documents\\uguntu";
        File folder = new File(path);
        if (folder.isDirectory()) {
            boolean ok = folder.delete();
            if (ok) {
                System.out.println("S'ha esborrat la carpeta " + folder.getAbsolutePath());
            } else {
                System.out.println("S'ha esborrat la carpeta " + folder.getAbsolutePath());
            }
        } else {
            boolean ok = folder.mkdir();
            if (ok) {
                System.out.println("S'ha creat la carpeta " + folder.getAbsolutePath());
            } else {
                System.out.println("S'ha creat la carpeta " + folder.getAbsolutePath());
            }
        }
    }

    public static void ex7(Scanner in) {
        File rutaCarpeta = llegirNomCarpeta(in);
        mostraFitxers(rutaCarpeta, 500);
    }

    public static void ex8() {
        String path = "C:\\Users\\iamno\\Documents\\imagen.jpg";
        File file = new File(path);
        System.out.println(file.getAbsoluteFile());
        Date data = new Date(file.lastModified());
        System.out.println("Darrera modificació: " + data);
        System.out.println("Mida: " + file.length());
    }

    public static void ex9() throws IOException {
        String path = "C:\\Users\\iamno\\Documents\\Fotos";
        String nomFitxer = "C:\\Users\\iamno\\Documents\\Fotos\\imagen.txt";
        File carpeta = new File(path);
        File file = new File(nomFitxer);

        boolean resultat = carpeta.mkdir();
        if (resultat) {
            System.out.println("Creada carpeta " + carpeta.getName() + "? " + resultat);
            file.createNewFile();
            if (file.exists()) {
                System.out.println("Creat fitxer " + file.getName());
            }
        } else {
            boolean delCarpeta = carpeta.delete();
            if (delCarpeta) {
                System.out.println("Esborrada carpeta " + carpeta.getName() + "? " + delCarpeta);
            } else {
                System.out.println("No s'ha pogut esborrar. Està buida ?");
            }

            if (file.exists()) {
                System.out.println("Existeix fitxer " + file.getName() + ". L'esborrem");
                boolean delFitxer = file.delete();
                System.out.println("Esborrat fitxer " + file.getName() + "? " + delFitxer);
                System.out.println("I ara esborrem la carpeta");
                delCarpeta = carpeta.delete();
                if (delCarpeta) {
                    System.out.println("Esborrada carpeta " + carpeta.getName() + "? " + delCarpeta);
                } else {
                    System.out.println("No s'ha pogut esborrar. Està buida ?");
                }
            }
        }
    }

    public static void ex10() {

        String path = "C:\\Users\\iamno\\Documents\\Fotos";
        File file = new File(path);
        String pathBase = "C:\\Users\\Pol\\Downloads";
        String pathdir = pathBase.concat("/Fotos");
        String pathdirNew = pathBase.concat("/Fotos2");
        String pathfile = pathBase.concat("/Fotos2/imagen.txt");
        String pathfileNew = pathBase.concat("/Fotos2/imagen2.txt");

        File origenCarpeta = new File(pathdir);
        File destiCarpeta = new File(pathdirNew);
        File origenDocument = new File(pathfile);
        File destiDocument = new File(pathfileNew);

        boolean resultat = origenCarpeta.renameTo(destiCarpeta);
        System.out.println("S'ha mogut i reanomenat la carpeta? " + resultat);
        resultat = origenDocument.renameTo(destiDocument);
        System.out.println("S'ha mogut el document? " + resultat);
    }

    public static void ex11() {
        String path = "C:\\Users\\iamno\\Documents";
        File carpeta = new File(path);
        File[] arrayElements = carpeta.listFiles();
        System.out.println("El contingut de " + carpeta.getAbsolutePath() + " és:");
        //Per recórrer un array, s'usa un bucle
        for (File f : arrayElements) {
            if (f.isDirectory()) {
                System.out.print("[DIR] ");
            } else {
                System.out.print("[FIT] ");
            }
            System.out.println(f.getName());
        }
    }

    public static void ex12(Scanner in) {
        String nomFitxer = preguntaNomFitxer(in);
        File rutaCarpeta = llegirRutaCarpeta();
        System.out.println("----------");
        cerca(rutaCarpeta, nomFitxer);
    }

    public static void ex13(Scanner in) {
        System.out.print("Escriu l'extensió origen i destí: ");
        String origen = in.next();
        String desti = in.next();

        String dirTreball = System.getProperty("user.dir");
        System.out.println(dirTreball);
        File rutaTreball = new File(dirTreball);

        File[] elements = rutaTreball.listFiles();

        for (int i = 0; i < elements.length; i++) {
            if (elements[i].isFile()) {
                canviaExtensio(elements[i], origen, desti);
            }
        }
    }



    public static void canviaExtensio(File ruta, String or, String des) {
        String nom = ruta.getName();
        int punt = nom.lastIndexOf(".");
        if (punt >= 0) {
            String extOrigen = nom.substring(punt + 1, nom.length());
            if (extOrigen.equals(or)) {
                String nouNom = nom.substring(0, punt + 1) + des;
                nouNom = ruta.getParent() + File.separator + nouNom;
                File novaRuta = new File(nouNom);
                ruta.renameTo(novaRuta);
            }
        }
    }

    public static void cerca(File carpeta, String nom) {
        File[] elements = carpeta.listFiles();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].isDirectory()) {
                cerca(elements[i], nom);
            } else {
                String nomElement = elements[i].getName();
                if (nomElement.equalsIgnoreCase(nom)) {
                    System.out.println("S'ha trobat el fitxer a: " + elements[i].getAbsolutePath());
                }
            }
        }

    }

    public static String preguntaNomFitxer(Scanner in) {
        System.out.println("Quin és el nom del fitxer a buscar?");
        return in.nextLine();
    }

    public static File llegirRutaCarpeta() {
        File file = null;
        boolean preguntar = true;
        Scanner lector = new Scanner(System.in);
        while (preguntar) {
            System.out.println("Escriu el nom d'una ruta a una carpeta: ");
            String nomCarpeta = lector.nextLine();
            file = new File(nomCarpeta);
            if (file.isDirectory()) {
                preguntar = false;
            } else {
                System.out.println("Aquesta carpeta no existeix...");
            }
        }
        return file;
    }

    public static File llegirNomCarpeta(Scanner in) {
        File file = null;
        boolean preguntar = true;
        while (preguntar) {
            System.out.println("Escriu el nom d'una ruta a una carpeta: ");
            String nomCarpeta = in.nextLine();
            file = new File(nomCarpeta);
            if (file.isDirectory()) {
                preguntar = false;
            } else {
                System.out.println("Aquesta carpeta no existeix...");
            }
        }
        return file;
    }

    public static void mostraFitxers(File f, int mida) {
        File[] elements = f.listFiles();
        System.out.println("Els fitxers de més de 500 Kb són:");
        for (int i = 0; i < elements.length; i++) {
            //es pot accedir directament a la ruta usant la posició de l'array.
            if (elements[i].isFile()) {
                if (elements[i].length() > 500 * 1024) {    //1024 = 1 Kilobyte
                    System.out.println(elements[i].getName());
                }
            }
        }
    }

    private static String getSizeMegaBytes(File file) {
        return (double) file.length() / (1024 * 1024) + " mb";
    }

    private static String getSizeKiloBytes(File file) {
        return (double) file.length() / 1024 + "  kb";
    }

    private static String getSizeBytes(File file) {
        return file.length() + " bytes";
    }

    public static int pideEntero(Scanner in) {
        int n = 0;
        boolean correcte = false;

        do {
            if (!in.hasNextInt()) {
                System.out.println("No és un nombre enter");
            } else {
                n = in.nextInt();
                correcte = true;
            }
            in.nextLine();
        } while (!correcte);
        return n;
    }
}
