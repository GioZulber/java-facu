package priorityQ;

import api.ColaPTDA;

public class ColaEP implements ColaPTDA {
    int[] values;
    int[] priorities;
    int cant;

    @Override
    public void InicializarCola() {
        values = new int[20];
        priorities = new int[20];
        cant = 0;
    }

    @Override
    public void Acolar(int x, int prioridad) {
        int i = cant;

        while (i > 0 && priorities[i - 1] >= prioridad) {
            values[i] = values[i - 1];
            priorities[i] = priorities[i - 1];
            i--;
        }
        values[i] = x;
        priorities[i] = prioridad;
        cant++;
    }

    @Override
    public void Desacolar() {
        for (int i = 0; i < cant - 1; i++) {
            values[i] = values[i + 1];
            priorities[i] = priorities[i + 1];
        }
        cant--;
    }

    @Override
    public int Prioridad() {
        return priorities[0];
    }

    @Override
    public int Primero() {
        return values[0];
    }

    @Override
    public boolean ColaVacia() {
        return (cant == 0);
    }

}
