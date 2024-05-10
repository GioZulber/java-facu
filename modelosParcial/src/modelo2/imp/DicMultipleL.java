package modelo2.imp;

import api.ConjuntoTDA;
import modelo1.listaDoblementeEnlazada.Nodo;
import modelo2.api.M2DicMultipleTDA;

public class DicMultipleL implements M2DicMultipleTDA {
    class NodoClave{
        int clave;
        NodoValor valores;
        NodoClave sigClave;


    }
    class NodoValor{
        int valor;
        NodoValor sigValor;
    }

    NodoClave origen;
    @Override
    public void InicializarDiccionario() {
        origen = null;
    }

    @Override
    public void Agregar(int clave, int valor) {
        NodoClave nc = Clave2NodoClave(clave);

        if(nc == null){
            nc = new NodoClave();
            nc.clave = clave;
            nc.sigClave = origen;
            origen = nc;
        }

        NodoValor aux = nc.valores;
        while (aux != null && aux.valor != valor){ // verificamos que exista el valor
            aux = aux.sigValor;
        }
        if(aux == null){ // si no existe el valor lo agregamos
            NodoValor nv = new NodoValor();
            nv.valor = valor;
            nv.sigValor = nc.valores;
            nc.valores = nv;
        }

    }

    @Override
    public ConjuntoTDA ClaseValor(int valor) {
        ConjuntoTDA c = new ConjuntosLD();
        c.InicializarConjunto();
        NodoClave aux = origen;
        while(aux != null){
            NodoValor auxValores = aux.valores;
            while(auxValores != null){
                if(auxValores.valor == valor){
                    c.Agregar(aux.clave);
                }
                auxValores = auxValores.sigValor;
            }
            aux = aux.sigClave;
        }
        return  c;
    }

    @Override
    public void Eliminar(int clave) {
        if(origen.clave == clave){
            origen = origen.sigClave;
        }else{
            NodoClave aux = origen;
            while (aux.sigClave != null && aux.sigClave.clave != clave){
                aux = aux.sigClave;
            }
            if(aux.sigClave != null){
                aux.sigClave = aux.sigClave.sigClave;
            }
        }
    }

    @Override
    public void EliminarValor(int clave, int valor) { // elimina el valor de la clave
        if(origen.clave == clave){
            EliminarValorEnNodo(origen, valor);
            if(origen.valores == null){
                origen = origen.sigClave;
            }
        }else{
            NodoClave aux = origen;
            while(aux.sigClave != null && aux.sigClave.clave != clave){
                aux = aux.sigClave;
            }
            if(aux.sigClave != null) {
                EliminarValorEnNodo(aux.sigClave, valor);
                if (aux.sigClave.valores == null) {
                    aux.sigClave = aux.sigClave.sigClave;
                }
            }
        }
    }

    @Override
    public ConjuntoTDA Recuperar(int clave) { // devuelve un conjunto con los valores de la clave
        NodoClave nc = Clave2NodoClave(clave);
        ConjuntoTDA c = new ConjuntosLD();
        c.InicializarConjunto();
        NodoValor aux = nc.valores;
        while(aux != null){
            c.Agregar(aux.valor);
            aux = aux.sigValor;
        }
        return c;
    }

    @Override
    public ConjuntoTDA Claves() { // devuelve un conjunto con las claves
        ConjuntoTDA c = new ConjuntosLD();
        c.InicializarConjunto();
        if(origen != null){
            NodoClave aux = origen;
            while(aux != null){
                c.Agregar(aux.clave);
                aux = aux.sigClave;
            }
        }
        return c;
    }

    private NodoClave Clave2NodoClave(int clave){ // devuelve el nodo clave de la clave
        NodoClave aux = origen;
        while (aux != null && aux.clave != clave){
            aux = aux.sigClave;
        }
        return aux;
    }

    private void EliminarValorEnNodo(NodoClave nodo, int valor){ // elimina el valor de un nodo clave
        if(nodo.valores.valor == valor){
            nodo.valores = nodo.valores.sigValor;
        }else{
            NodoValor aux = nodo.valores;
            while(aux.sigValor != null && aux.sigValor.valor != valor){
                aux = aux.sigValor;
            }
            if(aux.sigValor != null){
                aux.sigValor = aux.sigValor.sigValor;
            }
        }
    }

}
