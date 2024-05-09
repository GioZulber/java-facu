package imp;

import api.ColaTDA;

public class ColaTFE2 implements ColaTDA {

    int[] arr;
    int indice;
    @Override
    public void InicializarCola() { // 0(1) Constante
        arr = new int[20];
        indice = 0;
    }

    @Override
    public void Acolar(int x) { // 0(n) Lineal
        for (int i = indice; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        indice++;
        arr[0] = x;
    }

    @Override
    public void Desacolar() { // 0(1) Constante
        indice--;
    }
    @Override
    public boolean ColaVacia() { // 0(1) Constante
        return indice==0;
    }

    @Override
    public int Primero() { // 0(1) Constante
        return arr[indice-1];
    }
}
