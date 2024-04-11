package imp;

public class Nodo {
    private int value;
    private Nodo sig;

    public void setValue(int x) {value = x;}

    public void setSig(Nodo nxt) {sig = nxt;}

    public int getValue() {return value;}

    public Nodo getSig() {return sig;}
}
