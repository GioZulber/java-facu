package imp;

import api.iHeapTDA;

public class MinHeap implements iHeapTDA {
//Prioridad a numeros mas chicos
    int cant;
    int[] elems;

    public MinHeap(int largo) {
        cant = 0;
        elems = new int[largo];
    }


    @Override
    public int primero() {
        return elems[0];
    }

    @Override
    public void agregar(int x) {
        elems[cant] = x;
        int i = cant-1;
        while(tienePadre(i) && padre(i) > elems[i]) {
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
            int hijoMasChico = indiceHijoIzquierdo(i);
            if (tieneHijoDerecho(i) && hijoDerecho(i) < hijoIzquierdo(i))
                hijoMasChico = indiceHijoDerecho(i);
            if (elems[i] < elems[hijoMasChico])
                break;
            else
                intercambiar(i, hijoMasChico);
            i = hijoMasChico;
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
    @Override
    public void print(){
        for (int i = 0; i < cant; i++)
            System.out.print(elems[i] + " ");
        System.out.println();
    }


    //Obtener indices
    private int indicePadre(int i) {
        return (i-1)/2;
    }

    private int indiceHijoIzquierdo(int i) {
        return i*2 + 1;
    }

    private int indiceHijoDerecho(int i) {
        return i*2 + 2;
    }


    // Verifica si existe una realaciÃ³n
    private boolean tienePadre(int i){
        return (indicePadre(i) >= 0);
    }

    private boolean tieneHijoIzquierdo(int i){ return (indiceHijoIzquierdo(i) < cant); }

    private boolean tieneHijoDerecho(int i){ return (indiceHijoDerecho(i) < cant); }

    //Devuelve el tipo de elemento indicado
    private int padre(int i) { return (elems[indicePadre(i)]); }
    private int hijoIzquierdo(int i) {
        return (elems[indiceHijoIzquierdo(i)]);
    }

    private int hijoDerecho(int i) {
        return (elems[indiceHijoDerecho(i)]);
    }


    // Intercambia de lugar dos elementos
    private void intercambiar(int i, int j) {
        int aux = elems[i];
        elems[i] = elems[j];
        elems[j] = aux;
    }
}
