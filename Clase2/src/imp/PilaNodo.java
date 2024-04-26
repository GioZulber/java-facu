package imp;

import api.PilaListaEnlazada;
import nodo.Nodo;

public class PilaNodo implements PilaListaEnlazada {

    Nodo inicio;
    Nodo nodoFinal;


    @Override
    public void InicializarPila() {
        inicio = null;
        nodoFinal = null;
   }

    @Override
    public void Apilar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.setValue(x);
        nuevo.setSig(null);
        if(PilaVacia()){
            inicio = nuevo;
        }else{
            nodoFinal.setSig(nuevo);
        }
        nodoFinal = nuevo;

    }
    @Override
    public void Desapilar() {
        if(PilaVacia()){
            System.out.println("Pila Vacia");
            return;
        }

        Nodo current = inicio;

        while(current.getSig() != nodoFinal){
            if (current.getSig() == null){
                inicio = null;
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
        return (inicio == null);
    }
}
