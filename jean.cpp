#include <iostream>
#include <string>
using namespace std;

class Jean {
private:
    string codigo;
    string color;
    string talla;
    bool fueTenido;
    int cantidadTenidos;
    double precio;
    int cantidadBotones;
    int humedad; // en %
    string estadoTela; // Ej: Nueva, Desgastada, Seca

public:

    // Constructor
    Jean(string codigo, string color, string talla, bool fueTenido,
         int cantidadTenidos, double precio, int cantidadBotones,
         int humedad, string estadoTela) {

        this->codigo = codigo;
        this->color = color;
        this->talla = talla;
        this->fueTenido = fueTenido;
        this->cantidadTenidos = cantidadTenidos;
        this->precio = precio;
        this->cantidadBotones = cantidadBotones;
        this->humedad = humedad;
        this->estadoTela = estadoTela;
    }

    // Método Lavar
    void Lavar() {

        if (cantidadTenidos > 0) {
            cantidadTenidos--;

            cout << "Lavando... Cantidad de tenidos bajo a: "
                 << cantidadTenidos << endl;

            if (cantidadTenidos == 0) {
                fueTenido = false;
            }

        } else {
            cout << "El jean ya no tiene tenido." << endl;
        }

        humedad = 100;
        estadoTela = "Mojada";
    }

    // Método Secar
    void Secar() {

        if (humedad > 0) {
            humedad -= 20;

            if (humedad < 0) {
                humedad = 0;
            }

            cout << "Secando... Humedad actual: "
                 << humedad << "%" << endl;

            if (humedad == 0) {
                estadoTela = "Seca";
            }

        } else {
            cout << "El jean ya esta seco." << endl;
        }
    }

    // Método MostrarDatos
    void MostrarDatos() {

        cout << "\n--- DATOS DEL JEAN ---" << endl;
        cout << "Codigo: " << codigo << endl;
        cout << "Color: " << color << endl;
        cout << "Talla: " << talla << endl;

        cout << "Fue tenido: "
             << (fueTenido ? "Si" : "No") << endl;

        cout << "Cantidad tenidos restantes: "
             << cantidadTenidos << endl;

        cout << "Precio: $" << precio << endl;

        cout << "Cantidad botones: "
             << cantidadBotones << endl;

        cout << "Humedad: "
             << humedad << "%" << endl;

        cout << "Estado tela: "
             << estadoTela << endl;
    }
};
