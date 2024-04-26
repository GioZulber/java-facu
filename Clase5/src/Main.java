import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import imp.ConjuntoLD;
import imp.DicMultipleL;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void mostrarDiccionario(DiccionarioMultipleTDA A){
        ConjuntoTDA claves = A.Claves();
        int clave;
        while(!claves.ConjuntoVacio()){
            clave = claves.Elegir();
            claves.Sacar(clave);
            System.out.print(clave + ": ");
            ConjuntoTDA valores = A.Recuperar(clave);
            mostrarConjunto(valores);
        }
    }

    public static void mostrarConjunto(ConjuntoTDA A){
        System.out.print("{");
        int num;
        while(!A.ConjuntoVacio()){
            num = A.Elegir();
            System.out.print(num);
            A.Sacar(num);
            if(!A.ConjuntoVacio())
                System.out.print(", ");
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        /*
        ConjuntoTDA A = new ConjuntoLD();
        A.InicializarConjunto();
        A.Agregar(1);
        A.Agregar(2);
        A.Agregar(3);
        A.Agregar(4);
        A.Agregar(5);
        mostrarConjunto(A);

        A.Agregar(1);
        A.Agregar(15);
        System.out.println(A.Pertenece(1));
        mostrarConjunto(A);

         */

        DiccionarioMultipleTDA B = new DicMultipleL();
        B.InicializarDiccionario();
        B.Agregar(7, 1);
        B.Agregar(3, 3);
        B.Agregar(9, -2);
        B.Agregar(1, 2);
        B.Agregar(7, 0);
        B.Agregar(1, 4);
        B.Agregar(9, 2);
        B.Agregar(9, 0);
        mostrarDiccionario(B);
        B.EliminarValor(3, 3);
        mostrarDiccionario(B);


    }

}