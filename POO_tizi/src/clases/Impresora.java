package clases;

public class Impresora {
    private int cantTinta;
    private int cantHojas;



    public Impresora(int cantHojas, int cantTinta){
        this.cantTinta = cantTinta;
        this.cantHojas = cantHojas;
    }

    public void imprimir(int paginas) {
        if (this.cantHojas >= paginas && this.cantTinta >= 2 * paginas) {
            this.cantTinta -= 2 * paginas;
            this.cantHojas -= paginas;
        }
    }

    public void recargarTinta(int tinta) {
        this.cantTinta += tinta;
    }

    public void recargarHoja(int hojas){
        this.cantHojas += hojas;
    }

}
