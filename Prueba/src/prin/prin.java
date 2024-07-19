package prin;

import api.ConjuntoTDA;
import api.GrafoTDA;
import imp.GrafoMA;

public class prin {

	public static void mostrarGrafo(GrafoTDA G) {
		ConjuntoTDA o = G.Vertices();
		ConjuntoTDA d;
		int origen;
		int destino;
		int peso;
		while(!o.ConjuntoVacio()) {
			origen = o.Elegir();
			o.Sacar(origen);
			System.out.print("Nodo origen: " + origen);
			d = G.Vertices();
			while(!d.ConjuntoVacio()) {
				destino = d.Elegir();
				d.Sacar(destino);
				if(G.ExisteArista(origen, destino)) {
					peso = G.PesoArista(origen, destino);
					System.out.print("(nodo destino: " + destino + ", peso: " + peso+") ");
				}
			}
			System.out.println();
		}
	}
	
	public static void mostrar(ConjuntoTDA x) {
		while(!x.ConjuntoVacio()) {
			int u = x.Elegir();
			x.Sacar(u);
			System.out.println(u);
		}
	}
	
	public static boolean HamiltonianCycle(GrafoTDA G, int[]Ciclo) {
		boolean soFarSoGood = true;
		ConjuntoTDA V = G.Vertices();
		for(int i = 0; i < Ciclo.length && soFarSoGood; i++) {
			if(V.Pertenece(Ciclo[i])) 
				V.Sacar(Ciclo[i]); 
			else 
				soFarSoGood = false;
		}
		if(!V.ConjuntoVacio())
			soFarSoGood = false;
		if(soFarSoGood) {
			for(int i = 0; i < Ciclo.length - 1 && soFarSoGood; i++) {
				if(!G.ExisteArista(Ciclo[i], Ciclo[i+1])) 
					soFarSoGood = false; 
			}
			if(soFarSoGood)
				soFarSoGood = G.ExisteArista(Ciclo[Ciclo.length - 1], Ciclo[0]);
		}
		return soFarSoGood;
	}



	
	public static void main(String[] args) {
		GrafoTDA G = new GrafoMA();
		G.InicializarGrafo();
		G.AgregarVertice(1);
		G.AgregarVertice(2);
		//G.AgregarVertice(99);
		G.AgregarVertice(3);
		G.AgregarVertice(4);
		G.AgregarArista(1, 2, 2);
		G.AgregarArista(1, 3, 4);
		G.AgregarArista(2, 1, 3);
		G.AgregarArista(2, 4, 1);
		G.AgregarArista(3, 4, 2);
		G.AgregarArista(4, 1, 5);
		G.AgregarArista(4, 2, 3);
		//G.AgregarArista(1, 99, 9);
		//G.AgregarArista(2, 99, 11);
		//G.AgregarArista(99, 1, 22);
		//G.AgregarArista(99, 3, 7);
		//G.AgregarArista(99, 4, 18);
		mostrarGrafo(G);
		//G.EliminarVertice(99);
		//mostrarGrafo(G);
		// int[] A = {1, 2, 3, 4};
		//System.out.println(HamiltonianCycle(G,A));
	}

}
