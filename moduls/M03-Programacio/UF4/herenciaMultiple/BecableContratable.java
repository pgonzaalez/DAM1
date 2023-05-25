package UF4.Objetos.herenciaMultiple;

public interface BecableContratable extends Contratable, Becable{

    @Override
    public  default void contratar() {

        System.out.println("contratamos a la persona");
    }
    @Override
    public  default void becar() {

        System.out.println("becamos a la persona");
    }

}
