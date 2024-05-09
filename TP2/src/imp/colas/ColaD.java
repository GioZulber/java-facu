package imp.colas;

import api.ColaTDA;
import imp.nodo.Nodo;

public class ColaD implements ColaTDA {
    Nodo origen;
    Nodo nodoFinal;

    @Override
    public void InicializarCola() {
        origen = null;
        nodoFinal = null;
    }

    @Override
    public void Acolar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.setValue(x);
        nuevo.setSig(null);
        if(ColaVacia()){
            origen = nuevo;
        }else{
            nodoFinal.setSig(nuevo);
        }
        nodoFinal = nuevo;
    }

    @Override
    public void Desacolar() {
        origen = origen.getSig();
    }

    @Override
    public boolean ColaVacia() {
        return origen == null;
    }

    @Override
    public int Primero() {
        return origen.getValue();
    }
}
