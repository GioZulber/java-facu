package imp;

import api.BoundedUniverseTDA;

public class BoundedUniverse implements BoundedUniverseTDA {

	boolean[] contenido;
	int cantidad;
	int limite;
	
	@Override
	public void inicializarConjunto(int n) {
		contenido = new boolean[n+1];
		cantidad = 0;
		limite = n;
	}

	@Override
	public void agregar(int x) {
		if(x >= 0 && x <= limite) {
			if(!contenido[x]) {
				contenido[x] = true;
				cantidad++;
			}
		}
	}

	@Override
	public void sacar(int x) {
		if(x >= 0 && x <= limite) {
			if(contenido[x]) {
				contenido[x] = false;
				cantidad--;
			}
		}
	}

	@Override
	public boolean pertenece(int x) {
		if(x >= 0 && x <= limite) 
			return contenido[x];
		else
			return false;
	}

	@Override
	public int elegir() {
		int i = limite;
		while(i >= 0 && !contenido[i])
			i--;
		return i;
	}

	@Override
	public boolean conjuntoVacio() {
		return (cantidad == 0);
	}

	@Override
	public int limite() {
		return limite;
	}

	@Override
	public void interseccion(BoundedUniverseTDA B) {
		if(B.limite() == limite) {
			for (int i = 0; i <= limite; i++) {
				if(contenido[i] && !B.pertenece(i)) {
					this.sacar(i);
				}
			}
		}
	}
	
	@Override
	public void union(BoundedUniverseTDA B) {
		if(B.limite() == limite) {
			for (int i = 0; i <= limite; i++) {
				if(!contenido[i] && B.pertenece(i)) {
					this.agregar(i);
				}
			}
		}
	}
	
	@Override
	public void diferencia(BoundedUniverseTDA B) {
		if(B.limite() == limite) {
			for (int i = 0; i <= limite; i++) {
				if(contenido[i] && B.pertenece(i)) {
					this.sacar(i);
				}
			}	
		}
	}
	
	@Override
	public void complemento() {
		for (int i = 0; i <= limite; i++)
			contenido[i] = !contenido[i];
		cantidad = limite - cantidad + 1;
	}
	
}
