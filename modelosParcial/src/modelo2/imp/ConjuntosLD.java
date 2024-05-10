package modelo2.imp;


import api.ConjuntoTDA;

public class ConjuntosLD implements ConjuntoTDA {
    modelo1.Conjuntos.imp.Nodo origen;

    @Override
    public void InicializarConjunto() {
        origen = null;

    }

    @Override
    public void Agregar(int x) {
        if(!this.Pertenece(x)){
            modelo1.Conjuntos.imp.Nodo nuevo = new modelo1.Conjuntos.imp.Nodo();
            nuevo.setValue(x);
            nuevo.setSig(origen);
            origen = nuevo;
        }
    }

    @Override
    public void Sacar(int x) {
        if(!ConjuntoVacio()) {
            if (origen.getValue() == x) {
                origen = origen.getSig();
            } else {
                modelo1.Conjuntos.imp.Nodo aux = origen;
                while (aux.getSig() != null && aux.getSig().getValue() != x) {
                    aux = aux.getSig();
                }
                if (aux.getSig() != null) {
                    aux.setSig(aux.getSig().getSig());
                }
            }
        }
    }

    @Override
    public boolean Pertenece(int x) {
        modelo1.Conjuntos.imp.Nodo aux = origen;
        while (aux != null && aux.getValue() != x){
            aux = aux.getSig();
        }
        return aux != null;
    }

    @Override
    public int Elegir() {
        return origen.getValue();
    }

    @Override
    public boolean ConjuntoVacio() {

        return origen == null;
    }
}
