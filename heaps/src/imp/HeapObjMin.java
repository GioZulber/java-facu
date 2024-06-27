package imp;

import api.iHeapObjTDA;

public class HeapObjMin implements iHeapObjTDA {

    private int cant;
    private Elemento[] elems;

    public HeapObjMin(int cantidad) {
        this.cant = 0;
        elems = new Elemento[cantidad];
    }

    @Override
    public Elemento primero() {
        return elems[0];
    }

    @Override
    public void agregar(int prioridad, int valor) {
        elems[cant] = new Elemento(prioridad, valor);
        int i = cant;
        while(tienePadre(i) && padre(i).getPrioridad() > elems[i].getPrioridad()){
            intercambiar(indicePadre(i), i);
            i = indicePadre(i);
        }
        cant++;
    }

    @Override
    public void eliminar() {
        elems[0] = elems[cant-1];
        cant--;
        int i = 0;
        while(tieneHijoIzquierdo(i)) {
            int hijoMasGrande = indiceHijoIzquierdo(i);
            if (tieneHijoDerecho(i) && hijoDerecho(i).getPrioridad() < hijoIzquierdo(i).getPrioridad()) {
                hijoMasGrande = indiceHijoDerecho(i);
            }
            if (elems[i].getPrioridad() > elems[hijoMasGrande].getPrioridad()) break;
            else intercambiar(i, hijoMasGrande);

            i = hijoMasGrande;
        }
    }

    @Override
    public boolean vacio() {
        return (cant == 0);
    }

    @Override
    public int cantidad() {
        return cant;
    }

    // Obtener indices

    private int indicePadre(int i) {
        return (i-1)/2;
    }

    private int indiceHijoIzquierdo(int i) {
        return i*2 + 1;
    }

    private int indiceHijoDerecho(int i) {
        return i*2 + 2;
    }

    // Verifica si existe una realación

    private boolean tienePadre(int i){
        return (indicePadre(i) >= 0);
    }

    private boolean tieneHijoIzquierdo(int i) {
        return (indiceHijoIzquierdo(i) < cant);
    }

    private boolean tieneHijoDerecho(int i) {
        return (indiceHijoDerecho(i) < cant);
    }

    // Devuelve el tipo de elemento indicado

    private Elemento padre(int i) {
        return (elems[indicePadre(i)]);
    }

    private Elemento hijoIzquierdo(int i) {
        return (elems[indiceHijoIzquierdo(i)]);
    }

    private Elemento hijoDerecho(int i) {
        return (elems[indiceHijoDerecho(i)]);
    }

    // Intercambia de lugar dos elementos

    private void intercambiar(int i, int j) {
        Elemento aux = elems[i];
        elems[i] = elems[j];
        elems[j] = aux;
    }
}
