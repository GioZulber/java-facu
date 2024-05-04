package api;

public interface ConjutnoTDA {
    void InicializarConjunto(int x);
    void Agregar(int x);

    void Sacar(int x);
    boolean ConjuntoVacio();

    boolean Pertenece(int x);

    int Elegir();

    int Limite();


}
