package UF4.Objetos.interfaces;

public class Esfera {
    Esfera e = new Esfera();
    double radio;
    double superficie (){
        return 4* Math.PI * radio * radio;
    }
}
