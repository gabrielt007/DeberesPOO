package ToaquizaGabriel_Juegos_S8.Ejercicio_Reina_de_Quito;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Concurso {

    private static ArrayList<Candidata> listaCandidatas = new ArrayList<>();
    private static ArrayList<Voto> conteoVotos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public void registrarCandidata() throws DatoInvalidoException{
        int opcion = -1;
        do{
            System.out.println("-------MENU DE REGISTRO DE CANDIDATAS------");
            System.out.println("1.-Registro de Estudiante.\n2.-Registro de Profesional.\n3.-Salir.");
            opcion = sc.nextInt();
            try{
                switch (opcion){
                    case 1 -> registroEstudiante();
                    case 2 -> registroProfesional();
                }
            }catch (DatoInvalidoException e){
                System.out.println("Error."+ e.getMessage());
            }

        }while (opcion!=3);


    }

    private static void registroEstudiante() throws DatoInvalidoException{
        System.out.println("Ingrese el id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese la edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el distrito: ");
        String distrito = sc.nextLine();
        System.out.println("Ingrese el puntaje: ");
        double puntaje = sc.nextDouble();
        sc.nextLine();
        System.out.println("Ingrese la universidad: ");
        String universidad = sc.nextLine();
        System.out.println("Ingrese la carrera: ");
        String carrera = sc.nextLine();

        listaCandidatas.add(new CandidataEstudiante(id,edad,nombre,distrito,puntaje,universidad,carrera));
    }

    private static void registroProfesional() throws DatoInvalidoException{
        System.out.println("Ingrese el id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese la edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el distrito: ");
        String distrito = sc.nextLine();
        System.out.println("Ingrese el puntaje: ");
        double puntaje = sc.nextDouble();
        sc.nextLine();
        System.out.println("Ingrese la profesion: ");
        String profesion = sc.nextLine();
        System.out.println("Ingrese los anios de experiencia: ");
        int aniosExperiencia = sc.nextInt();
        sc.nextLine();

        listaCandidatas.add(new CandidataProfesional(id,edad,nombre,distrito,puntaje,profesion,aniosExperiencia));
    }

    public void votar(int idCandidata) throws DatoInvalidoException {
        boolean existe = listaCandidatas.stream().anyMatch(c -> c.getId() == idCandidata);
        if (!existe) {
            System.out.println("No existe candidata con ese ID.");
            return;
        }
        Voto voto = new Voto(idCandidata);
        conteoVotos.add(voto);
        System.out.println("Voto registrado para la candidata con ID: " + idCandidata);
    }

    public Map<Integer, Integer> contarVotos() {
        Map<Integer, Integer> resultados = new HashMap<>();
        for (Voto v : conteoVotos) {
            resultados.put(v.getIdCandidata(),
                    resultados.getOrDefault(v.getIdCandidata(), 0) + 1);
        }
        return resultados;
    }

    public List<Candidata> obtenerGanador() {
        Map<Integer, Integer> conteo = contarVotos();
        List<Candidata> ganadoras = new ArrayList<>();

        int maxVotos = 0;

        // Paso 1: encontrar el máximo número de votos
        for (int votos : conteo.values()) {
            if (votos > maxVotos) {
                maxVotos = votos;
            }
        }

        // Paso 2: buscar candidatas con ese número de votos
        for (Map.Entry<Integer, Integer> entry : conteo.entrySet()) {
            if (entry.getValue() == maxVotos) {
                int id = entry.getKey();
                for (Candidata c : listaCandidatas) {
                    if (c.getId() == id) {
                        ganadoras.add(c);
                    }
                }
            }
        }
        return ganadoras;
    }
    public List<Candidata> getListaCandidatas() {
        return listaCandidatas;
    }
    public List<Candidata> filtrarPorTipo(String tipo) {
        List<Candidata> filtradas = new ArrayList<>();
        for (Candidata c : listaCandidatas) {
            if (tipo.equalsIgnoreCase("Estudiante") && c instanceof CandidataEstudiante) {
                filtradas.add(c);
            } else if (tipo.equalsIgnoreCase("Profesional") && c instanceof CandidataProfesional) {
                filtradas.add(c);
            }
        }
        return filtradas;
    }
    public List<Candidata> buscarPorNombre(String nombre) {
        List<Candidata> resultados = new ArrayList<>();
        for (Candidata c : listaCandidatas) {
            if (c.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(c);
            }
        }
        return resultados;
    }



}

