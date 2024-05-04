import api.ColaTDA;
import imp.ColaTFE;

public class Main {

    public static void pasarCola(ColaTDA origen, ColaTDA destino) {
        while (!origen.ColaVacia()) {
            destino.Acolar(origen.Primero());
            origen.Desacolar();
        }
    }

    public static void showCola(ColaTDA origen) {
        System.out.print("[");
        while (!origen.ColaVacia()) {
            System.out.print(origen.Primero());

            origen.Desacolar();
            if (!origen.ColaVacia()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ColaTDA A = new ColaTFE();
        A.InicializarCola();
        A.Acolar(1);
        A.Acolar(2);
        A.Acolar(3);
        A.Acolar(4);
        A.Acolar(5);
        A.Acolar(6);
        ColaTDA B = new ColaTFE();
        B.InicializarCola();
        pasarCola(A, B);
        showCola(B);
        showCola(A);



    }


}