package ejercicio02;

public class CuentaBancaria {
	private String id;
    private String contrasena;
    private double saldo;
    public CuentaBancaria(String id, String contrasena, double saldoInicial) {
        this.id = id;
        this.contrasena = contrasena;
        this.saldo = saldoInicial;
    }
    public boolean verificarContraseña(String contrasena) {
        return this.contrasena.equals(contrasena);
    }
    public void depositar(double cantidad) {
        saldo += cantidad;
    }
    public boolean retirar(double cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
            return true;
        } else {
            return false;
        }
    }
    public double dame_Saldo() {
        return saldo;
    }
}
