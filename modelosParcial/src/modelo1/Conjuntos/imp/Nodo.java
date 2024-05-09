package modelo1.Conjuntos.imp;

public class Nodo {
    int value;
    Nodo sig;
    public Nodo getNodo() {
        return this;
    }

    public void setSig(Nodo nodo) {
        this.sig = nodo;
    }
    public Nodo getSig() {
        return this.sig;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
