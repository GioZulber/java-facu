package prin;

import api.BoundedUniverseTDA;
import imp.BoundedUniverse;

public class prin {

	public static BoundedUniverseTDA copiarConjunto(BoundedUniverseTDA original) {
		BoundedUniverseTDA aux = new BoundedUniverse();
		BoundedUniverseTDA copia = new BoundedUniverse();
		aux.inicializarConjunto(original.limite());
		copia.inicializarConjunto(original.limite());
		int x;
		while(!original.conjuntoVacio()) {
			x = original.elegir();
			original.sacar(x);
			aux.agregar(x);
		}
		while(!aux.conjuntoVacio()) {
			x = aux.elegir();
			aux.sacar(x);
			original.agregar(x);
			copia.agregar(x);
		}
		return copia;
	}
	
	public static void mostrarConjunto(BoundedUniverseTDA X) {
		BoundedUniverseTDA copia = copiarConjunto(X);
		int x;
		System.out.print("{");
		while(!copia.conjuntoVacio()) {
			x = copia.elegir();
			copia.sacar(x);
			System.out.print(x);
			if(!copia.conjuntoVacio())
				System.out.print(", ");
		}
		System.out.println("}");
	}
	
	public static void main(String[] args) {
		BoundedUniverseTDA A = new BoundedUniverse();
		BoundedUniverseTDA B = new BoundedUniverse();
		A.inicializarConjunto(11);
		B.inicializarConjunto(11);
		A.agregar(1);
		A.agregar(3);
		A.agregar(5);
		A.agregar(7);
		B.agregar(2);
		B.agregar(3);
		B.agregar(4);
		B.agregar(5);
		B.agregar(6);
		mostrarConjunto(A);
		mostrarConjunto(B);
		A.complemento();
		mostrarConjunto(A);
	}

}
