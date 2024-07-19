package modelo3;

import api.*;
import imp.*;

public class prin {

    public static boolean topologicamenteOrdenado(iGrafoTDA G) {
        iConjuntoTDA Vertices = G.Vertices();
        iConjuntoTDA aux;
        int v;
        int w;
        while(!Vertices.ConjuntoVacio()){
            v = Vertices.Elegir();
            Vertices.Sacar(v);
            aux = G.Vertices();
            aux.Sacar(v);
            while(!aux.ConjuntoVacio()){
                w = aux.Elegir();
                aux.Sacar(w);
                if(G.ExisteArista(w,v) && w > v){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        iGrafoTDA A = new GrafoMA();
        A.InicializarGrafo();
        for(int i = 1; i <7; i++){
            A.AgregarVertice(i);
        }
        A.AgregarArista(1,2,1);
        A.AgregarArista(1,3,1);
        A.AgregarArista(2,3,1);
        A.AgregarArista(2,5,1);
        A.AgregarArista(3,4,1);
        A.AgregarArista(3,6,1);
        A.AgregarArista(4,5,1);
        A.AgregarArista(5,6,1);

        iGrafoTDA B = new GrafoMA();
        B.InicializarGrafo();
        for(int i = 1; i <5; i++){
            B.AgregarVertice(i);
        }
        B.AgregarArista(1,2,1);
        B.AgregarArista(1,4,1);
        B.AgregarArista(2,3,1);
        B.AgregarArista(2,4,1);
        B.AgregarArista(3,4,1);
        B.AgregarArista(3,2,1);




        System.out.println(topologicamenteOrdenado(A));
        System.out.println(topologicamenteOrdenado(B));


    }
}
