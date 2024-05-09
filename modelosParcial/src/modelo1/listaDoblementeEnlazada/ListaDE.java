package modelo1.listaDoblementeEnlazada;

public class ListaDE {
    Nodo cabeza;

    Nodo cola;

    public void Agregar(int x){ // Costo constante O(1)
        if(ListaVacia()){
            Nodo nuevo = new Nodo();
            nuevo.setValue(x);
            nuevo.setPrev(null);
            nuevo.setSig(null);
            cabeza = nuevo;
            cola = nuevo;
        }else{
            if(cabeza.getSig() != null){
                Nodo nuevo = new Nodo();
                cola.setSig(nuevo);
                nuevo.setValue(x);
                nuevo.setSig(null);
                nuevo.setPrev(cola);
                cola = nuevo;
            }else{
                Nodo nuevo = new Nodo();
                nuevo.setValue(x);
                nuevo.setSig(null);
                nuevo.setPrev(cabeza);
                cabeza.setSig(nuevo);
                cola = nuevo;
            }
        }


    }
    public void Eliminar(int x){ // Costo lineal O(n)
        Nodo currentInicio = cabeza;
        Nodo currentFinal = cola;

        while(currentInicio.getValue() != x && currentFinal.getValue() != x){
            currentInicio = currentInicio.getSig();
            currentFinal = currentFinal.getPrev();
        }

        if(currentInicio.getValue() == x){
            if(currentInicio == cabeza){
                cabeza = cabeza.getSig();
                cabeza.setPrev(null);
            }else{
                currentInicio.getPrev().setSig(currentInicio.getSig());
                currentInicio.getSig().setPrev(currentInicio.getPrev());
                currentInicio = currentInicio.getPrev();
            }

        }else{
            if(currentFinal == cola){
               cola = cola.getPrev();
               cola.setSig(null);
            }else{
                currentFinal.getPrev().setSig(currentFinal.getSig());
                currentFinal.getSig().setPrev(currentFinal.getPrev());
                currentFinal = currentFinal.getPrev();
            }
        }

    }

    public boolean ListaVacia(){
        return  cabeza == null;
    }

    public void InicializarLista(){
        cabeza = null;
        cola = null;
    }

    public static void ImprimirLista(ListaDE lista){
        Nodo current = lista.cabeza;
        while(current != null){
            System.out.println(current.getValue());
            current = current.getSig();
        }
    }

    public static void main(String[] args) {
        ListaDE lista = new ListaDE();
        lista.InicializarLista();
        lista.Agregar(1);
        lista.Agregar(2);
        lista.Agregar(3);
        lista.Agregar(4);
        lista.Agregar(5);
        lista.Agregar(6);
        lista.Agregar(7);
        ImprimirLista(lista);
        lista.Eliminar(5);
        System.out.println("Despues de eliminar el 4");
        ImprimirLista(lista);}

}
