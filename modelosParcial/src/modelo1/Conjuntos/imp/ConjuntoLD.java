package modelo1.Conjuntos.imp;

import modelo1.Conjuntos.api.ConjuntoTDA;

public class ConjuntoLD implements ConjuntoTDA {
    Nodo origen;

    Nodo ultimo;
    @Override
    public void InicializarConjunto() {
        origen = null;
        ultimo = null;
    }

    @Override
    public void Agregar(int x) {
        if(!this.Pertenece(x)){
            Nodo nuevo = new Nodo();
            nuevo.setValue(x);
            nuevo.setSig(null);
            if(origen == null){
                origen = nuevo;
            }
            else{
                ultimo.setSig(nuevo);
            }
            ultimo = nuevo;
        }
    }

    @Override
    public void Sacar(int x) {
        if(ConjuntoVacio()){
            return;
        }
        if(origen.getValue() == x){
            origen = origen.getSig();
            if(origen == null){
                ultimo = null;
            }
        }
        else{
            Nodo aux = origen;
            while (aux.getSig() != null && aux.getSig().getValue() != x){
                aux = aux.getSig();
            }
            if(aux.getSig() != null){
                aux.setSig(aux.getSig().getSig());
                if(aux.getSig() == null){
                    ultimo = aux;
                }
            }
        }

    }

    @Override
    public boolean Pertenece(int x) {
        Nodo aux = origen;
        while (aux != null && aux.getValue() != x){
            aux = aux.getSig();
        }
        return aux != null;
    }


    private ConjuntoTDA CopiarConjunto(ConjuntoTDA c){
        ConjuntoTDA aux = new ConjuntoLD();
        ConjuntoTDA c2 = new ConjuntoLD();
        c2.InicializarConjunto();
        aux.InicializarConjunto();
        while(!c.ConjuntoVacio()){
            int x = c.Elegir();
            aux.Agregar(x);
            c.Sacar(x);
        }
        while(!aux.ConjuntoVacio()){
            int x = aux.Elegir();
            c2.Agregar(x);
            c.Agregar(x);
            aux.Sacar(x);
        }

        return c2;
    }

    private void mostrarConjunto(ConjuntoTDA c){
        ConjuntoTDA aux = CopiarConjunto(c);
        System.out.print("{");
        while(!aux.ConjuntoVacio()){
            int x = aux.Elegir();
            System.out.print(x);
            aux.Sacar(x);
            if(!aux.ConjuntoVacio()){
                System.out.print(",");
            }
        }
        if(c.ConjuntoVacio()){
            System.out.print("Conjunto vacio");
        }

        System.out.println("}");
    }


    @Override
    public boolean TodosPertenecen(ConjuntoTDA c) { // costo cubico
        ConjuntoTDA c2 = this.CopiarConjunto(c); // costo lineal

        boolean pertenece = true;
        while (!c2.ConjuntoVacio() && pertenece){ // costo cuadratico
            int x = c2.Elegir();
            pertenece = this.Pertenece(x);
            c2.Sacar(x);
        }
        return pertenece;
    }

    @Override
    public void SacarTodos(ConjuntoTDA c) {
        Nodo aux = origen;
        while (aux != null){
            if(c.Pertenece(aux.getValue())){
                this.Sacar(aux.getValue());
            }
            aux = aux.getSig();
        }
    }

    @Override
    public int Elegir() {
        return origen.getValue();
    }

    @Override
    public boolean ConjuntoVacio() {

        return origen == null;
    }
}
