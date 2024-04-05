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
            if (A.PilaVacia()){
                A.InicializarPila();
                A.Apilar(Aux.Tope());
            }
            else{
                A.Apilar(Aux.Tope());
            }
            Copy.Apilar(Aux.Tope());
            Aux.Desapilar();
        }
        return  Copy;
    }
    public static void showList(PilaListaEnlazada X) {
        PilaListaEnlazada copia = copyPila(X);
        System.out.print("<");
        while(!copia.PilaVacia()){
            System.out.print(copia.Tope());
            copia.Desapilar();
            if(!copia.PilaVacia())
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
        System.out.println("Tope: " + pila.Tope());
        pila.Desapilar();
        System.out.println("Nuevo tope: " + pila.Tope());
        showList(pila);
        pila.Apilar(10);
        showList(pila);


    }
}
