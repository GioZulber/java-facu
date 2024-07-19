package imp;
import api.iConjuntoTDA;
public class ConjuntoLD implements iConjuntoTDA {
    class Nodo{
        int info;
        Nodo sig;
    }

    Nodo c;

    @Override
    public void InicializarConjunto() {
        c = null;
    }

    @Override
    public void Agregar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.info = x;
        nuevo.sig = c;
        c = nuevo;
    }

    @Override
    public void Sacar(int x) {
        if(c != null) {
            if(c.info == x)
                c = c.sig;
            else {
                Nodo viajero = c;
                while(viajero.sig != null && viajero.sig.info != x)
                    viajero = viajero.sig;
                if(viajero.sig != null)
                    viajero.sig = viajero.sig.sig;
            }
        }
    }

    @Override
    public boolean Pertenece(int x) {
        Nodo viajero = c;
        if(viajero != null) {
            while(viajero != null && viajero.info != x)
                viajero = viajero.sig;
        }
        return (viajero != null);
    }

    @Override
    public int Elegir() {
        return c.info;
    }

    @Override
    public boolean ConjuntoVacio() {
        return (c == null);
    }
}
