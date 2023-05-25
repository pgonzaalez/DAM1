package UF4.Objetos.herenciaMultiple;

public class Persona {
    private String nombre;
    private int edad;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }


    public void andar() {
        System.out.println("la persona " +nombre+ "anda");
    }
}
