package punto2;

public class Bicicleta extends Transporte{

        public Bicicleta() {
            super("Bicicleta");
        }
        @Override
        public String obtenerPremio(){
            return "Recibe de premio un kit de seguridad compuesto por chaleco y casco.";
        }
}
