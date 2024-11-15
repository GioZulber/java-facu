public class OSLimitada extends ObraSocial{

    private int limite;

    public OSLimitada(int limite){
        super();
        this.limite  = limite;
    }

    @Override
    public boolean podesCubrir(Tratamiento tratamiento) {
        if (limite > 0) {
            limite--;
            return true;
        }
        else
            return false;
    }

    public void recargar(int recarga){
        limite += recarga;
    }

}
