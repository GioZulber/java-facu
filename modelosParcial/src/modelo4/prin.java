package modelo4;

import api.ConjuntoTDA;
import api.DicSimpleTDA;
import modelo4.imp.DicSimple;

public class prin {

    public static DicSimpleTDA combinar(DicSimpleTDA A, DicSimpleTDA B){
        DicSimpleTDA C = new DicSimple();
        C.InicializarDiccionario();
        ConjuntoTDA clavesA = A.Claves();
        ConjuntoTDA clavesB = B.Claves();
        int clave;
        while(!clavesA.ConjuntoVacio() && !clavesB.ConjuntoVacio()){
            if(clavesA.Elegir() == clavesB.Elegir()){
                clave = clavesA.Elegir();
                int valA = A.Recuperar(clave);
                int valB = B.Recuperar(clave);
                if(valA < valB)
                    C.Agregar(clave, valA);
                else
                    C.Agregar(clave, valB);
                clavesA.Sacar(clave);
                clavesB.Sacar(clave);
            }else{
                clave = clavesA.Elegir();
                C.Agregar(clave, A.Recuperar(clavesA.Elegir()));
                clavesA.Sacar(clave);

                clave = clavesB.Elegir();
                C.Agregar(clave, B.Recuperar(clavesB.Elegir()));
                clavesB.Sacar(clave);

            }
        }
        return C;
    }

    public static void mostrarDiccionario(DicSimpleTDA A){
        ConjuntoTDA claves = A.Claves();
        int clave;
        while (!claves.ConjuntoVacio()){
            clave = claves.Elegir();
            claves.Sacar(clave);
            System.out.println(clave + ": { "+ A.Recuperar(clave) + " }" );
        }
    }



    public static void main(String[] args) {
        DicSimpleTDA dic1 = new DicSimple();
        dic1.InicializarDiccionario();
        dic1.Agregar(3, 3);
        dic1.Agregar(2, 8);
        dic1.Agregar(4, 7);
        mostrarDiccionario(dic1);
        DicSimpleTDA dic2 = new DicSimple();
        dic2.InicializarDiccionario();
        dic2.Agregar(3, 3);
        dic2.Agregar(1,5);
        dic2.Agregar(7, 9);
        dic2.Agregar(2,9);
        mostrarDiccionario(dic2);
        DicSimpleTDA D = combinar(dic1, dic2);
        System.out.println("Diccionario combinado: ");
        mostrarDiccionario(D);
    }
}
