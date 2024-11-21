import java.util.List;

public class Main {

    public static void agregarTratamientoAPaciente(Paciente paciente, Tratamiento tratamiento) {
        try {
            paciente.agregarTratamiento(tratamiento);
            System.out.println("SE AGREGÓ EL TRATAMIENTO");
        } catch (TratamientoException exception) {
            System.out.println(exception.getMessage());
        }
    }


    public static void imprimirLista(List<Tratamiento> lista ){
        if (!lista.isEmpty()) {
            for (Tratamiento tratamiento : lista) {
                System.out.println("> " + tratamiento.getNombre());
            }
        } else {
            System.out.println("> NO se encontraron tratamientos");
        }
    }

    public static void imprimirHistoriaClinica(Paciente paciente) {
        if (!paciente.getHistoriaClinica().isEmpty()) {
            for (Tratamiento tratamiento : paciente.getHistoriaClinica()) {
                System.out.println("> " + tratamiento.getNombre());
            }
        } else {
            System.out.println("> La historia clínica está vacía");
        }
    }

    public static void main(String[] args) {

        // ESPECIALIDADES

        Especialidad traumatologia = new Especialidad();
        Especialidad neurologia = new Especialidad();
        Especialidad clinicaGeneral = new Especialidad();
        Especialidad cardiologia = new Especialidad();


        // TRATAMIENTOS

        Tratamiento reduccion = new Tratamiento("Reducción", traumatologia, true);
        Tratamiento resonancia = new Tratamiento("Resonancia", neurologia, true);
        Tratamiento extraccionSangre  = new Tratamiento("Extracción de Sangre", clinicaGeneral, false);
        Tratamiento vacuna = new Tratamiento("Vacuna", clinicaGeneral, false);
        Tratamiento hisopado = new Tratamiento("Hisopado", clinicaGeneral, true);
        Tratamiento holter = new Tratamiento("Holter", cardiologia, false);
        Tratamiento ecocardiograma = new Tratamiento("Ecocardiograma", cardiologia, true);


        // OBRAS SOCIALES

        OSFull miOSFull = new OSFull();
        OSUrgencia miOSUrgencia = new OSUrgencia();
        OSLimitada miOSLimitada = new OSLimitada(2);
        OSEspecialidad miOSEspecialidadCardio = new OSEspecialidad(cardiologia);
        OSTratamiento miOSTratemientoSangre = new OSTratamiento(extraccionSangre);
        OSCustom miOSCustom = new OSCustom();
        miOSCustom.agregarTratamiento(vacuna);              //Clinica General
        miOSCustom.agregarTratamiento(hisopado);            //Clinica General
        miOSCustom.agregarTratamiento(extraccionSangre);    //Clinica General
        miOSCustom.agregarTratamiento(holter);              //Cardiología


        // PACIENTES

        Paciente hanna = new Paciente(13, miOSEspecialidadCardio);
        Paciente giovanni = new Paciente(14, miOSCustom);
        Paciente joaquin = new Paciente(15, miOSFull);



        // PRUEBAS OS
        System.out.println("TESTS DE OBRAS SOCIALES:");
        System.out.println();
        System.out.println(miOSFull.podesCubrir(vacuna));                           // true
        System.out.println(miOSUrgencia.podesCubrir(reduccion));                    // true
        System.out.println(miOSUrgencia.podesCubrir(holter));                       // false
        System.out.println(miOSLimitada.podesCubrir(hisopado));                     // true
        System.out.println(miOSLimitada.podesCubrir(hisopado));                     // true
        System.out.println(miOSLimitada.podesCubrir(hisopado));                     // false
        System.out.println(miOSEspecialidadCardio.podesCubrir(holter));             // true
        System.out.println(miOSEspecialidadCardio.podesCubrir(vacuna));             // false
        System.out.println(miOSTratemientoSangre.podesCubrir(extraccionSangre));    // true
        System.out.println(miOSTratemientoSangre.podesCubrir(resonancia));          // false
        System.out.println(miOSCustom.podesCubrir(vacuna));                         // true
        System.out.println(miOSCustom.podesCubrir(reduccion));                      // false

        System.out.println();


        // AGREGADO DE TRATAMIENTOS A PACIENTES Y CAPTURA DE EXEPCIONES
        System.out.println("\n----------------------------------\n");
        System.out.println("TESTS DE AGREGADO DE TRATAMIENTOS A PACIENTES:");
        System.out.println();
        agregarTratamientoAPaciente(giovanni, resonancia);          // NO se agregará --> Excepción capturada
        agregarTratamientoAPaciente(giovanni, reduccion);           // NO se agregará --> Excepción capturada
        agregarTratamientoAPaciente(giovanni, vacuna);              // SI se agregará
        agregarTratamientoAPaciente(hanna, holter);                 // SI se agregará
        agregarTratamientoAPaciente(hanna, hisopado);               // NO se agregará --> Excepción capturada
        agregarTratamientoAPaciente(hanna, vacuna);                 // SI se agregará
        agregarTratamientoAPaciente(hanna, ecocardiograma);         // SI se agregará
        System.out.println();


        // IMPRESIÓN DE FILTROS SOBRE OSCUSTOM
        System.out.println("\n----------------------------------\n");
        System.out.println("TRATAMIENTOS DE CARDIOLOGÍA QUE CUBRE OSCUSTOM:");              // Holter
        List<Tratamiento> fil1 = miOSCustom.tratamientosSegunEspecialidad(cardiologia);
        imprimirLista(fil1);
        System.out.println();
        List<Tratamiento> fil2 = miOSCustom.tratamientosSegunEspecialidad(clinicaGeneral);  // Vacuna, Hisopado, Extracción de Sangre
        System.out.println("TRATAMIENTOS DE CLÍNICA GENERAL QUE CUBRE OSCUSTOM:");
        imprimirLista(fil2);
        System.out.println();
        List<Tratamiento> fil3 = miOSCustom.tratamientosSegunEspecialidad(neurologia);      // Vacía
        System.out.println("TRATAMIENTOS DE NEUROLOGÍA QUE CUBRE OSCUSTOM:");
        imprimirLista(fil3);
        System.out.println();

        // IMPRESIÓN DE HISTORIA CLÍNICA DE PACIENTES
        System.out.println("\n----------------------------------\n");
        System.out.println("HISTORIA CLÍNICA DE GIOVANNI:");            // Vacuna
        imprimirHistoriaClinica(giovanni);
        System.out.println();
        System.out.println("HISTORIA CLÍNICA DE HANNA:");               // Holter, Ecocardiograma
        imprimirHistoriaClinica(hanna);
        System.out.println();
        System.out.println("HISTORIA CLÍNICA DE JOACO:");               // Vacía
        imprimirHistoriaClinica(joaquin);
        System.out.println();

    }
}