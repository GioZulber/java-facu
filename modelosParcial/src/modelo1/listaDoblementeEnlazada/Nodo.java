package modelo1.listaDoblementeEnlazada;

public class Nodo {
    private int value;
    private Nodo sig;
    private Nodo prev;

    public void setValue(int x) {value = x;}

    public void setSig(Nodo nxt) {sig = nxt;}

    public void setPrev(Nodo prev) {this.prev = prev;}

    public int getValue() {return value;}

    public Nodo getSig() {return sig;}

    public Nodo getPrev() {return prev;}

}
