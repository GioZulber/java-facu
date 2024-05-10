package imp;

import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;

public class DicSimpleDinamico implements DiccionarioSimpleTDA {

	class NodoClave {
		int valor; 
		int clave;
		NodoClave sigClave; 
	}
	
	NodoClave inicio;
	
	
	public void InicializarDiccionario() {
		inicio = null; 
	}

	private NodoClave Clave2NodoClave (int clave) {
		NodoClave viajero = inicio; 
		while (viajero != null && viajero.clave != clave) {
			viajero = viajero.sigClave;
		}
		return viajero;
	}
	
	public void Agregar(int clave, int valor) {
		NodoClave nc = Clave2NodoClave(clave); 
		if (nc == null) {
			nc = new NodoClave(); 
			nc.clave = clave; 
			nc.sigClave = inicio; 
			inicio = nc; 
		}
		nc.valor = valor; 
	}

	
	public void Eliminar(int clave) {
		NodoClave nc = Clave2NodoClave(clave); 
		if (nc != null) {
			//Si la clave buscada es la primera hago que el inicio sea el siguiente al primero
			if (inicio.clave == clave) {
				inicio = inicio.sigClave; 
			}
			//Si no es el primero, necesito recorrer la lista
			else {
				NodoClave viajero = inicio;
				while(viajero.sigClave != null && viajero.sigClave.clave != clave) {
					viajero = viajero.sigClave;
				}
				if (viajero.sigClave != null) {
					viajero.sigClave = viajero.sigClave.sigClave;
				}
			}
		}
	}

	
	public int Recuperar(int clave) {
		// busco el nodo que quiero y devuelvo su valor
		NodoClave nc = Clave2NodoClave(clave);
		return nc.valor;
	}

	
	public ConjuntoTDA Claves() {
		ConjuntoTDA claves = new ConjuntoDinamico(); 
		claves.InicializarConjunto();
		NodoClave viajero = inicio; 
		while(viajero != null) {
			claves.Agregar(viajero.clave);
			viajero = viajero.sigClave;
		}
		return claves;
	}

}
