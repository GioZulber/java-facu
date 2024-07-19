package prin;

import api.iConjuntoTDA;
import api.iGrafoTDA;
import imp.ConjuntoLD;
import imp.GrafoMA;

public class Main {

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

    // ´Punto 4
    public static iConjuntoTDA AdyacentesDobles(iGrafoTDA G, int v){
        iConjuntoTDA aux = G.Vertices();
        iConjuntoTDA aux2;
        iConjuntoTDA Adyacentes = new ConjuntoLD();
        Adyacentes.InicializarConjunto();
        int w;
        int x;
        while(!aux.ConjuntoVacio()){
            w = aux.Elegir();
            aux.Sacar(w);
            aux2 = G.Vertices();
            aux2.Sacar(v);
            if(G.ExisteArista(v,w)){
                while (!aux2.ConjuntoVacio()){
                    x = aux2.Elegir();
                    aux2.Sacar(x);
                    if(G.ExisteArista(w,x) && w !=x){
                        Adyacentes.Agregar(x);
                    }
                }
            }
        }


        return Adyacentes;
    }


    // Punto 5
    public static int MayorPeso(iGrafoTDA G,int v){
        iConjuntoTDA Vertices = G.Vertices();
        int mayorPeso = 0;
        while(!Vertices.ConjuntoVacio()){
            int w = Vertices.Elegir();
            Vertices.Sacar(w);
            if(G.ExisteArista(v,w)){
                int peso = G.PesoArista(v,w);
                if(peso > mayorPeso){
                    mayorPeso = peso;
                }
            }
        }
        return mayorPeso;
    }

    // Punto 6
    public static iConjuntoTDA Predecesores(iGrafoTDA G, int v){
        iConjuntoTDA Vertices = G.Vertices();
        iConjuntoTDA Predecesores = new ConjuntoLD();
        Predecesores.InicializarConjunto();
        while(!Vertices.ConjuntoVacio()){
            int w = Vertices.Elegir();
            Vertices.Sacar(w);
            if(G.ExisteArista(w,v)){
                Predecesores.Agregar(w);
            }
        }
        return Predecesores;
    }

    // Punto 7
    public static iConjuntoTDA VerticesAislados(iGrafoTDA G){
        iConjuntoTDA aux1 = G.Vertices();
        iConjuntoTDA aux2;
        iConjuntoTDA Aislados = new ConjuntoLD();
        Aislados.InicializarConjunto();
        int v;
        int w;
        boolean EsAislado;
        while (!aux1.ConjuntoVacio()){
            aux2 = G.Vertices();
            v= aux1.Elegir();
            aux1.Sacar(v);
            EsAislado = true;
            while(EsAislado && !aux2.ConjuntoVacio()){
                w = aux2.Elegir();
                aux2.Sacar(w);
                if(( G.ExisteArista(v,w) || G.ExisteArista(w,v))){
                    EsAislado = false;
                }
            }
            if(EsAislado) {
                Aislados.Agregar(v);
            }
        }
        return Aislados;
    }

    // PUNTO 8
    public static iConjuntoTDA VerticesPuente(iGrafoTDA G, int v1, int v2){
        iConjuntoTDA Vertices = G.Vertices();
        iConjuntoTDA VerticesPuente = new ConjuntoLD();
        VerticesPuente.InicializarConjunto();

        while (!Vertices.ConjuntoVacio()){
            int w = Vertices.Elegir();
            Vertices.Sacar(w);
            if(G.ExisteArista(v1,w) && G.ExisteArista(w,v2)){
                VerticesPuente.Agregar(w);
            }
        }
        return VerticesPuente;
    }

    // PUNTO 9
    public static int CalcularGrado(iGrafoTDA G, int v){
        iConjuntoTDA Vertices = G.Vertices();
        int grado = 0;
        int w;
        while(!Vertices.ConjuntoVacio()){
            w = Vertices.Elegir();
            Vertices.Sacar(w);
            if(G.ExisteArista(v,w)){
                grado++;
            }
            if(G.ExisteArista(w,v)){
                grado--;
            }
        }
        return grado;
    }

    public static void main(String[] args) {
        iGrafoTDA G = new GrafoMA();
        G.InicializarGrafo();
        G.AgregarVertice(1);
        G.AgregarVertice(2);
        //G.AgregarVertice(99);
        G.AgregarVertice(3);
        G.AgregarVertice(4);
        G.AgregarVertice(5);
        G.AgregarArista(1, 2, 2);
        G.AgregarArista(1, 3, 4);
        G.AgregarArista(2, 1, 3);
        G.AgregarArista(2, 4, 1);
        G.AgregarArista(3, 4, 2);
        G.AgregarArista(4, 1, 5);
        G.AgregarArista(4, 2, 3);
        //G.AgregarArista(1, 99, 9);
        //G.AgregarArista(2, 99, 11);
        //G.AgregarArista(99, 1, 22);
        //G.AgregarArista(99, 3, 7);
        //G.AgregarArista(99, 4, 18);
        mostrarGrafo(G);
        System.out.println("Adyacentes Dobles de 1");
        iConjuntoTDA c = AdyacentesDobles(G, 1);
        mostrar(c);
        System.out.println("Mayor Peso de 1");
        System.out.println(MayorPeso(G, 1));
        System.out.println("Predecesores de 1");
        iConjuntoTDA p = Predecesores(G, 1);
        mostrar(p);
        System.out.println("Vertices Aislados");
        iConjuntoTDA a = VerticesAislados(G);
        mostrar(a);
        System.out.println("Vertices Puente");
        iConjuntoTDA vp = VerticesPuente(G, 1, 4);
        mostrar(vp);
        System.out.println("Grado de 1");
        System.out.println(CalcularGrado(G, 3));
        //G.EliminarVertice(99);
        //mostrarGrafo(G);
        // int[] A = {1, 2, 3, 4};
        //System.out.println(HamiltonianCycle(G,A));
    }
}