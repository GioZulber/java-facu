package modelo1.Conjuntos.api;

public interface M1ConjuntoTDA {
    void InicializarConjunto();
    void Agregar(int x);
    void Sacar(int x);
    boolean Pertenece(int x);

    boolean TodosPertenecen(M1ConjuntoTDA c);

    void SacarTodos(M1ConjuntoTDA c);
    int Elegir();
    boolean ConjuntoVacio();
}
