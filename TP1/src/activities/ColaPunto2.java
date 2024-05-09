package activities;

import api.ColaTDA;
import imp.ColaTFE;
import imp.ColaTFE2;

public class ColaPunto2 {
    public static ColaTDA pasarCola(ColaTDA origen, ColaTDA destino) {

        while (!origen.ColaVacia()) {
            destino.Acolar(origen.Primero());
            origen.Desacolar();
        }
        return destino;
    }

    public static void invertirCola(ColaTDA origen) {
        ColaTDA aux1 = new ColaTFE2();
        aux1.InicializarCola();
        ColaTDA aux2 = new ColaTFE2();
        aux2.InicializarCola();

        int cont = 0;
        while (!origen.ColaVacia()) {
            aux1.Acolar(origen.Primero());
            origen.Desacolar();
            cont++;
        }

        while (cont > 0) {
            for (int i = 0; i < cont-1; i++) {
                aux2.Acolar(aux1.Primero());
                aux1.Desacolar();
            }
            origen.Acolar(aux1.Primero()); // Guardo el ultimo elemento
            aux1.Desacolar();
            aux1 = aux2;
            cont--;
        }

    }

    public static void invertirCola2(ColaTDA origen) {
        if(origen.ColaVacia()) return;
        int x = origen.Primero();
        origen.Desacolar();
        invertirCola2(origen);
        origen.Acolar(x);
    }

    public static boolean coincideFinal(ColaTDA a, ColaTDA b){
        ColaTDA aux1 = copiar(a);
        ColaTDA aux2 = copiar(b);
        ColaTDA aux3 = copiar(b); // Para no perder los datos de la cola original
        int ultimo = 0;
        while (!aux1.ColaVacia()) {
            ultimo = aux1.Primero();
            aux1.Desacolar();
        }
        int cont2 = contarElementos(aux2);

        while(cont2 > 1){
            aux3.Desacolar();
            cont2--;
        }

        return ultimo == aux3.Primero();
    }

    public static boolean esCapicua(ColaTDA origen){
        ColaTDA aux1 = copiar(origen);
        ColaTDA aux2 = copiar(origen);

        int cont = contarElementos(aux1);

        int[] array = new int[cont];
        int i = 0;
        while (!aux2.ColaVacia()) {
            array[i] = aux2.Primero();
            aux2.Desacolar();
            i++;
        }
        for(int j = 0; j < cont / 2; j++){
            if(array[j] != array[cont - j - 1]){
                return false;
            }
        }
        return true;
    }

    public static  boolean esInversa(ColaTDA a, ColaTDA b){ // 0(n)
        ColaTDA aux1 = copiar(a); // 0(n)
        invertirCola(aux1); // Invierto la cola a
        ColaTDA aux2 = copiar(b);
        int aux1Cont = contarElementos(aux1); // 0(n)
        int aux2Cont = contarElementos(aux2); // 0(n)
        if(aux1Cont != aux2Cont){
            return false;
        }
        while (!aux1.ColaVacia() && !aux2.ColaVacia()) { // 0(n)
            if(aux1.Primero() != aux2.Primero()){
                return false;
            }
            aux1.Desacolar();
            aux2.Desacolar();
        }
        return true;
    }

    public static int contarElementos(ColaTDA origen){
        ColaTDA aux = copiar(origen);
        int cont = 0;
        while (!aux.ColaVacia()) {
            cont++;
            aux.Desacolar();
        }
        return cont;
    }


    public static ColaTDA copiar(ColaTDA origen) {
        ColaTDA aux = new ColaTFE2();
        ColaTDA destino = new ColaTFE2();
        aux.InicializarCola();
        destino.InicializarCola();

        while (!origen.ColaVacia()) {
            aux.Acolar(origen.Primero());
            origen.Desacolar();
        }
        while (!aux.ColaVacia()) {
            origen.Acolar(aux.Primero());
            destino.Acolar(aux.Primero());
            aux.Desacolar();
        }
        return destino;
    }

    public static void showCola(ColaTDA origen) {
        ColaTDA copia = copiar(origen);
        System.out.print("[");
        while (!copia.ColaVacia()) {
            System.out.print(copia.Primero());

            copia.Desacolar();
            if (!copia.ColaVacia()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ColaTDA A = new ColaTFE2();
        A.InicializarCola();
        A.Acolar(1);
        A.Acolar(2);
        A.Acolar(3);
        A.Acolar(4);
        A.Acolar(5);
        showCola(A);
        // A Pasar el contenido de la cola A a la cola B
        /*
        ColaTDA B = new ColaTFE();
        B.InicializarCola();
        ColaTDA res = pasarCola(A, B);
        showCola(res);
        */

        // B Invertir el contenido de la cola A (usando listas aux)
        // invertirCola(A);

        // C Invertir el contenido de la cola A (usando recursividad)
        // invertirCola2(A);
        //showCola(A);


        // D Determinar si el último elemento de la cola A coincide con el último elemento de la cola B
        /*
        ColaTDA B = new ColaTFE();
        B.InicializarCola();
        B.Acolar(2);
        B.Acolar(3);
        B.Acolar(4);
        B.Acolar(5);
        B.Acolar(6);
        boolean res = coincideFinal(A, B);
        System.out.println(res);
        */

        // E es capicua.
        boolean res = esCapicua(A);
        System.out.println(res);

        // F A es la inversa de B
        ColaTDA B = new ColaTFE2();
        B.InicializarCola();
        B.Acolar(5);
        B.Acolar(4);
        B.Acolar(3);
        B.Acolar(2);
        B.Acolar(1);
        showCola(B);
        B.Desacolar();
        B.Desacolar();
        showCola(B);
        /*
        boolean resI = esInversa(A, B);
        System.out.println(resI);
        */
    }
}
