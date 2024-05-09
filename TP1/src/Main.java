import api.ColaPTDA;
import api.ColaTDA;
import imp.ColaPTF;
import imp.ColaPTF2;
import imp.ColaTFE;

public class Main {
    public static ColaPTDA copiar(ColaPTDA x){
        ColaPTDA copia = new ColaPTF();
        ColaPTDA aux = new ColaPTF();
        copia.InicializarCola();
        aux.InicializarCola();
        int valor;
        int prioridad;
        while(!x.ColaVacia()){
            valor = x.Primero();
            prioridad = x.Prioridad();
            copia.Acolar(valor, prioridad);
            aux.Acolar(valor, prioridad);
            x.Desacolar();
        }
        while(!aux.ColaVacia()){
            valor = aux.Primero();
            prioridad = aux.Prioridad();
            x.Acolar(valor, prioridad);
            aux.Desacolar();
        }

        return copia;
    }
    public static void mostrarColaP(ColaPTDA x){
        ColaPTDA copia = copiar(x);
        while(!copia.ColaVacia()){
            System.out.println("Valor: " + copia.Primero() + ", Prioridad: " + copia.Prioridad());
            copia.Desacolar();
        }
    }

    public static ColaPTDA combinar(ColaPTDA A, ColaPTDA B){
        int prioridadActual = 20;
        ColaPTDA resFinal = new ColaPTF();
        resFinal.InicializarCola();
        while(!A.ColaVacia() && !B.ColaVacia()){
            if(B.Prioridad() > A.Prioridad()){
                resFinal.Acolar(B.Primero(), prioridadActual);
                B.Desacolar();
            }else{
                resFinal.Acolar(A.Primero(), prioridadActual);
                A.Desacolar();
            }
            prioridadActual--;
        }
        if(A.ColaVacia()){
            while(!B.ColaVacia()){
                resFinal.Acolar(B.Primero(), prioridadActual);
                B.Desacolar();
                prioridadActual--;
            }
        }else{
            while(!A.ColaVacia()){
                resFinal.Acolar(A.Primero(), prioridadActual);
                A.Desacolar();
                prioridadActual--;
            }
        }
        return resFinal;
    }

    public static int cantidadElementos(ColaPTDA x){
        ColaPTDA copia = copiar(x);
        int cantidad = 0;
        while(!copia.ColaVacia()){
            cantidad++;
            copia.Desacolar();
        }
        return cantidad;
    }

    public static boolean identicas(ColaPTDA a, ColaPTDA b){
        ColaPTDA copiaA = copiar(a);
        ColaPTDA copiaB = copiar(b);
        int cantA = cantidadElementos(copiaA);
        int cantB = cantidadElementos(copiaB);

        if(cantA != cantB){
            return false;
        }

        while(!copiaA.ColaVacia() && !copiaB.ColaVacia()){
            if(copiaA.Primero() != copiaB.Primero() || copiaA.Prioridad() != copiaB.Prioridad()){
                return false;
            }
            copiaA.Desacolar();
            copiaB.Desacolar();
        }
        return true;
    }

    public static void main(String[] args) {

        ColaPTDA cola = new ColaPTF2();
        cola.InicializarCola();
        System.out.println("Cola con prioridad A");
        cola.Acolar(10, 16);
        cola.Acolar(2, 6);
        cola.Acolar(15, 2);
        cola.Acolar(4, 7);
        cola.Acolar(19, 12);
        cola.Mostrar();
        //mostrarColaP(cola);
        cola.Desacolar();
        System.out.println("Cola despues de desacolar");
        cola.Mostrar();
        //mostrarColaP(cola);
        // A combinar con B.

        /*
        System.out.println("Cola con prioridad B");
        ColaPTDA cola2 = new ColaPTF();
        cola2.InicializarCola();
        cola2.Acolar(1, 6);
        cola2.Acolar(3, 9);
        cola2.Acolar(5, 1);
        cola2.Acolar(7, 4);
        cola2.Acolar(9, 8);
        cola2.Acolar(11, 12);
        mostrarColaP(cola2);
        System.out.println("Cola combinada");
        ColaPTDA cola3 = combinar(cola, cola2);
        mostrarColaP(cola3);
        */
        // B son identicas?

        /*
        ColaPTDA cola2 = new ColaPTF();
        cola2.InicializarCola();
        cola2.Acolar(10, 16);
        cola2.Acolar(2, 6);
        cola2.Acolar(15, 2);
        cola2.Acolar(4, 7);
        cola2.Acolar(19, 12);
        mostrarColaP(cola2);
        boolean iguales = identicas(cola, cola2);
        System.out.println("Colas iguales: " + iguales);
        */


    }


}