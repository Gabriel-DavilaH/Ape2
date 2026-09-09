public class Jean {
    private String codigo;
    private String color;
    private String talla;
    private boolean fueTenido;
    private int cantidadTenidos;
    private double precio;
    private int cantidadBotones;
    private int humedad; // en %
    private String estadoTela; // Ej: Nueva, Desgastada, Seca

    public Jean(String codigo, String color, String talla, boolean fueTenido, int cantidadTenidos, double precio, int cantidadBotones, int humedad, String estadoTela) {
        this.codigo = codigo;
        this.color = color;
        this.talla = talla;
        this.fueTenido = fueTenido;
        this.cantidadTenidos = cantidadTenidos;
        this.precio = precio;
        this.cantidadBotones = cantidadBotones;
        this.humedad = humedad;
        this.estadoTela = estadoTela;
    }

    public void Lavar() {
        if (cantidadTenidos > 0) {
            cantidadTenidos--;
            System.out.println("Lavando... Cantidad de teñidos bajó a: " + cantidadTenidos);
            if (cantidadTenidos == 0) fueTenido = false;
        } else {
            System.out.println("El jean ya no tiene teñido.");
        }
        humedad = 100;
        estadoTela = "Mojada";
    }

    public void Secar() {
        if (humedad > 0) {
            humedad -= 20;
            if (humedad < 0) humedad = 0;
            System.out.println("Secando... Humedad actual: " + humedad + "%");
            if (humedad == 0) estadoTela = "Seca";
        } else {
            System.out.println("El jean ya está seco.");
        }
    }

    public void MostrarDatos() {
        System.out.println("\n--- DATOS DEL JEAN ---");
        System.out.println("Codigo: " + codigo);
        System.out.println("Color: " + color);
        System.out.println("Talla: " + talla);
        System.out.println("Fue teñido: " + (fueTenido ? "Si" : "No"));
        System.out.println("Cantidad teñidos restantes: " + cantidadTenidos);
        System.out.println("Precio: $" + precio);
        System.out.println("Cantidad botones: " + cantidadBotones);
        System.out.println("Humedad: " + humedad + "%");
        System.out.println("Estado tela: " + estadoTela);
    }
}
