public class OSUrgencia extends ObraSocial{

    public OSUrgencia(){
        super();
    }


    @Override
    public boolean podesCubrir(Tratamiento tratamiento) {
        return tratamiento.sosUrgente();
    }
}
