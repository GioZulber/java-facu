package punto2;

public class Auto extends Transporte{

    public Auto() {
        super("Auto");
    }
    @Override
    public String obtenerPremio(){
        return "Recibe de premio un voucher de $50.000 en combustible.";
    }

}
