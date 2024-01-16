package ejercicio03;

public class Estudiante {
	private String nombre;
	private int edad;
	private double calificacion;
	public Estudiante() {
		nombre="Angel";
		edad=19;
		calificacion=7.5;
	}
	public String dame_estudiante() {
		return "El alumno "+nombre+" tiene una edad de "+edad+" años y tiene la nota "+calificacion;
	}
}
