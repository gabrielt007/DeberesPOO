package ToaquizaGabriel_Juegos_S8.Ejercicio_Reina_de_Quito;

public class CandidataProfesional extends Candidata{
    private String profesion;
    private int aniosExperiencia;
    public CandidataProfesional(int id, int edad, String nombre, String distrito, double puntaje, String profesion, int aniosExperiencia) throws DatoInvalidoException{
        super(id, edad, nombre, distrito, puntaje);
        if(profesion.isEmpty() || profesion==null || aniosExperiencia<=0){
            throw new DatoInvalidoException("El campo de profesion esta vacio o los anios de experiencia son invalidos.");
        }
        this.profesion=profesion;
        this.aniosExperiencia=aniosExperiencia;
    }
    @Override
    public void mostrarDetalles(){
        System.out.println("\n------Detalles de candidata------"+
                "\nId: "+getId()+"\nEdad: "+getEdad()+"\nNombre: "+getNombre()+
                "\nDistrito: "+getDistrito()+"\nPuntaje: "+getPuntaje()+
                "\nUniversidad: "+profesion+"\nCarrera: "+aniosExperiencia);
    }
}
