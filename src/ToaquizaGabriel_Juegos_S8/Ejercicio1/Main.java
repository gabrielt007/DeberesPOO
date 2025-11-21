package ToaquizaGabriel_Juegos_S8.Ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Juego {
    protected String nombre;
    protected int nivel;

    public Juego(String nombre, int nivel) throws DatoInvalidoException {
        if (nombre == null || nombre.isEmpty() || nivel <= 0) {
            throw new DatoInvalidoException("Nombre vacío o nivel no válido.");
        }
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public abstract void mostrarInfo();
}

class MarioBros extends Juego {
    private String personaje;

    public MarioBros(String nombre, int nivel, String personaje) throws DatoInvalidoException {
        super(nombre, nivel);
        if (personaje == null || personaje.isEmpty()) {
            throw new DatoInvalidoException("Personaje vacío.");
        }
        this.personaje = personaje;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Mario Bros -> Nombre: " + nombre + ", Nivel: " + nivel + ", Personaje: " + personaje);
    }
}

class CarreraVehiculos extends Juego {
    private String vehiculo;

    public CarreraVehiculos(String nombre, int nivel, String vehiculo) throws DatoInvalidoException {
        super(nombre, nivel);
        if (vehiculo == null || vehiculo.isEmpty()) {
            throw new DatoInvalidoException("Vehículo vacío.");
        }
        this.vehiculo = vehiculo;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Carrera -> Nombre: " + nombre + ", Nivel: " + nivel + ", Vehículo: " + vehiculo);
    }
}

// Excepción personalizada mínima
class DatoInvalidoException extends Exception {
    public DatoInvalidoException(String mensaje) { super(mensaje); }
}

public class Main {
    private static ArrayList<Juego> juegos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Registrar Mario Bros");
            System.out.println("2. Registrar Carrera");
            System.out.println("3. Mostrar todos");
            System.out.println("4. Buscar por nombre");
            System.out.println("5. Filtrar por tipo");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            try {
                switch (opcion) {
                    case 1 -> registrarMario();
                    case 2 -> registrarCarrera();
                    case 3 -> mostrarTodos();
                    case 4 -> buscarPorNombre();
                    case 5 -> filtrarPorTipo();
                }
            } catch (DatoInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 0);
    }

    private static void registrarMario() throws DatoInvalidoException {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Nivel: ");
        int nivel = sc.nextInt(); sc.nextLine();
        System.out.print("Personaje: ");
        String personaje = sc.nextLine();
        juegos.add(new MarioBros(nombre, nivel, personaje));
    }

    private static void registrarCarrera() throws DatoInvalidoException {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Nivel: ");
        int nivel = sc.nextInt(); sc.nextLine();
        System.out.print("Vehículo: ");
        String vehiculo = sc.nextLine();
        juegos.add(new CarreraVehiculos(nombre, nivel, vehiculo));
    }

    private static void mostrarTodos() {
        if (juegos.isEmpty()) System.out.println("No hay juegos.");
        else juegos.forEach(Juego::mostrarInfo);
    }

    private static void buscarPorNombre() {
        System.out.print("Nombre a buscar: ");
        String nombre = sc.nextLine();
        juegos.stream().filter(j -> j.nombre.equalsIgnoreCase(nombre)).forEach(Juego::mostrarInfo);
    }

    private static void filtrarPorTipo() {
        System.out.print("Tipo (Mario/Carrera): ");
        String tipo = sc.nextLine();
        for (Juego j : juegos) {
            if ((tipo.equalsIgnoreCase("Mario") && j instanceof MarioBros) ||
                    (tipo.equalsIgnoreCase("Carrera") && j instanceof CarreraVehiculos)) {
                j.mostrarInfo();
            }
        }
    }
}
