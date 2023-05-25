package UF4.Objetos.lords_of_steel;
import java.util.Scanner;
import java.util.ArrayList;

public class LordsOfSteel {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Nan higuain = new Nan("higuain", 8, 6, 13, 16, 16, new Arma("Daga"));
        Huma umtiti = new Huma("umtiti", 13, 16, 6, 10, 6, new Arma("Espasa"));
        Mitja callejon = new Mitja("callejon", 9, 7, 7, 15, 16, new Arma("Martell"));
        Maia diarra = new Maia("diarra", 7, 9, 12, 15, 17, new Arma("Daga"));
        
        ArrayList<Personatge> personatges = new ArrayList<Personatge>();
        personatges.add(higuain);
        personatges.add(umtiti);
        personatges.add(callejon);
        personatges.add(diarra);

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
            /* Menu principal */

            System.out.print("Tria opció [1-5]: ");
            entrada = sc.nextInt();

            if (entrada == 5){
                System.out.println("Gracies per jugar!");
            } else {
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
                }
            }
        } while (entrada != 5);
    }

    public static void afegirPersonatge(ArrayList<Personatge> personatges) {
        System.out.println("");
        System.out.println("* Afegir personatge *");
        System.out.println("Has de repartir 60 punts per les habilitats, " +
        "totes les habilitates han de tenir minim 3 punts i maxim 18 punts");
        System.out.println("");


        // Leer los datos del nuevo personaje
        System.out.println("Nom: ");
        String nom = sc.nextLine();

        System.out.println("Tipus: ");
        String tipus = sc.nextLine();

        System.out.println("Força: ");
        int força = Integer.parseInt(sc.nextLine());

        System.out.println("Consistencia: ");
        int cons = Integer.parseInt(sc.nextLine());

        System.out.println("Velocitat: ");
        int vel = Integer.parseInt(sc.nextLine());

        System.out.println("Inteligencia: ");
        int intel = Integer.parseInt(sc.nextLine());

        System.out.println("Sort: ");
        int sort = Integer.parseInt(sc.nextLine());

        System.out.println("Arma: ");
        System.out.println("'daga','espasa','martell'");
        String arma = sc.nextLine();

        // Crear el nuevo personaje y agregarlo a la lista de personajes
        Personatge nou = null;
        arma.toLowerCase();
        tipus.toLowerCase();
        if (tipus.equals("huma")) {
            nou = new Huma(nom, força, cons, vel, intel, sort, new Arma(arma));
        } else if ( tipus.equals("mitja")) {
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
        System.out.println("Personatges existens");
        mostraPersonatges(personatges);
        System.out.println("Quin personatge vols esborrar?");
        int tria = sc.nextInt();
        personatges.remove(tria - 1);
        mostraPersonatges(personatges);
    }
    public static void editarPersonatge(ArrayList<Personatge> personatges) {

    }

    public static void iniciarCombat(ArrayList<Personatge> personatges) {
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
            lluitadors[i-1]=personatges.get(opcio - 1);
          
        }
        Personatge atacant = lluitadors[0];
        Personatge defensor = lluitadors[1];
        Dau dau1 = new Dau();
        Dau dau2 = new Dau();
        Dau dau3 = new Dau();
        
        do {
            int valor = dau1.llencar()+dau2.llencar()+dau3.llencar();

            System.out.println("Valor dels daus: "+valor);
            
            if (valor<=atacant.getPa()) {
                System.out.println(atacant.getNom()+" pot atacar");
                    int valor2 = dau1.llencar()+dau2.llencar()+dau3.llencar();
                if (valor2 > defensor.getPe()) {
                    System.out.println(defensor.getNom()+" no ha pogut esquivar l'atac");
                    defensor.setPs(defensor.getPs()-atacant.getPd());
                    if (defensor.getPs()>0) {
                       System.out.println(defensor.getNom()+" s'ha quedat amb "+defensor.getPs()+" punts de salut");
                    } else
                        System.out.println(RED + defensor.getNom()+" ha mort!" + RESET);
                } else
                    System.out.println(defensor.getNom()+" ha pogut esquivar l'atac");

            } else {
                System.out.println(atacant.getNom()+" no pot atacar");
            }
            
        Personatge aux = atacant;
        atacant=defensor;
        defensor=aux;
        } while (defensor.getPs()>0 &&  atacant.getPs()>0);

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