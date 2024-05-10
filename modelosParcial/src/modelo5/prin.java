package modelo5;

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import modelo2.imp.ConjuntosLD;
import modelo5.imp.DicMultipleDinamico;

public class prin {


    public static DiccionarioMultipleTDA combinarIguales(DiccionarioMultipleTDA A, DiccionarioMultipleTDA B){
        ConjuntoTDA clavesA = A.Claves();
        DiccionarioMultipleTDA res = new DicMultipleDinamico();
        res.InicializarDiccionario();
        while(!clavesA.ConjuntoVacio()) {
            int clave = clavesA.Elegir(); // elegimos una clave
            clavesA.Sacar(clave); // la sacamos del conjunto
            ConjuntoTDA valoresA = A.Recuperar(clave); // recuperamos los valores de la clave
            ConjuntoTDA valoresB = B.Recuperar(clave); // recuperamos los valores de la clave
            ConjuntoTDA valoresRes = new ConjuntosLD(); // conjunto para guardar los valores iguales
            valoresRes.InicializarConjunto();
            while (!valoresA.ConjuntoVacio()) { // mientras haya valores en A
                int valor = valoresA.Elegir(); // elegimos un valor
                valoresA.Sacar(valor); // lo sacamos del conjunto
                if (valoresB.Pertenece(valor)) { // si el valor esta en B
                    valoresRes.Agregar(valor); // lo agregamos al conjunto de valores iguales
                }
            }
            if (!valoresRes.ConjuntoVacio()) { // si hay valores iguales
                while (!valoresRes.ConjuntoVacio()) { // mientras haya valores iguales
                    int valor = valoresRes.Elegir(); // elegimos un valor
                    valoresRes.Sacar(valor);
                    res.Agregar(clave, valor); // lo agregamos al diccionario resultado
                }
            }else{
                System.out.println("No hay valores iguales para la clave " + clave);
            }
        }
        return res;
    }

    public static void mostrarDiccionario(DiccionarioMultipleTDA D){
        ConjuntoTDA claves = D.Claves();
        while(!claves.ConjuntoVacio()){
            int clave = claves.Elegir();
            claves.Sacar(clave);
            ConjuntoTDA valores = D.Recuperar(clave);
            System.out.print(clave + ": ");
            mostrarConjunto(valores);
        }
    }

    public static void mostrarConjunto(ConjuntoTDA C){
        System.out.print("{");
        int num;
        while(!C.ConjuntoVacio()){
            num = C.Elegir();
            System.out.print(num);
            C.Sacar(num);
            if(!C.ConjuntoVacio())
                System.out.print(", ");
        }
        System.out.println("}");
    }


    public static void main(String[] args) {
        DiccionarioMultipleTDA D = new DicMultipleDinamico();
        D.InicializarDiccionario();
        D.Agregar(1, 2);
        D.Agregar(1, 7);
        D.Agregar(1, 9);
        D.Agregar(2, 3);
        D.Agregar(2, 1);
        D.Agregar(2, 5);
        D.Agregar(2, 8);
        D.Agregar(3, 1);
        D.Agregar(3, 9);
        D.Agregar(3, 6);
        D.Agregar(3, 3);
        D.Agregar(4, -3);
        D.Agregar(4, 9);
        D.Agregar(4, 7);
        D.Agregar(4, 3);
        D.Agregar(5, 3);
        D.Agregar(5, 8);
        D.Agregar(5, 6);

        DiccionarioMultipleTDA D2 = new DicMultipleDinamico();
        D2.InicializarDiccionario();
        D2.Agregar(1, 1);
        D2.Agregar(1, 9);
        D2.Agregar(1, 5);
        D2.Agregar(1, 2);
        D2.Agregar(2, 3);
        D2.Agregar(2, 1);
        D2.Agregar(3, 1);
        D2.Agregar(3, 9);
        D2.Agregar(3, 6);
        D2.Agregar(4, 2);
        D2.Agregar(4, 1);
        D2.Agregar(4, 19);
        D2.Agregar(5,8);
        D2.Agregar(5,23);
        D2.Agregar(5,1);

        System.out.println("Diccionario D");
        mostrarDiccionario(D);
        System.out.println("Diccionario D2");
        mostrarDiccionario(D2);
        System.out.println("Diccionario D Combinado");
        DiccionarioMultipleTDA D3 = combinarIguales(D, D2);
        mostrarDiccionario(D3);




    }
}
