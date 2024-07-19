package imp;

import api.ConjuntoTDA;
import api.GrafoTDA;

public class GrafoMA implements GrafoTDA {

	int n = 20;
	int[][]MAdy;
	int cantNodos;
	int[] Etiqs;
	
	@Override
	public void InicializarGrafo() {
		MAdy = new int[n][n];
		Etiqs = new int[n];
		cantNodos = 0;
	}

	@Override
	public void AgregarVertice(int v) {
		Etiqs[cantNodos] = v;
		for(int i = 0; i < n; i++) {
			MAdy[cantNodos][i] = 0;
			MAdy[i][cantNodos] = 0;
		}
		cantNodos++;		
	}

	@Override
	public void AgregarArista(int o, int d, int p) {
		int i = Vert2Indice(o);
		int j = Vert2Indice(d);
		MAdy[i][j] = p;
	}

	@Override
	public void EliminarVertice(int v) {
		int inx = Vert2Indice(v);
		Etiqs[inx] = Etiqs[cantNodos - 1];
		for(int i = 0; i < cantNodos; i++) {
			MAdy[inx][i] = MAdy[cantNodos - 1][i];
		}
		for(int i = 0; i < cantNodos; i++) {
			MAdy[i][inx] = MAdy[i][cantNodos - 1];	
		}
		cantNodos--;
	}

	@Override
	public void EliminarArista(int o, int d) {
		int i = Vert2Indice(o);
		int j = Vert2Indice(d);
		MAdy[i][j] = 0;
	}

	@Override
	public ConjuntoTDA Vertices() {
		ConjuntoTDA c = new ConjuntoLD();
		c.InicializarConjunto();
		for(int i = 0; i < cantNodos; i++)
			c.Agregar(Etiqs[i]);
		return c;
	}

	@Override
	public boolean ExisteArista(int o, int d) {
		int i = Vert2Indice(o);
		int j = Vert2Indice(d);
		return (MAdy[i][j] != 0);
	}

	@Override
	public int PesoArista(int o, int d) {
		int i = Vert2Indice(o);
		int j = Vert2Indice(d);
		return (MAdy[i][j]);
	}
	
	private int Vert2Indice(int v) {
		int i = cantNodos - 1;
		while(i >= 0 && Etiqs[i] != v)
			i--;
		return i;
	}
}
