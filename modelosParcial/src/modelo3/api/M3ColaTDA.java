package modelo3.api;

public interface M3ColaTDA {
    void InicializarCola();
    void Acolar(int x);

    M3ColaTDA Salida(M3ColaTDA c);
    void Desacolar();
    boolean ColaVacia();
    int Primero();
}
