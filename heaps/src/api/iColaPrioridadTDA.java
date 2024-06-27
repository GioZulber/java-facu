package api;

public interface iColaPrioridadTDA {
    void acolar(int valor, int prioridad);
    void desacolar();
    int primero();
    int prioridad();
    boolean colaVacia();

    int cantidad();
}
