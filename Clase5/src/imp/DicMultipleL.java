package imp;

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;

public class DicMultipleL implements DiccionarioMultipleTDA {

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
        if (nc == null){
            nc = new NodoClave();
            nc.clave = clave;
            nc.sigClave = origen;
            origen = nc;
        }
        NodoValor aux = nc.valores;
        while (aux != null && aux.valor != valor){
            aux = aux.sigValor;
        }
        if (aux == null){
            NodoValor nv = new NodoValor();
            nv.valor = valor;
            nv.sigValor = nc.valores;
            nc.valores = nv;
        }

    }

    @Override
    public void Eliminar(int clave) {
        if(origen.clave == clave){
            origen = origen.sigClave;
        }
        else{
            NodoClave aux = origen;
            while (aux.sigClave != null && aux.sigClave.clave != clave){
                aux = aux.sigClave;
            }
            if (aux.sigClave != null){
                aux.sigClave = aux.sigClave.sigClave;
            }
        }
    }

    @Override
    public void EliminarValor(int clave, int valor) {
        if(origen.clave == clave) {
            EliminarValorEnNodo(origen, valor);
            if(origen.valores == null)
                origen = origen.sigClave;
        } else {
            NodoClave viajero = origen;
            while(viajero.sigClave != null & viajero.sigClave.clave != clave)
                viajero = viajero.sigClave;
            if(viajero.sigClave != null) {
                EliminarValorEnNodo(viajero.sigClave, valor);
                if(viajero.sigClave.valores == null)
                    viajero.sigClave = viajero.sigClave.sigClave;
            }
        }
    }

    @Override
    public ConjuntoTDA Recuperar(int clave) {
        NodoClave nodo = Clave2NodoClave(clave);
        ConjuntoTDA c = new ConjuntoLD();
        c.InicializarConjunto();
        NodoValor viajero = nodo.valores;
        while(viajero != null) {
            c.Agregar(viajero.valor);
            viajero = viajero.sigValor;
        }
        return c;
    }

    @Override
    public ConjuntoTDA Claves() {
        ConjuntoTDA c = new ConjuntoLD();
        c.InicializarConjunto();
        if(origen != null) {
            NodoClave viajero = origen;
            while(viajero != null) {
                c.Agregar(viajero.clave);
                viajero = viajero.sigClave;
            }
        }
        return c;
    }

    private NodoClave Clave2NodoClave(int clave){
        NodoClave aux = origen;
        while (aux != null && aux.clave != clave){
            aux = aux.sigClave;
        }
        return aux;
    }

    private void EliminarValorEnNodo(NodoClave nodo, int valor){
        if (nodo.valores.valor == valor){
            nodo.valores = nodo.valores.sigValor;
        }else{
            NodoValor aux = nodo.valores;
            while(aux.sigValor != null && aux.sigValor.valor != valor){
                aux = aux.sigValor;
            }
            if (aux.sigValor != null){
                aux.sigValor = aux.sigValor.sigValor;
            }
        }
    }

}
