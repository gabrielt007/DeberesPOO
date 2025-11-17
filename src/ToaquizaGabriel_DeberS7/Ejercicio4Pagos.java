package ToaquizaGabriel_DeberS7;

// Excepción personalizada
class PagoInvalidoException extends Exception {
    public PagoInvalidoException(String mensaje) {
        super(mensaje);
    }
}

public class Ejercicio4Pagos {
    public static void validarPago(double monto) throws PagoInvalidoException {
        if (monto < 0) throw new PagoInvalidoException("El pago no puede ser negativo.");
        if (monto == 0) throw new PagoInvalidoException("El pago no puede ser igual a 0.");
        if (monto > 5000) throw new PagoInvalidoException("El pago no puede ser mayor a $5000.");
    }

    public static void main(String[] args) {
        double[] pagos = {100, -5, 0, 6000, 2500};
        for (double p : pagos) {
            try {
                validarPago(p);
                System.out.println("Pago válido: $" + p);
            } catch (PagoInvalidoException e) {
                System.out.println("Pago inválido (" + p + "): " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
    }
}
