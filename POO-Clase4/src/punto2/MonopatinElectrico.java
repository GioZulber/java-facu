package punto2;

public class MonopatinElectrico extends Transporte{

        public MonopatinElectrico() {
            super("Monopatin Electrico");
        }
    @Override
        public String obtenerPremio(){
            return "Recibe de premio una entrada para un evento a eleccion.";
        }
}
