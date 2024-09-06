package punto2;

public class main {

    public static void main(String[] args){
        Empleado empleado1 = new Empleado("Juan", new Bicicleta());
        System.out.println(empleado1.obtenerPremio());
        Empleado empleado2 = new Empleado("Pedro", new Moto());
        System.out.println(empleado2.obtenerPremio());
        Empleado empleado3 = new Empleado("Maria", new Auto());
        System.out.println(empleado3.obtenerPremio());
        Empleado empleado4 = new Empleado("Ana", new MonopatinElectrico());
        System.out.println(empleado4.obtenerPremio());
    }

}
