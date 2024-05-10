package modelo3;

import modelo3.api.M3ColaTDA;
import modelo3.imp.M3Cola;

public class prin {

    public static void mostrarCola(M3ColaTDA c){
        M3ColaTDA copia = copiar(c);
        while (!copia.ColaVacia()) {
            System.out.println(copia.Primero());
            copia.Desacolar();
        }
    }

    public static M3ColaTDA copiar(M3ColaTDA c){
        M3ColaTDA copia = new M3Cola();
        copia.InicializarCola();
        while (!c.ColaVacia()) {
            copia.Acolar(c.Primero());
            c.Desacolar();
        }
        return copia;
    }

    public static void main(String[] args) {
        M3ColaTDA cola = new M3Cola();
        cola.InicializarCola();
        cola.Acolar(1);
        cola.Acolar(2);
        cola.Acolar(3);
        cola.Acolar(4);
        M3ColaTDA salida = cola.Salida(cola);
        mostrarCola(cola);
        System.out.println("Salida");
        mostrarCola(salida);
    }
}
