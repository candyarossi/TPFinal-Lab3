package Main;

import ClasesDePersonas.Empleado;

import ClasesDePersonas.Empleador;
import ClasesDePersonas.Persona;
import Excepciones.ExcepcionDeCampoVacio;
import Json.JsonUtiles;
import ListadosGenericos.Listado;
import java.util.Scanner;




public class Main
{
	static Scanner leer = new Scanner(System.in);
	static Listado<Integer, Persona> empleadores = new Listado<Integer, Persona>();

	public static void main(String[] args)
	{	
		menuPrincipal();
		
		empleadores.leerDeArchivo();
		System.out.println(empleadores.listar());
		System.out.println("---");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// ZONA DE PRUEBAS ( Hacia abajo )
		
		
		
		/*
		Empleador nahuelEmpleador = new Empleador("Nahuel", "Trucco", new StringBuilder("20207565334"), "Buenos Aires", "Argentina", "Chacabuco 1312", "Mar del Plata", "487-7741", "lucas@gmail.com", "Ni idea");
	
		System.out.println(nahuelEmpleador.toString());
		
		System.out.println("");
        System.out.println("");
		
        Empleado empleadoN = new Empleado("Cosme", "Fulanito",  new StringBuilder("20205522336"), "Balcarce", "Argentina", "nose", "nose", "", "anamaria@hotmail.com", "niides", "", "2020-07-20");
        
        nahuelEmpleador.agregarEmpleado(empleadoN.getNroLegajo(), empleadoN);
        
        System.out.println(nahuelEmpleador.toString());
        System.out.println(nahuelEmpleador.getNombre());
        System.out.println(nahuelEmpleador.verEmpleados());
        
        System.out.println("");
        System.out.println("");
        
        
        System.out.println("Buscado: ");
        System.out.println(nahuelEmpleador.buscarEmpleado("Fulanito", "Cosme"));
        
        System.out.println("");
        System.out.println("");
        
        System.out.println(nahuelEmpleador.generarRecibos(nahuelEmpleador, empleadoN, 20000, "2020-07-03", "2020-05-01", 25, 5));
        
        
        System.out.println("");
        System.out.println("");
        
        
        System.out.println("Generando JSON de 1 empleador con array empleados:");
        System.out.println(nahuelEmpleador.toJSON().toString());

        
        Listado<Integer, Persona> empleadores = new Listado<Integer, Persona>();
        empleadores.agregar(nahuelEmpleador.getNroLegajo(), nahuelEmpleador);
        
        
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
        System.out.println("");
        
        
        System.out.println("Guardando archivo");
        Listado.guardarEnArchivo(empleadores);
        
        System.out.println("Leyendo archivo");
        Listado<Integer, Persona> listado = Listado.leerDeArchivo();
        System.out.println(listado.listar());
        
        
        */

       
	}
	
	 
	 
	public static void menuPrincipal()
	{
		int opcionMenu;
		banner();
		
		System.out.println("\n   Elija una opción:");
		System.out.println("");
		System.out.println("\t1.- Registrar un nuevo empleador");
		System.out.println("\t2.- Registrar un nuevo empleado");
		
		opcionMenu = leer.nextInt();
	
		
		switch (opcionMenu)
		{
			case 1: 
			Empleador nuevoEmpleador = (Empleador) crearPersona(opcionMenu); 
			
			empleadores.leerDeArchivo();
			empleadores.agregar(nuevoEmpleador.getNroLegajo(), nuevoEmpleador);
			empleadores.guardarEnArchivo(empleadores);
			
			//empleadores.clear();
			break;
			
		case 2:
			/*
			LimpiarBuffer();
			empleadores.leerDeArchivo();
			String nombre;
			String apellido;
			boolean encontrado = false;
			
			do
			{
				System.out.println("Ingrese primer nombre del empleador:");
				
			} while (  );
			
			
			Empleado nuevoEmpleado = crearPersona(opcionMenu);
			
			*/
			
			break;
			
		case 3:
			break;
		}
		
		
	}
	
	


	public static void banner()
	{
		System.out.println("\n====================================================================================\n");
		
		System.out.println("\t\t\t    Bienvenido a SevenGestión");
		
		System.out.println("\n------------------------------------------------------------------------------------\n");
	}
	

	private static void LimpiarBuffer()
	{
		leer.nextLine();
	}
	
	
	private static Persona crearPersona(int opcionMenu)
	{
		Persona nueva = null;
		boolean semaforo;
		String nombre;
		String apellido;
		StringBuilder cuil = new StringBuilder();
		String lugarNacimiento;
		String nacionalidad;
		String direccion;
		String lugarResidencia;
		String telefono;
		String email;
		
		
		// NOMBRE
		do
		{
			LimpiarBuffer();
			
			System.out.println("Ingrese nombre: ");
			nombre = leer.nextLine();
			
			try
			{
				if ( nombre.isEmpty() )
						throw new ExcepcionDeCampoVacio();
						// Excepción forzada para demostar funcionamiento
			}
			catch(ExcepcionDeCampoVacio e)
			{
				System.out.println("Debe completar este campo.\n");
			}
		} while (nombre.isEmpty());
		
		// APEllIDO
		do
		{
			LimpiarBuffer();
			
			System.out.println("Ingrese apellido: ");
			apellido = leer.nextLine();
			
			try
			{
				if ( apellido.isEmpty() )
						throw new ExcepcionDeCampoVacio();
						// Excepción forzada para demostar funcionamiento
			}
			catch(ExcepcionDeCampoVacio e)
			{
				System.out.println("Debe completar este campo.\n");
			}
		} while (apellido.isEmpty());
		
		// CUIL
		do
		{
			LimpiarBuffer();
			semaforo = false;
			String auxCUIL;
					
			System.out.println("Ingrese CUIL: ");
			auxCUIL = leer.nextLine();
					
			try
			{
				if ( auxCUIL.isEmpty() )
						throw new ExcepcionDeCampoVacio();
						// Excepción forzada para demostar funcionamiento
				else
				{
					cuil.append(auxCUIL);
					semaforo = true;
				}
			}
			catch(ExcepcionDeCampoVacio e)
			{
				System.out.println("Debe completar este campo.\n");
			}
		} while (!semaforo);
		

		// LUGAR DE NACIMIENTO
		do
		{
			LimpiarBuffer();
			
			System.out.println("Ingrese lugar de nacimiento: ");
			lugarNacimiento = leer.nextLine();
			
			if ( lugarNacimiento.isEmpty() )
				System.out.println("Debe completar este campo.\n");
		} while (lugarNacimiento.isEmpty());
		
		
		// NACIONALIDAD
		do
		{
			LimpiarBuffer();
			
			System.out.println("Ingrese nacionalidad: ");
			nacionalidad = leer.nextLine();
			
			if ( nacionalidad.isEmpty() )
				System.out.println("Debe completar este campo.\n");
		} while (nacionalidad.isEmpty());
		
		
		// DIRECCION
		do
		{
			LimpiarBuffer();
			
			System.out.println("Ingrese dirección: ");
			direccion = leer.nextLine();
			
			if ( direccion.isEmpty() )
				System.out.println("Debe completar este campo.\n");
		} while (direccion.isEmpty());
		
				
		// LUGAR DE RESIDENCIA
		do
		{
			LimpiarBuffer();
			
			System.out.println("Ingrese lugar de residencia: ");
			lugarResidencia = leer.nextLine();
			
			if ( lugarResidencia.isEmpty() )
				System.out.println("Debe completar este campo.\n");
		} while (lugarResidencia.isEmpty());
	
				
		// TELEFONO
		do
		{
			LimpiarBuffer();
			
			System.out.println("Ingrese teléfono: ");
			telefono = leer.nextLine();
			
			if ( telefono.isEmpty() )
				System.out.println("Debe completar este campo.\n");
		} while (telefono.isEmpty());
				
		// E-MAIL
		do
		{
			LimpiarBuffer();
			
			System.out.println("Ingrese e-mail: ");
			email = leer.nextLine();
			
			if ( email.isEmpty() )
				System.out.println("Debe completar este campo.\n");
		} while (email.isEmpty());
		
		switch (opcionMenu) 
		{
			case 1: 
					nueva = new Empleador();
					nueva = crearEmpleador(nombre, apellido, cuil, lugarNacimiento, nacionalidad, direccion, lugarResidencia, telefono, email);
					break;
			case 2:
					nueva = new Empleado();
					nueva = crearEmpleado(nombre, apellido, cuil, lugarNacimiento, nacionalidad, direccion, lugarResidencia, telefono, email);
					break;
		}
		
		return nueva;
		
	}
	
	private static Empleador crearEmpleador(String nombre, String apellido, StringBuilder cuil, String lugarNacimiento, String nacionalidad, String direccion, String lugarResidencia, String telefono, String email)
	{
		String auxActividad;
		
		// ACTIVIDAD
		do
		{
			LimpiarBuffer();
			
			System.out.println("Ingrese actividad: ");
			auxActividad = leer.nextLine();
			
			if ( auxActividad.isEmpty() )
				System.out.println("Debe completar este campo.\n");
		} while (auxActividad.isEmpty());
		
		Empleador nuevo = new Empleador(nombre, apellido, cuil, lugarNacimiento, nacionalidad, direccion, lugarResidencia, telefono, email, auxActividad);
		
		return nuevo;
	}
	
	private static Empleado crearEmpleado(String nombre, String apellido, StringBuilder cuil, String lugarNacimiento, String nacionalidad, String direccion, String lugarResidencia, String telefono, String email)
	{
		String auxCategoria;
		String auxObraSocial;
		String auxFechaIngreso;
		
		
		// CATEGORIA
		do
		{
			LimpiarBuffer();
			
			System.out.println("Ingrese categoría: ");
			auxCategoria = leer.nextLine();
			
			if ( auxCategoria.isEmpty() )
				System.out.println("Debe completar este campo.\n");
		} while (auxCategoria.isEmpty());
		
		
		
		//  OBRA SOCIAL
		do
		{
			LimpiarBuffer();
			
			System.out.println("Ingrese obra social: ");
			auxObraSocial = leer.nextLine();
			
			if ( auxObraSocial.isEmpty() )
				System.out.println("Debe completar este campo.\n");
		} while (auxObraSocial.isEmpty());
		
		
		// FECHA DE INGRESO
		do
		{
			LimpiarBuffer();
			
			System.out.println("Ingrese fecha de ingreso (aaaa-mm-dd): ");
			auxFechaIngreso = leer.nextLine();
			
			if ( auxFechaIngreso.isEmpty() )
				System.out.println("Debe completar este campo.\n");
		} while (auxFechaIngreso.isEmpty());
		
		
		Empleado nuevo = new Empleado(nombre, apellido, cuil, lugarNacimiento, nacionalidad, direccion, lugarResidencia, telefono, email, auxCategoria, auxObraSocial, auxFechaIngreso);
		
		
		return nuevo;
	}



	
	
	
	
}


	
	
	
	