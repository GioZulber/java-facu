package modelo2;

import api.ConjuntoTDA;
import modelo2.api.M2DicMultipleTDA;
import modelo2.imp.DicMultipleL;

public class prin {

    public static void mostrarDiccionario(M2DicMultipleTDA A){
        ConjuntoTDA claves = A.Claves();
        int clave;
        while(!claves.ConjuntoVacio()){
            clave = claves.Elegir();
            claves.Sacar(clave);
            System.out.print(clave + ": ");
            ConjuntoTDA valores = A.Recuperar(clave);
            mostrarConjunto(valores);
        }
    }
    public static void mostrarConjunto(ConjuntoTDA A){
        System.out.print("{");
        int num;
        while(!A.ConjuntoVacio()){
            num = A.Elegir();
            System.out.print(num);
            A.Sacar(num);
            if(!A.ConjuntoVacio())
                System.out.print(", ");
        }
        System.out.println("}");
    }


    public static void main(String[] args) {
        M2DicMultipleTDA A = new DicMultipleL();
        A.InicializarDiccionario();
        A.Agregar(4, 5);
        A.Agregar(4, 7);
        A.Agregar(4, -3);
        A.Agregar(9, 6);
        A.Agregar(9, -4);
        A.Agregar(9, -8);
        A.Agregar(9, 7);
        A.Agregar(9, 2);
        A.Agregar(3, 1);
        A.Agregar(3, 2);
        A.Agregar(3, 3);
        A.Agregar(3, 5);
        A.Agregar(3, 7);
        A.Agregar(3, 9);
        A.Agregar(8, 0);
        A.Agregar(8, 2);
        A.Agregar(8, 4);
        A.Agregar(8, 5);
        A.Agregar(8, 9);
        A.Agregar(11, 3);
        A.Agregar(11, 5);
        A.Agregar(11, 9);


        mostrarDiccionario(A);
        ConjuntoTDA teien3 = A.ClaseValor(3);
        System.out.println("Claves que tienen el valor 3: ");
        mostrarConjunto(teien3);
        ConjuntoTDA tiene7 = A.ClaseValor(7);
        System.out.println("Claves que tienen el valor 7: ");
        mostrarConjunto(tiene7);
        ConjuntoTDA tiene9 = A.ClaseValor(9);
        System.out.println("Claves que tienen el valor 9: ");
        mostrarConjunto(tiene9);
        ConjuntoTDA teine10 = A.ClaseValor(10);
        System.out.println("Claves que tienen el valor 10: ");
        mostrarConjunto(teine10);
    }
}
