public class Main {

    public static void agregarTratamientoAPaciente(Paciente paciente, Tratamiento tratamiento) {
        try {
            paciente.agregarTratamiento(tratamiento);
            System.out.println("SE AGREGÓ EL TRATAMIENTO");
        } catch (TratamientoException exception) {
            System.out.println(exception.getMessage());
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
        miOSCustom.agregarTratamiento(vacuna);
        miOSCustom.agregarTratamiento(hisopado);
        miOSCustom.agregarTratamiento(extraccionSangre);


        // PACIENTES

        Paciente hanna = new Paciente(13, miOSEspecialidadCardio);
        Paciente giovanni = new Paciente(14, miOSCustom);


        // PRUEBAS OS

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

        agregarTratamientoAPaciente(giovanni, resonancia);          // NO se agregará --> Excepción capturada
        agregarTratamientoAPaciente(giovanni, reduccion);           // NO se agregará --> Excepción capturada
        agregarTratamientoAPaciente(giovanni, vacuna);              // SI se agregará
        agregarTratamientoAPaciente(hanna, holter);                 // SI se agregará
        agregarTratamientoAPaciente(hanna, hisopado);               // NO se agregará --> Excepción capturada
        agregarTratamientoAPaciente(hanna, vacuna);                 // SI se agregará
        agregarTratamientoAPaciente(hanna, ecocardiograma);         // SI se agregará
        System.out.println();

        // IMPRESIÓN DE HISTORIA CLÍNICA DE PACIENTES
        System.out.println("HISOTRIA CLÍNICA DE GIOVANNI:");
        giovanni.historiaClinicaToString();
        System.out.println();
        System.out.println("HISOTRIA CLÍNICA DE HANNA:");
        hanna.historiaClinicaToString();

    }
}