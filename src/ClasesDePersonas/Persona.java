package ClasesDePersonas;

import java.io.Serializable;
import java.lang.StringBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import Archivos.DatosDelSistema;
import Excepciones.ExcepcionDeCampoVacio;
import Interfaces.IGenerarJSON;


/**
 * <p><b><i>Persona</i></b></p>
 * <pre>public abstract class Persona implements IGenerarJSON, Serializable</pre>
 * <p>La clase <code>Persona</code> contiene todos los métodos que serán compartidos por sus clases hijas. Esta clase no se puede instanciar e implementa las interfaces <code>IGenerarJSON</code> y <code>Serializable</code>.</p>
 * @author Yarossi, Candela & Trucco, Nahuel
 */
public abstract class Persona implements IGenerarJSON, Serializable
{
	private String nombre;
	private String apellido;
	private StringBuilder cuil; 
	private StringBuilder dni;
	private String lugarNacimiento;
	private String nacionalidad;
	private String direccion;
	private String lugarResidencia;
	private String telefono;
	private String email; 
	public int nroLegajo; 
	public String nombreArchivo; 
	
	
	/**
	 * <p><b><i>Persona</i></b></p>
	 * <pre>public Persona ()</pre>
	 * <p>Constructor de la clase <code>Persona</code>.</p>
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public Persona()
	{
		super();
		nombre = "";
		apellido = "";
		cuil = new StringBuilder();
		dni = new StringBuilder();
		lugarNacimiento = "";
		nacionalidad = "";
		direccion = "";
		lugarResidencia = "";
		telefono = "";
		email = "";
		nroLegajo = setNroLegajo();
		nombreArchivo = "";
	}
	
	
	/**
	 * <p><b><i>Persona</i></b></p>
	 * <pre>public Persona (String nombre, String apellido, StringBuilder cuil, String lugarNacimiento, String nacionalidad, String direccion, String lugarResidencia, String telefono, String email)</pre>
	 * <p>Constructor de la clase <code>Persona</code>.</p>
	 * @param nombre Recibe el nombre de la persona.
	 * @param apellido Recibe el apellido de la persona.
	 * @param cuil Recibe el cuil (sin guiones) de la persona.
	 * @param lugarNacimiento Recibe la ciudad de nacimiento de la persona.
	 * @param nacionalidad Recibe la nacionalidad de la persona.
	 * @param direccion Recibe la dirección de la persona.
	 * @param lugarResidencia Recibe la ciudad de residencia de la persona.
	 * @param telefono Recibe el telefono de la persona.
	 * @param email Recibe el e-mail de la persona.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public Persona(String nombre, String apellido, StringBuilder cuil, String lugarNacimiento,
			String nacionalidad, String direccion, String lugarResidencia, String telefono, String email) 
	{
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = setCuil(cuil);
		this.dni = setDni(cuil);
		this.lugarNacimiento = lugarNacimiento;
		this.nacionalidad = nacionalidad;
		this.direccion = direccion;
		this.lugarResidencia = lugarResidencia;
		this.telefono = telefono;
		this.email = email;
		nroLegajo = setNroLegajo();
		nombreArchivo = getCuil() + ".dat";
	}
	
	
	/**
	 * <p><b><i>getNombreCompleto</i></b></p>
	 * <pre>public String getNombreCompleto ()</pre>
	 * @return Retorna el nombre completo de la persona en formato <code>String</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public String getNombreCompleto()
	{
		return nombre + " " + apellido;
	}
	
	/**
	 * <p><b><i>getNombre</i></b></p>
	 * <pre>public String getNombre ()</pre>
	 * @return Retorna el nombre de la persona en formato <code>String</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public String getNombre()
	{
		return nombre;
	}
	
	
	/**
	 * <p><b><i>setNombre</i></b></p>
	 * <pre>public void setNombre (String nombre)</pre>
	 * @param nombre Recibe el nombre de la persona.
	 * @throws ExcepcionDeCampoVacio.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void setNombre(String nombre) throws ExcepcionDeCampoVacio
	{
		this.nombre = nombre;
	}
	
	
	/**
	 * <p><b><i>getApellido</i></b></p>
	 * <pre>public String getApellido ()</pre>
	 * @return Retorna el apellido de la persona en formato <code>String</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public String getApellido()
	{
		return apellido;
	}
	
	
	/**
	 * <p><b><i>setApellido</i></b></p>
	 * <pre>public void setApellido (String apellido)</pre>
	 * @param apellido Recibe el apellido de la persona.
	 * @throws ExcepcionDeCampoVacio.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void setApellido(String apellido) throws ExcepcionDeCampoVacio
	{
		this.apellido = apellido;
	}
	
	
	/**
	 * <p><b><i>getCuil</i></b></p>
	 * <pre>public String getCuil ()</pre>
	 * @return Retorna el cuil de la persona en formato <code>String</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public String getCuil()
	{
		return cuil.toString();
	} 
	
	
	/**
	 * <p><b><i>setCuil</i></b></p>
	 * <pre>public StringBuilder setCuil (StringBuilder cuil)</pre>
	 * <p>Este método recibe el cuil de la persona sin los guiones y los agrega. Además, guarda el número de dni.</p>
	 * @param cuil Recibe el cuil de la persona (sin guiones).
	 * @return Retorna el cuil de la persona en formato <code>StringBuilder</code>.
	 * @throws ExcepcionDeCampoVacio.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public StringBuilder setCuil(StringBuilder cuil) throws ExcepcionDeCampoVacio
	{
		this.cuil = cuil;
		cuil.insert(2, "-");
		cuil.insert(11, "-");
		
		return cuil;
	}
	
	
	/**
	 * <p><b><i>setDni</i></b></p>
	 * <pre>private StringBuilder setDni (StringBuilder cuil)</pre>
	 * <p>Este método recibe el cuil de la persona con sus guiones incluidos y genera el número de dni.</p>
	 * @param cuil Recibe el cuil de la persona (con guiones).
	 * @return Retorna el dni de la persona en formato <code>StringBuilder</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	private StringBuilder setDni(StringBuilder cuil)
	{
		StringBuilder dni = new StringBuilder();
		
		dni.append(cuil.substring(3, 11));
		dni.insert(2, ".");
		dni.insert(6, ".");
		
		return dni;
	}
	
	
	/**
	 * <p><b><i>getDni</i></b></p>
	 * <pre>public String getDni ()</pre>
	 * @return Retorna el dni de la persona en formato <code>String</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public String getDNI()
	{
		return dni.toString(); 
	}
	
	
	
	/**
	 * <p><b><i>getLugarNacimiento</i></b></p>
	 * <pre>public String getLugarNacimiento ()</pre>
	 * @return Retorna el lugar de nacimiento de la persona en formato <code>String</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public String getLugarNacimiento()
	{
		return lugarNacimiento;
	}
	
	
	
	/**
	 * <p><b><i>setLugarNacimiento</i></b></p>
	 * <pre>public void setLugarNacimiento (String lugarNacimiento)</pre>
	 * @param lugarNacimiento Recibe el lugar de nacimiento de la persona.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void setLugarNacimiento(String lugarNacimiento)
	{
		this.lugarNacimiento = lugarNacimiento;
	}
	
	
	
	/**
	 * <p><b><i>getNacionalidad</i></b></p>
	 * <pre>public String getNacionalidad ()</pre>
	 * @return Retorna la nacionalidad de la persona en formato <code>String</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public String getNacionalidad()
	{
		return nacionalidad;
	}
	
	
	
	/**
	 * <p><b><i>setNacionalidad</i></b></p>
	 * <pre>public void setNacionalidad (String nacionalidad)</pre>
	 * @param nacionalidad Recibe la nacionalidad de la persona.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void setNacionalidad(String nacionalidad)
	{
		this.nacionalidad = nacionalidad;
	}
	
	
	
	/**
	 * <p><b><i>getDireccion</i></b></p>
	 * <pre>public String getDireccion ()</pre>
	 * @return Retorna la direccion de la persona en formato <code>String</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public String getDireccion()
	{
		return direccion;
	}
	
	
	
	/**
	 * <p><b><i>setDireccion</i></b></p>
	 * <pre>public void setDireccion (String direccion)</pre>
	 * @param direccion Recibe la direccion de la persona.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}
	
	
	
	/**
	 * <p><b><i>getLugarResidencia</i></b></p>
	 * <pre>public String getLugarResidencia ()</pre>
	 * @return Retorna el lugar de residencia de la persona en formato <code>String</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public String getLugarResidencia()
	{
		return lugarResidencia;
	}
	
	
	
	/**
	 * <p><b><i>setLugarResidencia</i></b></p>
	 * <pre>public void setLugarResidencia (String lugarResidencia)</pre>
	 * @param lugarResidencia Recibe el lugar de residencia de la persona.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void setLugarResidencia(String lugarResidencia)
	{
		this.lugarResidencia = lugarResidencia;
	}
	
	
	
	/**
	 * <p><b><i>getTelefono</i></b></p>
	 * <pre>public String getTelefono ()</pre>
	 * @return Retorna el telefono de la persona en formato <code>String</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public String getTelefono()
	{
		return telefono;
	}
	
	
	
	/**
	 * <p><b><i>setTelefono</i></b></p>
	 * <pre>public void setTelefono (String telefono)</pre>
	 * @param telefono Recibe el telefono de la persona.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}
	
	
	
	/**
	 * <p><b><i>getEmail</i></b></p>
	 * <pre>public String getEmail ()</pre>
	 * @return Retorna el e-mail de la persona en formato <code>String</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public String getEmail()
	{
		return email;
	}
	
	
	
	/**
	 * <p><b><i>setEmail</i></b></p>
	 * <pre>public void setEmail (String email)</pre>
	 * @param email Recibe el email de la persona.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	
	
	/**
	 * <p><b><i>getNroLegajo</i></b></p>
	 * <pre>public int getNroLegajo ()</pre>
	 * @return Retorna el número de legajo de la persona en formato <code>int</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public int getNroLegajo()
	{
		return nroLegajo;
	}
	
	
	
	/**
	 * <p><b><i>setNroLegajo</i></b></p>
	 * <pre>public int setNroLegajo ()</pre>
	 * @return Retorna el número de legajo generado en formato <code>int</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	private int setNroLegajo()
	{
		DatosDelSistema dato = new DatosDelSistema();
		int proxlegajo = dato.getCantLegajos() +1;
		
		DatosDelSistema.setCantLegajos(proxlegajo);
		DatosDelSistema.guardarDatos();
		
		return proxlegajo;
	}
	
	
	/**
	 * <p><b><i>leerNroLegajo</i></b></p>
	 * <pre>public void leerNroLegajo (int legajo)</pre>
	 * @param legajo Recibe el número de legajo de la persona.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void leerNroLegajo (int legajo)
	{
		this.nroLegajo = legajo;
	}
	
	
	
	/**
	 * <p><b><i>leerCuil</i></b></p>
	 * <pre>public void leerCuil (String cuil)</pre>
	 * @param cuil Recibe el número de cuil de la persona.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void leerCuil (String cuil)
	{
		this.cuil = new StringBuilder(cuil);
	}
	
	
	
	/**
	 * <p><b><i>leerDni</i></b></p>
	 * <pre>public void leerDni (String dni)</pre>
	 * @param dni Recibe el número de dni de la persona.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	public void leerDni (String dni)
	{
		this.dni = new StringBuilder(dni);
	}

	
	/**
	 * <p><b><i>toString</i></b></p>
	 * <pre>public String toString ()</pre>
	 * <p>Sobreescritura del método <code>toString()</code>.</p>
	 * @return Retorna un <code>String</code> con los datos de la persona.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	@Override
	public String toString()
	{
		return "\nNombre: " + nombre + "\nApellido: " + apellido 
				+ "\nCuil: " + cuil 
				+ "\nDNI: " + dni 
				+ "\nLugar de nacimiento: " + lugarNacimiento 
				+ "\nNacionalidad: " + nacionalidad 
				+ "\nDireccion: " + direccion 
				+ "\nLugar de residencia: " + lugarResidencia 
				+ "\nTelefono: " + telefono 
				+ "\nE-mail: " + email 
				+ "\nNumero de legajo: " + nroLegajo;
	}
	
	
	
	/**
	 * <p><b><i>equals</i></b></p>
	 * <pre>public boolean equals (Object obj)</pre>
	 * <p>Sobreescritura del método <code>equals(Object obj)</code>. Compara números de CUIL.</p>
	 * @return Retorna un <code>boolean</code> indicando si ambas personas son iguales o no.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	@Override
	public boolean equals(Object obj)
	{
		boolean esIgual = false;
		
		if ( obj != null && obj instanceof Persona )
		{
			Persona aux = (Persona) obj; 
			
			if ( this.getCuil().equals(aux.getCuil()) )
				esIgual = true;
		}
		
		return esIgual;
	}
	
	
	
	/**
	 * <p><b><i>hashCode</i></b></p>
	 * <pre>public int hashCode ()</pre>
	 * <p>Sobreescritura del método <code>hashCode()</code>.</p>
	 * @return Retorna 1.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	@Override
	public int hashCode()
	{
		return 1;
	}
	
	
	/**
	 * <p><b><i>toJSON</i></b></p>
	 * <pre>public JSONObject toJSON ()</pre>
	 * <p>Sobreescritura del método <code>toJSON()</code> perteneciente a la interfaz <code>IGenerarJSON</code>.</p>
	 * @return Retorna un <code>JSONObject</code> con los datos de la persona en formato <code>JSON</code>.
	 * @author Yarossi, Candela & Trucco, Nahuel
	 */
	@Override
	public JSONObject toJSON()
	{
		
		JSONObject jsonObj = new JSONObject();
		
		try 
		{
			jsonObj.put("nombre", nombre);
			jsonObj.put("apellido", apellido);
			jsonObj.put("cuil", cuil);
			jsonObj.put("dni", dni);
			jsonObj.put("lugar de nacimiento", lugarNacimiento);
			jsonObj.put("nacionalidad", nacionalidad);
			jsonObj.put("direccion", direccion);
			jsonObj.put("lugar de residencia", lugarResidencia);
			jsonObj.put("telefono", telefono);
			jsonObj.put("email", email);
			jsonObj.put("legajo", nroLegajo);
		} 
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		
		return jsonObj;
	}

}
