package punto3;

public class MembresiaDiaDePrueba extends Membresia{
    private boolean diaDePrueba;

    public MembresiaDiaDePrueba(Persona persona){
        super(persona);
        this.diaDePrueba = false;
    }

    @Override
    public boolean puedeRealizarActividad(Actividad actividad){
        if(!diaDePrueba){
            diaDePrueba = true;
            return true;
        }
        return false;
    }

}
