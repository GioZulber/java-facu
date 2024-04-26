package imp;

import api.ColaTDA;
public class ColaD implements ColaTDA {
    Nodo origen;
    Nodo ultimo;

    @Override
    public void InicializarCola() {
        origen = null;
        ultimo = null;
    }

    @Override
    public void Acolar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.setValue(x);
        nuevo.setSig(null);
        if (origen == null) {
            origen = nuevo;
        } else {
            ultimo.setSig(nuevo);
        }
        ultimo = nuevo;
    }
    @Override
    public void Desacolar() {
        origen = origen.getSig();
    }
    @Override
    public boolean ColaVacia() {
        return (origen == null);
    }

    @Override
    public int Primero() {
        return origen.getValue();
    }


}
