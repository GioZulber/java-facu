package punto2;

public class Empleado {
    private String nombre;
    private Transporte medioTransporte;

    public Empleado(String nombre, Transporte medioTransporte) {
        this.nombre = nombre;
        this.medioTransporte = medioTransporte;
    }

    public String obtenerPremio(){
        return "El empleado " + nombre + " " + medioTransporte.obtenerPremio();
    }

    public String getNombre() {
        return nombre;
    }

    public Transporte getMedioTransporte() {
        return medioTransporte;
    }
}
