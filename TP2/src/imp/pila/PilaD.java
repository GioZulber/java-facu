package imp.pila;

import api.PilaTDA;
import imp.nodo.Nodo;

public class PilaD implements PilaTDA {

    Nodo origen;
    Nodo nodoFinal;
    @Override
    public void InicializarPila() {
        origen = null;
        nodoFinal = null;
    }

    @Override
    public void Apilar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.setValue(x);
        nuevo.setSig(null);
        if (PilaVacia()) {
            origen = nuevo;
        } else {
            nodoFinal.setSig(nuevo);
        }
        nodoFinal = nuevo;
    }
    @Override
    public void Desapilar() {
        if(PilaVacia()) {
            System.out.println("Pila Vacia");
            return;
        }

        Nodo current = origen;
        while(current.getSig() != nodoFinal){
            if(current.getSig() == null){ // Si el siguiente nodo es nulo, entonces la pila tiene un solo elemento
                origen = null;
                break;
            }
            current = current.getSig();
        }
        current.setSig(null);
        nodoFinal = current;
    }

    @Override
    public int Tope() {
        return nodoFinal.getValue();
    }

    @Override
    public boolean PilaVacia() {
        return origen == null;
    }
}
