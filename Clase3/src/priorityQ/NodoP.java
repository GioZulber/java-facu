package priorityQ;

public class NodoP {
    private int value;
    private int priority;
    private NodoP sig;

    public void setValue(int x) {value = x;}

    public void setPriority(int p) {priority = p;}

    public void setSig(NodoP nxt) {sig = nxt;}

    public int getValue() {return value;}

    public int getPriority() {return priority;}

    public NodoP getSig() {return sig;}
}
