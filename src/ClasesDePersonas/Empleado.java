package ClasesDePersonas;

import java.io.Serializable;
import java.time.LocalDate;
import org.json.JSONException;
import org.json.JSONObject;
import Interfaces.IGenerarJSON;


public class Empleado extends Persona implements IGenerarJSON, Serializable
{
		
	private String categoria;
	private String obraSocial;
	private LocalDate fechaIngreso;
	
	public Empleado()
	{
		super();
		categoria = "";
		obraSocial = "";
		fechaIngreso = LocalDate.parse("");
	}
	
	public Empleado(String nombre, String apellido, StringBuilder cuil, String lugarNacimiento, String nacionalidad, String direccion, String lugarResidencia, 
			String telefono, String email, String categoria, String obraSocial, String fIngreso)
	{
		super(nombre, apellido, new StringBuilder(cuil), lugarNacimiento, nacionalidad, direccion, lugarResidencia, telefono, email);
		this.categoria = categoria;
		this.obraSocial = obraSocial;
		this.fechaIngreso = LocalDate.parse(fIngreso);
	}

	public String getCategoria()
	{
		return categoria;
	}
	
	public void setCategoria(String categoria)
	{
		this.categoria = categoria;
	}
	
	public String getObraSocial()
	{
		return obraSocial;
	}
	
	public void setObraSocial(String obraSocial)
	{
		this.obraSocial = obraSocial;
	}
	
	public LocalDate getFechaIngreso()
	{
		return fechaIngreso;
	}
	
	public void setFechaIngreso(LocalDate fechaIngreso)
	{
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString()
	{
		return super.toString() +  "\nCategoria: " + categoria + " \nObra social: " + obraSocial + " \nFecha de ingreso: " + fechaIngreso;
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
