package modelo1;
import api.*;
import imp.*;
public class prin {
    public static void mostrarGrafo(iGrafoTDA G) {
        iConjuntoTDA o = G.Vertices();
        iConjuntoTDA d;
        int origen;
        int destino;
        int peso;
        while(!o.ConjuntoVacio()) {
            origen = o.Elegir();
            o.Sacar(origen);
            System.out.print("Nodo origen: " + origen);
            d = G.Vertices();
            while(!d.ConjuntoVacio()) {
                destino = d.Elegir();
                d.Sacar(destino);
                if(G.ExisteArista(origen, destino)) {
                    peso = G.PesoArista(origen, destino);
                    System.out.print("(nodo destino: " + destino + ", peso: " + peso+") ");
                }
            }
            System.out.println();
        }
    }

    public static void mostrar(iConjuntoTDA x) {
        while(!x.ConjuntoVacio()) {
            int u = x.Elegir();
            x.Sacar(u);
            System.out.println(u);
        }
    }

    public static Boolean existeCamino(iGrafoTDA G,int v1, int v2) {
        iConjuntoTDA visitados = new ConjuntoLD();
        visitados.InicializarConjunto();
        return  camino(G, v1, v2, visitados);
    }


    private static boolean camino(iGrafoTDA G, int actual, int destino, iConjuntoTDA visitados){
        if(actual == destino){
            return true;
        }
        visitados.Agregar(actual);
        iConjuntoTDA ady = G.Vertices();
        while (!ady.ConjuntoVacio()){
            int adyacente = ady.Elegir();
            ady.Sacar(adyacente);
            if(!visitados.Pertenece(adyacente) && G.ExisteArista(actual, adyacente)){
                if(camino(G, adyacente, destino, visitados)){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        iGrafoTDA G = new GrafoMA();
        G.InicializarGrafo();
        for (int i= 0; i <10; i++){
            G.AgregarVertice(i);
        }
        G.AgregarArista(0,1,1);
        G.AgregarArista(0,4,1);
        G.AgregarArista(1,3,1);
        G.AgregarArista(2,1,1);
        G.AgregarArista(2,6,1);
        G.AgregarArista(3,2,1);
        G.AgregarArista(5,9,1);
        G.AgregarArista(5,4,1);
        G.AgregarArista(6,0,1);
        G.AgregarArista(6,1,1);
        G.AgregarArista(6,4,1);
        G.AgregarArista(6,5,1);
        G.AgregarArista(7,8,1);
        G.AgregarArista(7,9,1);
        G.AgregarArista(7,6,1);
        G.AgregarArista(8,3,1);
        G.AgregarArista(8,2,1);
        G.AgregarArista(8,6,1);
        G.AgregarArista(9,6,1);

        mostrarGrafo(G);
        System.out.println("Existe camino de 8 a 0: " + existeCamino(G,8,0));


    }
}
