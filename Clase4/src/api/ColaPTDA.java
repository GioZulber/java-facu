package api;

public interface ColaPTDA {
    void InicializarColaPrioridad();
    void AcolarPrioridad(int valor, int prioridad);
    void Desacolar();
    int Primero();
    int Prioridad();
    boolean ColaVacia();
}
