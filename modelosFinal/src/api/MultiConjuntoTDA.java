package api;

public interface MultiConjuntoTDA {
    void InicializarMultiConjunto();

    void Agregar(int x);
    void Sacar(int x);
    int Multiplicidad(int x);
    boolean MultiConjuntoVacio();
    int Elegir();
}
