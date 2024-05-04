package imp;

import api.PilaTDA;

public class PilaTF implements PilaTDA {
    int[] arr;
    int indice;
    @Override
    public void InicializarPila() {
        arr = new int[20];
        indice = 0;
    }

    @Override
    public void Apilar(int x) {
        arr[indice] = x;
        indice++;
    }

    @Override
    public void Desapilar() {
        indice--;
    }

    @Override
    public int Tope() {
        return arr[indice-1];
    }

    @Override
    public boolean PilaVacia() {
        return (indice == 0);
    }
}
