package prin;

import api.ABBTDA;
import api.ConjuntoTDA;
import imp.ABB;
import imp.Conjunto;

public class Main {

	public static void MostrarConjunto(ConjuntoTDA a){
		while (!a.ConjuntoVacio()) {
			System.out.println(a.Elegir());
			a.Sacar(a.Elegir());
		}
	}
	public static void mostrarArbol(ABBTDA a) {
		mostrarArbol ("", a);
	}
	
	public static void mostrarArbol(String palabra, ABBTDA a) {
		if (!a.ArbolVacio()) {
			constructLine(palabra,a.Raiz());
			if (a.HijoIzq().ArbolVacio())
				mostrarArbol(palabra+"0",a.HijoDer());
			else 
				mostrarArbol(palabra+"1",a.HijoDer());
			mostrarArbol(palabra+"0",a.HijoIzq());
		}
	}
	
	public static void constructLine(String palabra, int x) {
		String con = "";
		if (palabra == "")
			con = String.valueOf(x);
		else if (palabra.charAt(palabra.length() - 1) == '1')
			con += "├──"+x;
		else 
			con += "└──"+x;
		for (int i = palabra.length() - 2; i >= 0; i--) {
			if (palabra.charAt(i) == '0')
				con = "   "+con;
			else
				con = "│  "+con;
		}
		System.out.println(con);		
	}
	

	


	// Punto A
	public static boolean existeElementoEnABB(ABBTDA a, int x){
		if(a.ArbolVacio()) return false;
		else if(a.Raiz() == x) return true;
		else if(a.Raiz() > x) return existeElementoEnABB(a.HijoIzq(), x);
		else return existeElementoEnABB(a.HijoDer(), x);
	}

	// Punto B
	public static boolean esHoja(ABBTDA a, int x){
		if(a.ArbolVacio()) return true;
		else if(a.Raiz() == x) return a.HijoIzq().ArbolVacio() && a.HijoDer().ArbolVacio();
		else if(a.Raiz() > x) return esHoja(a.HijoIzq(), x);
		else return esHoja(a.HijoDer(), x);
	}
	// Punto C
	public static int calcularProfundidad(ABBTDA a, int x){
		if(a.ArbolVacio()) return 0;

		else if(a.Raiz() == x) return 0;

		else if (a.Raiz() > x) return  1 + calcularProfundidad(a.HijoIzq(), x);

		else return 1 + calcularProfundidad(a.HijoDer(), x);

	}
	// PUNTO D
	public static int menorElemento(ABBTDA a){
		if(a.HijoIzq().ArbolVacio()) return a.Raiz();
		else return menorElemento(a.HijoIzq());
	}
	// PUNTO E
	public static int contarElem(ABBTDA a) {
		if(a.ArbolVacio()) return 0;
		else return 1 + contarElem(a.HijoIzq()) + contarElem(a.HijoDer());
	}

	// PUNTO F
	public static int sumaElementos(ABBTDA a){
		if (a.ArbolVacio()) return 0;
		else return (a.Raiz() + sumaElementos(a.HijoIzq()) + sumaElementos(a.HijoDer()));
	}

	// PUNTO G
	public static int cantidadHojas(ABBTDA a) {
		if(a.ArbolVacio()) return 0;
		else if(a.HijoIzq().ArbolVacio() && a.HijoDer().ArbolVacio()) return 1;
		else return cantidadHojas(a.HijoIzq()) + cantidadHojas(a.HijoDer());
	}


	// PUNTO H
	public static int altura(ABBTDA a) {
		
		if(a.ArbolVacio()) return -1;	

		else return 1 + Math.max(altura(a.HijoIzq()), altura(a.HijoDer())); 
	}

	// PUNTO I
	public static boolean isoMorfos(ABBTDA a, ABBTDA b) {

		if(a.ArbolVacio() && b.ArbolVacio())
			return true;
		else if((a.ArbolVacio() != b.ArbolVacio())){
			return false;
		}
		else if(a.HijoIzq().ArbolVacio() != b.HijoIzq().ArbolVacio()) {
			return false;
		}else {
			return (isoMorfos(a.HijoIzq(), b.HijoIzq()) && isoMorfos(a.HijoDer(), b.HijoDer()));
		}
	}
	// PUNTO J
	public static boolean sonIguales(ABBTDA a, ABBTDA b) {

		if(a.ArbolVacio() && b.ArbolVacio())
			return true;
		else if(a.Raiz()!= b.Raiz()) {
			return false;
		}
		else if((a.ArbolVacio() != b.ArbolVacio())){
			return false;
		}
		else if(a.HijoIzq().ArbolVacio() != b.HijoIzq().ArbolVacio()) {
			return false;
		}else {
			return (sonIguales(a.HijoIzq(), b.HijoIzq()) && sonIguales(a.HijoDer(), b.HijoDer()));
		}
	}

	// PUNTO K
	public static int cantElementosNivel(ABBTDA a, int nivel){
		if(a.ArbolVacio()) return 0;
		else if(nivel == 0) return 1;
		else return cantElementosNivel(a.HijoIzq(), nivel - 1) + cantElementosNivel(a.HijoDer(), nivel - 1);
	}
	// PUNTO L

	public static void preOrder(ABBTDA a) {
		System.out.print("Pre order: ");
		preOrder1(a);
		System.out.println();
	}

	public static void preOrder1(ABBTDA a) {
		if(!a.ArbolVacio()) {
			System.out.print(a.Raiz() + " ");
			preOrder1(a.HijoIzq());
			preOrder1(a.HijoDer());
		}
	}
	public static void inOrder(ABBTDA a) {
		System.out.print("In Order: ");
		inOrder1(a);
		System.out.println();
	}
	public static void inOrder1(ABBTDA a) {
		if(!a.ArbolVacio()) {
			preOrder1(a.HijoIzq());
			System.out.print(a.Raiz() + " ");
			preOrder1(a.HijoDer());
		}
	}
	public static void postOrder(ABBTDA a) {
		System.out.print("Post Order: ");
		postOrder1(a);
		System.out.println();
	}
	public static void postOrder1(ABBTDA a) {
		if(!a.ArbolVacio()) {
			postOrder1(a.HijoIzq());
			postOrder1(a.HijoDer());
			System.out.print(a.Raiz() + " ");
		}
	}

	// PUNTO M
	public static ConjuntoTDA mayoresQueElem(ABBTDA a, int x){
		ConjuntoTDA c = new Conjunto();
		c.InicializarConjunto();
		mayoresQueElem1(a, x, c);
		return c;
	}
	public static void mayoresQueElem1(ABBTDA a, int x, ConjuntoTDA c) {
		if(!a.ArbolVacio()) {
			if(a.Raiz() > x) {
				c.Agregar(a.Raiz());
			}
			mayoresQueElem1(a.HijoIzq(), x, c);
			mayoresQueElem1(a.HijoDer(), x, c);
		}
	}

	// PUNTO N
	public static int inmediatamenteAnterior(ABBTDA a, int x){
    if(!existeElementoEnABB(a, x)){
        return -1; // Si x no existe en el árbol, retorna -1.
    }else{
        return inmediatamenteAnteriorAux(a, x, -1);
    }
}

private static int inmediatamenteAnteriorAux(ABBTDA a, int x, int mayor){
    if(a.ArbolVacio()){
        return mayor;
    }
    if(a.Raiz() < x){
        // Si el valor de la raíz es menor que x, puede ser un candidato y seguimos buscando en el hijo derecho.
		mayor = a.Raiz();
        return inmediatamenteAnteriorAux(a.HijoDer(), x, mayor);
    }else{
        // Si el valor de la raíz es mayor o igual a x, buscamos en el hijo izquierdo.
        return inmediatamenteAnteriorAux(a.HijoIzq(), x, mayor);
    }
}



	
	public static void main(String[] args) {
		ABBTDA a = new ABB();
		a.InicializarArbol();
		a.AgregarElem(54);
		a.AgregarElem(27);
		a.AgregarElem(48);
		a.AgregarElem(22);
		a.AgregarElem(75);
		a.AgregarElem(111);
		a.AgregarElem(30);
		a.AgregarElem(76);
		a.AgregarElem(80);
		a.AgregarElem(121);
		a.AgregarElem(21);
		a.AgregarElem(98);

		mostrarArbol(a);

		/*
		ABBTDA b = new ABB();
		b.AgregarElem(54);
		b.AgregarElem(27);
		b.AgregarElem(48);
		b.AgregarElem(22);
		b.AgregarElem(75);
		b.AgregarElem(111);
		b.AgregarElem(30);
		b.AgregarElem(76);
		b.AgregarElem(80);
		b.AgregarElem(121);
		*/
		//mostrarArbol(a);
		// mostrarArbol(b);
		System.out.println("Cantidad de elementos: " + contarElem(a));

		preOrder(a);
		inOrder(a);
		postOrder(a);
		//ABBTDA c = new ABB();
		// System.out.println("Tienen la misma forma? " + isoMorfos(a, b));
		// System.out.println("Son iguales? " + sonIguales(a,b));

		System.out.println("Altura: " + altura(a));
		System.out.println("Existe el elemento 21? " + existeElementoEnABB(a, 22));
		System.out.println("Es hoja el elemento 111? " + esHoja(a, 111));
		System.out.println("Profundidad del elemento 48: " + calcularProfundidad(a, 48));
		System.out.println("Menor elemento: " + menorElemento(a));
		System.out.println("Cantidad de elementos: " + contarElem(a));
		System.out.println("Suma de elementos: " + sumaElementos(a));
		System.out.println("Cantidad de hojas: " + cantidadHojas(a));
		System.out.println("Cantidad de elementos en el nivel 2: " + cantElementosNivel(a, 2));
		System.out.println("Elementos mayores a 50: ");
		MostrarConjunto(mayoresQueElem(a, 50));
		System.out.println("Inmediatamente anterior a 30: " + inmediatamenteAnterior(a, 30));

	}
	
	
}