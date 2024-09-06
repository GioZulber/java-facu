package modelo5;
import api.*;
import imp.*;
public class prin {


    public static void preOrder(ABBTDA arbol){
        if(!arbol.ArbolVacio()){
            System.out.println(arbol.Raiz());
            preOrder(arbol.HijoIzq());
            preOrder(arbol.HijoDer());
        }
    }
    public  static  void inOrder(ABBTDA arbol){
        if(!arbol.ArbolVacio()){
            inOrder(arbol.HijoIzq());
            System.out.println(arbol.Raiz());
            inOrder(arbol.HijoDer());
        }
    }
    public static void postOrder(ABBTDA arbol){
        if(!arbol.ArbolVacio()){
            postOrder(arbol.HijoIzq());
            postOrder(arbol.HijoDer());
            System.out.println(arbol.Raiz());
        }
    }

    public static iConjuntoTDA ordenadosMenorAMayor(ABBTDA arbol){
        iConjuntoTDA c = new ConjuntoLD();
        c.InicializarConjunto();
        ordenadosMenorAMayor1(arbol, c);
        return c;
    }
    private static void ordenadosMenorAMayor1(ABBTDA arbol, iConjuntoTDA c){
        if(!arbol.ArbolVacio()){
            ordenadosMenorAMayor1(arbol.HijoDer(),c);
            c.Agregar(arbol.Raiz());
            ordenadosMenorAMayor1(arbol.HijoIzq(),c);
        }
    }

    public static void mostrar(iConjuntoTDA x) {
        while(!x.ConjuntoVacio()) {
            int u = x.Elegir();
            x.Sacar(u );
            System.out.print(u + " ");
        }
    }

    public static int altura(ABBTDA arbol){
        if(arbol.ArbolVacio()) return 0;
        else return  1 + Math.max(altura(arbol.HijoIzq()), altura(arbol.HijoDer()));

    }

    public static int sumarElsHojas(ABBTDA arbol ){
        if(arbol.ArbolVacio()) return 0;
        else if (arbol.HijoIzq().ArbolVacio() && arbol.HijoDer().ArbolVacio()) return  arbol.Raiz()  ;
        else return sumarElsHojas(arbol.HijoIzq())+ sumarElsHojas(arbol.HijoDer());
    }
    public static void main(String[] args) {
        ABBTDA arbol = new ABB();
        arbol.InicializarArbol();
        arbol.AgregarElem(4);
        arbol.AgregarElem(2);
        arbol.AgregarElem(1);
        arbol.AgregarElem(3);
        arbol.AgregarElem(5);



        System.out.println("In order");
        inOrder(arbol);

        System.out.println("Ordenados de menor a mayor");
        iConjuntoTDA c = ordenadosMenorAMayor(arbol);
        mostrar(c);
        System.out.println();
        System.out.println("Altura del arbol: " + altura(arbol));
        System.out.println("Suma de las hojas: " + sumarElsHojas(arbol));





    }




}
