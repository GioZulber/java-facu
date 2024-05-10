package modelo2.imp;

import modelo2.api.ColaLimitadaTDA;

public class ColaLimitada implements ColaLimitadaTDA {

    int[] arr;

    int cant;
    @Override
    public void InicializarCola(int x) {
        arr = new int[x];
        cant = 0;
    }

    @Override
    public boolean Acolar(int x) {
        if (!ColaLlena()){
            arr[cant] = x;
            cant++;
            return true;
        }
        return false;
    }

    @Override
    public void Desacolar() {
        for (int i = 0; i < cant - 1; i++){
            arr[i] = arr[i + 1];
        }
        cant--;
    }

    @Override
    public boolean ColaVacia() {
        return cant == 0;
    }

    @Override
    public boolean ColaLlena() {
        return cant == arr.length;
    }

    @Override
    public int Primero() {
        return arr[0];
    }
}
