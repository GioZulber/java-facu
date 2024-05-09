package activities;

import api.PilaTDA;
import imp.pila.PilaD;

public class pila1D {
    public static int promedio(PilaTDA x){
        return sumarElementos(x) / contarElementos(x);
    }

    public static int sumarElementos(PilaTDA x){
        PilaTDA aux = copiar(x);
        int sum = 0;
        while(!aux.PilaVacia()){
            sum += aux.Tope();
            aux.Desapilar();
        }
        return sum;
    }

    public static int contarElementos(PilaTDA x){
        PilaTDA aux = copiar(x);
        int cont = 0;
        while(!aux.PilaVacia()){
            aux.Desapilar();
            cont++;
        }
        return cont;
    }

    public static PilaTDA pasarPila(PilaTDA x){
        PilaTDA aux = copiar(x);
        PilaTDA res = new PilaD();
        res.InicializarPila();

        while(!aux.PilaVacia()){
            res.Apilar(aux.Tope());
            aux.Desapilar();
        }
        return  res;
    }


    public static void mostrar(PilaTDA pila){
        PilaTDA aux = copiar(pila);
        System.out.print("<");
        while(!aux.PilaVacia()){
            System.out.print(aux.Tope());
            aux.Desapilar();
            if(!aux.PilaVacia())
                System.out.print(", ");
        }
        System.out.println(">");
    }
    public static PilaTDA copiar(PilaTDA x){
        PilaTDA aux1 = new PilaD();
        PilaTDA aux2 = new PilaD();
        aux1.InicializarPila();
        aux2.InicializarPila();

        while(!x.PilaVacia()){
            aux1.Apilar(x.Tope());
            x.Desapilar();
        }
        while(!aux1.PilaVacia()){
            aux2.Apilar(aux1.Tope());
            x.Apilar(aux1.Tope());
            aux1.Desapilar();
        }
        return  aux2;
    }

    public static void main(String[] args) {
        PilaTDA pila1 = new PilaD();
        pila1.InicializarPila();
        pila1.Apilar(2);
        pila1.Apilar(4);
        pila1.Apilar(6);
        pila1.Apilar(8);
        pila1.Apilar(10);
        System.out.println("Pila og: ");
        mostrar(pila1);
        PilaTDA res = pasarPila(pila1);
        System.out.println("Pila invertida: ");
        mostrar(res);
        System.out.println("Cant elementos: " + contarElementos(pila1));
        System.out.println("Suma de elementos: " + sumarElementos(pila1));
        System.out.println("Promedio: " + promedio(pila1));






    }
}
