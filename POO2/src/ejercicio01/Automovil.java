package ejercicio01;

public class Automovil {
	private String marca,modelo;
	
	public Automovil(){
		marca="BMW";
		modelo="m3";
	}
	public String dime_marca() {
		return "Mi coche es un "+marca;
	}
	public String dime_modelo() {
		return "es el modelo "+modelo;
	}
}
