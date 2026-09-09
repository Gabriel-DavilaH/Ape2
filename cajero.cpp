#include <iostream>
using namespace std;

int main() {
    int dni, cantidad, cuenta = 0, opcion, origen, destino;
    double monto;

    int numeros[3];
    double saldos[3];

    cout << "=== SISTEMA DE CUENTAS BANCARIAS ===" << endl;
    cout << "Ingrese el DNI del cliente: ";
    cin >> dni;

    do {
        cout << "¿Cuántas cuentas desea crear? (1-3): ";
        cin >> cantidad;
    } while (cantidad < 1 || cantidad > 3);

    for (int i = 0; i < cantidad; i++) {
        cout << "Ingrese el número de la cuenta " << i + 1 << ": ";
        cin >> numeros[i];

        cout << "Ingrese el saldo inicial: ";
        cin >> saldos[i];
    }

    do {
        cout << "\n=== MENU ===" << endl;
        cout << "1. Ver atributos de la cuenta" << endl;
        cout << "2. Enviar dinero" << endl;
        cout << "3. Recibir dinero" << endl;
        cout << "4. Transferir entre cuentas" << endl;
        cout << "5. Salir" << endl;
        cout << "Seleccione una opcion: ";
        cin >> opcion;

        if (opcion >= 1 && opcion <= 4) {
            cout << "Seleccione el número de cuenta (1-" 
                 << cantidad << "): ";
            cin >> cuenta;

            cuenta = cuenta - 1;
        }

        switch (opcion) {

            case 1:
                cout << "DNI del cliente: " << dni << endl;
                cout << "Número de cuenta: " << numeros[cuenta] << endl;
                cout << "Saldo: $" << saldos[cuenta] << endl;
                break;

            case 2:
                cout << "Ingrese el monto a enviar: ";
                cin >> monto;

                if (monto > 0 && monto <= saldos[cuenta]) {
                    saldos[cuenta] -= monto;

                    cout << "Dinero enviado correctamente." << endl;
                    cout << "Nuevo saldo: $" << saldos[cuenta] << endl;
                } else {
                    cout << "Saldo insuficiente o monto inválido." << endl;
                }
                break;

            case 3:
                cout << "Ingrese el monto a recibir: ";
                cin >> monto;

                if (monto > 0) {
                    saldos[cuenta] += monto;

                    cout << "Dinero recibido correctamente." << endl;
                    cout << "Nuevo saldo: $" << saldos[cuenta] << endl;
                } else {
                    cout << "Monto inválido." << endl;
                }
                break;

            case 4:
                cout << "Ingrese la cuenta de origen (1-" 
                     << cantidad << "): ";
                cin >> origen;

                cout << "Ingrese la cuenta de destino (1-" 
                     << cantidad << "): ";
                cin >> destino;

                cout << "Ingrese el monto a transferir: ";
                cin >> monto;

                origen = origen - 1;
                destino = destino - 1;

                if (origen != destino &&
                    monto > 0 &&
                    monto <= saldos[origen]) {

                    saldos[origen] -= monto;
                    saldos[destino] += monto;

                    cout << "Transferencia realizada correctamente." 
                         << endl;
                } else {
                    cout << "No se pudo realizar la transferencia." 
                         << endl;
                }
                break;

            case 5:
                cout << "Saliendo del sistema..." << endl;
                break;

            default:
                cout << "Opción inválida." << endl;
                break;
        }

    } while (opcion != 5);

    return 0;
}
