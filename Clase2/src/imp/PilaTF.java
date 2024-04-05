package imp;

import api.PilaTDA;

public class PilaTF implements PilaTDA {
    int[] arr;
    int cant;

    @Override
    public void InicializarPila() {
        arr = new int[20];
        cant = 0;
    }

    @Override
    public void Apilar(int x) {
        arr[cant] = x;
        cant++;
    }

    @Override
    public void Desapilar() {
        cant--;
    }

    @Override
    public int Tope() {
        return arr[cant-1];
    }

    @Override
    public boolean PilaVacia() {
        return (cant == 0);
    }
}
