package imp;

import api.PilaListaEnlazada;
import nodo.Nodo;

public class PilaNodo implements PilaListaEnlazada {

    Nodo lista;
    int cant;

    public Nodo getLista() {
        return lista;
    }

    @Override
    public void InicializarPila() {
        lista = new Nodo();
        lista.setValue(0);
        lista.setSig(null);
        cant = 0;
    }

    @Override
    public void Apilar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.setValue(x);
        nuevo.setSig(null);
        cant ++;
        if(lista == null){
            System.out.println("Lista vacia. Iniciela para poder apilar");
        }else{
            Nodo current = lista;
            while(current.getSig() != null){
                current = current.getSig();
            }
            current.setSig(nuevo);
        }

    }
    @Override
    public void Desapilar() {
        if(PilaVacia()){
            System.out.println("Pila Vacia");
            return;
        }
        if (cant == 1){
            cant--;
            lista = null;
        }else{
            Nodo current = lista;
            while(current.getSig().getSig() != null){
                current =  current.getSig();
            }
            current.setSig(null);
            cant--;
        }

    }

    @Override
    public int Tope() {
        Nodo current = lista;
        if(PilaVacia()){
            System.out.println("Pila Vacia");
            return 0;
        }
        while(current.getSig() != null){
            current = current.getSig();
        }
        return current.getValue();
    }

    @Override
    public boolean PilaVacia() {
        return (cant == 0);
    }
}
