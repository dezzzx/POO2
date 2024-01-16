package ejercicio02;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
public class uso_CuentaBancaria {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, CuentaBancaria> cuentas = new HashMap<>();
        cuentas.put("usuario1", new CuentaBancaria("usuario1", "clave123", 1000));
        cuentas.put("usuario2", new CuentaBancaria("usuario2", "messi10", 500));
        String usuarioinicial = null;
        double cantidad = 0;
        boolean continuar=true;
        int opcion=0;
        while(continuar) {
        	if(usuarioinicial==null) {
        		try {
        		System.out.println("Por favor seleccione una opcion 1-Crear Cuenta 2-Inicio Sesion 3-Salir");
        		
        		opcion= scanner.nextInt();
        		} catch (InputMismatchException e) {
        			System.out.println("Formato incorrecto");
        			scanner.next(); 
                    continue;
        		}
        		switch(opcion) {
        			case 1:
        				System.out.println("Ingrese un nuevo ID de cuenta: ");
        				scanner.nextLine();
        				String nuevoId = scanner.nextLine();

        				if (cuentas.containsKey(nuevoId)) {
        				    System.out.println("El ID de cuenta ya está en uso. Operación cancelada.");
        				   
        				} else {
        				    System.out.println("Ingrese una nueva contraseña: ");
        				    String nuevaContrasena = scanner.nextLine();

                                
                                double saldoInicial = 0;
                                

                                cuentas.put(nuevoId, new CuentaBancaria(nuevoId, nuevaContrasena, saldoInicial));
                                System.out.println("Cuenta creada con éxito. Ahora puede iniciar sesión.");
                            }
                            break;
        			case 2:
        				System.out.println("Ingrese su ID de cuenta: ");
        				scanner.nextLine();
        		        String idCuenta = scanner.nextLine();
        		        System.out.println("Ingrese su contraseña: ");
        		        String contrasena = scanner.nextLine();

        		        if (cuentas.containsKey(idCuenta) && cuentas.get(idCuenta).verificarContraseña(contrasena)) {
        		        	boolean sesionActiva = true;
        		        	while(sesionActiva) {
        		        		try {
        		        	System.out.println("Seleccione una opcion : 1-Ingresar 2-Retirar 3-Consultar Saldo 4-Cerrar Sesion 5-Salir");
        		        	opcion = scanner.nextInt();
        		        		} catch (InputMismatchException e) {
        		        			System.out.println("Formato incorrecto");
        		        			scanner.next(); 
        		                    continue;
        		        		}
        		        	switch(opcion) {
        		        	case 1:
        		        		 try {
        		        		 System.out.println("Ingrese la cantidad a depositar. ");
        		        	        cantidad = scanner.nextDouble();
        		        		 } catch (InputMismatchException e) {
        		        			 System.out.println("Formato incorrecto");
        		        			 scanner.next(); 
        		                     continue;
        		        		 }
        		        	        if(cantidad<0) {
        		        	        	System.out.println("Cantidad invalida introduce una cantidad positiva no negativa");
        		        	        }else {
        		        	        cuentas.get(idCuenta).depositar(cantidad);
        		        	        System.out.println("Depósitando... ");
        		        	        System.out.println("Depósito exitoso");
        		        	        System.out.println("Nuevo saldo: " + cuentas.get(idCuenta).dame_Saldo());
        		        	        }
        		        	        break;
        		        	case 2:   
        		        		try {
        		        		
        		        		
        		        			System.out.println("¿Cuanto dinero desea retirar?");
        		        			
        		        				cantidad = scanner.nextDouble();
        		        		} catch (InputMismatchException e) {
        		        			System.out.println("Formato incorrecto");
        		        			scanner.next(); 
        		                    continue;
        		        		}
        		                
        		        			if (cuentas.get(idCuenta).retirar(cantidad)) {
        		        				System.out.println("Retirando...");
        		                    	System.out.println("Retiro exitoso");
        		                    	System.out.println("Saldo: " + cuentas.get(idCuenta).dame_Saldo());
        		        			} else {
        		        				System.out.println("Saldo insuficiente. Operación cancelada.");
        		        			}
        		        			break;
        		        	case 3:
        		        		System.out.println("Saldo actual es: " + cuentas.get(idCuenta).dame_Saldo());
        		        		break;
        		        	case 4:
        		        		System.out.println("Cerrando Sesion..");
        		        		System.out.println("Cierre de sesión exitoso para la cuenta: " + idCuenta);
        	                    sesionActiva=false;
        	                    break;
        		        	case 5:
        		        		System.out.println("Programa finalizado");
        	                    sesionActiva=false;
        	                    continuar=false;
        	                    break;
        	                default:
        	                    System.out.println("Opción no válida. Inténtelo de nuevo.");
        		        	}
        		        	}
        		        } else {
        		            System.out.println("Credenciales incorrectas. Operación cancelada.");
        		        }
        		        break;
        			case 3:
        				System.out.println("Programa  finalizado");
                        continuar= false;
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
        				
        		}
        		
        		
        	}
        }
	scanner.close();

	}

}
