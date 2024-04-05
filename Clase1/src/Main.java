import ejercicio.Nodo;

import java.lang.reflect.Type;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //Cuarto ejercicio

    public static void showList(Nodo X) {
        System.out.print("<");
        while(X != null) {
            System.out.print(X.getValue());
            if(X.getSig() != null)
                System.out.print(", ");
            X = X.getSig();
        }
        System.out.println(">");
    }
    public static Nodo addLast(Nodo X, int num){
        Nodo nuevo = new Nodo();
        nuevo.setValue(num);
        nuevo.setSig(null);
        if (X != null) {
            X.setSig(nuevo);
        }

        return nuevo;

    }
    public static void main(String[] args) {
        Nodo origen = addLast(null, 1);
        Nodo sig = addLast(origen, 3);
        sig = addLast(sig, 5);
        sig = addLast(sig, 7);
        sig = addLast(sig, 9);

        showList(origen);
    }

    // Tercer ejercicio
    /*
    public static void showList(Nodo X) {
        System.out.print("<");
        while(X != null) {
            System.out.print(X.value);
            if(X.sig != null)
                System.out.print(", ");
            X = X.sig;
        }
        System.out.println(">");
    }
    public static Nodo addOn(Nodo X, int num){
        Nodo nuevo = new Nodo();
        nuevo.value = num;
        nuevo.sig = X;
        return nuevo;
    }
    public static void main(String[] args) {
        Nodo origen = null;
        origen = addOn(origen, 3);
        origen = addOn(origen, 5);
        origen = addOn(origen, 7);
        showList(origen);
    }
    +/



    // Segundo ejercicio
    /*
    public static void showList(Nodo x){

        Nodo nuevo = new Nodo();
        nuevo.value = 3;
        nuevo.sig = x;
        x = nuevo;
        System.out.print("<");
        while(x != null){
            System.out.print(x.value);
            if(x.sig != null){
                System.out.print(",");
            }
            x = x.sig;
        }
        System.out.print(">");


    }


    public static void main(String[] args){
        Nodo A = new Nodo();
        Nodo B = new Nodo();
        A.value = 5;
        A.sig = B;
        B.value = 7;
        B.sig = null;
        showList(A);

    }
    */


    // Primer ejercicio
    /*
    public static void showList(Nodo x){
        System.out.print("<");
        while(x != null){
            System.out.print(x.value);
            if(x.sig != null){
                System.out.print(",");
            }
            x = x.sig;
        }
        System.out.print(">");

    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Nodo A = new Nodo();
        Nodo B = new Nodo();
        Nodo C = new Nodo();
        A.value = 3;
        A.sig = B;
        B.value = 5;
        B.sig = C;
        C.value = 7;
        C.sig = null;
        showList(A);

    }

        */
}