package api;

public interface DicSimpleTDA {
    void InicializarDiccionario();

    void Agregar(int clave, int valor);
    void Eliminar(int clave);
    int Recuperar(int clave);
    ConjuntoTDA Claves();
}
