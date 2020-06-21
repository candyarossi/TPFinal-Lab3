package Main;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.json.JSONArray;

import Archivos.GestorDeArchivos;

import java.util.Map.Entry;

import ClasesDePersonas.Empleado;
import ClasesDePersonas.Empleador;
import ClasesDePersonas.Persona;
import Excepciones.ExcepcionDeCampoVacio;
import Json.JsonUtiles;
import ListadosGenericos.Listado;


public class Main {
	
	static Scanner leer = new Scanner(System.in);
	static Listado<Integer, Empleador> empleadores = new Listado<Integer, Empleador>();

	public static void main(String[] args)
	{
		
		
		/*
		Empleador nuevo1 = new Empleador("Nahuel", "Trucco", new StringBuilder("20207565334"), "Buenos Aires", "Argentina", "Chacabuco 1312", "Mar del Plata", "487-7741", "lucas@gmail.com", "Ni idea");
		Empleador nuevo2 = new Empleador("Nahuel", "Goméz", new StringBuilder("20207565334"), "Buenos Aires", "Argentina", "Chacabuco 1312", "Mar del Plata", "487-7741", "lucas@gmail.com", "Ni idea");
		Empleador nuevo3 = new Empleador("Nahuel", "Peréz", new StringBuilder("20207565334"), "Buenos Aires", "Argentina", "Chacabuco 1312", "Mar del Plata", "487-7741", "lucas@gmail.com", "Ni idea");

		
		empleadores.agregar(nuevo1.getNroLegajo(), nuevo1);
		empleadores.agregar(nuevo2.getNroLegajo(), nuevo2);
		empleadores.agregar(nuevo3.getNroLegajo(), nuevo3);
		
		System.out.println(empleadores.listar());
		
		System.out.println("guardar\n");
		Listado.guardarEnArchivo(empleadores);
		System.out.println("Guardo? \n");
		*/
		
		Empleador nuevo1 = new Empleador("Nahuel", "Trucco", new StringBuilder("20207565334"), "Buenos Aires", "Argentina", "Chacabuco 1312", "Mar del Plata", "487-7741", "lucas@gmail.com", "Ni idea");
		Empleador nuevo2 = new Empleador("Nahuel", "Goméz", new StringBuilder("20207565335"), "Buenos Aires", "Argentina", "Chacabuco 1312", "Mar del Plata", "487-7741", "lucas@gmail.com", "Ni idea");
		Empleador nuevo3 = new Empleador("Nahuel", "Peréz", new StringBuilder("20207565336"), "Buenos Aires", "Argentina", "Chacabuco 1312", "Mar del Plata", "487-7741", "lucas@gmail.com", "Ni idea");

		Empleado empleadito = new Empleado("Cande", "Escudero", new StringBuilder("20202002002"), "Buenos Aires", "Argentina", "Chacabuco 1312", "Mar del Plata", "487-7741", "lucas@gmail.com", "Ni idea", "otra", "2020-03-04");
		Empleado empleadito2 = new Empleado("Cande", "Margaride", new StringBuilder("20202002003"), "Buenos Aires", "Argentina", "Chacabuco 1312", "Mar del Plata", "487-7741", "lucas@gmail.com", "Ni idea", "otra", "2020-03-04");

		
		nuevo2.agregarEmpleado(empleadito.getNroLegajo(), empleadito);
		nuevo2.agregarEmpleado(empleadito2.getNroLegajo(), empleadito2);

		
		empleadores.agregar(nuevo1.getNroLegajo(), nuevo1);
		empleadores.agregar(nuevo2.getNroLegajo(), nuevo2);
		empleadores.agregar(nuevo3.getNroLegajo(), nuevo3);
		
		System.out.println("Listado de empleados antes de guardar:");

		System.out.println(empleadores.listar());
		
		System.out.println("Guardando...\n");
		
		ArrayList<String> array = empleadores.setNombreArchivosEmpleadores();
		
		Listado.guardarCuils(array);
		
		empleadores.guardarListadoEnArchivos();
		
		System.out.println("Leyendo...");
		
		Listado<Integer, Empleador> empleadores2 = Listado.generarListadoDeArchivo();
				
		ArrayList<String> array2 = GestorDeArchivos.leerCuils();
		
		System.out.println("\nLista de nombres de archivos:");
		
		for(String str : array2)
		{
			System.out.println(str);
		}

		System.out.println("\nPrueba de leer un archivo en especial 1:");

		Empleador emp2 = GestorDeArchivos.leerEmpleador("20-20756533-6.dat");
		
		System.out.println(emp2.toString());
		
		System.out.println("\nPrueba de leer un archivo en especial 2:");
		
		Empleador emp3 = GestorDeArchivos.leerEmpleador("20-20756533-5.dat");
		
		System.out.println(emp3.toString());
		
		System.out.println("\nPrueba de leer un archivo en especial 3:");
		
		Empleador emp4 = GestorDeArchivos.leerEmpleador("20-20756533-4.dat");
		
		System.out.println(emp4.toString());
		
		System.out.println("------");
		System.out.println("Listado luego de la recuperacion:");
		System.out.println(empleadores2.listar());
		System.out.println("------");

		System.out.println("\nAccediendo a un empleado de un empleador recuperado de archivo:");

		String clave = emp3.buscarEmpleado("Escudero", "Cande");
		System.out.println(clave);
		
		
		JSONArray arrayJ = empleadores2.toJSON();
		JsonUtiles.grabar(arrayJ);
		
		System.out.println("\n\n\nJSON del Listado Completo:");
		String json = JsonUtiles.leer();
		System.out.println(json);

		
		/*
		Integer claveBuscado = empleadores.buscar("Peréz", "Nahuel");
		
		String bajado = empleadores.mostrar(claveBuscado);
		
		System.out.println(bajado);
		*/
		
	
		
		
		
		
		
		
		
		
		
		
		
	
		
		
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

	public static void menuPrincipal() {
		int opcionMenu;

		banner();
		opcionMenu = mostrarMenu();

		switch (opcionMenu)
		{
			case 1:
				Empleador nuevoEmpleador = (Empleador) crearPersona(opcionMenu);

				//Comento porque tira errores, ya no se llaman asi las funciones ni funcionan igual. 
				//empleadores.leerDeArchivo();
				//empleadores.agregar(nuevoEmpleador.getNroLegajo(), nuevoEmpleador);
				//empleadores.guardarEnArchivo(empleadores);

				// TODO terminar case
				// empleadores.clear();
				break;

			case 2:
				// TODO case
				//LimpiarBuffer(); empleadores.leerDeArchivo(); String nombre; String apellido;
				//boolean encontrado = false;
				 
				//do
				//{
				//	System.out.println("Ingrese primer nombre del empleador:");
			 
			 	//} while ( );
			 	
			 	//Empleado nuevoEmpleado = crearPersona(opcionMenu);
				break;

			case 3:
				// TODO case
				break;
			
			case 4:
				// TODO case
				break;
			
			case 5:
				// TODO case
				break;
		
			case 6:
				// TODO case
				break;
	
			case 7:
				// TODO case
				break;
			
			case 8:
				// TODO case
				break;
		}

	}

	public static int mostrarMenu() {
		int opcionMenu;

		System.out.println("\n   Elija una opción:");
		System.out.println("");
		System.out.println("\t1.- Registrar un nuevo empleador");
		System.out.println("\t2.- Registrar un nuevo empleado");
		System.out.println("\t3.- Buscar un empleador.");
		System.out.println("\t4.- Listar empleadores.");
		System.out.println("\t5.- Generar recibos.");
		System.out.println("\t6.- Generar factura.");
		System.out.println("\t7.- Generar Json de archivo de empleadores.");
		System.out.println("\t8.- Acerca del sistema.");
		opcionMenu = leer.nextInt();

		return opcionMenu;
	}

	private static Persona crearPersona(int opcionMenu) {
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
		do {
			LimpiarBuffer();
			
			System.out.println("Ingrese nombre: ");
			nombre = leer.nextLine();

			try {
				if (nombre.isEmpty())
					throw new ExcepcionDeCampoVacio();
				// Excepción forzada para demostar funcionamiento
			} catch (ExcepcionDeCampoVacio e) {
				System.out.println("Debe completar este campo.\n");
			}
		} while (nombre.isEmpty());

		// APEllIDO
		do {
			LimpiarBuffer();

			System.out.println("Ingrese apellido: ");
			apellido = leer.nextLine();

			try {
				if (apellido.isEmpty())
					throw new ExcepcionDeCampoVacio();
				// Excepción forzada para demostar funcionamiento
			} catch (ExcepcionDeCampoVacio e) {
				System.out.println("Debe completar este campo.\n");
			}
		} while (apellido.isEmpty());

		// CUIL
		do {
			LimpiarBuffer();
			semaforo = false;
			String auxCUIL;

			System.out.println("Ingrese CUIL (sin guiones): ");
			auxCUIL = leer.nextLine();

			try {
				if (auxCUIL.isEmpty())
					throw new ExcepcionDeCampoVacio();
				// Excepción forzada para demostar funcionamiento
				else {
					cuil.append(auxCUIL);
					semaforo = true;
				}
			} catch (ExcepcionDeCampoVacio e) {
				System.out.println("Debe completar este campo.\n");
			}
		} while (!semaforo);

		// LUGAR DE NACIMIENTO
		do {
			LimpiarBuffer();

			System.out.println("Ingrese lugar de nacimiento: ");
			lugarNacimiento = leer.nextLine();

			if (lugarNacimiento.isEmpty())
				System.out.println("Debe completar este campo.\n");
		} while (lugarNacimiento.isEmpty());

		// NACIONALIDAD
		do {
			LimpiarBuffer();

			System.out.println("Ingrese nacionalidad: ");
			nacionalidad = leer.nextLine();

			if (nacionalidad.isEmpty())
				System.out.println("Debe completar este campo.\n");
		} while (nacionalidad.isEmpty());

		// DIRECCION
		do {
			LimpiarBuffer();

			System.out.println("Ingrese dirección: ");
			direccion = leer.nextLine();

			if (direccion.isEmpty())
				System.out.println("Debe completar este campo.\n");
		} while (direccion.isEmpty());

		// LUGAR DE RESIDENCIA
		do {
			LimpiarBuffer();

			System.out.println("Ingrese lugar de residencia: ");
			lugarResidencia = leer.nextLine();

			if (lugarResidencia.isEmpty())
				System.out.println("Debe completar este campo.\n");
		} while (lugarResidencia.isEmpty());

		// TELEFONO
		do {
			LimpiarBuffer();

			System.out.println("Ingrese teléfono: ");
			telefono = leer.nextLine();

			if (telefono.isEmpty())
				System.out.println("Debe completar este campo.\n");
		} while (telefono.isEmpty());

		// E-MAIL
		do {
			LimpiarBuffer();

			System.out.println("Ingrese e-mail: ");
			email = leer.nextLine();

			if (email.isEmpty())
				System.out.println("Debe completar este campo.\n");
		} while (email.isEmpty());

		switch (opcionMenu) {
		case 1:
			nueva = new Empleador();
			nueva = crearEmpleador(nombre, apellido, cuil, lugarNacimiento, nacionalidad, direccion, lugarResidencia,
					telefono, email);
			break;
		case 2:
			nueva = new Empleado();
			nueva = crearEmpleado(nombre, apellido, cuil, lugarNacimiento, nacionalidad, direccion, lugarResidencia,
					telefono, email);
			break;
		}

		return nueva;

	}

	private static Empleador crearEmpleador(String nombre, String apellido, StringBuilder cuil, String lugarNacimiento,
			String nacionalidad, String direccion, String lugarResidencia, String telefono, String email) {
		String auxActividad;

		// ACTIVIDAD
		do {
			LimpiarBuffer();

			System.out.println("Ingrese actividad: ");
			auxActividad = leer.nextLine();

			if (auxActividad.isEmpty())
				System.out.println("Debe completar este campo.\n");
		} while (auxActividad.isEmpty());

		Empleador nuevo = new Empleador(nombre, apellido, cuil, lugarNacimiento, nacionalidad, direccion,
				lugarResidencia, telefono, email, auxActividad);

		return nuevo;
	}

	private static Empleado crearEmpleado(String nombre, String apellido, StringBuilder cuil, String lugarNacimiento,
			String nacionalidad, String direccion, String lugarResidencia, String telefono, String email) {
		String auxCategoria;
		String auxObraSocial;
		String auxFechaIngreso;

		// CATEGORIA
		do {
			LimpiarBuffer();

			System.out.println("Ingrese categoría: ");
			auxCategoria = leer.nextLine();

			if (auxCategoria.isEmpty())
				System.out.println("Debe completar este campo.\n");
		} while (auxCategoria.isEmpty());

		// OBRA SOCIAL
		do {
			LimpiarBuffer();

			System.out.println("Ingrese obra social: ");
			auxObraSocial = leer.nextLine();

			if (auxObraSocial.isEmpty())
				System.out.println("Debe completar este campo.\n");
		} while (auxObraSocial.isEmpty());

		// FECHA DE INGRESO
		do {
			LimpiarBuffer();

			System.out.println("Ingrese fecha de ingreso (aaaa-mm-dd): ");
			auxFechaIngreso = leer.nextLine();

			if (auxFechaIngreso.isEmpty())
				System.out.println("Debe completar este campo.\n");
		} while (auxFechaIngreso.isEmpty());

		Empleado nuevo = new Empleado(nombre, apellido, cuil, lugarNacimiento, nacionalidad, direccion, lugarResidencia,
				telefono, email, auxCategoria, auxObraSocial, auxFechaIngreso);

		return nuevo;
	}

	public static void banner() {
		System.out.println("\n====================================================================================\n");

		System.out.println("\t\t\t    Bienvenido a SevenGestión");

		System.out.println("\n------------------------------------------------------------------------------------\n");
	}

	private static void LimpiarBuffer() {
		leer.nextLine();
	}
}
