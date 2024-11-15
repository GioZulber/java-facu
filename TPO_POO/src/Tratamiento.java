public class Tratamiento {

    private String nombre;
    private Especialidad especialidad;
    private boolean esUrgente;


    public Tratamiento(String nombre, Especialidad especialidad, boolean esUrgente){
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.esUrgente = esUrgente;
    }


    public boolean sosUrgente(){
        return esUrgente;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public String getNombre() { return nombre;}
}
