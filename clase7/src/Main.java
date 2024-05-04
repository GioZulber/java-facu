import api.ConjutnoTDA;
import imp.Conjunto;

public class Main {


    public static void mostarConjunto(ConjutnoTDA x){
        System.out.print("{");
        for(int i = 0; i < x.Limite(); i++){
            if(x.Pertenece(i)){
                System.out.print(i +", ");
            }

        }
        System.out.println("}");
    }

    public static ConjutnoTDA interseccion(ConjutnoTDA a, ConjutnoTDA b){
        ConjutnoTDA c = new Conjunto();
        c.InicializarConjunto(a.Limite());
        for(int i = 0; i < a.Limite(); i++){
            if(a.Pertenece(i) && b.Pertenece(i)){
                c.Agregar(i);
            }
        }

        return c;
    }

    public static ConjutnoTDA union(ConjutnoTDA a, ConjutnoTDA b){
        ConjutnoTDA c = new Conjunto();
        c.InicializarConjunto(a.Limite());
        for(int i = 0; i < a.Limite(); i++){
            if(a.Pertenece(i) || b.Pertenece(i)){
                c.Agregar(i);
            }
        }

        return c;
    }

    public static ConjutnoTDA diferencia(ConjutnoTDA a, ConjutnoTDA b){
        ConjutnoTDA c = new Conjunto();
        c.InicializarConjunto(a.Limite());
        for(int i = 0; i < a.Limite(); i++){
            if(a.Pertenece(i) && !b.Pertenece(i)){
                c.Agregar(i);
            }
        }

        return c;
    }

    public static ConjutnoTDA complemento(ConjutnoTDA a){
        ConjutnoTDA c = new Conjunto();
        c.InicializarConjunto(a.Limite());
        for(int i = 0; i < a.Limite(); i++){
            if(!a.Pertenece(i)){
                c.Agregar(i);
            }
        }

        return c;
    }


    public static void main(String[] args) {
        ConjutnoTDA a = new Conjunto();
        a.InicializarConjunto(10);
        a.Agregar(2);
        a.Agregar(4);
        a.Agregar(6);
        a.Agregar(8);
        a.Agregar(10);
        System.out.print("Conjunto A: ");
        mostarConjunto(a);
        ConjutnoTDA b = new Conjunto();
        b.InicializarConjunto(10);
        b.Agregar(1);
        b.Agregar(3);
        b.Agregar(5);
        b.Agregar(7);
        b.Agregar(9);
        System.out.print("Conjunto B: ");
        mostarConjunto(b);
        ConjutnoTDA c = new Conjunto();
        c.InicializarConjunto(10);
        c.Agregar(10);
        c.Agregar(5);
        c.Agregar(7);
        c.Agregar(2);
        System.out.print("Conjunto C: ");
        mostarConjunto(c);
        ConjutnoTDA resI = interseccion(a, c);
        System.out.print("Interseccion de A y C: ");
        mostarConjunto(resI);
        System.out.print("Union de A y C: ");
        ConjutnoTDA resU = union(a, c);
        mostarConjunto(resU);
        System.out.print("Diferencia de A y C: ");
        ConjutnoTDA resD = diferencia(a, c);
        mostarConjunto(resD);
        System.out.print("Complemento de A: ");
        ConjutnoTDA resCom = complemento(a);
        mostarConjunto(resCom);






    }
}