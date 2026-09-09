import java.util.Scanner;

public class ControlDeHora {
public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int hora, minutos, segundos;
    char opcion;

    do {
        System.out.print("Ingrese la hora: ");
        hora = sc.nextInt();

        System.out.print("Ingrese los minutos: ");
        minutos = sc.nextInt();

        System.out.print("Ingrese los segundos: ");
        segundos = sc.nextInt();

        System.out.println("Hora registrada: " 
                + hora + ":" + minutos + ":" + segundos);

        System.out.print("¿Desea cambiar la hora? (S/N): ");
        opcion = sc.next().charAt(0);

    } while (opcion == 'S' || opcion == 's');

    System.out.println("Programa finalizado.");

    sc.close();
}

}
