#include <iostream>
using namespace std;

int main() {

```
int hora, minutos, segundos;
char opcion;

do {
    cout << "Ingrese la hora: ";
    cin >> hora;

    cout << "Ingrese los minutos: ";
    cin >> minutos;

    cout << "Ingrese los segundos: ";
    cin >> segundos;

    cout << "Hora registrada: "
         << hora << ":" << minutos << ":" << segundos << endl;

    cout << "¿Desea cambiar la hora? (S/N): ";
    cin >> opcion;

} while (opcion == 'S' || opcion == 's');

cout << "Programa finalizado." << endl;

return 0;
```

}

