package ToaquizaGabriel_DeberS7;
import java.util.Scanner;

public class Ejercicio1PrecioIVA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el precio del producto: ");
        String entrada = sc.nextLine();
        try {
            double precio = Double.parseDouble(entrada);
            if (precio < 0) {
                System.out.println("Error: el precio no puede ser negativo.");
                return;
            }
            double precioConIVA = precio * 1.15; // IVA 15%
            System.out.println("Precio con IVA (15%): " + precioConIVA);
        } catch (NumberFormatException e) {
            System.out.println("Error: valor inválido. Debe ingresar un número (ej: 19.99).");
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
