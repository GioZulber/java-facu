package modelo2.api;

import api.ConjuntoTDA;

public interface M2DicMultipleTDA {
    void InicializarDiccionario();

    void Agregar(int clave, int valor);

    ConjuntoTDA ClaseValor(int clave);

    void Eliminar(int clave);

    void EliminarValor(int clave, int valor);

    ConjuntoTDA Recuperar(int clave);

    ConjuntoTDA Claves();
}
