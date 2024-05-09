package imp;

import api.ColaTDA;

public class ColaTFE implements ColaTDA {
    int[] arr;
    int cant;


    @Override
    public void InicializarCola() { // 0(1) Constante
        arr = new int[20];
        cant = 0;
    }

    @Override
    public void Acolar(int x) { // 0(1) Constante
        arr[cant] = x;
        cant++;
    }

    @Override
    public void Desacolar() { // 0(n) Lineal
        for (int i = 0; i < cant - 1; i++) {
            arr[i] = arr[i + 1];
        }
        cant--;
    }

    @Override
    public boolean ColaVacia() {
        return (cant == 0);
    } // 0(1) Constante

    @Override
    public int Primero() {
        return arr[0];
    } // 0(1) Constante
}
