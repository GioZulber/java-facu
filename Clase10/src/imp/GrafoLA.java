package imp;
import api.*;
public class GrafoLA implements iGrafoTDA {

    class NodoGrafo{
        int nodo;
        NodoArista arista; // Lista de aristas
        NodoGrafo sigNodo; // Siguiente nodo
    }

    class NodoArista{
        int etiqueta; // Peso
        NodoGrafo nodoDestino;
        NodoArista sigArista;
    }

    NodoGrafo origen;

    @Override
    public void InicializarGrafo() {
        origen = null;
    }

    @Override
    public void AgregarVertice(int v) {
        // Se inserta al inicio
        NodoGrafo nuevo = new NodoGrafo();
        nuevo.nodo = v;
        nuevo.arista = null;
        nuevo.sigNodo = origen;
        origen = nuevo;
    }

    @Override
    public void EliminarVertice(int v) {
        // Se recorre la lista de vertices para remover el nodo v
        // y las aristas que lo contienen
        if(origen.nodo == v){
            origen = origen.sigNodo;
        }
        NodoGrafo aux = origen;
        while(aux != null){
            // elimina las aristas que contienen al nodo v
            this.EliminarAristaNodo(aux, v);

            if (aux.sigNodo != null && aux.sigNodo.nodo == v){
                // Si el sig nodo de aux es v
                // se elimina el nodo
                aux.sigNodo = aux.sigNodo.sigNodo;
            }
            aux = aux.sigNodo;
        }

    }

    private void EliminarAristaNodo(NodoGrafo nodo, int v){
        NodoArista aux = nodo.arista;
        if(aux != null){
            // Si la arista es la primera de la lista
            if(aux.nodoDestino.nodo == v){
                nodo.arista = aux.sigArista;
            }else{
                while(aux.sigArista != null && aux.sigArista.nodoDestino.nodo != v){
                    aux = aux.sigArista;
                }
                if(aux.sigArista != null){
                    // Se elimina la arista
                    aux.sigArista = aux.sigArista.sigArista;
                }
            }
        }
    }

    @Override
    public iConjuntoTDA Vertices() {
        ConjuntoLD Vert = new ConjuntoLD();
        Vert.InicializarConjunto();
        NodoGrafo aux = origen;
        while(aux != null){
            Vert.Agregar(aux.nodo);
            aux = aux.sigNodo;
        }
        return Vert;
    }


    /*
    Para agregar una arista, se debe buscar el nodo origen y el nodo destino.
    Y luego se inserta sobre la lista de aristas del nodo origen.
     */
    @Override
    public void AgregarArista(int v1, int v2, int peso) {
        NodoGrafo nodoOrigen = Vert2Nodo(v1);
        NodoGrafo nodoDestino = Vert2Nodo(v2);
        // La arista se inserta al inicio de la lista
        // de aristas del nodo origen
        NodoArista nuevo = new NodoArista();
        nuevo.etiqueta = peso;
        nuevo.nodoDestino = nodoDestino;
        nuevo.sigArista = nodoOrigen.arista;
        nodoOrigen.arista = nuevo;
    }

    private NodoGrafo Vert2Nodo(int v){
        NodoGrafo aux = origen;
        while(aux != null && aux.nodo != v)
            aux = aux.sigNodo;
        return aux;
    }

    @Override
    public void EliminarArista(int v1, int v2) {
        NodoGrafo n1 = Vert2Nodo(v1);
        EliminarAristaNodo(n1, v2);
    }

    @Override
    public boolean ExisteArista(int v1, int v2) {
        NodoGrafo n1 = Vert2Nodo(v1);
        NodoArista aux = n1.arista;
        while(aux != null && aux.nodoDestino.nodo != v2)
            aux = aux.sigArista;
        return aux != null;
    }

    @Override
    public int PesoArista(int v1, int v2) {
        NodoGrafo n1 = Vert2Nodo(v1);
        NodoArista aux = n1.arista;
        while(aux.nodoDestino.nodo != v2)
            aux = aux.sigArista;

        return aux.etiqueta;
    }
}
