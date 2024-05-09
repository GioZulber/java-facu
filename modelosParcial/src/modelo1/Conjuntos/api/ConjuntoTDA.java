package modelo1.Conjuntos.api;

public interface ConjuntoTDA {
    void InicializarConjunto();
    void Agregar(int x);
    void Sacar(int x);
    boolean Pertenece(int x);

    boolean TodosPertenecen(ConjuntoTDA c);

    void SacarTodos(ConjuntoTDA c);
    int Elegir();
    boolean ConjuntoVacio();
}
