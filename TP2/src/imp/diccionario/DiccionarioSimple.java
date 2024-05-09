package imp.diccionario;

import api.ConjuntoTDA;
import api.DicSimpleTDA;
import imp.conjuntos.ConjuntoAcotado;

public class DiccionarioSimple implements DicSimpleTDA {

    class Elemento{
        int clave;
        int valor;
    }

    Elemento[] elementos;
    int cant;

    @Override
    public void InicializarDiccionario() {
        elementos = new Elemento[100];
        cant = 0;
    }

    @Override
    public void Agregar(int clave, int valor) {
        int pos = Clave2Indice(clave);
        if(pos==-1){
            pos = cant;
            elementos[pos] = new Elemento();
            elementos[pos].clave = clave;
            cant++;
        }
        elementos[pos].valor = valor;
    }

    private int Clave2Indice(int clave){
        int i = cant-1;
        while( i>= 0 && elementos[i].clave != clave){
            i--;
        }
        return  i;
    }
    @Override
    public void Eliminar(int clave) {
        int pos = Clave2Indice(clave);
        if(pos!=-1){
            elementos[pos] = elementos[cant-1];
            cant--;
        }
    }

    @Override
    public void EliminarValor(int clave, int valor) {
        int pos = Clave2Indice(clave);
        if(pos!=-1){
            if(elementos[pos].valor == valor){
                elementos[pos] = elementos[cant-1];
                cant--;
            }
        }

    }




    @Override
    public ConjuntoTDA Claves() {
        ConjuntoTDA c = new ConjuntoAcotado();
        c.InicializarConjunto();

        for(int i = 0; i <cant; i++){
            c.Agregar(elementos[i].clave);
        }
        return c;
    }
}
