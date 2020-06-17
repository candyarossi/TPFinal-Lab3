package Main;

//import java.util.Scanner;
import ClasesDePersonas.Empleado;
import ClasesDePersonas.Empleador;
import ClasesDePersonas.Persona;
import Json.JsonUtiles;
import ListadosGenericos.Listado;
import java.util.Scanner;


public class Main
{
	Scanner leer = new Scanner(System.in);

	public static void main(String[] args)
	{
		// ZONA DE PRUEBAS

		//Scanner unScan = new Scanner(System.in);
		
		
		
		/*
		Empleador testN = new Empleador("Nahuel", "Trucco", new StringBuilder("20502315405"), "Mar del Plata", "Argentino", "Calle 1234", "Mar del Plata", "+542236338083", "test@n.com", "Algo");
		
		System.out.println(testN.getArchivoEmpleados());
		// Mostró esto: 50.231.540.dat
		// Suficiente para mi(?
		// Esto quiere decir que cada vez que se registra un nuevo empleador, automaticamente se genera el String que será el nombre de su archivo de empleados.
		// Y queda guardado en el atributo archivoEmpleados, que no estoy muy seguro de ponerlo en mayusculas, porque no es del todo una constante, pero casi,
		// Ya que una vez que se genera ese nombre de archivo, no se debería cambiar nunca más
		// Ahora tengo que trabajar esto desde GestorDeArchivos
		
		
		
		*/
		
		
		
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

        Listado<Integer, Persona> empleadores = new Listado<Integer, Persona>();
        
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
        
       /* System.out.println("");
        System.out.println("\nListado de Empleadores: ");
        System.out.println(empleadores.listar());
        
        /*System.out.println("");
        System.out.println("Guardando en archivo");
        
        System.out.println("");
        System.out.println("Leyendo el archivo");
        
        System.out.println("");
        System.out.println("Cantidad empleados: " + empleador2.getCantidadEmpleados());
        
        */

       
        System.out.println("");
        System.out.println("");
        System.out.println("Guardando archivo");
        Listado.guardarEnArchivo(empleadores);
        
        System.out.println("Leyendo archivo");
        Listado<Integer, Persona> listado = Listado.leerDeArchivo();
        System.out.println(listado.listar());


       
	}
	
	
}

	
	
	
	