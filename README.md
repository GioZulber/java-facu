import api.ColaPTDA;
import api.ColaTDA;
import imp.ColaD;
import imp.ColaE;
import priorityQ.ColaDP;
import priorityQ.ColaEP;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // Cola simple con Nodos y arrays
    /*
    public static void main(String[] args) {
        ColaTDA cola = new ColaD(); // Para usar con nodos
        // ColaTDA cola = new ColaE(); // Para usar con arrays
        cola.InicializarCola();
        cola.Acolar(1);
        cola.Acolar(2);
        cola.Acolar(3);
        cola.showCola();
        cola.Desacolar();
        System.out.println(cola.Primero());
        cola.Acolar(6);
        cola.showCola();
    }
    */

    public static ColaPTDA unionColas(ColaPTDA x1, ColaPTDA x2) {
        ColaPTDA resFinal = new ColaEP();
        resFinal.InicializarCola();
        ColaPTDA A = copyCola(x1);
        ColaPTDA B = copyCola(x2);

        int priority = 1;

        while (!A.ColaVacia() && !B.ColaVacia()) {
            if(A.Prioridad() <= B.Prioridad()) {
                resFinal.Acolar(A.Primero(), priority);
                A.Desacolar();
                priority++;
            } else {
                resFinal.Acolar(B.Primero(), priority);
                B.Desacolar();
                priority++;
            }
        }
        if(A.ColaVacia()){
            while(!B.ColaVacia()){
                resFinal.Acolar(B.Primero(), priority);
                B.Desacolar();
                priority++;
            }
        } else if (B.ColaVacia()) {
            while(!A.ColaVacia()){
                resFinal.Acolar(A.Primero(), priority);
                A.Desacolar();
                priority++;
            }
        }


        return resFinal;
    }

    public static ColaPTDA copyCola(ColaPTDA A){
        ColaPTDA Aux = new ColaEP();
        ColaPTDA Copy = new ColaEP();
        Aux.InicializarCola();
        Copy.InicializarCola();

        while(!A.ColaVacia()){
            Aux.Acolar(A.Primero(), A.Prioridad());
            A.Desacolar();
        }
        while (!Aux.ColaVacia()){
            A.Acolar(Aux.Primero(),Aux.Prioridad());
            Copy.Acolar(Aux.Primero(), Aux.Prioridad());
            Aux.Desacolar();
        }
        return  Copy;
    }



    // Cola con prioridad con Nodos y arrays
    public static void main(String[] args) {
        //ColaPTDA cola1 = new ColaDP(); // Para usar con nodos
        ColaPTDA cola1 = new ColaEP(); // Para usar con arrays
        cola1.InicializarCola();
        cola1.Acolar(9, 1);
        cola1.Acolar(7, 3);
        cola1.Acolar(5, 5);
        cola1.Acolar(3, 7);
         cola1.Acolar(6,2);
        cola1.showCola();


        //ColaPTDA cola2 = new ColaDP(); // Para usar con nodos
        ColaPTDA cola2 = new ColaEP(); // Para usar con arrays
        cola2.InicializarCola();
        cola2.Acolar(10, 2);
        cola2.Acolar(9, 3);
        cola2.Acolar(6, 5);
        cola2.Acolar(2, 9);

        cola2.showCola();

        ColaPTDA res = unionColas(cola1,cola2);
        res.showCola();

    }
}
