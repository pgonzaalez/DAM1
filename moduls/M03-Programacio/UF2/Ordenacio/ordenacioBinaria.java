package UF2.Ordenacio;

public class ordenacioBinaria {
    static int cercaBinaria(String[] paisosOrdenats, String paisEscollit) {
        int resultat = -1;
        int esquerra = 0;
        int dreta = paisosOrdenats.length - 1;
        int meitat;
        int passades = 0;


        while (esquerra <= dreta) {
            meitat = (esquerra + dreta) / 2;
            passades++;

            if (paisosOrdenats[meitat].equalsIgnoreCase(paisEscollit)) {
                resultat = meitat;
                break;
            } else if (paisosOrdenats[meitat].compareToIgnoreCase(paisEscollit) < 0) {
                esquerra = meitat + 1;
            } else {
                dreta = meitat - 1;
            }
        }

        System.out.println("Total passades: " + passades);
        return resultat;




    }
}

