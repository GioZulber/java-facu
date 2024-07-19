package imp;

import api.*;
public class MultiConjunto implements MultiConjuntoTDA{

    class Nodo{
        int info; //elemento
        int multi; //multiplicidad

        Nodo sig;
    }

    Nodo multi;
    @Override
    public void InicializarMultiConjunto() {
        multi = null;
    }

    @Override
    public void Agregar(int x) {
        if (this.MultiConjuntoVacio()){
            Nodo nuevo = new Nodo();
            nuevo.info = x;
            nuevo.multi = 1;
            nuevo.sig = null;
            multi = nuevo;
        }else {
            Nodo aux = multi;
            while (aux.sig != null && aux.info != x){
                aux = aux.sig;
            }
            if (aux.info == x){
                aux.multi++;
            }else {
                Nodo nuevo = new Nodo();
                nuevo.info = x;
                nuevo.multi = 1;
                nuevo.sig = null;
                aux.sig = nuevo;
            }
        }

    }

    @Override
    public void Sacar(int x) {
        if (!this.MultiConjuntoVacio()){
            if (multi.info == x){
                if (multi.multi > 1){
                    multi.multi--;
                }else {
                    multi = multi.sig;
                }
            }else {
                Nodo aux = multi;
                while (aux.sig != null && aux.sig.info != x){
                    aux = aux.sig;
                }
                if (aux.sig != null){
                    if (aux.sig.multi > 1){
                        aux.sig.multi--;
                    }else {
                        aux.sig = aux.sig.sig;
                    }
                }
            }
        }

    }

    @Override
    public int Multiplicidad(int x) {
        if(!this.MultiConjuntoVacio()){
            Nodo aux = multi;
            while (aux != null && aux.info != x){
                aux = aux.sig;
            }
            if (aux != null){
                return aux.multi;
            }

        }

        return 0;
    }

    @Override
    public boolean MultiConjuntoVacio() {
        return multi == null;
    }

    @Override
    public int Elegir() {
        return multi.info;
    }

    @Override
    public String toString() {
        String result = "";
        Nodo aux = multi;
        while (aux != null){
            result += aux.info + " - " + aux.multi + "\n";
            aux = aux.sig;
        }
        return result;
    }

}
