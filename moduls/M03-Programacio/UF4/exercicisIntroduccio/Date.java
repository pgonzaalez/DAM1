package UF4.Objetos.exercicisIntroduccio;

public class Date {
    private int dia;
    private int mes;
    private int any;

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAny() {
        return any;
    }

    public void setDia(int d) {
        if (d > 0){
            switch (mes){
                case 4:
                case 6:

                case 9:
                case 11:
                    if (d<= 30){
                        this.dia = d;
                    }
                    break;
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (d<= 31){
                        this.dia = d;
                    }
                    break;
                case 2:
                    if ((any % 4 == 0) && (any % 100 != 0) || (any % 400 == 0)) {
                        if (d <= 29){
                            this.dia = d;
                        }
                    } else {
                        if (d<= 28){
                            this.dia = d;
                        }
                    }
                    break;
            }
        } else {
            System.out.println("Dia no valid");
        }
    }

    public void setMes(int m) {
        if (m >=12){
            this.mes = m;
        } else {
            System.out.println("Mes no valid");
        }
    }

    public void setAny(int a) {
        if (a >= 0){
            this.any = a;
        } else {
            System.out.println("Any no valid");
        }

    }

    public static void main(String[] args) {
        Date a = new Date();

        a.setDia(29);
        a.setMes(2);
        a.setAny(2024);

        System.out.println(a.getDia() +"/" +a.getMes() +"/" +a.getAny());


    }
}

