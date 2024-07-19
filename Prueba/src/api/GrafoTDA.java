package api;

public interface GrafoTDA {
	void InicializarGrafo();
	void AgregarVertice(int v);					// Grafo inicializado y vértice no existe
	void AgregarArista(int o, int d, int p);	// Grafo inicializado y vértices existen
	void EliminarVertice(int v);				// Grafo inicializado y vértice existe
	void EliminarArista(int o, int d);			// Grafo inicializado y vértices existen
	ConjuntoTDA Vertices();						// Grafo inicializado
	boolean ExisteArista(int o, int d);			// Grafo inicializado y vértices existen
	int PesoArista(int o, int d);				// Grafo inicializado y vértices existen
}
