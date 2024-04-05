import api.PilaTDA;
import imp.PilaTF;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static PilaTDA copyPila(PilaTDA A){
        PilaTDA Aux = new PilaTF();
        PilaTDA Copy = new PilaTF();
        Aux.InicializarPila();
        Copy.InicializarPila();

        while(!A.PilaVacia()){
            Aux.Apilar(A.Tope());
            A.Desapilar();
        }
        while (!Aux.PilaVacia()){
            A.Apilar(Aux.Tope());
            Copy.Apilar(Aux.Tope());
            Aux.Desapilar();
        }
        return  Copy;
    }

    public static void showPila(PilaTDA A){
        PilaTDA copy = copyPila(A);
        while(!copy.PilaVacia()){
            System.out.print(copy.Tope());
            copy.Desapilar();
            if(!copy.PilaVacia())
                System.out.print(", ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        PilaTDA pila1 = new PilaTF();
        pila1.InicializarPila();
        pila1.Apilar(5);
        pila1.Apilar(4);
        pila1.Apilar(3);
        pila1.Apilar(2);
        pila1.Apilar(1);
        showPila(pila1);
        showPila(pila1);

    }

}