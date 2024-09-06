package punto3;

public class MembresiaFull extends Membresia{

    public MembresiaFull(Persona persona){
        super(persona);
    }

    @Override
    public boolean puedeRealizarActividad(){
        return true;
    }

}
