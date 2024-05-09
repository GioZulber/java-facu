package activities;

import api.PilaTDA;
import imp.PilaTF;
import imp.PilaTF2;

public class punto1 {

    public static PilaTDA pasaraOtraPila(PilaTDA X){
        PilaTDA pilaAux = new PilaTF();
        pilaAux.InicializarPila();
        while(!X.PilaVacia()){
            pilaAux.Apilar(X.Tope());
            X.Desapilar();
        }
        return pilaAux;
    }

    public static PilaTDA copiarPila(PilaTDA X){
        PilaTDA pilaAux = new PilaTF2();
        pilaAux.InicializarPila();
        PilaTDA pilaAux2 = new PilaTF2();
        pilaAux2.InicializarPila();
        while(!X.PilaVacia()){
            pilaAux.Apilar(X.Tope());
            X.Desapilar();
        }

        while(!pilaAux.PilaVacia()){
            X.Apilar(pilaAux.Tope());
            pilaAux2.Apilar(pilaAux.Tope());
            pilaAux.Desapilar();
        }
        return pilaAux2;
    }

    public static void invertirPila(PilaTDA X){
        PilaTDA pilaAux = new PilaTF2();
        PilaTDA pilaAux2 = new PilaTF2();
        pilaAux.InicializarPila();
        pilaAux2.InicializarPila();
        while(!X.PilaVacia()){
            pilaAux.Apilar(X.Tope());
            X.Desapilar();
        }
        while(!pilaAux.PilaVacia()){
            pilaAux2.Apilar(pilaAux.Tope());
            pilaAux.Desapilar();
        }
        while(!pilaAux2.PilaVacia()){
            X.Apilar(pilaAux2.Tope());
            pilaAux2.Desapilar();
        }

    }

    public static int contarElementos(PilaTDA X){
        PilaTDA pilaAux = copiarPila(X);
        int contador = 0;
        while(!pilaAux.PilaVacia()){
            contador++;
            pilaAux.Desapilar();
        }
        return contador;
    }
    public static int sumarElementos(PilaTDA X){
        PilaTDA pilaAux = copiarPila(X);
        int suma = 0;
        while(!pilaAux.PilaVacia()){
            suma += pilaAux.Tope();
            pilaAux.Desapilar();
        }
        return suma;
    }

    public static int promedioPila(PilaTDA X){
        return sumarElementos(X)/contarElementos(X);
    }
    public static void showPila(PilaTDA X){
        PilaTDA pilaAux = copiarPila(X);
        System.out.print("<");
        while(!pilaAux.PilaVacia()){
            System.out.print(pilaAux.Tope());
            if(!pilaAux.PilaVacia()){
                System.out.print(",");
            }
            pilaAux.Desapilar();
        }
        System.out.println(">");
    }

    public static void main(String[] args) {
        PilaTDA pila = new PilaTF2();
        pila.InicializarPila();
        pila.Apilar(2);
        pila.Apilar(4);
        pila.Apilar(6);
        pila.Apilar(8);
        pila.Apilar(10);
        pila.Apilar(12);
        showPila(pila);
        //PilaTDA pilaAux = pasaraOtraPila(pila);
        //showPila(pilaAux);
        /*
        invertirPila(pila);
        showPila(pila);
        System.out.println(contarElementos(pila));
        System.out.println(sumarElementos(pila));
        System.out.println(promedioPila(pila));
        */ 
    }
}
