import api.ColaPTDA;
import imp.ColaP;

public class Main {


    public static ColaPTDA copiar(ColaPTDA x){
        ColaPTDA copia = new ColaP();
        ColaPTDA aux = new ColaP();
        copia.InicializarColaPrioridad();
        aux.InicializarColaPrioridad();
        int valor;
        int prioridad;
        while(!x.ColaVacia()){
            valor = x.Primero();
            prioridad = x.Prioridad();
            copia.AcolarPrioridad(valor, prioridad);
            aux.AcolarPrioridad(valor, prioridad);
            x.Desacolar();
        }
        while(!aux.ColaVacia()){
            valor = aux.Primero();
            prioridad = aux.Prioridad();
            x.AcolarPrioridad(valor, prioridad);
            aux.Desacolar();
        }

        return copia;
    }
    public static void mostrarColaP(ColaPTDA x){
        ColaPTDA copia = copiar(x);
        while(!copia.ColaVacia()){
            System.out.println("Valor: " + copia.Primero() + ", Prioridad: " + copia.Prioridad());
            copia.Desacolar();
        }
    }

    public static ColaPTDA combinar(ColaPTDA A, ColaPTDA B){
        int prioridadActual = 20;
        ColaPTDA resFinal = new ColaP();
        resFinal.InicializarColaPrioridad();
        while(!A.ColaVacia() && !B.ColaVacia()){
            if(B.Prioridad() > A.Prioridad()){
                resFinal.AcolarPrioridad(B.Primero(), prioridadActual);
                B.Desacolar();
            }else{
                resFinal.AcolarPrioridad(A.Primero(), prioridadActual);
                A.Desacolar();
            }
            prioridadActual--;
        }
        if(A.ColaVacia()){
            while(!B.ColaVacia()){
                resFinal.AcolarPrioridad(B.Primero(), prioridadActual);
                B.Desacolar();
                prioridadActual--;
            }
        }else{
            while(!A.ColaVacia()){
                resFinal.AcolarPrioridad(A.Primero(), prioridadActual);
                A.Desacolar();
                prioridadActual--;
            }
        }
        return resFinal;
    }


    public static void main(String[] args) {
        ColaPTDA A = new ColaP();
        ColaPTDA B = new ColaP();
        A.InicializarColaPrioridad();
        B.InicializarColaPrioridad();
        A.AcolarPrioridad(9, 7);
        A.AcolarPrioridad(1, 0);
        A.AcolarPrioridad(3, 1);
        A.AcolarPrioridad(7, 5);
        A.AcolarPrioridad(5, 3);
        B.AcolarPrioridad(6, 3);
        B.AcolarPrioridad(2, 0);
        B.AcolarPrioridad(10, 6);
        B.AcolarPrioridad(9, 5);
        System.out.println("Cola A");
        mostrarColaP(A);
        System.out.println("Cola B");
        mostrarColaP(B);
        ColaPTDA C = combinar(A, B);
        System.out.println("Cola C");
        mostrarColaP(C);

    }
}