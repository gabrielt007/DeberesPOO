package ToaquizaGabriel_Taller_S8;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Excepción personalizada
class DatosInvalidosException extends Exception {
    public DatosInvalidosException(String mensaje) { super(mensaje); }
}

// Clase abstracta base
abstract class Participante {
    private String nombre;

    public Participante(String nombre) throws DatosInvalidosException {
        if (nombre == null || nombre.isBlank()) {
            throw new DatosInvalidosException("El nombre del participante es obligatorio.");
        }
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    // Método abstracto para polimorfismo
    public abstract String tipo();
}

// Clase hija: Atleta
class Atleta extends Participante {
    private String deporte;

    public Atleta(String nombre, String deporte) throws DatosInvalidosException {
        super(nombre);
        if (deporte == null || deporte.isBlank()) {
            throw new DatosInvalidosException("El deporte del atleta es obligatorio.");
        }
        this.deporte = deporte;
    }

    public String getDeporte() { return deporte; }

    @Override
    public String tipo() { return "Atleta"; }

    @Override
    public String toString() {
        return "Atleta{nombre='" + getNombre() + "', deporte='" + deporte + "'}";
    }
}

// Clase hija: Equipo
class Equipo extends Participante {
    private int integrantes;

    public Equipo(String nombre, int integrantes) throws DatosInvalidosException {
        super(nombre);
        if (integrantes <= 0) {
            throw new DatosInvalidosException("Un equipo debe tener al menos 1 integrante.");
        }
        this.integrantes = integrantes;
    }

    public int getIntegrantes() { return integrantes; }

    @Override
    public String tipo() { return "Equipo"; }

    @Override
    public String toString() {
        return "Equipo{nombre='" + getNombre() + "', integrantes=" + integrantes + "}";
    }
}

// Evento con composición de participantes
class Evento {
    private String nombre;
    private final List<Participante> participantes = new ArrayList<>();

    public Evento(String nombre) throws DatosInvalidosException {
        if (nombre == null || nombre.isBlank()) {
            throw new DatosInvalidosException("El nombre del evento es obligatorio.");
        }
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    public void agregarParticipante(Participante p) {
        participantes.add(p);
    }

    public List<Participante> getParticipantes() { return participantes; }

    @Override
    public String toString() {
        return "Evento{nombre='" + nombre + "', participantes=" + participantes.size() + "}";
    }
}

// Olimpiada con composición de eventos
class Olimpiada {
    private String nombre;
    private String ciudad;
    private final List<Evento> eventos = new ArrayList<>();

    public Olimpiada(String nombre, String ciudad) throws DatosInvalidosException {
        if (nombre == null || nombre.isBlank()) {
            throw new DatosInvalidosException("El nombre de la olimpiada es obligatorio.");
        }
        if (ciudad == null || ciudad.isBlank()) {
            throw new DatosInvalidosException("La ciudad de la olimpiada es obligatoria.");
        }
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public void agregarEvento(Evento e) { eventos.add(e); }

    public List<Evento> getEventos() { return eventos; }

    @Override
    public String toString() {
        return "Olimpiada{nombre='" + nombre + "', ciudad='" + ciudad + "', eventos=" + eventos.size() + "}";
    }
}

// Programa principal con menú
public class MainOlimpiadas {
    private static final Scanner scanner = new Scanner(System.in);
    private static Olimpiada olimpiada; // una instancia simple

    public static void main(String[] args) {
        try {
            olimpiada = new Olimpiada("Olimpiadas Nacionales", "Quito");
        } catch (DatosInvalidosException e) {
            System.out.println("Error inicializando olimpiada: " + e.getMessage());
            return;
        }

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            try {
                switch (opcion) {
                    case 1 -> crearEvento();
                    case 2 -> registrarAtletaEnEvento();
                    case 3 -> registrarEquipoEnEvento();
                    case 4 -> listarEventosYParticipantes();
                    case 5 -> System.out.println("Saliendo. Gracias.");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (DatosInvalidosException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("===== MENÚ OLIMPIADAS =====");
        System.out.println("1. Crear evento");
        System.out.println("2. Registrar atleta en evento");
        System.out.println("3. Registrar equipo en evento");
        System.out.println("4. Listar eventos y participantes");
        System.out.println("5. Salir");
    }

    private static int leerEntero(String msg) {
        System.out.print(msg);
        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un entero válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static String leerLinea(String msg) {
        System.out.print(msg);
        scanner.nextLine(); // limpiar salto previo si es necesario
        return scanner.nextLine();
    }

    private static Evento seleccionarEvento() throws DatosInvalidosException {
        if (olimpiada.getEventos().isEmpty()) {
            throw new DatosInvalidosException("No hay eventos creados. Cree uno primero.");
        }
        System.out.println("Eventos disponibles:");
        for (int i = 0; i < olimpiada.getEventos().size(); i++) {
            System.out.println((i + 1) + ". " + olimpiada.getEventos().get(i).getNombre());
        }
        int idx = leerEntero("Seleccione evento por número: ") - 1;
        if (idx < 0 || idx >= olimpiada.getEventos().size()) {
            throw new DatosInvalidosException("Índice de evento inválido.");
        }
        return olimpiada.getEventos().get(idx);
    }

    private static void crearEvento() throws DatosInvalidosException {
        String nombre = leerLinea("Nombre del evento: ");
        Evento e = new Evento(nombre);
        olimpiada.agregarEvento(e);
        System.out.println("Evento creado: " + e);
    }

    private static void registrarAtletaEnEvento() throws DatosInvalidosException {
        Evento e = seleccionarEvento();
        String nombre = leerLinea("Nombre del atleta: ");
        String deporte = leerLinea("Deporte del atleta: ");
        Atleta a = new Atleta(nombre, deporte);
        e.agregarParticipante(a);
        System.out.println("Atleta registrado en " + e.getNombre());
    }

    private static void registrarEquipoEnEvento() throws DatosInvalidosException {
        Evento e = seleccionarEvento();
        String nombre = leerLinea("Nombre del equipo: ");
        int integrantes = leerEntero("Número de integrantes: ");
        Equipo eq = new Equipo(nombre, integrantes);
        e.agregarParticipante(eq);
        System.out.println("Equipo registrado en " + e.getNombre());
    }

    private static void listarEventosYParticipantes() {
        System.out.println(olimpiada);
        if (olimpiada.getEventos().isEmpty()) {
            System.out.println("No hay eventos.");
            return;
        }
        for (Evento ev : olimpiada.getEventos()) {
            System.out.println("- " + ev.getNombre() + " (" + ev.getParticipantes().size() + " participantes)");
            for (Participante p : ev.getParticipantes()) {
                System.out.println("  * " + p.tipo() + ": " + p.toString());
            }
        }
    }
}

