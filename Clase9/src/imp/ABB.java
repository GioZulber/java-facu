package imp;

import api.ABBTDA;

public class ABB implements ABBTDA {
	
	class NodoABB{
		int info;
		ABBTDA hijoIzq;
		ABBTDA hijoDer;
	}
	
	NodoABB raiz;
	
	@Override
	public int Raiz() {
		
		return raiz.info;
	}

	@Override
	public ABBTDA HijoDer() {
		
		return raiz.hijoDer;
	}

	@Override
	public ABBTDA HijoIzq() {
		return raiz.hijoIzq;
	}

	@Override
	public boolean ArbolVacio() {
		return (raiz == null);
	}

	@Override
	public void InicializarArbol() {
		raiz = null;
	}
	@Override
	public void AgregarElem(int x) {
		// Creo una raiz y sus dos hijos, que todavia no son nodos.
		if(this.ArbolVacio()) {
			raiz = new NodoABB();
			raiz.info = x;
			raiz.hijoIzq = new ABB();
			raiz.hijoIzq.InicializarArbol();
			raiz.hijoDer = new ABB();
			raiz.hijoDer.InicializarArbol();
		}
		else if(this.Raiz() > x) {
			this.HijoIzq().AgregarElem(x);
		} else if(this.Raiz() < x) {
			this.HijoDer().AgregarElem(x);
		}
	}
	@Override


	public void EliminarElem(int x) {
		if(!this.ArbolVacio()){
			if(this.Raiz() == x && this.HijoIzq().ArbolVacio() && this.HijoDer().ArbolVacio()) {
				raiz = null;
			}
			else if(this.Raiz() == x && !this.HijoIzq().ArbolVacio()) {
				raiz.info = this.mayor(this.HijoIzq());
				this.HijoIzq().EliminarElem(raiz.info);

				
			} else if(this.Raiz() == x) {
				raiz.info = this.menor(this.HijoDer());
				this.HijoDer().EliminarElem(raiz.info);
				
			} else if(this.Raiz() < x) {
				this.HijoDer().EliminarElem(x);
			} else {
				this.HijoIzq().EliminarElem(x);
			}
		}
	}


	
	private int mayor(ABBTDA a){
		if(a.HijoDer().ArbolVacio()) {
			return a.Raiz();
		}
		else {
			return mayor(a.HijoDer());
		}
	}
	
	private int menor(ABBTDA b) {
		if(b.HijoIzq().ArbolVacio()) {
			return b.Raiz();
		}
		else {
			return menor(b.HijoIzq());
		}
	}	

}
