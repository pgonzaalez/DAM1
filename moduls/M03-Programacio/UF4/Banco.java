package UF4.Objetos;

// @author pgonzalez

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
    static List<Cuenta> cuentas = new ArrayList<Cuenta>();

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int id= 0;
        int saldo;
        System.out.println("Bienvenido al banco");
        System.out.println("-------------------");
        System.out.println("Elige la opcion que quieres hacer");
        System.out.println("-------------------");
        System.out.println("1. Acceder a la cuenta");
        System.out.println("2. Crear a la cuenta");
        System.out.println("0. Sortir");
        System.out.println("-------------------");
        int option;
        do {
            option = sn.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Cual es tu numero de cuenta?");
                    int numCuenta = sn.nextInt();
                    Cuenta cuentaConsulta = findCuentaByID(numCuenta, cuentas);
                    if (cuentaConsulta != null) {
                        id = numCuenta;
                        System.out.println("1. Consultar Saldo ");
                        System.out.println("2. Ingresar");
                        System.out.println("3. Retirar");
                        System.out.println("4. Transferencia");
                        System.out.println("0. Sortir");
                        System.out.println("-------------------");
                        int opcion;
                        do {
                            opcion = sn.nextInt();
                            switch (opcion) {
                                case 1:
                                    System.out.println(" El saldo es " + findCuentaByID(id, cuentas).consultarSaldo());
                                    break;
                                case 2:
                                    if (findCuentaByID(id, cuentas).ingresar(100)) {
                                        System.out.println("Operacion realizada correctamente");
                                    } else {
                                        System.out.println("Error, Algo no ha ido bien.");
                                    }
                                    break;
                                case 3:
                                    if (findCuentaByID(id, cuentas).retirar(50)) {
                                        System.out.println("Operacion realizada correctamente");
                                    } else {
                                        System.out.println("Error, Algo no ha ido bien.");
                                    }
                                    break;
                                case 4:
                                    System.out.println("A que cuenta quieres hacer la transferencia?");
                                    int receptor = sn.nextInt();
                                    Cuenta cuentaReceptora = findCuentaByID(receptor, cuentas);
                                    if (cuentaReceptora != null) {
                                        id = receptor;
                                        if (findCuentaByID(id, cuentas).realizarTransferencia(50, findCuentaByID(receptor, cuentas))) {
                                            System.out.println("Operacion realizada correctamente");
                                        } else {
                                            System.out.println("Error, Algo no ha ido bien.");
                                        }
                                    }
                                    break;

                            }
                        } while (opcion != 0);
                    } else {
                        System.out.println("La cuenta no existe");
                    }
                    break;
                case 2:
                    System.out.println("Introdueix numero de cuenta");
                    id = sn.nextInt();

                    if (!añadirCuenta(id, cuentas)) {
                        System.out.println("Cuenta añadida correctamente");
                    } else {
                        System.out.println("El ID ya existe");
                    }
                    break;
                case 0:

                    break;
            }
        } while (option != 0);


    }

    public static Cuenta findCuentaByID(int id, List<Cuenta> cuentas) {
        Cuenta cuenta = null;
        Cuenta cuentaEncontrada = null;
        for (int i = 0; i < cuentas.size(); i++) {
            cuenta = (Cuenta) cuentas.get(i);
            if (cuenta.id == id) {
                cuentaEncontrada = cuenta;
            }
        }
        return cuentaEncontrada;
    }

    public static boolean añadirCuenta(int id, List<Cuenta> cuentas) {
        boolean existe = false;
        for (int i = 0; i < cuentas.size(); i++) {
            if (cuentas.get(i).id == id) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            cuentas.add(new Cuenta(id));
            return false;
        } else {
            return true;
        }
    }
}

class Cuenta {
    private int saldo;
    public int id;

    public Cuenta(int id) {
        this.id = id;
    }

    public Cuenta(int id, int saldoCuenta) {
        this.id = id;
        saldo = saldoCuenta;

    }

    public boolean retirar(int cantidad) {
        if (cantidad > 0) {
            saldo = saldo - cantidad;
            return true;
        }

        return false;
    }

    public boolean ingresar(int cantidad) {
        if (cantidad > 0) {
            saldo = saldo + cantidad;
            return true;
        }

        return false;
    }

    public int consultarSaldo() {
        return saldo;
    }

    public boolean realizarTransferencia(int cantidad, Cuenta numeroCuenta) {
        if (cantidad > 0) {
            numeroCuenta.saldo = saldo + cantidad;
            saldo = saldo - cantidad;
            return true;
        }

        return false;
    }
}


