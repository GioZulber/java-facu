package api;

public interface BoundedUniverseTDA {
	void inicializarConjunto(int n);
	void agregar(int x);
	void sacar(int x);
	boolean pertenece(int x);
	int elegir();
	boolean conjuntoVacio();
	int limite();
	void interseccion(BoundedUniverseTDA B);
	void union(BoundedUniverseTDA B);
	void diferencia(BoundedUniverseTDA B);
	void complemento();
}
