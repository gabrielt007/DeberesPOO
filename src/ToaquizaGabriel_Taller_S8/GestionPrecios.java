package ToaquizaGabriel_Taller_S8;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionPrecios {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Double> precios = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> ingresarPrecio();
                case 2 -> mostrarPrecios();
                case 3 -> precioMasAlto();
                case 4 -> precioMasBajo();
                case 5 -> preciosIguales();
                case 6 -> buscarPrecio();
                case 7 -> System.out.println("Saliendo del sistema. ¡Hasta pronto!");
                default -> System.out.println("Opción no válida.");
            }
            System.out.println();
        } while (opcion != 7);
    }

    private static void mostrarMenu() {
        System.out.println("===== MENÚ DE PRECIOS INMOBILIARIOS =====");
        System.out.println("1. Ingresar precio");
        System.out.println("2. Mostrar todos los precios");
        System.out.println("3. Mostrar precio más alto");
        System.out.println("4. Mostrar precio más bajo");
        System.out.println("5. Mostrar precios iguales");
        System.out.println("6. Buscar un precio específico");
        System.out.println("7. Salir");
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un número entero válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.print("Ingrese un número decimal válido: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    // Opción 1: ingresar precio (validación > 0)
    private static void ingresarPrecio() {
        double precio = leerDouble("Ingrese precio (mayor a 0): ");
        if (precio > 0) {
            precios.add(precio);
            System.out.println("Precio agregado: " + precio);
        } else {
            System.out.println("El precio debe ser mayor a cero. No se agregó.");
        }
    }

    // Opción 2: mostrar todos los precios
    private static void mostrarPrecios() {
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados.");
            return;
        }
        System.out.println("Precios registrados:");
        for (int i = 0; i < precios.size(); i++) {
            System.out.println((i + 1) + ". " + precios.get(i));
        }
    }

    // Opción 3: mostrar precio más alto
    private static void precioMasAlto() {
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados.");
            return;
        }
        double max = precios.get(0);
        for (double p : precios) {
            if (p > max) max = p;
        }
        System.out.println("Precio más alto: " + max);
    }

    // Opción 4: mostrar precio más bajo
    private static void precioMasBajo() {
        if (precios.isEmpty()) {
            System.out.println("No existen precios registrados.");
            return;
        }
        double min = precios.get(0);
        for (double p : precios) {
            if (p < min) min = p;
        }
        System.out.println("Precio más bajo: " + min);
    }

    // Opción 5: mostrar precios iguales (lista de duplicados exactos)
    private static void preciosIguales() {
        if (precios.size() < 2) {
            System.out.println("No hay suficientes precios para comparar.");
            return;
        }
        boolean hayIguales = false;
        System.out.println("Precios repetidos:");
        for (int i = 0; i < precios.size(); i++) {
            double actual = precios.get(i);
            int conteo = 0;
            for (double p : precios) {
                if (Double.compare(p, actual) == 0) conteo++;
            }
            if (conteo > 1) {
                System.out.println("- " + actual + " (aparece " + conteo + " veces)");
                hayIguales = true;
            }
        }
        if (!hayIguales) {
            System.out.println("No se encontraron precios repetidos.");
        }
    }

    // Opción 6: buscar un precio específico (contains)
    private static void buscarPrecio() {
        double objetivo = leerDouble("Ingrese el precio a buscar: ");
        boolean existe = precios.contains(objetivo);
        if (existe) {
            System.out.println("El precio " + objetivo + " SÍ está registrado.");
        } else {
            System.out.println("El precio " + objetivo + " NO está registrado.");
        }
    }
}

