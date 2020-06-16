package Main;

//import java.util.Scanner;
import ClasesDePersonas.Empleado;
import ClasesDePersonas.Empleador;
import Json.JsonUtiles;
import ListadosGenericos.Listado;
import Papeles.Factura;
import Archivos.Archivo;


public class Main {

	public static void main(String[] args) {
		// ZONA DE PRUEBAS

		//Scanner unScan = new Scanner(System.in);
		
		Empleador empleador = new Empleador("Lucas", "Perez", new StringBuilder("20207522334"), "Buenos Aires", "Argentina", "Chacabuco 1312", "Mar del Plata", "487-7741", "lucas@gmail.com", "Ni idea");
		
		System.out.println(empleador.toString());
		
        System.out.println("");
        System.out.println("");
		
        Empleador empleador2 = new Empleador("Lucas", "Perez", new StringBuilder("20207522334"), "Buenos Aires", "Argentina", "Chacabuco 1312", "Mar del Plata", "487-7741", "lucas@gmail.com", "Ni idea");
		
		Empleado empleado1 = new Empleado("Maria", "Garcia",  new StringBuilder("20207522335"), "Balcarce", "Argentina", "nose", "nose", "", "anamaria@hotmail.com", "niides", "Ospedyc", "2018-07-20");
		Empleado empleado2 = new Empleado("Luna", "Garcia",  new StringBuilder("20207522336"), "Balcarce", "Argentina", "nose", "nose", "", "anamaria@hotmail.com", "niides", "", "2020-07-20");

		empleador2.agregarEmpleado(empleado1.getNroLegajo(), empleado1);
		empleador2.agregarEmpleado(empleado2.getNroLegajo(), empleado2);

        System.out.println(empleador2.toString());
		
        System.out.println(empleador2.getNombre());
        
        System.out.println(empleador2.verEmpleados());
        
        System.out.println("");
        System.out.println("Buscado: ");
        System.out.println(empleador2.buscarEmpleado("Garcia", "Luna"));
        
        System.out.println("");
        System.out.println("");

        System.out.println(empleador2.generarRecibos(empleador2, empleado1, 20000, "2020-07-03", "2020-05-01", 25, 5));
        System.out.println(empleador2.generarFactura(empleador2, 357));

        
        System.out.println("");
        System.out.println("");
        System.out.println("Generando JSON de 1 empleador con array empleados:");
        
        System.out.println(empleador2.toJSON().toString());

        Listado<Integer, Empleador> empleadores = new Listado<Integer, Empleador>();
        
        empleadores.agregar(empleador.getNroLegajo(), empleador);
        empleadores.agregar(empleador2.getNroLegajo(), empleador2);
        
        System.out.println("");
        System.out.println("");
        System.out.println("Generando JSON de listado de empleadores");
        
        System.out.println(empleadores.toJSON().toString());

        System.out.println("");
        System.out.println("");
        System.out.println("Guardando archivo JSON...");
        JsonUtiles.grabar(empleadores.toJSON());
        
        System.out.println("");
        System.out.println("");
        System.out.println("Leyendo archivo JSON...");
        System.out.println(JsonUtiles.leer().toString());
        
        System.out.println("");
        System.out.println("\nListado de Empleadores: ");
        System.out.println(empleadores.listar());
        
        /*System.out.println("");
        System.out.println("Guardando en archivo");
        
        System.out.println("");
        System.out.println("Leyendo el archivo");*/
        
        System.out.println("");
        System.out.println("Cantidad empleados: " + empleador2.getCantidadEmpleados());

       
	}
	
	
	
}

	
	
	
	