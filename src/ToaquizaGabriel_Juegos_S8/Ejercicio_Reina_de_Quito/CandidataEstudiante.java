package ToaquizaGabriel_Juegos_S8.Ejercicio_Reina_de_Quito;

public class CandidataEstudiante extends Candidata{
    private String universidad, carrera;
    public CandidataEstudiante(int id, int edad, String nombre, String distrito, double puntaje, String universidad, String carrera) throws DatoInvalidoException{
        super(id, edad, nombre, distrito, puntaje);
        if(universidad.isEmpty() || carrera.isEmpty() || universidad==null || carrera == null){
            throw new DatoInvalidoException("El campo universida o carrera estan vacios.");
        }
        this.universidad=universidad;
        this.carrera=carrera;
    }
    @Override
    public void mostrarDetalles(){
        System.out.println("\n------Detalles de candidata------"+
                "\nId: "+getId()+"\nEdad: "+getEdad()+"\nNombre: "+getNombre()+
                "\nDistrito: "+getDistrito()+"\nPuntaje: "+getPuntaje()+
                "\nUniversidad: "+universidad+"\nCarrera: "+carrera);
    }

}
