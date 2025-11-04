package Correcion_POO_Toaquiza;
import java.util.Scanner;
public class SolicitanteSubsidio {
    private String nombreCompleto;
    private String cedula;
    private double ingresosMensuales;
    private int cantidadVehiculos;
    private boolean viveEnEcuador;

    public SolicitanteSubsidio(String nombreCompleto, String cedula, double ingresosMensuales, int cantidadVehiculos, boolean viveEnEcuador) {
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        setIngresosMensuales(ingresosMensuales);
        setCantidadVehiculos(cantidadVehiculos);
        this.viveEnEcuador = viveEnEcuador;
    }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public double getIngresosMensuales() { return ingresosMensuales; }
    public void setIngresosMensuales(double ingresosMensuales) {
        if (ingresosMensuales >= 470) this.ingresosMensuales = ingresosMensuales;
        else this.ingresosMensuales = 470;
    }

    public int getCantidadVehiculos() { return cantidadVehiculos; }
    public void setCantidadVehiculos(int cantidadVehiculos) {
        if (cantidadVehiculos >= 0) this.cantidadVehiculos = cantidadVehiculos;
        else this.cantidadVehiculos = 0;
    }

    public boolean isViveEnEcuador() { return viveEnEcuador; }
    public void setViveEnEcuador(boolean viveEnEcuador) { this.viveEnEcuador = viveEnEcuador; }

    public boolean subsidioAprobado() {
        return ingresosMensuales <= 1200 && cantidadVehiculos <= 1 && viveEnEcuador;
    }

    public void generarResultado() {
        if (subsidioAprobado()) {
            System.out.println("Subsidio aprobado: Cumple con todos los requisitos.");
        } else {
            System.out.println("Subsidio rechazado: No cumple con los siguientes requisitos:");
            if (ingresosMensuales > 1200) System.out.println("- Ingresos mayores a $1200.");
            if (cantidadVehiculos > 1) System.out.println("- Más de un vehículo registrado.");
            if (!viveEnEcuador) System.out.println("- No reside en Ecuador.");
        }
    }

    public String toString() {
        return "Nombre: " + nombreCompleto + "\nCédula: " + cedula + "\nIngresos mensuales: $" + ingresosMensuales +
                "\nCantidad de vehículos: " + cantidadVehiculos + "\nVive en Ecuador: " + viveEnEcuador;
    }

    public static void mostrarReglasSubsidio() {
        System.out.println("Reglas para obtener el subsidio");
        System.out.println("1. Tener ingresos mensuales menores o iguales a $1,200.");
        System.out.println("2. No poseer más de un vehículo registrado.");
        System.out.println("3. Tener residencia en Ecuador.");
    }

    public double calcularConsumoMensual() {
        return 400 / 40.0;
    }

    public double calcularConsumoMensual(double kmExtra) {
        return (400 + kmExtra) / 40.0;
    }

    public static void main(String[] args) {
        SolicitanteSubsidio.mostrarReglasSubsidio();
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese su nombre completo: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese su cédula: ");
        String cedula = sc.nextLine();

        System.out.print("Ingrese sus ingresos mensuales: ");
        double ingresos = sc.nextDouble();

        System.out.print("Ingrese la cantidad de vehículos registrados: ");
        int vehiculos = sc.nextInt();

        System.out.print("¿Vive en Ecuador? (true/false): ");
        boolean vive = sc.nextBoolean();

        SolicitanteSubsidio solicitante = new SolicitanteSubsidio(nombre, cedula, ingresos, vehiculos, vive);

        System.out.println("\nDatos del solicitante");
        System.out.println(solicitante.toString());

        System.out.println("\nResultado de la evaluación");
        solicitante.generarResultado();

        System.out.println("\nCálculo de consumo mensual");
        System.out.println("Consumo mensual estimado (sin km extra): " + solicitante.calcularConsumoMensual() + " galones");
        System.out.println("Consumo con kilómetros extra (80 km adicionales): " + solicitante.calcularConsumoMensual(80) + " galones");

    }
}

