package modelo1.Conjuntos;

import modelo1.Conjuntos.api.M1ConjuntoTDA;
import modelo1.Conjuntos.imp.ConjuntoLD;

public class prin {

    public static M1ConjuntoTDA CopiarConjunto(M1ConjuntoTDA c){
        M1ConjuntoTDA aux = new ConjuntoLD();
        M1ConjuntoTDA c2 = new ConjuntoLD();
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
    public static void mostrarConjunto(M1ConjuntoTDA c){
        M1ConjuntoTDA aux = CopiarConjunto(c);
        System.out.print("{");
        while(!aux.ConjuntoVacio()){
            int x = aux.Elegir();
            System.out.print(x);
            aux.Sacar(x);
            if(!aux.ConjuntoVacio()){
                System.out.print(",");
            }
        }
        if(c.ConjuntoVacio()){
            System.out.print("Conjunto vacio");
        }

        System.out.println("}");
    }

    public static void main(String[] args) {
        M1ConjuntoTDA c1 = new ConjuntoLD();
        M1ConjuntoTDA c2 = new ConjuntoLD();
        c1.InicializarConjunto();
        c2.InicializarConjunto();
        c1.Agregar(1);
        c1.Agregar(2);
        c1.Agregar(3);
        c1.Agregar(10);
        c1.Agregar(11);
        c1.Agregar(12);
        c2.Agregar(1);
        c2.Agregar(2);
        c2.Agregar(3);
        c2.Agregar(11);
        mostrarConjunto(c1);
        mostrarConjunto(c2);

        System.out.println(c1.TodosPertenecen(c2));
        c2.Agregar(4);
        mostrarConjunto(c2);
        System.out.println(c1.TodosPertenecen(c2));
        c1.SacarTodos(c2);
        mostrarConjunto(c1);
        mostrarConjunto(c2);



    }
}
