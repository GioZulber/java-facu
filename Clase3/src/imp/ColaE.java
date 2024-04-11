package imp;

import api.ColaTDA;

public class ColaE implements ColaTDA {
    int[] array;
    int cant;


    @Override
    public void InicializarCola() {
        array = new int[20];

    }
    @Override
    public void Acolar(int x) {
        array[cant] = x;
        cant++;
    }

    @Override
    public void Desacolar() {
        for (int i = 0; i < cant - 1; i++) {
            array[i] = array[i + 1];
        }
        cant--;
    }
    @Override
    public boolean ColaVacia() {
        return (cant == 0);
    }

    @Override
    public int Primero() {
        return array[0];
    }

    public void showCola() {
        System.out.print("<");
        for (int i = 0; i < cant; i++) {
            System.out.print(array[i]);
            if(i != cant - 1) {
                System.out.print(",");
            }
        }
        System.out.println(">");
    }
}
