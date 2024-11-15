public class OSTratamiento extends ObraSocial{

    private Tratamiento tratamientoAsociado;

    public OSTratamiento(Tratamiento tratamientoAsociado){
        super();
        this.tratamientoAsociado = tratamientoAsociado;
    }

    @Override
    public boolean podesCubrir(Tratamiento tratamiento) {
        return tratamiento == tratamientoAsociado;
    }
}
