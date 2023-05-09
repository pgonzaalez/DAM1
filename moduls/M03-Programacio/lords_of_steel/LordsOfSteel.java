package UF4.lords_of_steel;

import java.util.Scanner;
import java.util.ArrayList;

public class LordsOfSteel {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Nan higuain = new Nan("higuain", 8, 6, 13, 16, 16, new Arma("Daga"));
        Huma umtiti = new Huma("umtiti", 13, 16, 6, 10, 6, new Arma("Espasa"));
        Mitja callejon = new Mitja("callejon", 9, 7, 7, 15, 16, new Arma("Martell"));
        Maia diarra = new Maia("diarra", 7, 9, 12, 15, 17, new Arma("Daga"));

        ArrayList<Personatge> personatges = new ArrayList<Personatge>();
        personatges.add(higuain);
        personatges.add(umtiti);
        personatges.add(callejon);
        personatges.add(diarra);

        /* Menu principal */
        System.out.println("");
        System.out.println("* Benvingut a Terralands *");
        System.out.println("1.- Afegir personatge");
        System.out.println("2.- Esborrar personatge");
        System.out.println("3.- Editar personatge");
        System.out.println("4.- Iniciar combat");
        System.out.println("5.- Sortir");
        System.out.println("");

        int entrada;
        // Comprovar entrada
        do {
            System.out.print("Tria opció [1-5]: ");
            entrada = sc.nextInt();

            if (entrada != 5) {
                switch (entrada) {
                    case 1:
                        afegirPersonatge(personatges);
                        break;
                    case 2:
                        borrarPersonatge(personatges);
                        break;
                    case 3:
                        editarPersonatge(personatges);
                        break;
                    case 4:
                        iniciarCombat(personatges);
                        break;
                    case 5:
                        System.out.println("¡Gracies per jugar!");
                        break;
                    default:
                        break;
                }
            }
        } while (entrada != 5);
    }

    public static void afegirPersonatge(ArrayList<Personatge> personatges) {
        System.out.println("* Afegir personatge *");
        System.out.println("");
        System.out.println("Has de repartir 60 punts per les habilitats, " +
                "totes les habilitates han de tenir minim 3 punts i maxim 18 punts");
        System.out.println("");

        Scanner sc = new Scanner(System.in);




        // Leer los datos del nuevo personaje
        System.out.println("Nom: ");
        String nom = sc.next();

        System.out.println("Tipus: ");
        String tipus = sc.next();

        System.out.println("Força: ");
        int força = Integer.parseInt(sc.next());

        System.out.println("Consistencia: ");
        int cons = Integer.parseInt(sc.next());

        System.out.println("Velocitat: ");
        int vel = Integer.parseInt(sc.next());

        System.out.println("Inteligencia: ");
        int intel = Integer.parseInt(sc.next());

        System.out.println("Sort: ");
        int sort = Integer.parseInt(sc.next());

        System.out.println("Arma- 'daga','espasa','martell' :");
        String arma = sc.next();



        // Crear el nuevo personaje y agregarlo a la lista de personajes
        Personatge nou = null;
        nom.toLowerCase();
        arma.toLowerCase();
        tipus.toLowerCase();
        if (tipus.equals("huma")) {
            nou = new Huma(nom, força, cons, vel, intel, sort, new Arma(arma));
        } else if (tipus.equals("mitja")) {
            nou = new Mitja(nom, força, cons, vel, intel, sort, new Arma(arma));
        } else if (tipus.equals("nan")) {
            nou = new Nan(nom, força, cons, vel, intel, sort, new Arma(arma));
        } else if (tipus.equals("maia")) {
            nou = new Maia(nom, força, cons, vel, intel, sort, new Arma(arma));
        }

        personatges.add(nou);
        mostraPersonatges(personatges);
        System.out.println("Personatge afegit amb èxit!");
    }

    public static void borrarPersonatge(ArrayList<Personatge> personatges) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Personatges existens");
        mostraPersonatges(personatges);
        System.out.println("Quin personatge vols esborrar?");
        int tria = sc.nextInt();
        personatges.remove(tria - 1);
        mostraPersonatges(personatges);
    }

    public static void editarPersonatge(ArrayList<Personatge> personatges) {
        Scanner sc = new Scanner(System.in);

        System.out.println("* Editar personatge *");
        System.out.println("");

        // Mostrar llista de personajes
        mostraPersonatges(personatges);
        System.out.print("Tria el numero del personatge que vols editar: ");
        int index = sc.nextInt() - 1;

        // Seleccionar el personatge triat
        Personatge personatge = personatges.get(index);

        // Mostra els atributs del personatge seleccionat
        System.out.println("");
        System.out.println("Nom: " + personatge.getNom());
        System.out.println("Tipus: " + personatge.getClass().getSimpleName());
        System.out.println("Força: " + personatge.getForça());
        System.out.println("Consistencia: " + personatge.getConstitucio());
        System.out.println("Velocitat: " + personatge.getVelocitat());
        System.out.println("Inteligencia: " + personatge.getIntelligencia());
        System.out.println("Sort: " + personatge.getSort());
        System.out.println("Arma: " + personatge.getArma().getNomArma());
        System.out.println("");

        // Introduir nous valors
        System.out.println("Introdueix els nous valors (o prem enter per deixar els mateixos valors):");

        System.out.print("Nom (" + personatge.getNom() + "): ");
        String nom = sc.nextLine().trim();
        if (!nom.isEmpty()) {
            personatge.setNom(nom);
        }

        System.out.print("Tipus (" + personatge.getClass().getSimpleName() + "): ");
        String tipus = sc.nextLine().trim();
        if (!tipus.isEmpty()) {
            if (tipus.equalsIgnoreCase("huma")) {
                personatges.set(index, new Huma(personatge.getNom(), personatge.getForça(), personatge.getConstitucio(),
                        personatge.getVelocitat(), personatge.getIntelligencia(), personatge.getSort(), personatge.getArma()));
            } else if (tipus.equalsIgnoreCase("mitja")) {
                personatges.set(index, new Mitja(personatge.getNom(), personatge.getForça(), personatge.getConstitucio(),
                        personatge.getVelocitat(), personatge.getIntelligencia(), personatge.getSort(), personatge.getArma()));
            } else if (tipus.equalsIgnoreCase("nan")) {
                personatges.set(index, new Nan(personatge.getNom(), personatge.getForça(), personatge.getConstitucio(),
                        personatge.getVelocitat(), personatge.getIntelligencia(), personatge.getSort(), personatge.getArma()));
            } else if (tipus.equalsIgnoreCase("maia")) {
                personatges.set(index, new Maia(personatge.getNom(), personatge.getForça(), personatge.getConstitucio(),
                        personatge.getVelocitat(), personatge.getIntelligencia(), personatge.getSort(), personatge.getArma()));
            } else {
                System.out.println("El tipus introduit no és vàlid.");
            }
        }

    }


    public static void iniciarCombat(ArrayList<Personatge> personatges) {
        Scanner sc = new Scanner(System.in);
        boolean[] personatgesActius = new boolean[personatges.size()];
        Personatge[] lluitadors = new Personatge[2];
        for (int i = 1; i <= 2; i++) {
            for (int j = 0; j < personatges.size(); j++) {
                if (!personatgesActius[j]) {
                    String tipus = "";
                    if (personatges.get(j) instanceof Nan) {
                        tipus = "Nan";
                    } else if (personatges.get(j) instanceof Huma) {
                        tipus = "Humà";
                    } else if (personatges.get(j) instanceof Mitja) {
                        tipus = "Mitjà";
                    } else if (personatges.get(j) instanceof Maia) {
                        tipus = "Maia";
                    }

                    System.out.println((j + 1) + ".- " + personatges.get(j).getNom() + "(" + tipus + ")");
                }
            }

            System.out.print("Tria un personatge " + i + ": ");
            int opcio = sc.nextInt();
            personatgesActius[opcio - 1] = true;

            System.out.println("Personatge triat: " + personatges.get(opcio - 1).getNom());
            lluitadors[i - 1] = personatges.get(opcio - 1);

        }
        Personatge atacant = lluitadors[0];
        Personatge defensor = lluitadors[1];
        Dau dau1 = new Dau();
        Dau dau2 = new Dau();
        Dau dau3 = new Dau();

        do {
            int valor = dau1.llencar() + dau2.llencar() + dau3.llencar();
            System.out.println("Valor dels daus: " + valor);

            if (valor <= atacant.getPa()) {
                System.out.println(PURPLE + atacant.getNom() + " pot atacar" + RESET);
                int valor2 = dau1.llencar() + dau2.llencar() + dau3.llencar();
                if (valor2 > defensor.getPe()) {
                    System.out.println(YELLOW + defensor.getNom() + " no ha pogut esquivar l'atac" + RESET);
                    defensor.setPs(defensor.getPs() - atacant.getPd());
                    if (defensor.getPs() > 0) {
                        System.out.println(defensor.getNom() + " s'ha quedat amb " + defensor.getPs() + " punts de salut");
                    } else
                        System.out.println(RED + defensor.getNom() + " ha mort!" + RESET);
                } else
                    System.out.println(defensor.getNom() + " ha pogut esquivar l'atac" + RESET);

            } else {
                System.out.println(GREEN + atacant.getNom() + " no pot atacar" + RESET);
            }

            Personatge aux = atacant;
            atacant = defensor;
            defensor = aux;
        } while (defensor.getPs() > 0 && atacant.getPs() > 0);

    }

    private static void mostraPersonatges(ArrayList<Personatge> personatges) {
        for (int i = 0; i < personatges.size(); i++) {
            System.out.println((i + 1) + ".-" + personatges.get(i).getNom());
        }
    }


    // Metodes per els colors
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String RED = "\033[0;31m";
    public static final String RESET = "\u001B[0m";

}