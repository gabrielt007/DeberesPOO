package ToaquizaGabriel_DeberS7;

public class Estudiante {
    private String nombre;
    private int edad;

    public Estudiante(String nombre, int edad) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (edad < 0 || edad > 120) {
            throw new IllegalArgumentException("La edad debe estar entre 0 y 120.");
        }
        this.nombre = nombre.trim();
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }

    public static void main(String[] args) {
        try {
            Estudiante e1 = new Estudiante("Ana", 20);
            System.out.println("Estudiante creado: " + e1.getNombre() + ", " + e1.getEdad());
            Estudiante e2 = new Estudiante("", 30); // Provoca excepción
        } catch (IllegalArgumentException e) {
            System.out.println("Validación: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
