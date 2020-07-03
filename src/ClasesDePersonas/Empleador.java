package ClasesDePersonas;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONException;
import org.json.JSONObject;
import Archivos.GestorDeArchivos;
import Interfaces.IGenerarJSON;
import ListadosGenericos.Listado;
import Papeles.Factura;
import Papeles.Recibo;
import sun.util.locale.provider.AuxLocaleProviderAdapter;


/**
 * <p><b><i>Empleador</i></b></p>
 * <pre>public class Empleador extends Persona implements IGenerarJSON, Serializable</pre>
 * <p>La clase <code>Empleador</code> contiene todos los métodos necesarios para instanciar un empleador. La misma extiende de la clase abstracta <code>Persona</code> e implementa las interfaces <code>IGenerarJSON</code> y <code>Serializable</code>.</p>
 * @author Yarossi, Candela & Trucco, Nahuel
 */
public class Empleador extends Persona implements IGenerarJSON, Serializable
{
	private String actividad;
	private Listado<Integer, Empleado> empleados; 
	private int cantidadEmpleados;
	private String nombreArchivo;
	
	
	/**
	 * <p><b><i>Empleador</i></b></p>
	 * <pre>public Empleador ()</pre>
	 * <p>Constructor de la clase <code>Empleador</code>.</p>
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public Empleador()
	{
		super();
		actividad = "";
		empleados = new Listado<Integer, Empleado>();
		cantidadEmpleados = 0;
		nombreArchivo = "";
	}
	
	
	/**
	 * <p><b><i>Empleador</i></b></p>
	 * <pre>public Empleador (String nombre, String apellido, StringBuilder cuil, String lugarNacimiento, String nacionalidad, String direccion, String lugarResidencia, String telefono, String email, String actividad)</pre>
	 * <p>Constructor de la clase <code>Empleador</code>.</p>
	 * @param nombre Recibe el nombre de la persona.
	 * @param apellido Recibe el apellido de la persona.
	 * @param cuil Recibe el cuil (sin guiones) de la persona.
	 * @param lugarNacimiento Recibe la ciudad de nacimiento de la persona.
	 * @param nacionalidad Recibe la nacionalidad de la persona.
	 * @param direccion Recibe la dirección de la persona.
	 * @param lugarResidencia Recibe la ciudad de residencia de la persona.
	 * @param telefono Recibe el telefono de la persona.
	 * @param email Recibe el e-mail de la persona.
	 * @param actividad Recibe la actividad desarrollada por la persona (rubro).
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public Empleador(String nombre, String apellido, StringBuilder cuil, String lugarNacimiento, String nacionalidad,
			String direccion, String lugarResidencia, String telefono, String email, String actividad)
	{
		super(nombre, apellido, new StringBuilder (cuil), lugarNacimiento, nacionalidad, direccion, lugarResidencia, telefono, email);
		this.actividad = actividad;
		empleados = new Listado<Integer, Empleado>();
		setCantidadEmpleados();
		nombreArchivo = getCuil() + ".dat";
	}

	
	/**
	 * <p><b><i>getActividad</i></b></p>
	 * <pre>public String getActividad ()</pre>
	 * @return Retorna la actividad desarrollada por la persona en formato <code>String</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public String getActividad()
	{
		return actividad;
	}

	
	/**
	 * <p><b><i>setActividad</i></b></p>
	 * <pre>public void setActividad ()</pre>
	 * @param actividad Recibe la actividad desarrollada por la persona.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void setActividad(String actividad)
	{
		this.actividad = actividad;
	}
	
	
	/**
	 * <p><b><i>getEmpleados</i></b></p>
	 * <pre>public Listado<Integer, Empleado> getEmpleados ()</pre>
	 * @return Retorna el listado de empleados pertenecientes a determinado empleador.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public Listado<Integer, Empleado> getEmpleados () 
	{
		return empleados; 
	}
	
	
	/**
	 * <p><b><i>agregarEmpleado</i></b></p>
	 * <pre>public void agregarEmpleado (Integer nroLegajo, Empleado empleado)</pre>
	 * @param nroLegajo Recibe el número de legajo del empleado.
	 * @param empleado Recibe al empleado.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void agregarEmpleado (Integer nroLegajo, Empleado empleado) 
	{
		empleados.agregar(nroLegajo, empleado);
		setCantidadEmpleados();
	}
	
	
	/**
	 * <p><b><i>borrarEmpleado</i></b></p>
	 * <pre>public void borrarEmpleado (String apellido, String nombre)</pre>
	 * @param nombre Recibe el nombre del empleado.
	 * @param apellido Recibe el apellido del empleado.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void borrarEmpleado (String apellido, String nombre)
	{
		Integer clave = empleados.buscar(apellido, nombre);
		empleados.borrar(clave);
	}
	
	
	/**
	 * <p><b><i>buscarEmpleado</i></b></p>
	 * <pre>public Empleado buscarEmpleado (String apellido, String nombre)</pre>
	 * @param clave Recibe la clave (Numero de legajo) del empleado.
	 * @return Retorna un <code>Empleado</code> con los datos del empleado.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public Empleado buscarEmpleado (Integer clave)
	{
		boolean encontrado = false;
		Empleado empleado = null;
		
		if ( clave != null )
		{
			Iterator it = empleados.getHashMap().entrySet().iterator();
			
			while ( !encontrado && it.hasNext() )
			{
				Map.Entry<Integer, Empleado> me = (Entry<Integer, Empleado>) it.next();
				Empleado aux = (Empleado) me.getValue();
				
				if ( aux.getNroLegajo() == clave )
				{
					encontrado = true;
					empleado = aux;
				}
			}
		}
		
		return empleado;
	}
	
	/**
	 * <p><b><i>buscarEmpleado</i></b></p>
	 * <pre>public Empleado buscarEmpleado (String apellido, String nombre)</pre>
	 * @param nombre Recibe el nombre del empleado.
	 * @param apellido Recibe el apellido del empleado.
	 * @return Retorna un <code>Empleado</code> con los datos del empleado.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public Empleado buscarEmpleado (String apellido, String nombre)
	{
		Integer clave = empleados.buscar(apellido, nombre);
		
boolean encontrado = false;
		Empleado empleado = null;
				
		if ( clave != null )
		{
			Iterator it = empleados.getHashMap().entrySet().iterator();
			
			while ( !encontrado && it.hasNext() )
			{
				Map.Entry<Integer, Empleado> me = (Entry<Integer, Empleado>) it.next();
				Empleado aux = (Empleado) me.getValue();
				
				
				if ( aux.getNombre().equalsIgnoreCase(nombre) && aux.getApellido().equalsIgnoreCase(apellido) )
				{
					encontrado = true;
					empleado = aux;					
				}
			}
		}
		
		return empleado;
	}
	
	
	/**
	 * <p><b><i>setCantidadEmpleados</i></b></p>
	 * <pre>public void setCantidadEmpleados ()</pre>
	 * <p>Contabiliza la cantidad de empleados que tiene un empleador.</p>
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void setCantidadEmpleados ()
	{
		this.cantidadEmpleados = empleados.contar();
	}
	
	
	/**
	 * <p><b><i>getCantidadEmpleados</i></b></p>
	 * <pre>public int getCantidadEmpleados ()</pre>
	 * @return Retorna la cantidad de empleados que tiene un empleador en formato <code>int</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public int getCantidadEmpleados () 
	{
		return cantidadEmpleados;
	}
	
	
	/**
	 * <p><b><i>leerCantidadEmpleados</i></b></p>
	 * <pre>public void leerCantidadEmpleados (int cantidad)</pre>
	 * @param cantidad Recibe la cantidad de empleados que tiene un empleador.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void leerCantidadEmpleados (int cantidad) 
	{
		this.cantidadEmpleados = cantidad;
	}
	
	
	/**
	 * <p><b><i>verEmpleados</i></b></p>
	 * <pre>public String verEmpleados ()</pre>
	 * @return Retorna un <code>String</code> con el listado de empleados del empleador.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public String verEmpleados ()
	{
		return empleados.listar();
	}

	
	/**
	 * <p><b><i>setNombreArchivo</i></b></p>
	 * <pre>public void setNombreArchivo ()</pre>
	 * <p>Crea el nombre del archivo del empleador.</p>
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void setNombreArchivo () 
	{
		this.nombreArchivo =  getCuil() + ".dat";
	}
	
	
	/**
	 * <p><b><i>getNombreArchivo</i></b></p>
	 * <pre>public String getNombreArchivo ()</pre>
	 * @return Retorna el nombre del archivo del empleador en formato <code>String</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public String getNombreArchivo ()
	{
		return nombreArchivo;
	}
	
	
	/**
	 * <p><b><i>toString</i></b></p>
	 * <pre>public String toString ()</pre>
	 * <p>Sobreescritura del método <code>toString()</code>.</p>
	 * @return Retorna un <code>String</code> con los datos del empleador.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	@Override
	public String toString()
	{
		return super.toString() + "\nActividad: " + actividad + "\n\nEmpleados: \n" + verEmpleados();
	}
	
	/**
	 * <p><b><i>mostrarDatos</i></b></p>
	 * <pre>public String mostrarDatos ()</pre>
	 * @return Retorna un <code>String</code> con los datos del empleador.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public String mostrarDatos()
	{
		return super.toString() + "\nActividad: " + actividad + "\n";
	}
	
	
	/**
	 * <p><b><i>generarRecibo</i></b></p>
	 * <pre>public String generarRecibo (Empleador empleador, Empleado empleado, float sueldoBasico, String fechaPago, String periodo, int diasTrabajados, int diasVacaciones)</pre>
	 * @param empleador Recibe al empleador.
	 * @param empleado Recibe al empleado del que se va a generar el recibo.
	 * @param sueldoBasico Recibe el monto del sueldo básico establecido para la categoría del empleado.
	 * @param fechaPago Recibe la fecha en la cual se debe realizar el pago en formato <code>yyyy-mm-dd</code>.
	 * @param periodo Recibe la fecha del periodo que se va a pagar en formato <code>yyyy-mm-dd</code>.
	 * @param diasTrabajados Recibe la cantidad de días que el empleado ha trabajado en este periodo.
	 * @param diasVacaciones Recibe la cantidad de días que el empleado se ha tomado de vacaciones en este periodo.
	 * @return Retorna un <code>String</code> con el recibo de sueldo del empleado.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public String generarRecibo (Empleador empleador, Empleado empleado, double sueldoBasico, String fechaPago, String periodo, int diasTrabajados, int diasVacaciones)
	{
		Recibo recibo = new Recibo(empleador, empleado, sueldoBasico, fechaPago, periodo, diasTrabajados, diasVacaciones);
		return recibo.imprimirRecibo().toString();
	}
	
	
	/**
	 * <p><b><i>generarFactura</i></b></p>
	 * <pre>public String generarFactura (Empleador empleador, double costoPorRecibo)</pre>
	 * @param empleador Recibe al empleador del que se va a generar la factura.
	 * @param costoPorRecibo Recibe el costo unitario de cada recibo hecho.
	 * @return Retorna un <code>String</code> con la factura para el empleador.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public String generarFactura (Empleador empleador, double costoPorRecibo)
	{
		Factura factura = new Factura(empleador, costoPorRecibo);
		return factura.imprimirFactura().toString();
	}

	
	/**
	 * <p><b><i>toJSON</i></b></p>
	 * <pre>public JSONObject toJSON ()</pre>
	 * <p>Sobreescritura del método <code>toJSON()</code> perteneciente a la interfaz <code>IGenerarJSON</code>.</p>
	 * @return Retorna un <code>JSONObject</code> con los datos del empleador en formato <code>JSON</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	@Override
	public JSONObject toJSON()
	{
		
		JSONObject jsonObj = super.toJSON();
		
		try 
		{
			jsonObj.put("actividad", actividad);
		    jsonObj.put("empleados", empleados.toJSON());
		    jsonObj.put("cantidad de empleados", cantidadEmpleados);
		} 
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		
		return jsonObj;
	}
	
	
	/**
	 * <p><b><i>guardarEnArchivo</i></b></p>
	 * <pre>public static void guardarEnArchivo (Empleador empleador)</pre>
	 * @param empleador Recibe el empleador a guardar en el archivo.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public static void guardarEnArchivo (Empleador empleador) 
	{
			GestorDeArchivos.guardarEmpleador(empleador, empleador.getNombreArchivo()); 
	}
	
	
	/**
	 * <p><b><i>leerDeArchivo</i></b></p>
	 * <pre>public static Empleador leerDeArchivo (String archivo)</pre>
	 * @param archivo Recibe el nombre del archivo a leer.
	 * @return Retorna el empleador leido del archivo.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public static Empleador leerDeArchivo (String archivo) 
	{
		Empleador empleador = GestorDeArchivos.leerEmpleador(archivo);
		
		return empleador;
	}
}
