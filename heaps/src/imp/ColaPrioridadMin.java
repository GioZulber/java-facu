package imp;

import api.iColaPrioridadTDA;
import api.iHeapObjTDA;

public class ColaPrioridadMin implements iColaPrioridadTDA {

    iHeapObjTDA heap;

    public ColaPrioridadMin(int largo) {
        this.heap = new HeapObjMin(largo);
    }

    @Override
    public void acolar(int prioridad, int valor) {
        this.heap.agregar(prioridad, valor);
    }

    @Override
    public void desacolar() {
        this.heap.eliminar();
    }

    @Override
    public int primero() {
        return this.heap.primero().getValor();
    }

    @Override
    public int prioridad() {
        return this.heap.primero().getPrioridad();
    }

    @Override
    public boolean colaVacia() {
        return this.heap.vacio();
    }

    @Override
    public int cantidad() {
        return this.heap.cantidad();
    }
}
