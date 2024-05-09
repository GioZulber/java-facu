package activities;

import api.ColaTDA;
import imp.colas.ColaD;

public class colaD2 {

    public static boolean esInversa(ColaTDA a, ColaTDA b){
        ColaTDA aux = copiar(a);
        ColaTDA aux2 = copiar(b);
        int cont1 = contarEl(aux);
        int cont2 = contarEl(aux2);

        if(cont1 != cont2) return false;

        revertirR(aux2);

        while(!aux.ColaVacia()){
            if(aux.Primero() != aux2.Primero()) return false;
            aux.Desacolar();
            aux2.Desacolar();
        }
        return true;
    }

    public static boolean esCapicua(ColaTDA a){
        ColaTDA aux = copiar(a);
        ColaTDA aux2 = copiar(a);

        int cant = contarEl(aux);

        int[] arr = new int[cant];

        int i = 0;

        while(!aux2.ColaVacia()){
            arr[i] = aux2.Primero();
            aux2.Desacolar();
            i++;
        }

        for(int j = 0; j < cant/2; j++){
            if(arr[j] != arr[cant -j -1]){
                return false;
            }
        }
        return true;
    }

    public static boolean coincidenFinal(ColaTDA a, ColaTDA b){
        ColaTDA aux1 = copiar(a);
        ColaTDA aux2 = copiar(b);
        ColaTDA aux3 = copiar(b);

        int ultimo = 0;

        while (!aux1.ColaVacia()){
            ultimo = aux1.Primero();
            aux1.Desacolar();
        }
        int cont2 = contarEl(aux2);

        while(cont2 > 1){
            aux3.Desacolar();
            cont2--;
        }

        return ultimo == aux3.Primero();
    }

    public static void revertir(ColaTDA x){
        ColaTDA aux = new ColaD();
        ColaTDA aux2 = new ColaD();
        aux.InicializarCola();
        aux2.InicializarCola();

        int cont = 0;
        while(!x.ColaVacia()){
            aux.Acolar(x.Primero());
            x.Desacolar();
            cont++;
        }

        while(cont > 0){
            for(int i = 0; i < cont-1; i++){
                aux2.Acolar(aux.Primero());
                aux.Desacolar();
            }
            x.Acolar(aux.Primero());
            aux.Desacolar();
            aux = aux2;
            cont--;
        };

    }


    public static void revertirR(ColaTDA x){
        if(x.ColaVacia()) return;
        int num = x.Primero();
        x.Desacolar();
        revertirR(x);
        x.Acolar(num);
    }

    public static int contarEl(ColaTDA x){
        ColaTDA aux = copiar(x);
        int cont = 0;
        while (!aux.ColaVacia()){
            cont++;
            aux.Desacolar();
        }
        return cont;
    }


    public static ColaTDA pasar(ColaTDA x){
        ColaTDA aux = copiar(x);
        ColaTDA res = new ColaD();
        while(!aux.ColaVacia()){
            res.Acolar(aux.Primero());
            aux.Desacolar();
        }
        return res;
    }

    public static void mostrar(ColaTDA pila){
        ColaTDA aux = copiar(pila);
        System.out.print("<");
        while(!aux.ColaVacia()){
            System.out.print(aux.Primero());
            aux.Desacolar();
            if(!aux.ColaVacia())
                System.out.print(", ");
        }
        System.out.println(">");
    }
    public static ColaTDA copiar(ColaTDA x){
        ColaTDA aux1 = new ColaD();
        ColaTDA aux2 = new ColaD();
        aux1.InicializarCola();
        aux2.InicializarCola();

        while(!x.ColaVacia()){
            aux1.Acolar(x.Primero());
            x.Desacolar();
        }
        while(!aux1.ColaVacia()){
            aux2.Acolar(aux1.Primero());
            x.Acolar(aux1.Primero());
            aux1.Desacolar();
        }
        return  aux2;
    }

    public static void main(String[] args) {
        ColaTDA cola = new ColaD();
        cola.InicializarCola();
        cola.Acolar(2);
        cola.Acolar(4);
        cola.Acolar(6);
        cola.Acolar(8);
        cola.Acolar(10);
        mostrar(cola);

        ColaTDA cola2 = new ColaD();
        cola2.InicializarCola();
        cola2.Acolar(10);
        cola2.Acolar(8);
        cola2.Acolar(6);
        cola2.Acolar(4);
        cola2.Acolar(2);
        mostrar(cola2);
        System.out.println("El final es el mismo: " + coincidenFinal(cola, cola2));
        System.out.println("ES capicua: " + esCapicua(cola));
        System.out.println("Es la inversa: "+ esInversa(cola, cola2));
        /*
        revertirR(cola);
        mostrar(cola);
        */
    }
}
