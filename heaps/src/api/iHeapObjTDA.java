package api;

import imp.Elemento;

public interface iHeapObjTDA {
    Elemento primero();
    void agregar(int prioridad, int valor);
    void eliminar();
    boolean vacio();
    int cantidad();
}
