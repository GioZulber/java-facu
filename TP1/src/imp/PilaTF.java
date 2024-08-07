package imp;

import api.PilaTDA;

public class PilaTF implements PilaTDA {
    int[] arr;
    int indice;
    @Override
    public void InicializarPila() { // Costo constante
        arr = new int[20];
        indice = 0;
    }

    @Override
    public void Apilar(int x) { // Costo constante
        arr[indice] = x;
        indice++;
    }

    @Override
    public void Desapilar() { // Costo constante
        indice--;
    }

    @Override
    public int Tope() { // Costo constante
        return arr[indice-1];
    }

    @Override
    public boolean PilaVacia() { // Costo constante
        return (indice == 0);
    }
}
