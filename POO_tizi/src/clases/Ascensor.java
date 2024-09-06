package clases;

public class Ascensor {
    private int pisoActual;
    private boolean puertaAbierta;

    public Ascensor(){
        this.pisoActual = 0;
        this.puertaAbierta = false;
    }

    public void subir(int piso){
        if (piso > this.pisoActual){
            this.pisoActual = piso;
        }
    }

    public void bajar(int piso) {
        if (piso < this.pisoActual) {
            this.pisoActual = piso;
        }
    }

    public void abrirPuerta(){
        this.puertaAbierta = true;
    }

    public void cerrarPuerta(){
        this.puertaAbierta = false;
    }
}
