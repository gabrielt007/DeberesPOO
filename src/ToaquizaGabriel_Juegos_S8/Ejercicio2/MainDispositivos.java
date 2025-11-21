package ToaquizaGabriel_Juegos_S8.Ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

class Dispositivo {
    private String marca;
    private String modelo;
    private double precio;

    public Dispositivo(String marca, String modelo, double precio) throws DatoInvalidoException {
        if (marca == null || marca.isEmpty()) throw new DatoInvalidoException("Marca vacía.");
        if (precio < 0) throw new DatoInvalidoException("Precio negativo.");
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public double getPrecio() { return precio; }

    public void mostrarInfo() {
        System.out.println("Dispositivo -> Marca: " + marca + ", Modelo: " + modelo + ", Precio: $" + precio);
    }
}

class Laptop extends Dispositivo {
    public Laptop(String marca, String modelo, double precio) throws DatoInvalidoException {
        super(marca, modelo, precio);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Laptop -> Marca: " + getMarca() + ", Modelo: " + getModelo() + ", Precio: $" + getPrecio());
    }
}

class Telefono extends Dispositivo {
    public Telefono(String marca, String modelo, double precio) throws DatoInvalidoException {
        super(marca, modelo, precio);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Teléfono -> Marca: " + getMarca() + ", Modelo: " + getModelo() + ", Precio: $" + getPrecio());
    }
}

// Excepción personalizada mínima
class DatoInvalidoException extends Exception {
    public DatoInvalidoException(String mensaje) { super(mensaje); }
}

public class MainDispositivos {
    private static ArrayList<Dispositivo> dispositivos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ DISPOSITIVOS ---");
            System.out.println("1. Registrar Laptop");
            System.out.println("2. Registrar Teléfono");
            System.out.println("3. Mostrar todos");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            try {
                switch (opcion) {
                    case 1 -> registrarLaptop();
                    case 2 -> registrarTelefono();
                    case 3 -> mostrarTodos();
                }
            } catch (DatoInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 0);
    }

    private static void registrarLaptop() throws DatoInvalidoException {
        System.out.print("Marca: ");
        String marca = sc.nextLine();
        System.out.print("Modelo: ");
        String modelo = sc.nextLine();
        System.out.print("Precio: ");
        double precio = sc.nextDouble(); sc.nextLine();
        dispositivos.add(new Laptop(marca, modelo, precio));
    }

    private static void registrarTelefono() throws DatoInvalidoException {
        System.out.print("Marca: ");
        String marca = sc.nextLine();
        System.out.print("Modelo: ");
        String modelo = sc.nextLine();
        System.out.print("Precio: ");
        double precio = sc.nextDouble(); sc.nextLine();
        dispositivos.add(new Telefono(marca, modelo, precio));
    }

    private static void mostrarTodos() {
        if (dispositivos.isEmpty()) System.out.println("No hay dispositivos.");
        else dispositivos.forEach(Dispositivo::mostrarInfo);
    }
}
