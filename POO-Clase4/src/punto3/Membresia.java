package punto3;

public class Membresia {

    private Persona persona;

    public Membresia(Persona persona){
        this.persona = persona;
    }

    public boolean puedeRealizarActividad(){return true;}

    public String getNombrePersona(){
        return persona.getNombre();
    }

    public boolean puedeRealizarActividad(Actividad actividad) {
        return true;
    }
}

