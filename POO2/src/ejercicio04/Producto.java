package ejercicio04;

public class Producto {
	private String nombre;
	private int stock;
	private double precio;
	public Producto() {
		nombre="pan";
		stock=4;
		precio=0.75;
	}
	public String Supermercado(){
		return "El "+nombre+" solo quedan "+stock+"a un precio de "+precio+" $";
	}
}
