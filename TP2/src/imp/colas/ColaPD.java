package imp.colas;

import api.ColaPTDA;
import imp.nodo.NodoP;

public class ColaPD implements ColaPTDA {

    NodoP origen;

    NodoP ultimo;
    @Override
    public void InicializarCola() {
        origen = null;
        ultimo = null;
    }

    @Override
    public void Acolar(int x, int prioridad) {
        NodoP nuevo = new NodoP();
        nuevo.setValue(x);
        nuevo.setPrioridad(prioridad);

        if(ColaVacia()){
            nuevo.setSig(null);
            origen = nuevo;
            ultimo = nuevo;
        }else {

            if(prioridad > origen.getPrioridad()){
                nuevo.setSig(origen);
                origen = nuevo;
            }else if( prioridad <= ultimo.getPrioridad() ){
                ultimo.setSig(nuevo);
                ultimo = nuevo;
                nuevo.setSig(null);
            }else{
                NodoP current = origen;
                while(current.getSig() != null && current.getSig().getPrioridad() >= prioridad){
                    current = current.getSig();
                }

                nuevo.setSig(current.getSig());
                current.setSig(nuevo);
            }
        }
    }

    @Override
    public void Desacolar() {
        origen = origen.getSig();
    }

    @Override
    public int Prioridad() {
        return origen.getPrioridad();
    }

    @Override
    public int Primero() {
        return origen.getValue();
    }

    @Override
    public boolean ColaVacia() {
        return origen == null;
    }
}
