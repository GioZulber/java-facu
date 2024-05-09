package activities;

import api.ColaPTDA;
import imp.colas.ColaPD;

public class ColaPD2 {
    public static boolean identicas(ColaPTDA a, ColaPTDA b){
        ColaPTDA aux = copiar(a);
        ColaPTDA aux2 = copiar(b);

        int con1 = contarEl(aux);
        int con2 = contarEl(aux2);

        if (con1 != con2) return false;

        while(!aux.ColaVacia()){
            if(aux.Primero() != aux2.Primero() || aux.Prioridad() != aux2.Prioridad() ) return  false;
            aux.Desacolar();
            aux2.Desacolar();
        }
        return true;
    }

    public static ColaPTDA unionColas(ColaPTDA a, ColaPTDA b){
        ColaPTDA auxA = copiar(a);
        ColaPTDA auxB = copiar(b);
        ColaPTDA resFinal = new ColaPD();
        resFinal.InicializarCola();
        int priori = 30;

        while(!auxA.ColaVacia() && !auxB.ColaVacia()){
            if( auxA.Prioridad() >= auxB.Prioridad() ){
                resFinal.Acolar(auxA.Primero(), priori);
                auxA.Desacolar();
                priori--;
            }else{
                resFinal.Acolar(auxB.Primero(), priori);
                priori--;
                auxB.Desacolar();
            }
        }

        if(auxA.ColaVacia()){
            while(!auxB.ColaVacia()){
                resFinal.Acolar(auxB.Primero(), priori);
                auxB.Desacolar();
            }
        }else{
            while(!auxA.ColaVacia()){
                resFinal.Acolar(auxA.Primero(), priori);
                auxA.Desacolar();
            }
        }
        return resFinal;
    }

    public static int contarEl(ColaPTDA a){
        ColaPTDA aux = copiar(a);
        int cont = 0;
        while (!aux.ColaVacia()){
            cont++;
            aux.Desacolar();
        }
        return  cont;
    }

    public static ColaPTDA copiar(ColaPTDA x){
        ColaPTDA aux = new ColaPD();
        ColaPTDA aux2 = new ColaPD();
        aux.InicializarCola();
        aux2.InicializarCola();

        while(!x.ColaVacia()){
            aux.Acolar(x.Primero(), x.Prioridad());
            x.Desacolar();
        }
        while(!aux.ColaVacia()){
            aux2.Acolar(aux.Primero(), aux.Prioridad());
            x.Acolar(aux.Primero(), aux.Prioridad());
            aux.Desacolar();
        }
        return aux2;
    }

    public static void mostrar(ColaPTDA a){
        ColaPTDA aux = copiar(a);
        while(!aux.ColaVacia()){
            System.out.println("Valor: " + aux.Primero() + " Prioridad: " + aux.Prioridad());
            aux.Desacolar();
        }
    }


    public static void main(String[] args) {
        ColaPTDA cola1 = new ColaPD(); // Para usar con arrays
        cola1.InicializarCola();
        cola1.Acolar(9, 1);
        cola1.Acolar(7, 3);
        cola1.Acolar(5, 5);
        cola1.Acolar(3, 7);

        System.out.println("Cola 1");
        mostrar(cola1);


        //ColaPTDA cola2 = new ColaDP(); // Para usar con nodos
        ColaPTDA cola2 = new ColaPD(); // Para usar con arrays
        cola2.InicializarCola();
        cola2.Acolar(9,1);
        cola2.Acolar(7, 3);
        cola2.Acolar(5, 5);
        cola2.Acolar(3, 7);
        System.out.println("Cola 2");
        mostrar(cola2);

        ColaPTDA res = unionColas(cola1,cola2);
        System.out.println("Cola final");
        mostrar(res);
        System.out.println("Son identicas? " + identicas(cola1, cola2));

    }
}
