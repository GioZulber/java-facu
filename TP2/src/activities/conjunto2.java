package activities;

import api.ConjuntoTDA;
import imp.conjuntos.ConjuntoAcotado;

public class conjunto2 {
    public static ConjuntoTDA copiar(ConjuntoTDA og){
        ConjuntoTDA copia = new ConjuntoAcotado();
        ConjuntoTDA aux = new ConjuntoAcotado();
        copia.InicializarConjunto();
        aux.InicializarConjunto();

        while(!og.ConjuntoVacio()){
            int el = og.Elegir();
            aux.Agregar(el);
            copia.Agregar(el);
            og.Sacar(el);
        }
        while (!aux.ConjuntoVacio()){
            int el = aux.Elegir();
            og.Agregar(el);
            aux.Sacar(el);
        }
        return copia;
    }

    public static void mostrar(ConjuntoTDA a){
        System.out.print("{");

        while (!a.ConjuntoVacio()){
            int el = a.Elegir();
            System.out.print(el);
            a.Sacar(el);

            if(!a.ConjuntoVacio()){
                System.out.print(", ");
            }
        }
        System.out.println("}\n");
    }

    public static void main(String[] args) {
        ConjuntoTDA A = new ConjuntoAcotado();
        ConjuntoTDA B = new ConjuntoAcotado();

        A.InicializarConjunto(10);
        A.Agregar(6);
        A.Agregar(2);
        A.Agregar(4);
        A.Agregar(8);
        mostrar(A);


    }
}
