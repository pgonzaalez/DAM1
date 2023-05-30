package UF3;

import java.io.*;

public class A2 {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("C:\\Users\\iamno\\IdeaProjects\\PracticaM03\\src\\UF3\\resultats.txt");
            BufferedReader entrada = new BufferedReader(fr);

            final int totalPartits = 10;
            String[] equips = new String[totalPartits * 2];
            int[] puntuacio = new int[totalPartits * 2];

            String partit;
            int i = 0;

            while ((partit = entrada.readLine()) != null) {
                equips[i * 2] = partit.split("-")[0].split(":")[0];
                int golsEquip1 = Integer.parseInt(partit.split("-")[0].split(":")[1]);

                equips[i * 2 + 1] = partit.split("-")[1].split(":")[0];
                int golsEquip2 = Integer.parseInt(partit.split("-")[1].split(":")[1]);

                if (golsEquip1 > golsEquip2) {
                    puntuacio[i * 2] += 3;
                } else if (golsEquip1 < golsEquip2) {
                    puntuacio[i * 2 + 1] += 3;
                } else {
                    puntuacio[i * 2] += 1;
                    puntuacio[i * 2 + 1] += 1;
                }
                ++i;
            }
            entrada.close();

            mostrarClassificacions(equips, puntuacio);

            ordenacio(equips, puntuacio);

            System.out.println("\n\n*** Clasificacio final ***");
            mostrarClassificacions(equips, puntuacio);

            BufferedWriter sortida = new BufferedWriter(new FileWriter("C:\\Users\\iamno\\IdeaProjects\\PracticaM03\\src\\UF3\\classificacio.txt"));

            for (i = 0; i < equips.length; i++) {
                sortida.write(equips[i] + ":" + puntuacio[i] + "\n");
            }
            sortida.close();

            System.out.println("Se ha generado el archivo 'classificacio.txt' con la clasificación.");

        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }

    // Afegiment: Mètode per a ordenar els equips i puntuacions en ordre descendent de puntuació
    static void ordenacio(String[] equips, int[] puntuacions) {
        for (int i = 0; i < puntuacions.length - 1; i++) {
            for (int j = 0; j < puntuacions.length - i - 1; j++) {
                if (puntuacions[j] < puntuacions[j + 1]) {
                    // Intercambiar puntuacions
                    int tempPuntuacio = puntuacions[j];
                    puntuacions[j] = puntuacions[j + 1];
                    puntuacions[j + 1] = tempPuntuacio;

                    // Intercambiar equipos
                    String tempEquip = equips[j];
                    equips[j] = equips[j + 1];
                    equips[j + 1] = tempEquip;
                }
            }
        }
    }

    // Afegiment: Mètode per a mostrar la classificació
    static void mostrarClassificacions(String[] equips, int[] puntuacions) {
        System.out.println("Classificació:");
        for (int i = 0; i < equips.length; i++) {
            System.out.println(equips[i] + " - Punts: " + puntuacions[i]);
        }
    }
}
