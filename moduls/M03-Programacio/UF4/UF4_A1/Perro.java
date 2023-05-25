package UF4.Objetos.UF4_A1;

public class Perro extends Animal{
    public String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void ladrar(){
        System.out.println("GUAU!");
    }
    public String toString(){
        return "Perro {nombre: " + nombre + " , edat: " + edat + "}";
    }

}
