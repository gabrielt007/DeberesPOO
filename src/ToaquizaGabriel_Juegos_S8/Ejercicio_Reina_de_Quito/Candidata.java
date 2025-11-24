package ToaquizaGabriel_Juegos_S8.Ejercicio_Reina_de_Quito;

public abstract class Candidata {
    private int id, edad;
    private String nombre, distrito;
    private double puntaje;

    public Candidata(int id, int edad, String nombre, String distrito, double puntaje) throws DatoInvalidoException{
        if (id <= 0) throw new DatoInvalidoException("ID inválido");
        if (edad < 16) throw new DatoInvalidoException("Edad mínima 16");
        if (nombre == null || nombre.trim().isEmpty()) throw new DatoInvalidoException("Nombre vacío");
        if (distrito == null || distrito.trim().isEmpty()) throw new DatoInvalidoException("Distrito vacío");
        if (puntaje < 0 || puntaje > 100) throw new DatoInvalidoException("Puntaje fuera de rango (0–100)");

        this.id = id;
        this.edad = edad;
        this.nombre = nombre.trim();
        this.distrito = distrito.trim();
        this.puntaje = puntaje;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public int getId() {
        return id;
    }

    public String getDistrito() {
        return distrito;
    }

    public abstract void mostrarDetalles();
}
