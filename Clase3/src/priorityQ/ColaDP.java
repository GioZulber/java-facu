package priorityQ;

import api.ColaPTDA;
import imp.Nodo;

public class ColaDP implements ColaPTDA {

    NodoP origen;
    NodoP ultimo;

    public void InicializarCola() {
        origen = null;
        ultimo = null;
    }

    @Override
    public void Acolar(int x, int prioridad){
        NodoP nuevo = new NodoP();
        nuevo.setValue(x);
        nuevo.setPriority(prioridad);


        if(ColaVacia()){
            nuevo.setSig(null);
            origen = nuevo;
            ultimo = nuevo;
        }
        else{

            if(prioridad < origen.getPriority()){
                nuevo.setSig(origen);
                origen = nuevo;
            }else if (prioridad >= ultimo.getPriority()) {
                ultimo.setSig(nuevo);
                ultimo = nuevo;
                nuevo.setSig(null);
            }else{

                NodoP aux = origen;
                while(aux.getSig() != null && aux.getSig().getPriority() <= prioridad){
                    aux = aux.getSig();
                }
                if (aux.getSig().getPriority() == prioridad){
                    nuevo.setSig(aux.getSig().getSig());
                    aux.setSig(nuevo);
                }else{
                    nuevo.setSig(aux.getSig());
                    aux.setSig(nuevo);
                }
            }
        }

    }

    @Override
    public void Desacolar() {
        origen = origen.getSig();
        if(ColaVacia()){
            ultimo = null;
        }
    }

    @Override
    public int Prioridad() {
        return origen.getPriority();
    }

    @Override
    public int Primero() {
        return origen.getValue();
    }
    @Override
    public boolean ColaVacia() {
        return (origen == null);
    }

}
