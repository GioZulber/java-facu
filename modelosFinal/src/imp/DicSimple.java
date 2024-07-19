package imp;

import api.iConjuntoTDA;
import api.DicSimpleTDA;
import imp.ConjuntoLD;


public class DicSimple implements DicSimpleTDA {

    class Elemento{
        int clave;
        int valor;
    }

    Elemento[] elementos;
    int cant;

    @Override
    public void InicializarDiccionario() {
        elementos = new Elemento[100];
        cant =0;
    }

    @Override
    public void Agregar(int clave, int valor) {
        int pos = Clave2Indice(clave);
        if(pos == cant){
            elementos[pos] = new Elemento();
            elementos[pos].clave = clave;
            cant++;
        }
        elementos[pos].valor = valor; // Si la clave ya existe, se sobreescribe el valor
    }

    @Override
    public void Eliminar(int clave) {
        int pos = Clave2Indice(clave);
        if(pos < cant){
            // Reemplazo el elemento que quiero eliminar con el último de la lista
            elementos[pos] = elementos[cant-1];
            cant--;
        }
    }

    @Override
    public int Recuperar(int clave) {
        int pos = Clave2Indice(clave);
        return elementos[pos].valor;
    }

    @Override
    public iConjuntoTDA Claves() {
        iConjuntoTDA claves = new ConjuntoLD();
        claves.InicializarConjunto();
        for(int i = 0; i < cant; i++){
            claves.Agregar(elementos[i].clave);
        }
        return claves;
    }

    private int Clave2Indice(int clave){ // Devuelve la posición de la clave en el array o la cantidad de elementos si no la encuentra
        int i = 0;
        while(i < cant && elementos[i].clave != clave){
            i++;
        }
        return i;
    }

}
