package imp;

public class NodoDBL {
    private int value;
    private NodoDBL sig;
    private NodoDBL prev;

    public void setValue(int x) {value = x;}

    public void setSig(NodoDBL nxt) {sig = nxt;}

    public void setPrev(NodoDBL prev) {this.prev = prev;}

    public int getValue() {return value;}

    public NodoDBL getSig() {return sig;}

    public NodoDBL getPrev() {return prev;}

}