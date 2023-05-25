package UF4.Objetos.exercicisIntroduccio;

public class ClasseA {
    int valor1;
    int valor2;

    public ClasseA() {
        valor1 = 5;
        valor2 = 10;
    }

    public ClasseA(int vp) {
        valor1 = vp;
        valor2 = 10;
    }

    public ClasseA(int vp, int vs) {
        valor1 = vp;
        valor2 = vs;
    }

    public int getPrimari() {
        return valor1;
    }

    public int getSecundari() {
        return valor2;
    }

    public static void main(String[] args) {
        ClasseA a = new ClasseA();
        ClasseA b = new ClasseA(20);
        ClasseA c = new ClasseA(20, 40);
        System.out.println("L'objecte _a:_ conté: " + a.getPrimari() + ", " + a.getSecundari());
        System.out.println("L'objecte _b:_ conté: " + b.getPrimari() + ", " + b.getSecundari());
        System.out.println("L'objecte _c:_ conté: " + c.getPrimari() + ", " + c.getSecundari());
    }

}
