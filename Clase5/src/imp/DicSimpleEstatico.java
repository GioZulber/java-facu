package imp;

import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;

public class DicSimpleEstatico implements DiccionarioSimpleTDA {

	
	class Elemento{
		int clave;
		int valor; 
	}
	
	Elemento[] elementos; //Array con objetos de tipo "Elemento"
	int cant;
	
	public void InicializarDiccionario() {
		cant = 0; 
		elementos = new Elemento[100];
	}

	private int Clave2Indice (int clave) {
		int i = 0; 
		// Deveuelve i = cant si no se encontró la clave. Devuelve un valor de i < cant correspondiente a la pos si la encontró 
		while (i < cant && elementos[i].clave != clave) {
			i++; 
		}
		return i;
	}
	
	public void Agregar(int clave, int valor) {
		int pos = Clave2Indice(clave); 
		if (pos == cant) {
			elementos[pos] = new Elemento(); 
			elementos[pos].clave = clave; 
			cant ++;
		}
		elementos[pos].valor = valor;
	}

	
	public void Eliminar(int clave) {
		int pos = Clave2Indice(clave);
		if (pos < cant) {
			// reemplazo el elemento que quiero eliminar con el último de la lista. 
			elementos[pos] = elementos[cant-1]; 
			cant--; 
		}

	}


	public int Recuperar(int clave) {
		int pos = Clave2Indice(clave);
		// chequear que pasa si intento recuperar el valor de una clave que no existe.
		return elementos[pos].valor;
	}

	
	public ConjuntoTDA Claves() {
		ConjuntoTDA C = new ConjuntoDinamico(); 
		C.InicializarConjunto();
		for (int i = 0; i<cant; i++) {
			C.Agregar(elementos[i].clave);
		}
		return C;
	}

}
