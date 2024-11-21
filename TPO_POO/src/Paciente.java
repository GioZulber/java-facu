import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Paciente {

    private int id;
    private ObraSocial obraSocial;
    private Set<Tratamiento> historiaClinica = new HashSet<>();

    public Paciente(int id, ObraSocial obraSocial){
        this.id = id;
        this.obraSocial = obraSocial;
    }

    public void agregarTratamiento(Tratamiento unTratamiento) throws TratamientoException{
        if (obraSocial.podesCubrir(unTratamiento)) {
            historiaClinica.add(unTratamiento);
        }
        else throw new TratamientoException("OPERACIÓN FALLIDA: La obra social no cubre el tratamiento");
    }

    public List<Tratamiento> historiaClinicaSegunEspecialidad(Especialidad especialidad) {
        return historiaClinica
                .stream()
                .filter(tratamiento -> tratamiento.getEspecialidad() == especialidad)
                .toList();
    }

    public Set<Tratamiento> getHistoriaClinica(){
        return historiaClinica;
    }




}
