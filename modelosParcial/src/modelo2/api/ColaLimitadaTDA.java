package modelo2.api;

public interface ColaLimitadaTDA {
    void InicializarCola(int x);
    boolean Acolar(int x);
    void Desacolar();
    boolean ColaVacia();

    boolean ColaLlena();
    int Primero();
}
