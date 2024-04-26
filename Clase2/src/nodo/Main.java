package nodo;

import imp.PilaNodo;
import api.PilaListaEnlazada;



public class Main {
    public static PilaListaEnlazada copyPila(PilaListaEnlazada A){
        PilaListaEnlazada Aux = new PilaNodo();
        PilaListaEnlazada Copy = new PilaNodo();
        Aux.InicializarPila();
        Copy.InicializarPila();

        while(!A.PilaVacia()){
            Aux.Apilar(A.Tope());
            A.Desapilar();
        }
        while (!Aux.PilaVacia()){
            A.Apilar(Aux.Tope());
            Copy.Apilar(Aux.Tope());
            Aux.Desapilar();
        }
        return  Copy;
    }
    public static void showList(PilaListaEnlazada X) {
        PilaListaEnlazada copy = copyPila(X);
        System.out.print("<");
        while(!copy.PilaVacia()){
            System.out.print(copy.Tope());
            copy.Desapilar();
            if(!copy.PilaVacia())
                System.out.print(", ");
        }
        System.out.println(">");
    }

    public static void main(String[] args){


        PilaListaEnlazada pila = new PilaNodo();
        pila.InicializarPila();
        pila.Apilar(2);
        pila.Apilar(4);
        pila.Apilar(6);
        pila.Apilar(8);
        //showList(pila);
        System.out.println("Tope: " + pila.Tope());
        pila.Desapilar();
        System.out.println("Nuevo tope: " + pila.Tope());
        showList(pila);
        pila.Apilar(10);
        showList(pila);


    }
}
