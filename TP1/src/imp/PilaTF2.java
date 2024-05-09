package imp;

import api.PilaTDA;

public class PilaTF2 implements PilaTDA {
    int[] arr;
    int indice;


    @Override
    public void InicializarPila() { // Costo constante
        arr = new int[20];
        indice = 0;
    }

    @Override
    public void Apilar(int x) { // Costo lineal

        for (int i = indice; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        indice++;
        arr[0] = x;

    }

    @Override
    public void Desapilar() { // Costo lineal
        for(int i = 0; i < indice -1; i++){
            arr[i] = arr[i+1];
        }
        indice--;
    }

    @Override
    public int Tope() { // Costo constante
        return arr[0];
    }

    @Override
    public boolean PilaVacia() { // Costo constante
        return (indice == 0);
    }
}
