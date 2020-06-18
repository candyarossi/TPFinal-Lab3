package Main;

import ClasesDePersonas.Empleado;

import ClasesDePersonas.Empleador;
import ClasesDePersonas.Persona;
import Excepciones.ExcepcionDeCampoVacio;
import Json.JsonUtiles;
import ListadosGenericos.Listado;
import java.util.Scanner;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.SoapBindingParameterStyle;



public class Main
{
	static Scanner leer = new Scanner(System.in);
	static Listado<Integer, Persona> empleadores = new Listado<Integer, Persona>();

	public static void main(String[] args)
	{	
		menuPricipal();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
        
        
        
        
        
        
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
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

        
        System.out.println("");
        System.out.println("");
        System.out.println("Guardando archivo");
        Listado.guardarEnArchivo(empleadores);
        
        System.out.println("Leyendo archivo");
        Listado<Integer, Persona> listado = Listado.leerDeArchivo();
        System.out.println(listado.listar());
        
      
        */


       
	}
	
	
	public static void menuPricipal()
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
			Empleador nuevoEmpleador = crearEmpleador();
			empleadores.agregar(nuevoEmpleador.getNroLegajo(), nuevoEmpleador);
			empleadores.guardarEnArchivo(empleadores);
			empleadores.clear();
			
			break;
			
		case 2:
			LimpiarBuffer();
			empleadores.leerDeArchivo();
			String nombre;
			String apellido;
			boolean encontrado = false;
			
			do
			{
				System.out.println("Ingrese primer nombre del empleador:");
				
			} while (  );
			
			
			
			
			
			Empleado nuevoEmpleado = crearEmpleado();
			break;
			
		case 3:
			break;
		}
		
		
	}
	
	private static Persona crearPersona()
	{
		Persona nueva;
		boolean semaforo;
		
		String nombre;
		String apellido;
		StringBuilder cuil = new StringBuilder();
		StringBuilder dni = new StringBuilder();
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
			
			System.out.println("Ingrese primer nombre: ");
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
			
			System.out.println("Ingrese lugar de nacimineto: ");
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
		
		
		
		nueva = new Persona(nombre, apellido, cuil, lugarNacimiento, nacionalidad, direccion, lugarResidencia, telefono, email);
		
		return nueva;
	}
	
	private static Empleador crearEmpleador()
	{
		Persona nueva = crearPersona();
		StringBuilder strBuilderCUIL = new StringBuilder();
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
		
		strBuilderCUIL.append(nueva.getCuil());
		
		Empleador nuevo = new Empleador(nueva.getNombre(), nueva.getApellido(), strBuilderCUIL, nueva.getLugarNacimiento(), nueva.getNacionalidad(), nueva.getDireccion(),
				nueva.getLugarResidencia(), nueva.getTelefono(), nueva.getEmail(), auxActividad);
		
		
		
		
		return nuevo;
	}
	
	private static Empleado crearEmpleado()
	{
		Persona nueva = crearPersona();
		StringBuilder strBuilderCUIL = new StringBuilder();
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
			
			System.out.println("Ingrese fecha de ingreso (dd-mm-aaaa): ");
			auxFechaIngreso = leer.nextLine();
			
			if ( auxFechaIngreso.isEmpty() )
				System.out.println("Debe completar este campo.\n");
		} while (auxFechaIngreso.isEmpty());
		
		strBuilderCUIL.append(nueva.getCuil());
		
		Empleado nuevo = new Empleado(nueva.getNombre(), nueva.getApellido(), strBuilderCUIL, nueva.getLugarNacimiento(), nueva.getNacionalidad(), nueva.getDireccion(),
				nueva.getLugarResidencia(), nueva.getTelefono(), nueva.getEmail(), auxCategoria, auxObraSocial, auxFechaIngreso);
		
		
		
		
		return nuevo;
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
}


	
	
	
	