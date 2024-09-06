package clases;

public class CuentaBancaria {
    private int saldo;
    private int cbu;
    private String alias;


    public CuentaBancaria(int saldo, int cbu, String alias) {
        this.saldo = saldo;
        this.cbu = cbu;
        this.alias = alias;
    }

    public void depositar(int monto) {
        this.saldo += monto;
    }

    public void extraer(int monto) {
        if (this.saldo >= monto) {
            this.saldo -= monto;
        }
    }


}
