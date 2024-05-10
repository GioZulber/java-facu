package modelo2;

import modelo2.api.ColaLimitadaTDA;
import modelo2.imp.ColaLimitada;

public class prinCOLA {


    public static ColaLimitada copiarCola(ColaLimitadaTDA A){
        ColaLimitada B = new ColaLimitada();
        B.InicializarCola(10);
        while (!A.ColaVacia()){
            B.Acolar(A.Primero());
            A.Desacolar();
        }
        return B;
    }
    public static void mostrarCola(ColaLimitadaTDA A){
        ColaLimitada B = copiarCola(A);
        while (!B.ColaVacia()){
            System.out.println("Primero: " +B.Primero());
            B.Desacolar();
        }
    }

    public static void main(String[] args) {
        ColaLimitadaTDA A = new ColaLimitada();
        int x = 5;
        A.InicializarCola(x);
        while (!A.ColaLlena()){
            System.out.println("Acolar " + x + ": " + A.Acolar(x));
            x--;
        }
        boolean res = A.Acolar(6);
        System.out.println("Acolar 6: " + res);
        mostrarCola(A);

    }
}
