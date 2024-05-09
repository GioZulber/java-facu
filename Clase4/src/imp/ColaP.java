package imp;

import api.ColaPTDA;

public class ColaP implements ColaPTDA {

    class Elemento{
        int valor;
        int prioridad;
    }

    Elemento[] elementos;

    int indice;

    @Override
    public void InicializarColaPrioridad(){
        elementos = new Elemento[20];
        indice = 0;
    }

    @Override
    public void AcolarPrioridad(int valor, int prioridad){
        int j = 0;
        for(j = indice; j > 0 && elementos[j-1].prioridad >= prioridad; j--){
            elementos[j] = elementos[j-1];
        }
        elementos[j] = new Elemento();
        elementos[j].valor = valor;
        elementos[j].prioridad = prioridad;
        indice++;
    }

    @Override
    public void Desacolar(){
        indice--;
    }

    @Override
    public int Primero() {return elementos[indice-1].valor; }

    @Override
    public int Prioridad() {return elementos[indice-1].prioridad; }

    @Override
    public boolean ColaVacia() {return (indice == 0); }
}
