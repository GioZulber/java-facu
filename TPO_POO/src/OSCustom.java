import java.util.HashSet;
import java.util.Set;

public class OSCustom extends ObraSocial {
    private Set<Tratamiento> tratamientos = new HashSet<>();

    public OSCustom(){
        super();
    }

    public void agregarTratamiento(Tratamiento tratamiento){
        tratamientos.add(tratamiento);
    }


    @Override
    public boolean podesCubrir(Tratamiento tratamiento) {
        return tratamientos.contains(tratamiento);
    }
}
