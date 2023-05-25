package UF4.Objetos.UF4_A1.Herencia;

public class Entrenador extends SeleccionFutbol
{
    private int idFederacion;

    public Entrenador(int i, String vicente, String delBosque, int i1, String s) {
        super();
    }

    // Constructor, getter y setter

    @Override
    public void entrenar() {
        System.out.println("Dirige un entrenamiento (Clase Entrenador)");

    }

    @Override
    public void jugarPartido() {
        System.out.println("Dirige un Partido (Clase Entrenador)");
    }

    public void planificarEntrenamiento() {
        System.out.println("Planificar un Entrenamiento");
    }

    public void dirigirPartido() {
    }

    public void dirigirEntreno() {
    }
}