package modelo3.imp;

import api.ColaTDA;
import modelo3.api.M3ColaTDA;

public class M3Cola implements M3ColaTDA {

    int[] arr;
    int cant;

    @Override
    public void InicializarCola() {
        arr = new int[100];
        cant = 0;
    }

    @Override
    public void Acolar(int x) {
        if(x < 0) return;
        arr[cant] = x;
        cant++;

    }

    private M3ColaTDA copiarCola(M3ColaTDA c){
        M3ColaTDA aux = new M3Cola();
        M3ColaTDA copia = new M3Cola();
        aux.InicializarCola();
        copia.InicializarCola();
        while (!c.ColaVacia()) {
            aux.Acolar(c.Primero());
            c.Desacolar();
        }
        while (!aux.ColaVacia()) {
            copia.Acolar(aux.Primero());
            c.Acolar(aux.Primero());
            aux.Desacolar();
        }

        return copia;
    }
    private float PromedioGeneral(M3ColaTDA c){
        M3ColaTDA copia = copiarCola(c);
        int suma = 0;
        int cant = 0;
        while (!copia.ColaVacia()) {
            suma += copia.Primero();
            cant++;
            copia.Desacolar();
        }
        System.out.println("Suma: " + suma);
        System.out.println("Cantidad: " + cant);
        return (float) suma / cant;
    }

    @Override
    public M3ColaTDA Salida(M3ColaTDA c) { // costo O(n) lineal
        M3ColaTDA copia = copiarCola(c); // lineal
        M3ColaTDA mayores = new M3Cola();
        mayores.InicializarCola();
        M3ColaTDA menores = new M3Cola();
        menores.InicializarCola();
        M3ColaTDA igualPromedio = new M3Cola();
        igualPromedio.InicializarCola();

        M3ColaTDA salida = new M3Cola();
        salida.InicializarCola();

        float promedio = PromedioGeneral(copia);

        System.out.println("Promedio: " + promedio);

        while(!copia.ColaVacia()){
            if(copia.Primero() > promedio){
                mayores.Acolar(copia.Primero());
            }else if(copia.Primero() < promedio){
                menores.Acolar(copia.Primero());
            }else{
                igualPromedio.Acolar(copia.Primero());
            }
            copia.Desacolar();
        }
        while (!mayores.ColaVacia()) {
            salida.Acolar(mayores.Primero());
            mayores.Desacolar();
        }
        salida.Acolar(0);
        while (!igualPromedio.ColaVacia()) {
            salida.Acolar(igualPromedio.Primero());
            igualPromedio.Desacolar();
        }
        salida.Acolar(0);
        while (!menores.ColaVacia()) {
            salida.Acolar(menores.Primero());
            menores.Desacolar();
        }

        return salida;
    }

    @Override
    public void Desacolar() {
        for (int i = 0; i < cant - 1; i++) {
            arr[i] = arr[i + 1];
        }
        cant--;
    }

    @Override
    public boolean ColaVacia() {
        return cant == 0;
    }

    @Override
    public int Primero() {
        return arr[0];
    }
}
