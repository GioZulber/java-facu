package punto3;

public class MembresiaCantidadActividades extends Membresia {
    private int cantidadActividades;

    public MembresiaCantidadActividades(Persona persona){
        super(persona);
        this.cantidadActividades = 2;
    }
    @Override
    public boolean puedeRealizarActividad(Actividad actividad){
        if(cantidadActividades > 0){
            cantidadActividades--;
            return true;
        }
        return false;
    }
}
