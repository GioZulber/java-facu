package imp;

public class Elemento {
    private int prioridad;
    private int valor;

    public Elemento(int prioridad, int valor) {
        this.prioridad = prioridad;
        this.valor = valor;
    }

    public int getPrioridad() {
        return this.prioridad;
    }

    public int getValor() {
        return this.valor;
    }

}
