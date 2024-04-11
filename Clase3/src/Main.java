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

    // Cola con prioridad con Nodos y arrays
    public static void main(String[] args) {
        //ColaPTDA colaPrioridad = new ColaDP(); // Para usar con nodos
        ColaPTDA colaPrioridad = new ColaEP(); // Para usar con arrays
        colaPrioridad.InicializarCola();
        colaPrioridad.Acolar(5, 2);
        colaPrioridad.Acolar(2, 4);
        colaPrioridad.Acolar(14, 1);
        colaPrioridad.Acolar(3, 3);
        colaPrioridad.showCola();
        System.out.println("El primero en la fila: " + colaPrioridad.Primero());
        System.out.println("Con una prioridad: " + colaPrioridad.Prioridad());
        colaPrioridad.Desacolar();
        colaPrioridad.Acolar(6,2);
        colaPrioridad.Acolar(7, 3);
        colaPrioridad.Acolar(8, 4);
        colaPrioridad.Acolar(9, 5);
        System.out.println("El primero en la fila: " + colaPrioridad.Primero());
        System.out.println("Con una prioridad: " + colaPrioridad.Prioridad());
        colaPrioridad.showCola();
    }
}