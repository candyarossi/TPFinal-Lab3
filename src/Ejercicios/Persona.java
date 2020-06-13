package Ejercicios;

import java.lang.StringBuilder;

public abstract class Persona
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
	public static int cantidad = 0;
	
	
	public Persona()
	{
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
	}
	
	public Persona(String nombre, String apellido, StringBuilder cuil, String lugarNacimiento,
			String nacionalidad, String direccion, String lugarResidencia, String telefono, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		setDni(cuil);
		this.lugarNacimiento = lugarNacimiento;
		this.nacionalidad = nacionalidad;
		this.direccion = direccion;
		this.lugarResidencia = lugarResidencia;
		this.telefono = telefono;
		this.email = email;
		nroLegajo = setNroLegajo();
	}
	
	

	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public String getApellido()
	{
		return apellido;
	}
	
	public void setApellido(String apellido)
	{
		this.apellido = apellido;
	}
	
	public StringBuilder getCuil()
	{
		return cuil;
	} 
	
	public void setCuil(StringBuilder cuil)
	{
		setDni(cuil);
		this.cuil = cuil;
		cuil.insert(2, "-");
		cuil.insert(11, "-");
	}
	
	private void setDni(StringBuilder cuil)
	{
		dni.append(cuil.substring(2, 10));
		dni.insert(2, ".");
		dni.insert(6, ".");
	}
	
	public StringBuilder getDNI()
	{
		return dni; 
	}
	
	public String getLugarNacimiento()
	{
		return lugarNacimiento;
	}
	
	public void setLugarNacimiento(String lugarNacimiento)
	{
		this.lugarNacimiento = lugarNacimiento;
	}
	
	public String getNacionalidad()
	{
		return nacionalidad;
	}
	
	public void setNacionalidad(String nacionalidad)
	{
		this.nacionalidad = nacionalidad;
	}
	
	public String getDireccion()
	{
		return direccion;
	}
	
	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}
	
	public String getLugarResidencia()
	{
		return lugarResidencia;
	}
	
	public void setLugarResidencia(String lugarResidencia)
	{
		this.lugarResidencia = lugarResidencia;
	}
	
	public String getTelefono()
	{
		return telefono;
	}
	
	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public int getNroLegajo()
	{
		return nroLegajo;
	}
	
	private int setNroLegajo()
	{
		return incrementarCantidad();
	}
	
	private static int incrementarCantidad()
	{
		return cantidad++;
	}
	

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
	
	@Override
	public int hashCode()
	{
		return 1;
	}

}
