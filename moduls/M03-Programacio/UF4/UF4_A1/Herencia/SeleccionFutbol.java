package UF4.Objetos.UF4_A1.Herencia;

public abstract class SeleccionFutbol implements IntegrantesSeleccionFutbol{
    protected int id;

    protected String nombre;

    protected String apellidos;

    protected int edad;

    // Constructor, getter y setter

    public void concentrarse() {
        System.out.println("Concentrarse (Clase Padre)");
    }

    public void viajar() {
        System.out.println("Viajar (Clase Padre)");
    }

    public void entrenar() {
        System.out.println("Entrenar (Clase Padre)");
    }

    public void jugarPartido() {
        System.out.println("Asiste al Partido de Fútbol (Clase Padre)");
    }

    public boolean getNombre() {
        return false;
    }

    public Object getApellidos() {
        return false;
    }
}
