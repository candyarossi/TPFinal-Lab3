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
import Papeles.Factura;
import Papeles.Recibo;
import appData.DatosDelSistema;

public class Main {

	static Scanner leer = new Scanner(System.in);
	static Listado<Integer, Empleador> empleadores = new Listado<Integer, Empleador>();
	static final int CASE_SALIDA = 11; // Actualizar esta variable siempre que se agreguen o quiten opciones al menú principal.

	public static void main(String[] args)
	{
		
		Main.generarDatosGenericos();
		
//		empleadores = Listado.generarListadoDeArchivo();
		
		menuPrincipal();
		

		

	}

	/**
	 * <p><b><i>menuPrincipal</i></b></p>
	 * <pre>public static void menuPrincipal()</pre>
	 * <p>Contiene el <code>switch</c> que construye el menu principal del sistema, solo dejará de 
	 * ejecutarse cuando el usuario ingrese un valor igual al almacenado en <code>CASE_SALIDA</code></p>
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
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
				case2(opcionMenu);
				// Lo corvertí en un método para limitar la existencia de las variables solo al tiempo de ejecución del método,
				//	y evitar inconvenientes con las mismas, ya que se repetirían o debería usar nombres muy parecidos,
				// 	por ejemplo en los casos de nombre, apellido, buscado, etc
				break;

			case 3:
				Empleador buscado = buscarEmpleador();
				
				if ( buscado != null )
					System.out.println(buscado.toString());
				else
					System.out.println("El empleador que usted busca, no está registrado en el sistema");
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
				case6();
				break;

			case 7:
				LimpiarBuffer();
				
				Empleador empleador;
				double costo = -1;
				Factura factura;
				
				System.out.println("Generar factura:\n");
				System.out.println("Tiene que indicar el empleador del cual quiere imprimir su factura.");
				
				empleador =  buscarEmpleador();
				
				if ( empleador == null )
					System.out.println("El empleador que usted busca, no está registrado en el sistema");
				else
				{
					do {
						System.out.println("Ingrese el costo por recibo para este empleador: ");
						costo = leer.nextDouble();
						
						if ( costo < 0 )
							System.out.println("\t >> Debe ingresar datos.\n");
					} while (costo < 0);
					
					factura = new Factura(empleador, costo);
					System.out.println(factura.imprimirFactura());
				}
				break;
				
			case 8:
				System.out.println("\n====================================================================================\n");
				System.out.println(empleadores.toJSON());
				System.out.println("\n------------------------------------------------------------------------------------\n");
				
				
				break;

			case 9:
				DatosDelSistema.guardarDatos();
				guardarCambios();
				System.out.println("\n====================================================================================");
				System.out.println("\n\t\t   Los cambios se guardaron correctamente");
				System.out.println("\n------------------------------------------------------------------------------------");
				break;
				
			case 10:
				acercaDelSistema();   
				break;

			case CASE_SALIDA:
				DatosDelSistema.guardarDatos();
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
				
			default:
				System.out.println("\n\t >> Opción invalida");
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
		System.out.println("\t 6.- Generar recibo.");
		System.out.println("\t 7.- Generar factura.");
		System.out.println("\t 8.- Generar Json a partir del listado de empleadores.");
		System.out.println("\t 9.- Guardar cambios en archivo.");
		System.out.println("\t10.- Acerca del sistema.");
		System.out.println("\t" + CASE_SALIDA + ".- Salir.");
		opcionMenu = leer.nextInt();

		return opcionMenu;
	}

	/**
	 * <p><b><i>crearPersona</i></b></p>
	 * <pre>private static Persona crearPersona(int opcionMenu)</pre>
	 * <p>Crea una <code>Persona (Empleaador o Empleado</code> dependiendo de la opción elegida por el usuario.</p>
	 * @param opcionMenu Recibe la opcion escojida por el usuario, puede ser 1 o 2
	 * @return Retorna un <code>Persona</code> que contendrá un <code>Empleador</code> o un <code>Empleador</code>
	 * -gracias al método de sustitución- según la opción elegida por usuario.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
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
	
	/**
	 * <p><b><i>buscarEmpleador</i></b></p>
	 * <pre>public static Empleador buscarEmpleador()</pre>
	 * @return Retorna un <code>Empleador</code> buscado por el usuario o <code>null</code> si no existe.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public static Empleador buscarEmpleador()
	{
	LimpiarBuffer();
	
	String nombre = "";
	String apellido = "";
	Integer claveEmpleador = null;
	Empleador empleador = null;
	
	while ( nombre.isEmpty() )
	{
		System.out.println("Ingrese el nombre de pila del empleador: ");
		nombre = leer.nextLine();
		LimpiarBuffer();
		
		if ( nombre.isEmpty() )
			System.out.println("\t >> Debe ingresar datos.\n");
			
	}
	
	while ( apellido.isEmpty() )
	{
		System.out.println("Ingrese el apellido del empleador:");
		apellido = leer.nextLine();
		LimpiarBuffer();
		
		if ( apellido.isEmpty() )
			System.out.println("\t >> Debe ingresar datos.\n");
	}
		
	claveEmpleador = empleadores.buscar(apellido, nombre);
	
	if ( claveEmpleador != null )
	{
		empleador = empleadores.getEmpleador(claveEmpleador);
	}
	
	return empleador;
}
	
	/**
	 * <p><b><i>buscarEmpleador</i></b></p>
	 * <pre>public static Empleador buscarEmpleador()</pre>
	 * @return Retorna un <code>Empleador</code> buscado por el usuario o <code>null</code> si no existe.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
public static Empleado buscarEmpleado(Empleador empleador)
{	
	 String nombre = "";
	String apellido = "";
//	Integer claveEmpleado;
	Empleado empleado = null;
	
	while ( nombre.isEmpty() )
	{
		System.out.println("Ingrese el nombre de pila del empleado: ");
		nombre = leer.nextLine();
		LimpiarBuffer();
		
		if ( nombre.isEmpty() )
			System.out.println("\t >> Debe ingresar datos.\n");
	}
	
	while ( apellido.isEmpty() )
	{
		System.out.println("Ingrese el apellido del empleado:");
		apellido = leer.nextLine();
		LimpiarBuffer();
		
		if ( apellido.isEmpty() )
			System.out.println("\t >> Debe ingresar datos.\n");
	}
	
	// PRUEBA DE SOBRECARGA DEL METODO buscarEmpleado() de la clase Empleador.
//	 claveEmpleado = empleados.buscar(apellido, nombre);
//	 empleado = empleador.buscarEmpleado(claveEmpleado);
			
	empleado = empleador.buscarEmpleado(apellido, nombre);
	
	
	return empleado;
}


public static String formarPeriodo()
{
	String periodo = "";

	while ( periodo.isEmpty() )
	{
		System.out.println("Ingrese la fecha de pago (aaaa-mm): ");
		periodo = leer.nextLine();
		LimpiarBuffer();
		
		if ( periodo.isEmpty() )
			System.out.println("\t >> Debe ingresar datos.\n");
	}
	
	return periodo + "-01";
}
	
	public static void banner() {
		System.out.println("\n====================================================================================\n");

		System.out.println("\t\t\t    Bienvenido a SevenGestión");

		System.out.println("\n------------------------------------------------------------------------------------\n");
	}
	
	public static void acercaDelSistema()
	{
		System.out.println("SevenGestión v1.0");
		System.out.println("");
		System.out.println("");
		System.out.println("\t> SevenGestión es el Trabajo Final de Laboratorio de Computación 3. ");
		System.out.println("\n\t\t>> Diseñado y desarrollado por Candela Yarossi y Nahuel Truco.");
		System.out.println("\n\t> Es un sistema de gestión contable generador de recibos de sueldo y facturación" 
						   + "\t  de gastos administrativos en base a datos de empleadores y sus empleados.");
		System.out.println("");
		System.out.println("\tUltima revisión: Viernes 3 de Julio de 2020");
	}

	private static void LimpiarBuffer()
	{
		leer.nextLine();
	}
	
	
	
	
	// ---------------------------------------------- MÉTODOS CASE ----------------------------------------------------- //
	
	
	public static void case2(int opcionMenu) // REGISTRAR UN NUEVO EMPLEADO
	{
		LimpiarBuffer();
		
		Empleador empleador = buscarEmpleador();
		
		if ( empleador == null )
			System.out.println("El empleador que usted busca, no está registrado en el sistema");
		else
		{
			System.out.println("Empleador encontrado\n");
			System.out.println("Presione tecla Entrar para ingresar los datos del empleado:\n");
			
			Empleado nuevo = (Empleado) crearPersona(opcionMenu);
			empleador.agregarEmpleado(nuevo.getNroLegajo(), nuevo);
			System.out.println("\n > Se asignó a " + nuevo.getNombreCompleto() + " como empleado de " + empleador.getNombreCompleto()+ ".\n");
		}
	}
	
	public static void case4() // BUSCAR UN EMPLEADO
	{
		
		//TODO revisar, no anda
		LimpiarBuffer();
		
		Empleador empleador =  buscarEmpleador();
		Empleado empleado = null;
		
		
		if ( empleador == null )
			System.out.println("El empleador que usted busca, no está registrado en el sistema");
		else
		{	
			System.out.println("Empleador encontrado.");
			System.out.println("Presione tecla Entrar para buscar el empleado.\n");
			LimpiarBuffer();
			
			empleado = buscarEmpleado(empleador);
			
			if ( empleado == null )
				System.out.println("La persona que usted busca, no está registrada en el sistema como empleado de " + empleador.getNombreCompleto() + "." );
			else
			{
				System.out.println("\n\t >> " + empleado.getNombreCompleto());
			}
		}
	}
	
	
	public static void case6()
	{
		Empleador empleador = buscarEmpleador();
		Empleado empleado;
		
		double sueldoBasico = -1;
		String fechaPago = "";
		String periodo = "";
		int diasTrabajados = -1;
		int diasVacaciones = -1;
		
		Recibo recibo;
		
		System.out.println("\nGenerar recibos\n");
		
		if ( empleador == null )
			System.out.println("El empleador que usted ingresó, no está registrado en el sistema");
		else
		{
			empleado = buscarEmpleado(empleador);
			
			if ( empleado == null )
				System.out.println("El empleado que usted ingresó, no está registrado en el sistema");
			else
			{
				System.out.println("\n > Se va generar el rebibo correspondiente al empleado: " + empleado.getNombreCompleto() + "\n");
				LimpiarBuffer();
				
				while ( sueldoBasico < 0 )
				{
					System.out.println("Ingrese su sueldo basico: ");
					sueldoBasico = leer.nextInt();
					LimpiarBuffer();
					
					if ( sueldoBasico < 0 )
						System.out.println("\t >> Debe ingresar datos.\n");
				}
				
				while ( fechaPago.isEmpty() )
				{
					System.out.println("Ingrese la fecha de pago (aaaa-mm-dd): ");
					fechaPago = leer.nextLine();
					LimpiarBuffer();
					
					if ( fechaPago.isEmpty() )
						System.out.println("\t >> Debe ingresar datos.\n");
				}
				
				
				periodo = formarPeriodo();
				
				
				while ( diasTrabajados  < 0 )
				{
					System.out.println("Ingrese la cantidad de días trabajados: ");
					diasTrabajados = leer.nextInt();
					LimpiarBuffer();
					
					if ( diasTrabajados < 0 )
						System.out.println("\t >> Debe ingresar datos.\n");
				}
				
				while ( diasVacaciones < 0 )
				{
					System.out.println("Ingrese la cantidad de días de vacaciones: ");
					diasVacaciones = leer.nextInt();
					LimpiarBuffer();
					
					if ( diasVacaciones < 0 )
						System.out.println("\t >> Debe ingresar datos.\n");
				}
				
				
				
				recibo = new Recibo(empleador, empleado, sueldoBasico, fechaPago, periodo, diasTrabajados, diasVacaciones);
				System.out.println(recibo.imprimirRecibo());
				
			}
		}
	}
	
	
	
	// CARGA DE DATOS GENERICOS PARA PRUEBAS
	public static void generarDatosGenericos()
	{
		Empleador empleador1 = new Empleador("Nahuel", "Trucco", new StringBuilder("20502315405"), "Mar del Plata", 
				"Argentino", "Falucho 995","Mar del Plata", "+542236338083", "nahuel.trucco.bkn@gmail.com", "Java Full-Stack Developer");
		
		
		Empleado empleado11 =  new Empleado("Gabriela", "Gomez", new StringBuilder("204005653395"), "Mar del Plata", 
				"Argentino", "Arenales 425", "Mar del Plata", "+542236260365", "gabiel@gomez.com", "categoria", "OSDE", "1995-05-15");
		
		Empleado empleado12 =  new Empleado("Julieta", "Guzman", new StringBuilder("204005288495"), "Mar del Plata", 
				"Argentino", "Azcuenaga 12345", "Mar del Plata", "+542236520365", "qwerty@qwerty.com", "categoria", "OSDE", "1985-05-15");
		
		Empleado empleado13 =  new Empleado("Ivan", "Goméz", new StringBuilder("203305658495"), "Mar del Plata", 		
				"Argentino", "Constitución 1345", "Mar del Plata", "+542236520365", "qaz@yui.com", "", "OSDE", "1992-05-15");
		
		Empleado empleado14 =  new Empleado("Agustina", "Zabala", new StringBuilder("204005648495"), "Mar del Plata", 
				"Argentino", "Luro 1245", "Mar del Plata", "+542238520365", "email", "categoria", "OSDE", "1985-05-15");

		Empleado empleado15 =  new Empleado("Nicolas", "Benavidez", new StringBuilder("2040056168495"), "Mar del Plata", 
				"Argentino", "Libertad 1235", "Mar del Plata", "+542236520765", "email", "categoria", "OSDE", "1997-05-15");
		
		empleador1.agregarEmpleado(empleado11.getNroLegajo(), empleado11);
		empleador1.agregarEmpleado(empleado12.getNroLegajo(), empleado12);
		empleador1.agregarEmpleado(empleado13.getNroLegajo(), empleado13);
		empleador1.agregarEmpleado(empleado14.getNroLegajo(), empleado14);
		empleador1.agregarEmpleado(empleado15.getNroLegajo(), empleado15);
		
		
		
		
		Empleador empleador2 = new Empleador("Candela", "Yarossi", new StringBuilder("20397845625"), "Mar del Plata", 
				"Argentina", "Luro 4523", "Mar del Plata", "+542235448596", "candela@yarossi.com", "Diseño Gráfico");
		
		Empleado empleado21 =  new Empleado("Santino", "Guardia", new StringBuilder("20452361812"), "CABA", "Argentino",
				"San Martin 1253", "CABA", "+5411465328", "liuy@paser.com", "categoria", "Maphre", "1985-05-14");
		
		Empleado empleado22 =  new Empleado("Bruno", "Guardia", new StringBuilder("20452318812"), "CABA", "Argentino",
				"San Nicolas 1253", "CABA", "+5414565328", "lasre@paser.com", "categoria", "Maphre", "1985-05-14");
					
		Empleado empleado23 =  new Empleado("Diego", "Roca", new StringBuilder("20458561812"), "Mar del Plata", "Argentino",
				"Belgrano 1253", "CABA", "+5411465328", "granafk@paser.com", "categoria", "Maphre", "1995-04-14");
					
		Empleado empleado24 =  new Empleado("Sabrina", "Mendiola", new StringBuilder("20452385612"), "Chascomus", "Argentina",
				"San Martin 4520", "Mar del Plata", "+5429165328", "sabrina@paser.com", "categoria", "Maphre", "2015-05-14");
					
		Empleado empleado25 =  new Empleado("Victoria", "Balbuena", new StringBuilder("20452361842"), "CABA", "Argentina",
				"Aristobulo del Valle 1614", "Mar del Plata", "+54114515328", "vbalbuena@paser.com", "categoria", "Maphre", "2019-05-14");
		
		empleador2.agregarEmpleado(empleado21.getNroLegajo(), empleado21);
		empleador2.agregarEmpleado(empleado22.getNroLegajo(), empleado22);
		empleador2.agregarEmpleado(empleado23.getNroLegajo(), empleado23);
		empleador2.agregarEmpleado(empleado24.getNroLegajo(), empleado24);
		empleador2.agregarEmpleado(empleado25.getNroLegajo(), empleado25);
		
		
		
		
		
		
		empleadores.agregar(empleador1.getNroLegajo(), empleador1);
		empleadores.agregar(empleador2.getNroLegajo(), empleador2);
	}
}






























