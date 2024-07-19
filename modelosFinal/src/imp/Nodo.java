package imp;

public class Nodo {
    int info;
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

    public int getInfo() {
        return this.info;
    }

    public void setInfo(int info) {
        this.info = info;
    }
}
