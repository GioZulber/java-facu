public class OSEspecialidad extends ObraSocial{

    private Especialidad especialidadAsociada;

    public OSEspecialidad(Especialidad especialidadAsociada){
        super();
        this.especialidadAsociada = especialidadAsociada;
    }



    @Override
    public boolean podesCubrir(Tratamiento tratamiento) {
        return tratamiento.getEspecialidad() == especialidadAsociada;
    }
}
