package api;

public interface DicSimpleTDA {
    void InicializarDiccionario();
    void Agregar(int clave, int valor);

    void Eliminar(int clave);



    void EliminarValor(int clave, int valor);

    ConjuntoTDA Claves();


}
