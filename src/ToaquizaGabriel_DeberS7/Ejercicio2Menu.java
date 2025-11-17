package ToaquizaGabriel_DeberS7;

import java.util.Scanner;

public class Ejercicio2Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Menú:");
        System.out.println("1. Opción A");
        System.out.println("2. Opción B");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");

        String entrada = sc.nextLine();
        try {
            int opcion = Integer.parseInt(entrada);
            switch (opcion) {
                case 1:
                    System.out.println("Seleccionaste Opción A");
                    break;
                case 2:
                    System.out.println("Seleccionaste Opción B");
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: debes ingresar un número (1-3).");
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}

