package api;

public interface DiccionarioMultipleTDA {
  void InicializarDiccionario();
  void Agregar(int clave, int valor);
  void Eliminar(int clave);
  void EliminarValor(int clave, int valor);
  iConjuntoTDA Recuperar(int clave);
  iConjuntoTDA Claves();
}
