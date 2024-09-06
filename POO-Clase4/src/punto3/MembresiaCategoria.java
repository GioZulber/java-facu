package punto3;

public class MembresiaCategoria extends Membresia{

    private String categoria;

    public MembresiaCategoria(Persona persona, String categoria){
        super(persona);
        this.categoria = categoria;
    }

    @Override
    public boolean puedeRealizarActividad(Actividad actividad) {
        return actividad.getTipo().equals(categoria.toLowerCase());
    }

}
