package ToaquizaGabriel_Juegos_S8.Ejercicio_Reina_de_Quito;

import java.time.LocalDateTime;

public class Voto {
    private static int contadorVotos = 1; // contador estático para generar idVoto único
    private int idVoto, idCandidata;
    private LocalDateTime fechaHora;

    public Voto(int idCandidata) throws DatoInvalidoException {
        if (idCandidata <= 0) {
            throw new DatoInvalidoException("ID de candidata inválido");
        }
        this.idCandidata = idCandidata;
        this.idVoto = contadorVotos++;
        this.fechaHora = LocalDateTime.now();
    }

    public int getIdCandidata() {
        return idCandidata;
    }

    public int getIdVoto() {
        return idVoto;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
}

