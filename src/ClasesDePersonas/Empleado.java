package ClasesDePersonas;

import java.io.Serializable;
import java.time.LocalDate;
import org.json.JSONException;
import org.json.JSONObject;
import Interfaces.IGenerarJSON;


/**
 * <p><b><i>Empleado</i></b></p>
 * <pre>public class Empleado extends Persona implements IGenerarJSON, Serializable</pre>
 * <p>La clase <code>Empleado</code> contiene todos los métodos necesarios para instanciar un empleado. La misma extiende de la clase abstracta <code>Persona</code> e implementa las interfaces <code>IGenerarJSON</code> y <code>Serializable</code>.</p>
 * @author Yarossi, Candela & Trucco, Nahuel
 */
public class Empleado extends Persona implements IGenerarJSON, Serializable
{
		
	private String categoria;
	private String obraSocial;
	private LocalDate fechaIngreso;
	
	
	/**
	 * <p><b><i>Empleado</i></b></p>
	 * <pre>public Empleado ()</pre>
	 * <p>Constructor de la clase <code>Empleado</code>.</p>
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public Empleado()
	{
		super();
		categoria = "";
		obraSocial = "";
		fechaIngreso = LocalDate.parse("1900-01-01");
	}
	
	
	/**
	 * <p><b><i>Empleado</i></b></p>
	 * <pre>public Empleado (String nombre, String apellido, StringBuilder cuil, String lugarNacimiento, String nacionalidad, String direccion, String lugarResidencia, String telefono, String email, String categoria, String obraSocial, String fIngreso)</pre>
	 * <p>Constructor de la clase <code>Empleado</code>.</p>
	 * @param nombre Recibe el nombre de la persona.
	 * @param apellido Recibe el apellido de la persona.
	 * @param cuil Recibe el cuil (sin guiones) de la persona.
	 * @param lugarNacimiento Recibe la ciudad de nacimiento de la persona.
	 * @param nacionalidad Recibe la nacionalidad de la persona.
	 * @param direccion Recibe la dirección de la persona.
	 * @param lugarResidencia Recibe la ciudad de residencia de la persona.
	 * @param telefono Recibe el telefono de la persona.
	 * @param email Recibe el e-mail de la persona.
	 * @param categoria Recibe la categoría de trabajo de la persona (actividad que desarrolla dentro del rubro).
	 * @param obraSocial Recibe el nombre de la obra social de la persona.
	 * @param fIngreso Recibe la fecha de ingreso a la actividad de la persona en formato <code>yyyy-mm-dd</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public Empleado(String nombre, String apellido, StringBuilder cuil, String lugarNacimiento, String nacionalidad, String direccion, String lugarResidencia, 
			String telefono, String email, String categoria, String obraSocial, String fIngreso)
	{
		super(nombre, apellido, new StringBuilder(cuil), lugarNacimiento, nacionalidad, direccion, lugarResidencia, telefono, email);
		this.categoria = categoria;
		this.obraSocial = obraSocial;
		this.fechaIngreso = LocalDate.parse(fIngreso);
	}
	
	
	/**
	 * <p><b><i>getCategoria</i></b></p>
	 * <pre>public String getCategoria ()</pre>
	 * @return Retorna la categoría de trabajo de la persona en formato <code>String</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public String getCategoria()
	{
		return categoria;
	}
	
	
	/**
	 * <p><b><i>setCategoria</i></b></p>
	 * <pre>public void setCategoria ()</pre>
	 * @param categoria Recibe la categoría de trabajo de la persona.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void setCategoria(String categoria)
	{
		this.categoria = categoria;
	}
	
	
	/**
	 * <p><b><i>getObraSocial</i></b></p>
	 * <pre>public String getObraSocial ()</pre>
	 * @return Retorna el nombre de la obra social de la persona en formato <code>String</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public String getObraSocial()
	{
		return obraSocial;
	}
	
	
	/**
	 * <p><b><i>setObraSocial</i></b></p>
	 * <pre>public void setObraSocial ()</pre>
	 * @param obraSocial Recibe el nombre de la obra social de la persona.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void setObraSocial(String obraSocial)
	{
		this.obraSocial = obraSocial;
	}
	
	
	/**
	 * <p><b><i>getFechaIngreso</i></b></p>
	 * <pre>public LocalDate getFechaIngreso ()</pre>
	 * @return Retorna la fecha de ingreso del empleado a la actividad en formato <code>yyyy-mm-dd</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public LocalDate getFechaIngreso()
	{
		return fechaIngreso;
	}
	
	
	/**
	 * <p><b><i>setFechaIngreso</i></b></p>
	 * <pre>public void setFechaIngreso (String fIngreso)</pre>
	 * @param fIngreso Recibe la fecha de ingreso del empleado a la actividad en formato <code>yyyy-mm-dd</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void setFechaIngreso(String fIngreso)
	{
		this.fechaIngreso = LocalDate.parse(fIngreso);
	}
	
	/**
	 * <p><b><i>toString</i></b></p>
	 * <pre>public String toString ()</pre>
	 * <p>Sobreescritura del método <code>toString()</code>.</p>
	 * @return Retorna un <code>String</code> con los datos del empleado.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	@Override
	public String toString()
	{
		return super.toString() +  "\nCategoria: " + categoria + " \nObra social: " + obraSocial + " \nFecha de ingreso: " + fechaIngreso;
	}

	
	/**
	 * <p><b><i>toJSON</i></b></p>
	 * <pre>public JSONObject toJSON ()</pre>
	 * <p>Sobreescritura del método <code>toJSON()</code> perteneciente a la interfaz <code>IGenerarJSON</code>.</p>
	 * @return Retorna un <code>JSONObject</code> con los datos del empleado en formato <code>JSON</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	@Override
	public JSONObject toJSON() {
		
		JSONObject jsonObj = super.toJSON();
		
		try 
		{
			jsonObj.put("categoria", categoria);
			jsonObj.put("obra social", obraSocial);
			jsonObj.put("fecha de ingreso", fechaIngreso);
		} 
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		
		return jsonObj;
	} 
	
}
