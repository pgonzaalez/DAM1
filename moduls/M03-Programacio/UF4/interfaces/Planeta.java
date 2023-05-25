package UF4.Objetos.interfaces;

public class Planeta extends Esfera {
    int numSatelits;

    public void getNumSatelits() {
    }
    public static void main(String[] args) {
        Planeta p1 = new Planeta();
        Esfera e = new Planeta();
        
        ((Planeta) e).getNumSatelits();

    }
}
