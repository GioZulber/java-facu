package punto2;

public class Colectivo extends Transporte{

    public Colectivo() {
        super("Colectivo");
    }
    @Override
    public String obtenerPremio(){
        return "Recibe de premio un voucher de $80.000 en la tarjeta SUBE.";
    }

}
