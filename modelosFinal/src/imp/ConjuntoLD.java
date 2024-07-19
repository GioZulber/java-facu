package imp;

import api.iConjuntoTDA;

public class ConjuntoLD implements iConjuntoTDA {
    class Nodo{
        int value;
        Nodo sig;
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public Nodo getSig() {
            return sig;
        }
        public void setSig(Nodo sig) {
            this.sig = sig;
        }
    }

    Nodo origen;

    @Override
    public void InicializarConjunto() {
        origen = null;

    }

    @Override
    public void Agregar(int x) {
        if(!this.Pertenece(x)){
            Nodo nuevo = new Nodo();
            nuevo.setValue(x);
            nuevo.setSig(origen);
            origen = nuevo;
        }
    }

    @Override
    public void Sacar(int x) {
        if(!ConjuntoVacio()) {
            if (origen.getValue() == x) {
                origen = origen.getSig();
            } else {
                Nodo aux = origen;
                while (aux.getSig() != null && aux.getSig().getValue() != x) {
                    aux = aux.getSig();
                }
                if (aux.getSig() != null) {
                    aux.setSig(aux.getSig().getSig());
                }
            }
        }
    }

    @Override
    public boolean Pertenece(int x) {
        Nodo aux = origen;
        while (aux != null && aux.getValue() != x){
            aux = aux.getSig();
        }
        return aux != null;
    }

    @Override
    public int Elegir() {
        return origen.getValue();
    }

    @Override
    public boolean ConjuntoVacio() {

        return origen == null;
    }
}
