package ClasesDePersonas;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
import Interfaces.IGenerarJSON;
import ListadosGenericos.Listado;
import Papeles.Factura;
import Papeles.Recibo;


public class Empleador extends Persona implements IGenerarJSON, Serializable
{
	private String actividad;
	private Listado<Integer, Empleado> empleados; 
	private int cantidadEmpleados;
	
	public Empleador()
	{
		super();
		actividad = "";
		empleados = new Listado<Integer, Empleado>();
		cantidadEmpleados = 0;
	}
	
	public Empleador(String nombre, String apellido, StringBuilder cuil, String lugarNacimiento, String nacionalidad,
			String direccion, String lugarResidencia, String telefono, String email, String actividad)
	{
		super(nombre, apellido, new StringBuilder (cuil), lugarNacimiento, nacionalidad, direccion, lugarResidencia, telefono, email);
		this.actividad = actividad;
		empleados = new Listado<Integer, Empleado>();
		setCantidadEmpleados();
	}

	public String getActividad()
	{
		return actividad;
	}

	public void setActividad(String actividad)
	{
		this.actividad = actividad;
	}
	
	public Listado<Integer, Empleado> getEmpleados () 
	{
		return empleados; 
	}
	
	public void agregarEmpleado (Integer nroLegajo, Empleado empleado) 
	{
		empleados.agregar(nroLegajo, empleado);
		setCantidadEmpleados();
	}
	
	public void borrarEmpleado (String apellido, String nombre)
	{
		Integer clave = empleados.buscar(apellido, nombre);
		empleados.borrar(clave);
	}
	
	public String buscarEmpleado (String apellido, String nombre)
	{
		Integer clave = empleados.buscar(apellido, nombre);
		return empleados.mostrar(clave);
	}
	
	public void setCantidadEmpleados ()
	{
		this.cantidadEmpleados = empleados.contar();

	}
	
	public int getCantidadEmpleados () 
	{
		return cantidadEmpleados;
	}
	
	public void leerCantidadEmpleados (int cantidad) 
	{
		this.cantidadEmpleados = cantidad;
	}
	
	public String verEmpleados ()
	{
		return empleados.listar();
	}

	@Override
	public String toString()
	{
		return super.toString() + "\nActividad: " + actividad + "\n\nEmpleados: \n" + verEmpleados();
	}
	
	public StringBuilder generarRecibos (Empleador empleador, Empleado empleado, float sueldoBasico, String fechaPago, String periodo, int diasTrabajados, int diasVacaciones)
	{
		Recibo recibo = new Recibo(empleador, empleado, sueldoBasico, fechaPago, periodo, diasTrabajados, diasVacaciones);
		return recibo.imprimirRecibo();
	}
	
	public StringBuilder generarFactura (Empleador empleador, double costoPorRecibo)
	{
		Factura factura = new Factura(empleador, costoPorRecibo);
		return factura.imprimirFactura();
	}

	@Override
	public JSONObject toJSON() {
		
		JSONObject jsonObj = new JSONObject();
		
		try 
		{
			jsonObj.put("nombre", super.getNombre());
			jsonObj.put("apellido", super.getApellido());
			jsonObj.put("cuil", super.getCuil());
			jsonObj.put("dni", super.getDNI());
			jsonObj.put("lugar de nacimiento", super.getLugarNacimiento());
			jsonObj.put("nacionalidad", super.getNacionalidad());
			jsonObj.put("direccion", super.getDireccion());
			jsonObj.put("lugar de residencia", super.getLugarResidencia());
			jsonObj.put("telefono", super.getTelefono());
			jsonObj.put("email", super.getEmail());
			jsonObj.put("legajo", super.getNroLegajo());
			jsonObj.put("actividad", actividad);
		    jsonObj.put("empleados", empleados.toJSON());
		} 
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		
		return jsonObj;
	}
	
}
