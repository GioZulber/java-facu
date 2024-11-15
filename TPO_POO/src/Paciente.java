import java.util.HashSet;
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

    public Set<Tratamiento> getHistoriaClinica(){
        return historiaClinica;
    }

    public void historiaClinicaToString(){
        for (Tratamiento tratamiento : historiaClinica) {
            System.out.println(tratamiento.getNombre());
        }
    }


}
