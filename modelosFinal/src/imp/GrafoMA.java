package imp;
import api.iConjuntoTDA;
import api.iGrafoTDA;

public class GrafoMA implements iGrafoTDA {

    static int n = 100;

    int [][] MAdy;
    int [] Etiqs; //etiquetas de los vertices

    int cantNodos;

    @Override
    public void InicializarGrafo() {
        MAdy = new int[n][n];
        Etiqs = new int[n];
        cantNodos = 0;

    }

    @Override
    public void AgregarVertice(int v) {
        Etiqs[cantNodos] = v; // se guarda la etiqueta del vertice
        for(int i=0; i <= cantNodos; i++){
            MAdy[cantNodos][i] = 0;
            MAdy[i][cantNodos] = 0;
        }
        cantNodos++;
    }

    @Override
    public void EliminarVertice(int v) {
        int ind = Vert2Indice(v); // se busca el vertice
        // se desplazan las filas y columnas
        for(int k = 0; k <cantNodos; k++){
            MAdy[k][ind] = MAdy[k][cantNodos-1]; // se desplaza la columna a la izquierda
        }
        for(int k = 0; k <cantNodos; k++){
            MAdy[ind][k] = MAdy[cantNodos-1][k]; // se desplaza la fila hacia arriba
        }
        Etiqs[ind] = Etiqs[cantNodos-1]; // se desplaza la etiqueta
        cantNodos--;
    }

    private int Vert2Indice(int v){
        int i = cantNodos-1;
        // se busca el vertice
        // mientras no se llegue al principio y la etiqueta no sea igual a la etiqueta del vertice
        while(i >= 0 & Etiqs[i] !=v )
            i--;
        return i;
    }

    @Override
    public iConjuntoTDA Vertices() {
        iConjuntoTDA Vert = new ConjuntoLD();
        Vert.InicializarConjunto();
        for(int i= 0; i< cantNodos; i++){
            Vert.Agregar(Etiqs[i]);
        }
        return Vert;
    }

    @Override
    public void AgregarArista(int v1, int v2, int peso) {
        int o = Vert2Indice(v1); // se busca el vertice origen
        int d = Vert2Indice(v2); // se busca el vertice destino
        MAdy[o][d] = peso;
    }

    @Override
    public void EliminarArista(int v1, int v2) {
        int o = Vert2Indice(v1); // se busca el vertice origen
        int d = Vert2Indice(v2); // se busca el vertice destino
        MAdy[o][d] = 0;
    }

    @Override
    public boolean ExisteArista(int v1, int v2) {
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        return MAdy[o][d] != 0;
    }

    @Override
    public int PesoArista(int v1, int v2) {
        int o = Vert2Indice(v1);
        int d = Vert2Indice(v2);
        return MAdy[o][d];
    }
}
