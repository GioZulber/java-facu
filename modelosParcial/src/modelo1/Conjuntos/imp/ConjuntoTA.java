package modelo1.Conjuntos.imp;

import modelo1.Conjuntos.api.ConjuntoTDA;

public class ConjuntoTA implements ConjuntoTDA {
    int[] a;

    int cant;

    @Override
    public void InicializarConjunto() {
        a = new int[100];
        cant = 0;
    }
    @Override
    public void Agregar(int x){
        if(!this.Pertenece(x)){ // costo lineal
            a[cant] = x;
            cant++;
        }
    }

    @Override
    public void Sacar(int x) {
        int i = 0;
        while(i <cant && a[i] != x){
            i++;
        }

        if(i<cant){
            a[i] = a[cant-1];
            cant--;
        }
    }

    @Override
    public boolean Pertenece(int x) {
        int i = 0;
        while(i < cant && a[i] != x){
            i++;
        }
        return i < cant;
    }

    private ConjuntoTDA CopiarConjunto(ConjuntoTDA c){
        ConjuntoTDA aux = new ConjuntoTA();
        ConjuntoTDA c2 = new ConjuntoTA();
        c2.InicializarConjunto();
        aux.InicializarConjunto();
        while(!c.ConjuntoVacio()){
            int x = c.Elegir();
            aux.Agregar(x);
            c.Sacar(x);
        }
        while(!aux.ConjuntoVacio()){
            int x = aux.Elegir();
            c2.Agregar(x);
            c.Agregar(x);
            aux.Sacar(x);
        }

        return c2;
    }

    private int ContarElementos(ConjuntoTDA c){
        ConjuntoTDA c2 = this.CopiarConjunto(c);
        int cont = 0;
        while(!c2.ConjuntoVacio()){
            int x = c2.Elegir();
            c2.Agregar(x);
            cont++;
            c2.Sacar(x);
        }
        return cont;
    }

    @Override
    public boolean TodosPertenecen(ConjuntoTDA c) {
        int cont = this.ContarElementos(c); // costo cuadratico

        boolean pertencen = true;
        System.out.println("Cont: " + cont);
        for(int i = 0; i<cont && pertencen; i++){ // costo cuadratico
            pertencen = c.Pertenece(a[i]);
        }

        return pertencen;
    }

    @Override
    public void SacarTodos(ConjuntoTDA c) { // costo cubico

        int cont = this.ContarElementos(c); // costo cuadratico
        for(int i = 0; i<cont; i++){ // costo cubico
            if(cant == 0){
                break;
            }
            if (c.Pertenece(a[i])){ // costo cuadratico
                c.Sacar(a[i]);
                cant--;
            }
        }
    }

    @Override
    public int Elegir() {
        return a[cant-1]; // costo constante
    }

    @Override
    public boolean ConjuntoVacio() {
        return cant == 0; // costo constante
    }


}
