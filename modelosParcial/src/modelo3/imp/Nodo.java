package modelo3.imp;

import api.ConjuntoTDA;
import modelo1.Conjuntos.imp.ConjuntoLD;
import modelo2.imp.ConjuntosLD;

public class Nodo {
    int valor;
    Nodo siguiente;
    public void Metodo(Nodo origen){ // Eliminar duplicados de una lista
        ConjuntoTDA bolsa = new ConjuntosLD();
        bolsa.InicializarConjunto();
        if(origen != null){
            bolsa.Agregar(origen.valor);
        }
        Nodo aux = new Nodo();
        aux = origen;
        while(aux.siguiente != null){
            if(bolsa.Pertenece(aux.siguiente.valor)){
                aux.siguiente = aux.siguiente.siguiente;
            }else {
                bolsa.Agregar(aux.siguiente.valor);
                aux = aux.siguiente;
            }
        }
    }
}


// a) Elimina duplicados de una lista.
// b) Crea un conjunto con los valores de la lista. Si el valor ya existe en el conjunto, elimina el nodo de la lista
// c) TIENE COSTO O(n^2) CUADRATICO