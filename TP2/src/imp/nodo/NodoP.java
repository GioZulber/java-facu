package imp.nodo;

public class NodoP {
    private int value;

    private int prioridad;

    private NodoP sig;

    public void setValue(int value) {
        this.value = value;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public void setSig(NodoP sig) {
        this.sig = sig;
    }

    public int getValue() {
        return value;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public NodoP getSig() {
        return sig;
    }

}
