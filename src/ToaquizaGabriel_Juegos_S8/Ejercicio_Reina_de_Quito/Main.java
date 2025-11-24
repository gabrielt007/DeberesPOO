package ToaquizaGabriel_Juegos_S8.Ejercicio_Reina_de_Quito;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Concurso concurso = new Concurso();

        int opcion;
        do {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Registrar candidatas");
            System.out.println("2. Listar todas las candidatas");
            System.out.println("3. Buscar candidata por nombre");
            System.out.println("4. Filtrar por tipo");
            System.out.println("5. Votar por candidata");
            System.out.println("6. Mostrar resultados y ganadora");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    try {
                        concurso.registrarCandidata(); // ya tienes este método
                    } catch (DatoInvalidoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("=== LISTA DE CANDIDATAS ===");
                    for (Candidata c : concurso.getListaCandidatas()) {
                        c.mostrarDetalles(); // polimorfismo
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese el nombre a buscar: ");
                    String nombre = sc.nextLine();
                    List<Candidata> resultados = concurso.buscarPorNombre(nombre);
                    if (resultados.isEmpty()) {
                        System.out.println("No se encontraron candidatas con ese nombre.");
                    } else {
                        for (Candidata c : resultados) {
                            c.mostrarDetalles();
                        }
                    }
                }
                case 4 -> {
                    System.out.print("Ingrese el tipo (Estudiante/Profesional): ");
                    String tipo = sc.nextLine();
                    List<Candidata> filtradas = concurso.filtrarPorTipo(tipo);
                    for (Candidata c : filtradas) {
                        c.mostrarDetalles();
                    }
                }
                case 5 -> {
                    System.out.print("Ingrese el ID de la candidata a votar: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    try {
                        concurso.votar(id);
                    } catch (DatoInvalidoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 6 -> {
                    System.out.println("=== RESULTADOS ===");
                    Map<Integer, Integer> votos = concurso.contarVotos();
                    for (Map.Entry<Integer, Integer> entry : votos.entrySet()) {
                        System.out.println("ID: " + entry.getKey() + " → Votos: " + entry.getValue());
                    }

                    List<Candidata> ganadoras = concurso.obtenerGanador();
                    System.out.println("=== GANADORA(S) ===");
                    for (Candidata c : ganadoras) {
                        c.mostrarDetalles();
                    }
                }
                case 7 -> System.out.println("¡Gracias por usar el sistema!");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 7);
    }
}

