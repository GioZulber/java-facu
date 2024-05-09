package imp;

import api.ColaPTDA;

public class ColaPTF2 implements ColaPTDA {

    int[] valores;
    int[] prioridades;
    int indice;

    @Override
    public void InicializarCola() {
        valores = new int[20];
        prioridades = new int[20];
        indice = 0;
    }

    @Override
    public void Acolar(int x, int prioridad) { // 0(n) Lineal

        // Acolar el de mayor prioridad en la pos =
        // 0 y el de menor prioridad en la pos = n-1
        int j = 0;
        for (j = indice; j > 0 && prioridades[j - 1] >= prioridad; j--) {
            valores[j] = valores[j - 1];
            prioridades[j] = prioridades[j - 1];
        }
        valores[j] = x;
        prioridades[j] = prioridad;
        indice++;
    }


    @Override
    public void Desacolar() {
        valores[indice-1] = 0;
        indice--;

    }

    @Override
    public int Prioridad() {
        return prioridades[0];
    }

    @Override
    public int Primero() {
        return valores[0];
    }

    @Override
    public boolean ColaVacia() {
        return (indice == 0);
    }

    @Override
    public void Mostrar() {
        for (int i = 0; i < indice; i++) {
            System.out.println("Valor: " + valores[i] + " Prioridad: " + prioridades[i]);
        }
    }
}
