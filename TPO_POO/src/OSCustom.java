import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OSCustom extends ObraSocial {
    private Set<Tratamiento> tratamientos = new HashSet<>();

    public OSCustom(){
        super();
    }

    public void agregarTratamiento(Tratamiento tratamiento){
        tratamientos.add(tratamiento);
    }

    public List<Tratamiento> tratamientosSegunEspecialidad(Especialidad especialidad) {
        return tratamientos
                .stream()
                .filter(tratamiento -> tratamiento.getEspecialidad() == especialidad)
                .toList();
    }

    @Override
    public boolean podesCubrir(Tratamiento tratamiento) {
        return tratamientos.contains(tratamiento);
    }
}
