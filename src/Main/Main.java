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
	static final int CASE_SALIDA = 11; // Actualizar esta variable siempre que se agreguen o quiten opciones al menú principal.

	public static void main(String[] args) {
		
		empleadores = Listado.generarListadoDeArchivo();
		
		menuPrincipal();
		
	

		/*
		Empleador nuevo1 = new Empleador("Nahuel", "Trucco", new StringBuilder("20207565334"), "Buenos Aires", "Argentina", "Chacabuco 1312", 
				"Mar del Plata", "487-7741", "lucas@gmail.com", "Ni idea");
		
		Empleador nuevo2 = new Empleador("Nahuel", "Goméz", new StringBuilder("20207565335"), "Buenos Aires", "Argentina", "Chacabuco 1312", 
				"Mar del Plata", "487-7741", "lucas@gmail.com", "Ni idea");
		
		Empleador nuevo3 = new Empleador("Nahuel", "Peréz", new StringBuilder("20207565336"), "Buenos Aires", "Argentina", "Chacabuco 1312", 
				"Mar del Plata", "487-7741", "lucas@gmail.com", "Ni idea");
		
		
		Empleado empleadito = new Empleado("Cande", "Escudero", new StringBuilder("20202002002"), "Buenos Aires", "Argentina", "Chacabuco 1312", 
				"Mar del Plata", "487-7741", "lucas@gmail.com", "Ni idea", "otra", "2020-03-04");
		
		Empleado empleadito2 = new Empleado("Cande", "Margaride", new StringBuilder("20202002003"), "Buenos Aires", "Argentina", "Chacabuco 1312",
				"Mar del Plata", "487-7741", "lucas@gmail.com", "Ni idea", "otra", "2020-03-04");

		
		
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
		//ArrayList<String> array2 = GestorDeArchivos.leerCuils();
		System.out.println("\nLista de nombres de archivos:");
		 
		//for(String str : array2)
			//System.out.println(str);
		 
		
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
		System.out.println(empleadores2.listar()); System.out.println("------");
		
		
		System.out.println("\nAccediendo a un empleado de un empleador recuperado de archivo:");
		String clave = emp3.buscarEmpleado("Escudero", "Cande");
		System.out.println(clave);
		
		JSONArray arrayJ = empleadores2.toJSON(); JsonUtiles.grabar(arrayJ);
		System.out.println("\n\n\nJSON del Listado Completo:"); String json =
		JsonUtiles.leer(); System.out.println(json);
		*/
		

	}

	public static void menuPrincipal() {
		int opcionMenu;

		do {
			banner();

			do {
				opcionMenu = mostrarMenu();
			} while (opcionMenu < 1 && opcionMenu > 10); // Rango de opciones del menu 1...10

			switch (opcionMenu) {
			case 1:
				Empleador nuevoEmpleador = (Empleador) crearPersona(opcionMenu);
				empleadores.agregar(nuevoEmpleador.getNroLegajo(), nuevoEmpleador);
				break;

			case 2:
				// TODO ver método, tiene error.
				case2(opcionMenu);
				// Lo corvertí en un método para limitar la existencia de las variables solo al tiempo de ejecución del método,
				//	y evitar inconvenientes con las mismas, ya que se repetirían o debería usar nombres muy parecidos,
				// 	por ejemplo en los casos de nombre, apellido, buscado, etc
				break;

			case 3:
				case3();
				break;

			case 4:
				case4();
				break;

			case 5:
				System.out.println("\n====================================================================================\n");

				System.out.println("\t\t   Lista de empleadores registrados en el sistema\n\n");
				System.out.println(empleadores.listar());

				System.out.println("\n------------------------------------------------------------------------------------\n");
				break;

			case 6:
				// TODO case GENERAR RECIBOS
				
				break;

			case 7:
				// TODO case GENERAR FACTURAS
				break;
				
			case 8:
				// TODO case GENERAR JSON
				System.out.println("\n====================================================================================\n");
				System.out.println(empleadores.toJSON());
				System.out.println("\n------------------------------------------------------------------------------------\n");
				
				
				break;

			case 9:
				guardarCambios();
				System.out.println("\n====================================================================================");
				System.out.println("\t\t   Los cambios se guardaron correctamente");
				System.out.println("\n------------------------------------------------------------------------------------");
				break;
				
			case 10:
				// TODO case ACERCA DEL SISTEMA
				
				break;

			case CASE_SALIDA:
				guardarCambios();
				
				String confirmacion;
				
				LimpiarBuffer();
				System.out.println("\n====================================================================================\n");
				System.out.println("Confirmar: \n");
				System.out.println("¿Desea salir del sistema?\n");
				System.out.println("Presione S para confirmar, si presiona cualquier otra tecla volverá al menu principal:\n\n");
				confirmacion = leer.nextLine();

				if ( confirmacion.equalsIgnoreCase("S"))
				{
					System.out.println("¡Gracias. Vuelvas prontos!");
					System.out.println("\n------------------------------------------------------------------------------------\n");
				}
				else
				{
					System.out.println("   >> Se ha cancelado la acción.");
					menuPrincipal();
				}
				break;
			}

		} while (opcionMenu != CASE_SALIDA); // CASE_SALIDA contiene el valor de la opción del menú, que da la salida del sistema.

	}

	public static int mostrarMenu() {
		int opcionMenu;

		System.out.println("\n   Elija una opción y luego presione tecla Entrar:");
		System.out.println("");
		System.out.println("\t 1.- Registrar un nuevo empleador");
		System.out.println("\t 2.- Registrar un nuevo empleado");
		System.out.println("\t 3.- Buscar un empleador.");
		System.out.println("\t 4.- Buscar un empleado.");
		System.out.println("\t 5.- Listar empleadores.");
		System.out.println("\t 6.- Generar recibos.");
		System.out.println("\t 7.- Generar factura.");
		System.out.println("\t 8.- Generar Json a partir del listado de empleadores.");
		System.out.println("\t 9.- Guardar cambios en archivo.");
		System.out.println("\t10.- Acerca del sistema.");
		System.out.println("\t" + CASE_SALIDA + ".- Salir.");
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
	
	public static void guardarCambios()
	{
		ArrayList<String> array = empleadores.setNombreArchivosEmpleadores();
		
		Listado.guardarCuils(array);
		empleadores.guardarListadoEnArchivos();
	}
	
	public static void banner() {
		System.out.println("\n====================================================================================\n");

		System.out.println("\t\t\t    Bienvenido a SevenGestión");

		System.out.println("\n------------------------------------------------------------------------------------\n");
	}

	private static void LimpiarBuffer() {
		leer.nextLine();
	}
	
	
	
	
	// ---------------------------------------------- MÉTODOS CASE ----------------------------------------------------- //
	
	
	public static void case2(int opcionMenu) // REGISTRAR UN NUEVO EMPLEADO
	{
		LimpiarBuffer();
		String nombre;
		String apellido;
		Integer claveBuscado;
		
		// TODO ARROJA ERROR ACÁ, NO DESCUBRO PROBLEMA
		System.out.println("Ingrese el nombre de pila del empleador: \n\t(Empleador al que se le añadirán los datos de un nuevo empleado) ");
		nombre = leer.nextLine();
		LimpiarBuffer();
		
		System.out.println("Ingrese el apellido del empleador:");
		apellido = leer.nextLine();
		LimpiarBuffer();
		
		claveBuscado = empleadores.buscar(apellido, nombre);
		
		if ( claveBuscado == null )
			System.out.println("El empleador que usted busca, no está registrado en el sistema");
		else
		{
			System.out.println("Empleador encontrado\n");
			System.out.println("Ingrese los datos del empleado:\n");
			Empleador buscado = (Empleador)empleadores.getEmpleador(claveBuscado);
			Empleado nuevo = (Empleado) crearPersona(opcionMenu);
			buscado.agregarEmpleado(nuevo.getNroLegajo(), nuevo);
			System.out.println("Se asignó a " + nuevo.getNombreCompleto() + " como empleado de " + buscado.getNombreCompleto()+ ".\n");
		}
	}
	
	public static void case3() // BUSCAR UN EMPLEADOR
	{
		LimpiarBuffer();
		
		String nombre;
		String apellido;
		Integer claveBuscado;
		String buscado;
		
		System.out.println("Ingrese el nombre de pila del empleador: ");
		nombre = leer.nextLine();
		LimpiarBuffer();
		
		System.out.println("Ingrese el apellido del empleador:");
		apellido = leer.nextLine();
		LimpiarBuffer();
		
		claveBuscado = empleadores.buscar(apellido, nombre);
		
		if ( claveBuscado != null )
		{
			buscado = empleadores.mostrar(claveBuscado);
			System.out.println(buscado);
		}
		else
		{
			System.out.println("El empleador que usted busca, no está registrado en el sistema");
		}
	}
	
	public static void case4() // BUSCAR UN EMPLEADO
	{
		String nombre;
		String apellido;
		Empleador buscado;
		
		System.out.println("Ingrese el nombre de pila del empleador: ");
		nombre = leer.nextLine();
		LimpiarBuffer();
		
		System.out.println("Ingrese el apellido del empleador:");
		apellido = leer.nextLine();
		LimpiarBuffer();
		
		buscado = empleadores.buscar(apellido, nombre);
		
		if ( buscado == null )
			System.out.println("El empleador que usted busca, no está registrado en el sistema");
		else
		{
			buscado.toString();
		}
	}
}
