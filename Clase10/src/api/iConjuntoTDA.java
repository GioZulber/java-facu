package api;

public interface iConjuntoTDA {
    void InicializarConjunto();
    void Agregar(int x);
    void Sacar(int x);
    int Elegir();
    boolean Pertenece(int x);
    boolean ConjuntoVacio();
}
