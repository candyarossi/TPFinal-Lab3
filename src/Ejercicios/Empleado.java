package Ejercicios;

import java.time.LocalDate;

public class Empleado extends Persona
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
	
	public Empleado(String nombre, String apellido, String cuil, String lugarNacimiento, String nacionalidad, String direccion, String lugarResidencia, 
			String telefono, String email, int nroLegajo, String categoria, String obraSocial, LocalDate fechaIngreso)
	{
		super(nombre, apellido, new StringBuilder(cuil), lugarNacimiento, nacionalidad, direccion, lugarResidencia, telefono, email);
		this.categoria = categoria;
		this.obraSocial = obraSocial;
		this.fechaIngreso = fechaIngreso;
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
	
}
