package ToaquizaGabriel_DeberS7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Excepción personalizada para datos inválidos (lista vacía / promedio imposible)
class DatosInvalidosException extends Exception {
    public DatosInvalidosException(String mensaje) {
        super(mensaje);
    }
}

// Clase base Producto
abstract class Producto {
    protected String codigo;
    protected String nombre;
    protected double precioBase;

    public Producto(String codigo, String nombre, double precioBase) {
        if (codigo == null || codigo.trim().isEmpty())
            throw new IllegalArgumentException("El código no puede estar vacío.");
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        if (precioBase < 0)
            throw new IllegalArgumentException("El precio base no puede ser negativo.");
        this.codigo = codigo.trim();
        this.nombre = nombre.trim();
        this.precioBase = precioBase;
    }

    public abstract double calcularPrecioFinal();

    public String resumen() {
        return String.format("%s - %s | Base: %.2f | Final: %.2f",
                codigo, nombre, precioBase, calcularPrecioFinal());
    }
}

// Producto nacional (IVA 12%)
class ProductoNacional extends Producto {
    public ProductoNacional(String codigo, String nombre, double precioBase) {
        super(codigo, nombre, precioBase);
    }

    @Override
    public double calcularPrecioFinal() {
        return precioBase * 1.12;
    }
}

// Producto importado (impuesto importación 5%)
class ProductoImportado extends Producto {
    public ProductoImportado(String codigo, String nombre, double precioBase) {
        super(codigo, nombre, precioBase);
    }

    @Override
    public double calcularPrecioFinal() {
        return precioBase * 1.05;
    }
}

public class SistemaProductos {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Producto> lista = new ArrayList<>();

    public static void main(String[] args) {
        int opcion=-1;
        do {
            mostrarMenu();
            String entrada = sc.nextLine();
            try {
                opcion = Integer.parseInt(entrada);
                switch (opcion) {
                    case 1:
                        registrarProducto();
                        break;
                    case 2:
                        mostrarProductos();
                        break;
                    case 3:
                        mostrarPromedioPrecios();
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: debes ingresar un número de opción.");
                opcion = -1; // para continuar
            } catch (IllegalArgumentException e) {
                System.out.println("Validación: " + e.getMessage());
            } catch (DatosInvalidosException e) {
                System.out.println("Datos inválidos: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        } while (opcion != 4);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Sistema de Productos ---");
        System.out.println("1. Registrar producto");
        System.out.println("2. Mostrar productos");
        System.out.println("3. Calcular promedio de precios finales");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void registrarProducto() {
        System.out.print("Tipo (N = Nacional, I = Importado): ");
        String tipo = sc.nextLine();

        System.out.print("Código: ");
        String codigo = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Precio base: ");
        String precioTexto = sc.nextLine();

        try {
            double precioBase = Double.parseDouble(precioTexto);
            Producto p;
            if (tipo.equalsIgnoreCase("N")) {
                p = new ProductoNacional(codigo, nombre, precioBase);
            } else if (tipo.equalsIgnoreCase("I")) {
                p = new ProductoImportado(codigo, nombre, precioBase);
            } else {
                throw new IllegalArgumentException("Tipo inválido. Usa 'N' o 'I'.");
            }
            lista.add(p);
            System.out.println("Producto registrado: " + p.resumen());
        } catch (NumberFormatException e) {
            System.out.println("Error: el precio debe ser un número válido (ej: 19.99).");
        }
    }

    private static void mostrarProductos() {
        if (lista.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        System.out.println("\n--- Lista de productos ---");
        for (Producto p : lista) {
            System.out.println(p.resumen());
        }
    }

    private static void mostrarPromedioPrecios() throws DatosInvalidosException {
        if (lista.isEmpty()) {
            throw new DatosInvalidosException("La lista está vacía. No se puede calcular el promedio.");
        }
        double suma = 0;
        for (Producto p : lista) {
            suma += p.calcularPrecioFinal();
        }
        double promedio = suma / lista.size();
        System.out.printf("Promedio de precios finales: %.2f%n", promedio);
    }
}

