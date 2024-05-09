package imp;

import api.ColaPTDA;

public class ColaPTF implements ColaPTDA {
    class Elemento{
        int valor;
        int prioridad;
    }
    Elemento[] elementos;
    int cant;
    @Override
    public void InicializarCola() {
        elementos = new Elemento[20];
        cant = 0;
    }

    @Override
    public void Acolar(int x, int prioridad) {
       int j = 0;
        for (j =cant;j > 0 && elementos[j-1].prioridad >= prioridad ;j--) {
            elementos[j] = elementos[j-1];
        }
        elementos[j] = new Elemento();
        elementos[j].valor = x;
        elementos[j].prioridad = prioridad;
        cant++;

    }

    @Override
    public void Desacolar() { cant--;}

    @Override
    public int Prioridad() {return elementos[cant-1].prioridad;}

    @Override
    public int Primero() {return elementos[cant-1].valor;}

    @Override
    public boolean ColaVacia() {
        return cant == 0;
    }

    @Override
    public void Mostrar() {
        for (int i = 0; i < cant; i++) {
            System.out.println("Valor: "+elementos[i].valor+" Prioridad: "+elementos[i].prioridad);
        }
    }
}
