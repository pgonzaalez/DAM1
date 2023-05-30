package UF3.examen;

import java.io.*;
import java.util.Scanner;

public class UF3_1 {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        boolean sortir = false;
        while (!sortir) {
            System.out.println("\n1.- Afegir client");
            System.out.println("2.- Mostrar llista clients [tots]");
            System.out.println("3.- Mostrar llista clients [majors edat]");
            System.out.println("4.- Generar mailing");
            System.out.println("5.- Sortir");
            System.out.print("\nTria opció: ");
            int opcio = in.nextInt();
            switch (opcio) {
                case 1:
                    afegirDadesClient();
                    break;
                case 2:
                    mostrarLlistaClients(false);
                    break;
                case 3:
                    mostrarLlistaClients(true);
                    break;
                case 4:
                    generarMailing();
                    break;
                default:
                    System.out.println("Adeu!!");
                    sortir = true;
            }
        }
    }
    private static void afegirDadesClient(){
        Scanner in = new Scanner(System.in);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\iamno\\IdeaProjects\\PracticaM03\\src\\UF3\\examen\\clients.txt", true))) {
            while (true) {
                System.out.print("Quin es el teu nom? ");
                String nom = in.nextLine();
                if (nom.isEmpty()){
                    break;
                }
                System.out.print("Ets major d'edat? ");
                String majorEdat = in.nextLine();
                writer.write(nom + ";" + majorEdat);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error, no s'ha pogut llegir el fitxer.");
        }
    }
    private static void mostrarLlistaClients(boolean nomesMajors){
        try (BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\iamno\\IdeaProjects\\PracticaM03\\src\\UF3\\examen\\clients.txt"))) {
            String liniaArxiu;
            while ((liniaArxiu = lector.readLine()) != null) {
                String[] partsArxiu = liniaArxiu.split(";");
                String nomClient = partsArxiu[0];
                String majorEdat = partsArxiu[1];
                if (nomesMajors) {
                    if (majorEdat.equalsIgnoreCase("si")) {
                        System.out.println(nomClient);
                    }
                } else {
                    System.out.println(nomClient);
                }
            }
        } catch (IOException e) {
            System.out.println("Error, no s'ha pogut llegir el fitxer.");
        }
    }
    private static void generarMailing(){
        try (BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\iamno\\IdeaProjects\\PracticaM03\\src\\UF3\\examen\\clients.txt"))) {
            String numlinia;
            while ((numlinia = lector.readLine()) != null) {
                String[] data = numlinia.split(";");
                String nomClient = data[0];
                String nomFitxer = "C:\\Users\\iamno\\IdeaProjects\\PracticaM03\\src\\UF3\\examen\\mail\\" + nomClient.toLowerCase().replace(" ", "_") + ".html";
                String contingut = plantilla(nomClient);
                try (BufferedWriter escriu = new BufferedWriter(new FileWriter(nomFitxer))) {
                    escriu.write(contingut);
                    System.out.println("S'ha generat el fitxer correctament");
                } catch (IOException e) {
                    System.out.println("Error, no s'ha pogut escriure el fitxer de benvinguda.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error, no s'ha pogut llegir el fitxer.");
        }
    }

    private static String plantilla(String nomClient) {
        try (BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\iamno\\IdeaProjects\\PracticaM03\\src\\UF3\\examen\\plantilles\\plantilla.html"))) {
            StringBuilder generaMail = new StringBuilder();
            String liniaArxiu;
            while ((liniaArxiu = lector.readLine()) != null) {
                liniaArxiu = liniaArxiu.replace("{nom_client}", nomClient);
                generaMail.append(liniaArxiu).append("\n");
            }
            return generaMail.toString();
        } catch (IOException e) {
            System.out.println("Error, no s'ha pogut llegir el fitxer de plantilla.");
        }
        return "";
    }
}
