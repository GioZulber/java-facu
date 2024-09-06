package clases;

public class Gato {
    private int estomago;
    private String nombre;
    private int edad;


    private Gato(String nombre,int edad){
        this.edad = edad;
        this.nombre = nombre;
        this.estomago = 100;

    }

    public void comer(int comida){
        this.estomago += comida;
        if (estomago > 100){
            estomago = 100;
        }
    }

    public void cumplirAnios(){
       this.edad++;
    }

    public void maullar(){
        System.out.println("Miau");
    }

}
