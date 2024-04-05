package api;

public interface PilaTDA {
    void InicializarPila();		// Sin precondiciones
    void Apilar(int x);			// Pila inicializada
    void Desapilar();			// Pila inicializada y no vacía
    int Tope();					// Pila inicializada y no vacía
    boolean PilaVacia();		// Pila inicializada
}
