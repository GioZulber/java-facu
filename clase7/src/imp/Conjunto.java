package imp;

import api.ConjutnoTDA;

public class Conjunto implements ConjutnoTDA {

    boolean[] a;
    int cant;

    @Override
    public void InicializarConjunto(int x) {
        a = new boolean[x+1];
        cant = 0;
    }

    @Override
    public void Agregar(int x) {
        if(!this.Pertenece(x)){
            a[x] = true;
            cant++;
        }
    }

    @Override
    public void Sacar(int x) {
        if(this.Pertenece(x)){
            a[x] = false;
            cant--;
        }
    }

    @Override
    public boolean ConjuntoVacio() {
        return (cant == 0);
    }

    @Override
    public boolean Pertenece(int x) {
        return a[x];
    }

    @Override
    public int Elegir() {
        int i = 0;
        while(!a[i]){
            i++;
        }
        return i;
    }

    @Override
    public int Limite() {
        return a.length;
    }
}
