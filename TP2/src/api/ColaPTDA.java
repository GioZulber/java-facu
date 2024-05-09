package api;

public interface ColaPTDA {
    void InicializarCola();
    void Acolar(int x, int prioridad);
    void Desacolar();

    int Prioridad();
    int Primero();

    boolean ColaVacia();
}
