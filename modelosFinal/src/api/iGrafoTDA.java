package api;

public interface iGrafoTDA {
    void InicializarGrafo();
    // Siempre que no exista el nodo
    void AgregarVertice(int v);
    // Siempre que  exista el nodo
    void EliminarVertice(int v);

    iConjuntoTDA Vertices();
    // Siempre que existan los nodos
    void AgregarArista(int v1, int v2, int peso);

    void EliminarArista(int v1, int v2);

    boolean ExisteArista(int v1, int v2);

    int PesoArista(int v1, int v2);

}
