import api.iHeapObjTDA;
import imp.ColaPrioridadMax;
import api.iColaPrioridadTDA;
import api.iHeapTDA;
import imp.ColaPrioridadMin;
import imp.MaxHeap;
import imp.MinHeap;

public class Main {

    public static void mostrarHeap(iHeapObjTDA x) {
        System.out.println(x.primero());
    }


    public static iColaPrioridadTDA copiar(iColaPrioridadTDA x){
        iColaPrioridadTDA copia = new ColaPrioridadMax(x.cantidad());
        iColaPrioridadTDA aux = new ColaPrioridadMax(x.cantidad());

        int valor;
        int prioridad;
        while(!x.colaVacia()){
            valor = x.primero();
            prioridad = x.prioridad();
            copia.acolar(valor, prioridad);
            aux.acolar(valor, prioridad);
            x.desacolar();
        }
        while(!aux.colaVacia()){
            valor = aux.primero();
            prioridad = aux.prioridad();
            x.acolar(valor, prioridad);
            aux.desacolar();
        }

        return copia;
    }
    public static void mostrarColaP(iColaPrioridadTDA x){
        iColaPrioridadTDA copia = copiar(x);
        while(!copia.colaVacia()){
            System.out.println("Valor: " + copia.primero() + ", Prioridad: " + copia.prioridad());
            copia.desacolar();
        }
    }

    public static void ordenar(int[] arr){
        iHeapTDA heap = new MinHeap(arr.length);
        for (int i = 0; i < arr.length; i++) {
            heap.agregar(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.primero();
            heap.eliminar();
        }
    }

    public static void mostrarArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {


        iColaPrioridadTDA colaP = new ColaPrioridadMax(10);

        colaP.acolar(1, 10);
        colaP.acolar(2, 20);
        colaP.acolar(3, 30);
        colaP.acolar(4, 40);
        colaP.acolar(2, 50);
        colaP.acolar(5, 60);
        colaP.acolar(6, 70);

        mostrarColaP(colaP);
        colaP.desacolar();
        System.out.println("Desacolando...");
        mostrarColaP(colaP);



        // Metodo de ordenamiento
        int[] arr = new int[7];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println("Array sin ordenar:");
        mostrarArray(arr);
        System.out.println();
        ordenar(arr);
        System.out.println("Array ordenado:");
        mostrarArray(arr);

    }
}