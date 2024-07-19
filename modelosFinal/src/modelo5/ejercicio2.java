package modelo5;

import api.*;
import imp.*;

public class ejercicio2 {


    public static void mostrarDiccionario(DiccionarioMultipleTDA A){
        iConjuntoTDA claves = A.Claves();
        int clave;
        while(!claves.ConjuntoVacio()){
            clave = claves.Elegir();
            claves.Sacar(clave);
            System.out.print(clave + ": ");
            iConjuntoTDA valores = A.Recuperar(clave);
            mostrarConjunto(valores);
        }
    }

    public static void mostrarConjunto(iConjuntoTDA A){
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


    public static iConjuntoTDA adyacentes(iGrafoTDA G, int v){
        iConjuntoTDA aux = G.Vertices();
        iConjuntoTDA adyacentes = new ConjuntoLD();
        adyacentes.InicializarConjunto();
        int w;
        while(!aux.ConjuntoVacio()){
            w = aux.Elegir();
            aux.Sacar(w);
            if(G.ExisteArista(v, w)){
                adyacentes.Agregar(w);
            }
        }
        return adyacentes;
    }

    public static DiccionarioMultipleTDA deGrafoADiccionario(iGrafoTDA G){
        DiccionarioMultipleTDA dicc = new DicMultipleL();
        dicc.InicializarDiccionario();
        iConjuntoTDA vertices = G.Vertices();
        while (!vertices.ConjuntoVacio()){
            int v = vertices.Elegir();
            vertices.Sacar(v);
            iConjuntoTDA adyacentes = adyacentes(G, v);

            if (adyacentes.ConjuntoVacio()){
                dicc.Agregar(v, 0);
            }
            else{
                while (!adyacentes.ConjuntoVacio()){
                    int w = adyacentes.Elegir();
                    adyacentes.Sacar(w);
                    dicc.Agregar(v, w);
                }
            }

        }

        return dicc;
    }

    public static void main(String[] args) {
            iGrafoTDA grafo = new GrafoMA();
            grafo.InicializarGrafo();
            for (int i = 1; i <= 3; i++) {
                grafo.AgregarVertice(i);
            }

            grafo.AgregarArista(1, 2, 7);
            grafo.AgregarArista(1, 3, 5);
            grafo.AgregarArista(2, 3, 3);

            DiccionarioMultipleTDA dicc = deGrafoADiccionario(grafo);
            mostrarDiccionario(dicc);



    }
}
