package imp;

import api.ConjuntoTDA;

public class ConjuntoLD implements ConjuntoTDA {

    class Nodo {
        int info;
        Nodo sig;
        public Nodo getNodo() {
            return this;
        }

        public void setSig(Nodo nodo) {
            this.sig = nodo;
        }
        public Nodo getSig() {
            return this.sig;
        }

        public int getInfo() {
            return this.info;
        }

        public void setInfo(int info) {
            this.info = info;
        }

    }

    Nodo conjunto;
    @Override
    public void InicializarConjunto() {
        conjunto = null;
    }

    @Override
    public void Agregar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.setInfo(x);
        nuevo.setSig(conjunto);
        conjunto = nuevo;
    }

    @Override
    public void Sacar(int x) {
        if(conjunto != null){
            if(conjunto.getInfo() == x)
                conjunto = conjunto.getSig();
            else {
                Nodo current = conjunto;
                while(current.getSig() != null && current.getSig().getInfo() != x);
                    current = current.getSig();
                if(current.getSig() != null){
                     current.setSig(current.getSig().getSig());
                }
            }
        }
    }

    @Override
    public boolean Pertenece(int x) {
        Nodo current = conjunto;
        if(current != null){
            while(current != null && current.getInfo() != x){
                current = current.getSig();
            }
        }
        return (current != null);
    }

    @Override
    public int Elegir() {
        return conjunto.getInfo();
    }

    @Override
    public boolean ConjuntoVacio() {
        return (conjunto == null);
    }
}
