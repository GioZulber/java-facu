package api;

public interface ABBTDA {
	int Raiz();
	ABBTDA HijoDer();
	ABBTDA HijoIzq();
	boolean ArbolVacio();
	void InicializarArbol ();
	void EliminarElem ( int x);
	void AgregarElem( int x);

}
