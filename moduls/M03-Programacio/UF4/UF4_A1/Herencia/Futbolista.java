package UF4.Objetos.UF4_A1.Herencia;

public class Futbolista extends SeleccionFutbol
{
    private int dorsal;
    private String demarcacion;

    public Futbolista(int i, String andres, String iniesta, int i1, int i2, String interiorDerecho) {
        super();
    }

    // Constructor, getter y setter

    @Override
    public void entrenar() {
        System.out.println("Realiza un entrenamiento (Clase Futbolista)");
    }

    @Override
    public void jugarPartido() {
        System.out.println("Juega un Partido (Clase Futbolista)");
    }

    public void entrevista() {
        System.out.println("Da una Entrevista");
    }
}
