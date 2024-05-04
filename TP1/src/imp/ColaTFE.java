package imp;

import api.ColaTDA;

public class ColaTFE implements ColaTDA {
    int[] arr;
    int cant;


    @Override
    public void InicializarCola() {
        arr = new int[20];
    }

    @Override
    public void Acolar(int x) {
        arr[cant] = x;
        cant++;
    }

    @Override
    public void Desacolar() {
        for (int i = 0; i < cant - 1; i++) {
            arr[i] = arr[i + 1];
        }
        cant--;
    }

    @Override
    public boolean ColaVacia() {
        return (cant == 0);
    }

    @Override
    public int Primero() {
        return arr[0];
    }
}
