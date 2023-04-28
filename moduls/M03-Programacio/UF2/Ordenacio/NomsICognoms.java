package UF2.Ordenacio;

public class NomsICognoms {
    public static void main(String[] args) {

        String[] nomsComplets = {"Torres Hernández, Pere", "Majoral Gatell, Anna",
                "Pérez Gomis, Josep", "López López, Rosa",
                "Camps García, Ricard", "Sánchez Pasqual, Carles",
                "Mengual Sánchez, Gemma", "Puig Soler, Jordi"
        };

        System.out.println("Abans d'ordenar:");
        mostraNoms(nomsComplets);

        ordenaBombolla(nomsComplets);

        System.out.println("");
        System.out.println("Després d'ordenar:");
        mostraNoms(nomsComplets);
    }


    static void ordenaBombolla(String[] noms) {

        for(int i = 0; i < noms.length - 1; ++i)
        {
            for (int j = 0; j < noms.length - 1 - i;++j)
            {
                String nom1 = noms[j].split(",")[1].trim();
                String nom2 = noms[j+1].split(",")[1].trim();
                if(nom1.compareToIgnoreCase(nom2) > 0)
                {
                    // Intercanviem posicions
                    String aux = noms[j];
                    noms[j] = noms[j+1];
                    noms[j+1] = aux;
                }
            }
        }

    }

    static void mostraNoms(String[] nomsComplets) {

        for (String nom : nomsComplets)
            System.out.println(nom);

    }
}
