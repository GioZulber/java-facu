package api;

import api.iConjuntoTDA;

public interface M2DicMultipleTDA {
    void InicializarDiccionario();

    void Agregar(int clave, int valor);

    iConjuntoTDA ClaseValor(int clave);

    void Eliminar(int clave);

    void EliminarValor(int clave, int valor);

    iConjuntoTDA Recuperar(int clave);

    iConjuntoTDA Claves();
}
