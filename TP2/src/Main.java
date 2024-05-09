import api.ConjuntoTDA;
import api.DicSimpleTDA;
import imp.conjuntos.ConjuntoAcotado;
import imp.diccionario.DiccionarioSimple;

public class Main {
    public static DicSimpleTDA copiar(DicSimpleTDA dic){
        DicSimpleTDA dic2 = new DiccionarioSimple();
        dic2.InicializarDiccionario();
        ConjuntoTDA claves = dic.Claves();
        claves.InicializarConjunto();
        while(!claves.ConjuntoVacio()){
            int clave = claves.Elegir();
            claves.Sacar(clave);
            ConjuntoTDA valores = dic.Recuperar(clave);
            valores.InicializarConjunto();
            while(!valores.ConjuntoVacio()){
                int valor = valores.Elegir();
                valores.Sacar(valor);
                dic2.Agregar(clave, valor);
            }
        }
        return dic2;
    }
    public static void MostrarDiccionario(DicSimpleTDA dic){
        ConjuntoTDA claves = dic.Claves();
        claves.InicializarConjunto();
        while(!claves.ConjuntoVacio()){
            int clave = claves.Elegir();
            claves.Sacar(clave);
            System.out.println("Clave: "+clave+" Valor: "+dic.Recuperar(clave).Elegir());
        }
    }

    public static void main(String[] args) {
        DicSimpleTDA dic = new DiccionarioSimple();
        dic.InicializarDiccionario();
        dic.Agregar(1, 2);
        dic.Agregar(2, 3);
        dic.Agregar(3, 4);
        dic.Agregar(4, 5);


    }



}