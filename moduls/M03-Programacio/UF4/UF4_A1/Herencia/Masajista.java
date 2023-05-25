package UF4.Objetos.UF4_A1.Herencia;

public class Masajista extends SeleccionFutbol
{
    private String titulacion;
    private int aniosExperiencia;

    public Masajista(int i, String raúl, String martinez, int i1, String licenciadoEnFisioterapia, int i2) {
        super();
    }

    // Constructor, getter y setter

    @Override
    public void entrenar() {
        System.out.println("Da asistencia en el entrenamiento (Clase Masajista)");
    }

    public void darMasaje() {
        System.out.println("Da un Masaje");
    }
}
