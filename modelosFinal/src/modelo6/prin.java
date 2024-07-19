package modelo6;

import api.*;
import imp.*;

public class prin {


    public static void mostrarMulti(MultiConjuntoTDA c) {
        MultiConjuntoTDA aux = new MultiConjunto();
        aux.InicializarMultiConjunto();
        while (!c.MultiConjuntoVacio()) {
            int x = c.Elegir();
            System.out.println(x + " - " + c.Multiplicidad(x));
            while (c.Multiplicidad(x) > 1) {
                aux.Agregar(x);
                c.Sacar(x);
            }
            aux.Agregar(x);
            c.Sacar(x);
        }
        while (!aux.MultiConjuntoVacio()) {
            c.Agregar(aux.Elegir());
            aux.Sacar(aux.Elegir());
        }
    }

    public static void main(String[] args) {
        MultiConjuntoTDA  mc = new MultiConjunto();
        mc.InicializarMultiConjunto();
        mc.Agregar(5);
        mc.Agregar(2);
        mc.Agregar(2);
        mc.Agregar(3);
        mc.Agregar(5);
        mc.Agregar(5);
        mc.Agregar(7);
        mc.Agregar(9);
        mc.Agregar(7);

        System.out.println("Elementos del MultiConjunto:");
        mostrarMulti(mc);


    }
}
