import java.util.Scanner;

public class Cajero{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dni, cantidad, cuenta = 0, opcion, origen, destino;
        double saldo, monto;
        int[] numeros = new int[3];
        double[] saldos = new double[3];

        System.out.println("=== SISTEMA DE CUENTAS BANCARIAS ===");
        System.out.print("Ingrese el DNI del cliente: ");
        dni = sc.nextInt();

        do {
            System.out.print("¿Cuántas cuentas desea crear? (1-3): ");
            cantidad = sc.nextInt();
        } while (cantidad < 1 || cantidad > 3);

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese el número de la cuenta " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();

            System.out.print("Ingrese el saldo inicial: ");
            saldos[i] = sc.nextDouble();
        }

        do {
            System.out.println("\n=== MENÚ ===");
            System.out.println("1. Ver atributos de la cuenta");
            System.out.println("2. Enviar dinero");
            System.out.println("3. Recibir dinero");
            System.out.println("4. Transferir entre cuentas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Seleccione el número de cuenta (1-" + cantidad + "): ");
                cuenta = sc.nextInt() - 1; // restamos 1 porque en Java el arreglo empieza en 0
            }

            switch (opcion) {
                case 1:
                    System.out.println("DNI del cliente: " + dni);
                    System.out.println("Número de cuenta: " + numeros[cuenta]);
                    System.out.println("Saldo: $" + saldos[cuenta]);
                    break;

                case 2:
                    System.out.print("Ingrese el monto a enviar: ");
                    monto = sc.nextDouble();
                    if (monto > 0 && monto <= saldos[cuenta]) {
                        saldos[cuenta] -= monto;
                        System.out.println("Dinero enviado correctamente.");
                        System.out.println("Nuevo saldo: $" + saldos[cuenta]);
                    } else {
                        System.out.println("Saldo insuficiente o monto inválido.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el monto a recibir: ");
                    monto = sc.nextDouble();
                    if (monto > 0) {
                        saldos[cuenta] += monto;
                        System.out.println("Dinero recibido correctamente.");
                        System.out.println("Nuevo saldo: $" + saldos[cuenta]);
                    } else {
                        System.out.println("Monto inválido.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese la cuenta de origen (1-" + cantidad + "): ");
                    origen = sc.nextInt() - 1;
                    System.out.print("Ingrese la cuenta de destino (1-" + cantidad + "): ");
                    destino = sc.nextInt() - 1;
                    System.out.print("Ingrese el monto a transferir: ");
                    monto = sc.nextDouble();

                    if (origen!= destino && monto > 0 && monto <= saldos[origen]) {
                        saldos[origen] -= monto;
                        saldos[destino] += monto;
                        System.out.println("Transferencia realizada correctamente.");
                    } else {
                        System.out.println("No se pudo realizar la transferencia.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion!= 5);

        sc.close();
    }
}
