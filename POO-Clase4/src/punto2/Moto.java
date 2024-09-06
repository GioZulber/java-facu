package punto2;

public class Moto extends Transporte{

        public Moto() {
            super("Moto");
        }
        @Override
        public String obtenerPremio(){
            return "Recibe de premio un voucher de $50.000 en combustible.";
        }
}
